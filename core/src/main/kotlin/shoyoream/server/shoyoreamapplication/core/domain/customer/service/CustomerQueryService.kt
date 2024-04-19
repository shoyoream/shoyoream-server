package shoyoream.server.shoyoreamapplication.core.domain.customer.service

import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.core.domain.customer.repository.CustomerRepository

@Service
class CustomerQueryService(
    private val customerRepository: CustomerRepository
)
