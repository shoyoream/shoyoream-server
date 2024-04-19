package shoyoream.server.shoyoreamapplication.core.domain.customer.service

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.core.domain.customer.entity.Customer
import shoyoream.server.shoyoreamapplication.core.domain.customer.repository.CustomerRepository

@Service
class CustomerDomainService(
    private val customerRepository: CustomerRepository
) {
    @Transactional
    fun createCustomer(customer: Customer): Customer {
        return customerRepository.save(customer)
    }
}
