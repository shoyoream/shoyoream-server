package shoyoream.server.shoyoreamapplication.core.domain.order.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.core.domain.order.entity.Stocks
import shoyoream.server.shoyoreamapplication.core.domain.order.repository.StocksRepository

@Service
class StocksDomainService(
    private val stocksRepository: StocksRepository
) {
    @Transactional
    fun createStocks(stocks: Stocks): Stocks {
        return stocksRepository.save(stocks)
    }
}
