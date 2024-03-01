package shoyoream.server.shoyoreamapplication.application.dto

import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsSize
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsType
import java.math.BigDecimal
import java.util.UUID

class StockRequestDTO {
    data class StockInput(
        val goodsId: UUID,
        val goodsType: GoodsType,
        val goodsSize: GoodsSize,
        val price: BigDecimal
    )
}
