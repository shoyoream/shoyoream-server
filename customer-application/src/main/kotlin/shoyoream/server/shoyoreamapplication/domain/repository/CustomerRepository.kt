package shoyoream.server.shoyoreamapplication.domain.repository

import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.springframework.data.jpa.repository.JpaRepository
import shoyoream.server.shoyoreamapplication.domain.entity.Customer

interface CustomerRepository : JpaRepository<Customer, Long>, KotlinJdslJpqlExecutor
