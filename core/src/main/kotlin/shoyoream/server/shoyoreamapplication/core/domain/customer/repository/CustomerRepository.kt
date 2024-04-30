package shoyoream.server.shoyoreamapplication.core.domain.customer.repository

import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.springframework.data.jpa.repository.JpaRepository
import shoyoream.server.shoyoreamapplication.core.domain.customer.entity.Customer

interface CustomerRepository : JpaRepository<Customer, Long>, KotlinJdslJpqlExecutor
