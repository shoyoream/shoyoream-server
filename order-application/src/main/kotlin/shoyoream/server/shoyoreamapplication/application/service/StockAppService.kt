package shoyoream.server.shoyoreamapplication.application.service

import java.util.UUID
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.application.dto.StockRequestDTO
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse
import shoyoream.server.shoyoreamapplication.core.common.exception.DataNotFoundException
import shoyoream.server.shoyoreamapplication.core.domain.order.entity.Stocks
import shoyoream.server.shoyoreamapplication.core.domain.order.exception.StocksErrorType
import shoyoream.server.shoyoreamapplication.core.domain.order.service.StocksDomainService
import shoyoream.server.shoyoreamapplication.core.domain.order.service.StocksSelectionService

@Service
class StockAppService(
    private val stocksDomainService: StocksDomainService,
    private val stocksSelectionService: StocksSelectionService
) {
    @Transactional
    fun registerStock(stockInput: StockRequestDTO.StockInput): DefaultResponse<UUID> {
        val newStocks = stocksDomainService.createStocks(
            Stocks.of(
                goodsId = stockInput.goodsId,
                goodsType = stockInput.goodsType,
                goodsSize = stockInput.goodsSize,
                price = stockInput.price
            )
        )
        return DefaultResponse.response(newStocks.id)
    }

    @Transactional(readOnly = true)
    fun getStocks(stockId: UUID): DefaultResponse<UUID> {
        val targetStocks = stocksSelectionService.findStocksById(stockId)
            ?: throw DataNotFoundException(StocksErrorType.NOT_FOUND_STOCKS)
        return DefaultResponse.response(targetStocks.id)
    }
}
