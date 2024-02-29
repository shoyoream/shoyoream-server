package shoyoream.server.shoyoreamapplication.application.service

import java.math.BigDecimal
import java.util.UUID
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsSize
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsType
import shoyoream.server.shoyoreamapplication.core.domain.order.entity.Stocks
import shoyoream.server.shoyoreamapplication.core.domain.order.service.StocksDomainService

@Service
class OrderAppService(
    private val stocksDomainService: StocksDomainService
) {
    @Transactional
    fun registerStock(goodsId: UUID, goodsType: GoodsType, goodsSize: GoodsSize, size: BigDecimal): DefaultResponse<UUID> {
        val newStocks = stocksDomainService.createStocks(
            Stocks.of(goodsId, goodsType, goodsSize, size)
        )
        return DefaultResponse.response(newStocks.id)
    }
}
