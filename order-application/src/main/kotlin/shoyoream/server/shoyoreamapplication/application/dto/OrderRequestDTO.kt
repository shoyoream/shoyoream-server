package shoyoream.server.shoyoreamapplication.application.dto

import java.util.UUID

class OrderRequestDTO {
    data class OrderInput(
        val goodsId: UUID,
        val buyerId: Long,
        val stocksId: UUID
    )
}
