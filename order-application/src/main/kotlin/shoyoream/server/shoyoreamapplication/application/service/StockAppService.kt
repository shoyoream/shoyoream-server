package shoyoream.server.shoyoreamapplication.application.service

import java.util.UUID
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.application.dto.StockRequestDTO
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse
import shoyoream.server.shoyoreamapplication.core.common.exception.DataNotFoundException
import shoyoream.server.shoyoreamapplication.domain.entity.Stocks
import shoyoream.server.shoyoreamapplication.domain.exception.StocksErrorType
import shoyoream.server.shoyoreamapplication.domain.service.StocksDomainService
import shoyoream.server.shoyoreamapplication.domain.service.StocksSelectionService

interface StockAppService {
    fun registerStock(stockInput: StockRequestDTO.StockInput): DefaultResponse<UUID>
    fun getStocks(stockId: UUID): DefaultResponse<UUID>
}

@Service
class StockAppServiceImpl(
    private val stocksDomainService: StocksDomainService,
    private val stocksSelectionService: StocksSelectionService
) : StockAppService {
    @Transactional
    override fun registerStock(stockInput: StockRequestDTO.StockInput): DefaultResponse<UUID> {
        val newStocks = stocksDomainService.createStocks(
            Stocks.of(
                stocksId = UUID.randomUUID(),
                goodsId = stockInput.goodsId,
                goodsType = stockInput.goodsType,
                goodsSize = stockInput.goodsSize,
                price = stockInput.price,
                sellerId = stockInput.sellerId
            )
        )
        return DefaultResponse.uuidResponse(newStocks.id)
    }

    @Transactional(readOnly = true)
    override fun getStocks(stockId: UUID): DefaultResponse<UUID> {
        val targetStocks = stocksSelectionService.findStocksById(stockId)
            ?: throw DataNotFoundException(StocksErrorType.NOT_FOUND_STOCKS)
        return DefaultResponse.uuidResponse(targetStocks.id)
    }
}
