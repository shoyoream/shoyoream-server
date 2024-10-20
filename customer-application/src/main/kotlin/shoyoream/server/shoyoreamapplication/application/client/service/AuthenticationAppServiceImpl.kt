package shoyoream.server.shoyoreamapplication.application.client.service

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.application.dto.LoginInput
import shoyoream.server.shoyoreamapplication.application.dto.RegisterUserInput
import shoyoream.server.shoyoreamapplication.application.dto.UserInfo
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse
import shoyoream.server.shoyoreamapplication.core.common.exception.InvalidRequestException
import shoyoream.server.shoyoreamapplication.domain.entity.Customer
import shoyoream.server.shoyoreamapplication.domain.service.CustomerDomainService
import shoyoream.server.shoyoreamapplication.domain.service.CustomerSelectionService
import shoyoream.server.shoyoreamapplication.exception.AuthenticationErrorType
import shoyoream.server.shoyoreamapplication.token.component.JWTProvider
import shoyoream.server.shoyoreamapplication.token.component.JWTValidator
import shoyoream.server.shoyoreamapplication.token.entity.RefreshToken
import shoyoream.server.shoyoreamapplication.token.model.TokenVariable.ACCESS_TOKEN
import shoyoream.server.shoyoreamapplication.token.model.enums.TokenType
import shoyoream.server.shoyoreamapplication.token.repository.RefreshTokenRepository

interface AuthenticationAppService {
    fun login(loginInput: LoginInput, request: HttpServletRequest, response: HttpServletResponse): DefaultResponse<Long>
    fun registerCustomer(registerUserInput: RegisterUserInput): DefaultResponse<Long>
    fun getUserInfo(accessToken: String): UserInfo
}

@Service
class AuthenticationAppServiceImpl(
    private val jwtValidator: JWTValidator,
    private val jwtProvider: JWTProvider,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val customerDomainService: CustomerDomainService,
    private val customerSelectionService: CustomerSelectionService
) : AuthenticationAppService {
    override fun login(loginInput: LoginInput, request: HttpServletRequest, response: HttpServletResponse): DefaultResponse<Long> {
        // 세선 생성

        val session = request.session

        val customer = customerSelectionService.findCustomerForLogin(loginInput.email, loginInput.password)

        session.setAttribute(ACCESS_TOKEN, jwtProvider.generateToken(customer.customerId.toInt(), loginInput.email, TokenType.ACCESS))
        session.maxInactiveInterval = 60 * 60

        val refreshToken = jwtProvider.generateToken(customer.customerId.toInt(), customer.email, TokenType.REFRESH)
        val accessToken = jwtProvider.generateToken(customer.customerId.toInt(), customer.email, TokenType.ACCESS)

        response.addHeader(HttpHeaders.AUTHORIZATION, "Bearer $accessToken")

        val existingToken = refreshTokenRepository.findByEmail(customer.email)

        if (existingToken != null) {
            refreshTokenRepository.delete(existingToken)
        }

        refreshTokenRepository.save(
            RefreshToken.of(refreshToken, customer.email)
        )

        return DefaultResponse.successResponse(customer.customerId)
    }

    override fun registerCustomer(registerUserInput: RegisterUserInput): DefaultResponse<Long> {
        val newCustomer = customerDomainService.createCustomer(
            Customer.of(registerUserInput.email, registerUserInput.password)
        )

        return DefaultResponse.successResponse(newCustomer.customerId)
    }

    override fun getUserInfo(accessToken: String): UserInfo {
        val userIdAndEmail = if (jwtValidator.validateToken(accessToken, TokenType.ACCESS)) {
            jwtProvider.getUserIdAndEmailFromAccessToken(accessToken)
        } else {
            throw InvalidRequestException(AuthenticationErrorType.INVALID_TOKEN)
        }

        val customer = customerSelectionService.findCustomerById(userIdAndEmail.first.toLong())
        return UserInfo.of(customer)
    }
}
