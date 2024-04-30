package shoyoream.server.shoyoreamapplication.application.client.service

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.application.dto.LoginInput
import shoyoream.server.shoyoreamapplication.application.dto.RegisterUserInput
import shoyoream.server.shoyoreamapplication.application.dto.UserInfoResponse
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse
import shoyoream.server.shoyoreamapplication.core.domain.customer.entity.Customer
import shoyoream.server.shoyoreamapplication.core.domain.customer.service.CustomerDomainService
import shoyoream.server.shoyoreamapplication.core.domain.customer.service.CustomerSelectionService

@Service
class AuthenticationAppService(
    private val customerDomainService: CustomerDomainService,
    private val customerSelectionService: CustomerSelectionService
) {
    fun login(loginInput: LoginInput, request: HttpServletRequest): DefaultResponse<Long> {
        // 세선 생성
        val session = request.session

        val customerId = customerSelectionService.findCustomerForLogin(loginInput.email, loginInput.password)

        // key value 넣기 + 유효시간 설정
        session.setAttribute("customerId", customerId)
        session.maxInactiveInterval = 60 * 60

        return DefaultResponse.successResponse(customerId)
    }

    fun registerCustomer(registerUserInput: RegisterUserInput): DefaultResponse<Long> {
        val newCustomer = customerDomainService.createCustomer(
            Customer.of(registerUserInput.email, registerUserInput.password)
        )

        return DefaultResponse.successResponse(newCustomer.customerId)
    }

    fun getUserInfo(userId: Long): UserInfoResponse {
        val customer = customerSelectionService.findCustomerById(userId)
        return UserInfoResponse.of(customer)
    }
}
