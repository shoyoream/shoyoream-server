package shoyoream.server.shoyoreamapplication.core.domain.customer.repository

import org.springframework.data.jpa.repository.JpaRepository
import shoyoream.server.shoyoreamapplication.core.domain.customer.entity.Customer

interface CustomerRepository : JpaRepository<Customer, Long>
