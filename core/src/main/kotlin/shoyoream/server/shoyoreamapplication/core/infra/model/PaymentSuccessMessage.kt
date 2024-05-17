package shoyoream.server.shoyoreamapplication.core.infra.model

import kotlinx.serialization.Serializable

@Serializable
data class PaymentSuccessMessage(
    val orderId: String,
    val updatedStatus: String
)
