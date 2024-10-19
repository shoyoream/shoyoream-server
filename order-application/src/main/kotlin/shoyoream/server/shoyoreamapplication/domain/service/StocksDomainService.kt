package shoyoream.server.shoyoreamapplication.domain.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.domain.entity.Stocks
import shoyoream.server.shoyoreamapplication.domain.repository.StocksRepository

interface StocksDomainService {
    fun createStocks(stocks: Stocks): Stocks
}

@Service
class StocksDomainServiceImpl(
    private val stocksRepository: StocksRepository
) : StocksDomainService {
    @Transactional
    override fun createStocks(stocks: Stocks): Stocks {
        return stocksRepository.save(stocks)
    }
}
