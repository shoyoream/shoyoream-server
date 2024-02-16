package shoyoream.server.shoyoreamapplication.core.domain.payment.repository

import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.graphql.data.GraphQlRepository
import shoyoream.server.shoyoreamapplication.core.domain.payment.entity.Payment

@GraphQlRepository
interface PaymentRepository : JpaRepository<Payment, UUID>, PaymentRepositorySupport
