package shoyoream.server.shoyoreamapplication.resolver

import java.math.BigDecimal
import java.util.UUID
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller
import shoyoream.server.shoyoreamapplication.application.service.StockAppService
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsSize
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsType

@Controller
class StockResolver(
    private val stockAppService: StockAppService
) {
    @MutationMapping
    fun registerStock(
        @Argument goodsId: UUID,
        @Argument goodsType: GoodsType,
        @Argument goodsSize: GoodsSize,
        @Argument price: BigDecimal
    ): DefaultResponse<UUID> {
        return stockAppService.registerStock(goodsId, goodsType, goodsSize, price)
    }
}
