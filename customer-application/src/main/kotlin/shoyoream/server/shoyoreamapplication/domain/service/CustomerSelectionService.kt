package shoyoream.server.shoyoreamapplication.domain.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.core.common.exception.DataNotFoundException
import shoyoream.server.shoyoreamapplication.core.infra.extensions.findNullableSingle
import shoyoream.server.shoyoreamapplication.domain.entity.Customer
import shoyoream.server.shoyoreamapplication.domain.exception.CustomerErrorType
import shoyoream.server.shoyoreamapplication.domain.repository.CustomerRepository

@Service
class CustomerSelectionService(
    private val customerRepository: CustomerRepository
) {
    @Transactional(readOnly = true)
    fun findCustomerForLogin(email: String, encodedPassword: String): Customer {
        return customerRepository.findNullableSingle {
            select(
                entity(Customer::class)
            ).from(
                entity(Customer::class)
            ).whereAnd(
                path(Customer::email).equal(email),
                path(Customer::password).equal(encodedPassword)
            )
        } ?: throw DataNotFoundException(CustomerErrorType.NOT_FOUND_CUSTOMER)
    }

    @Transactional(readOnly = true)
    fun findCustomerById(id: Long): Customer {
        return customerRepository.findNullableSingle {
            select(
                entity(Customer::class)
            ).from(
                entity(Customer::class)
            ).where(
                path(Customer::customerId).equal(id)
            )
        } ?: throw DataNotFoundException(CustomerErrorType.NOT_FOUND_CUSTOMER)
    }
}
