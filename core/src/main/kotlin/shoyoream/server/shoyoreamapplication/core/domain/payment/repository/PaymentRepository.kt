package shoyoream.server.shoyoreamapplication.core.domain.payment.repository

import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.graphql.data.GraphQlRepository
import shoyoream.server.shoyoreamapplication.core.domain.payment.entity.Payment

@GraphQlRepository
interface PaymentRepository : JpaRepository<Payment, UUID>, KotlinJdslJpqlExecutor
