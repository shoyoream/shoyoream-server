package shoyoream.server.shoyoreamapplication.application.client.service

import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.application.dto.RegisterUserInput
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse
import shoyoream.server.shoyoreamapplication.core.domain.customer.entity.Customer
import shoyoream.server.shoyoreamapplication.core.domain.customer.service.CustomerDomainService

@Service
class AuthenticationAppService(
    private val customerDomainService: CustomerDomainService
) {
    fun registerCustomer(registerUserInput: RegisterUserInput): DefaultResponse<Long> {
        val newCustomer = customerDomainService.createCustomer(Customer.of(registerUserInput.email, registerUserInput.password))
        return DefaultResponse.successResponse(newCustomer.customerId)
    }
}
