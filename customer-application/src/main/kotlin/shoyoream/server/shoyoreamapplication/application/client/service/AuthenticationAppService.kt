package shoyoream.server.shoyoreamapplication.application.client.service

import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.application.dto.LoginInput
import shoyoream.server.shoyoreamapplication.application.dto.RegisterUserInput
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse
import shoyoream.server.shoyoreamapplication.core.domain.customer.entity.Customer
import shoyoream.server.shoyoreamapplication.core.domain.customer.service.CustomerDomainService
import shoyoream.server.shoyoreamapplication.core.domain.customer.service.CustomerSelectionService

@Service
class AuthenticationAppService(
    private val bcryptPasswordEncoder: BCryptPasswordEncoder,
    private val customerDomainService: CustomerDomainService,
    private val customerSelectionService: CustomerSelectionService
) {
    fun login(loginInput: LoginInput, request: HttpServletRequest): DefaultResponse<Long> {
        // TODO : 로그인 처리 로직
        val customerId = customerSelectionService.findCustomerForLogin(loginInput.email, bcryptPasswordEncoder.encode(loginInput.password))

        val session = request.session

        return DefaultResponse.successResponse(0L)
    }

    fun registerCustomer(registerUserInput: RegisterUserInput): DefaultResponse<Long> {
        val newCustomer = customerDomainService.createCustomer(
            Customer.of(registerUserInput.email, bcryptPasswordEncoder.encode(registerUserInput.password))
        )

        // T

        return DefaultResponse.successResponse(newCustomer.customerId)
    }
}
