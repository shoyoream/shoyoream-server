package shoyoream.server.shoyoreamapplication.domain.service

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.domain.entity.Customer
import shoyoream.server.shoyoreamapplication.domain.repository.CustomerRepository

@Service
class CustomerDomainService(
    private val customerRepository: CustomerRepository
) {
    @Transactional
    fun createCustomer(customer: Customer): Customer {
        return customerRepository.save(customer)
    }
}
