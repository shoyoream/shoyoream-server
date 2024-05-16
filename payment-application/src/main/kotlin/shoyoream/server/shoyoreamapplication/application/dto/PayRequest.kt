package shoyoream.server.shoyoreamapplication.application.dto

import java.util.UUID
import shoyoream.server.shoyoreamapplication.core.domain.payment.entity.enums.PayType

data class PayRequest(
    val orderId: UUID,
    val buyerId: Long,
    val payType: PayType
)
