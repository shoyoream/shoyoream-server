package shoyoream.server.shoyoreamapplication.core.domain.payment.repository

import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import shoyoream.server.shoyoreamapplication.core.domain.payment.entity.Payment

interface PaymentRepository : JpaRepository<Payment, UUID>, PaymentRepositorySupport
