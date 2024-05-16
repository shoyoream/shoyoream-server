package shoyoream.server.shoyoreamapplication.application.dto

import java.util.UUID
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsSize
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsType

class OrderRequestDTO {
    data class OrderInput(
        val goodsId: UUID,
        val goodsType: GoodsType,
        val goodsSize: GoodsSize,
        val buyerId: Long,
        val stocksId: UUID
    )
}
