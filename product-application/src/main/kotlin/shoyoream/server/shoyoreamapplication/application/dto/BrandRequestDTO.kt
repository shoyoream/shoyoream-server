package shoyoream.server.shoyoreamapplication.application.dto

import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsSize
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsType
import java.util.UUID

class BrandRequestDTO {
    data class GoodsInput(
        val goodsName: String,
        val goodsCode: String,
        val goodsType: GoodsType,
        val goodsSize: GoodsSize,
        val brandId: UUID
    )
}
