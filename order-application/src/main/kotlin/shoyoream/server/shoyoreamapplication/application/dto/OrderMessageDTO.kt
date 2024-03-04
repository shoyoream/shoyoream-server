package shoyoream.server.shoyoreamapplication.application.dto

import java.util.*

data class OrderMessageDTO(
    // FIXME : 예시
    val orderId: UUID,
    val orderStatus: String
)
