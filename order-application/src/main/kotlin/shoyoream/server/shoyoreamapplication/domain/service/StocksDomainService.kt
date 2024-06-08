package shoyoream.server.shoyoreamapplication.domain.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.domain.entity.Stocks
import shoyoream.server.shoyoreamapplication.domain.repository.StocksRepository

@Service
class StocksDomainService(
    private val stocksRepository: StocksRepository
) {
    @Transactional
    fun createStocks(stocks: Stocks): Stocks {
        return stocksRepository.save(stocks)
    }
}
