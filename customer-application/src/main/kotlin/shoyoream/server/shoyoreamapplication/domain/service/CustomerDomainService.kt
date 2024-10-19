package shoyoream.server.shoyoreamapplication.domain.service

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.domain.entity.Customer
import shoyoream.server.shoyoreamapplication.domain.repository.CustomerRepository

interface CustomerDomainService {
    fun createCustomer(customer: Customer): Customer
}

@Service
class CustomerDomainServiceImpl(
    private val customerRepository: CustomerRepository
) : CustomerDomainService {
    @Transactional
    override fun createCustomer(customer: Customer): Customer {
        return customerRepository.save(customer)
    }
}
