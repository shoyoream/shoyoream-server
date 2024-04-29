package shoyoream.server.shoyoreamapplication.application.client.service

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.application.dto.LoginInput
import shoyoream.server.shoyoreamapplication.application.dto.RegisterUserInput
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
        // TODO : 로그인 처리 로직
        val session = request.session

        val customerId = customerSelectionService.findCustomerForLogin(loginInput.email, loginInput.password)
        // TODO : 세션을 저장하고 불러오는 로직이 필요함

        return DefaultResponse.successResponse(customerId)
    }

    fun registerCustomer(registerUserInput: RegisterUserInput): DefaultResponse<Long> {
        val newCustomer = customerDomainService.createCustomer(
            Customer.of(registerUserInput.email, registerUserInput.password)
        )

        return DefaultResponse.successResponse(newCustomer.customerId)
    }
}
