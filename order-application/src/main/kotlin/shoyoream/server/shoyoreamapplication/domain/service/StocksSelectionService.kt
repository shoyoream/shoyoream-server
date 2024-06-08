package shoyoream.server.shoyoreamapplication.domain.service

import java.util.*
import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.domain.entity.Stocks
import shoyoream.server.shoyoreamapplication.domain.repository.StocksRepository
import shoyoream.server.shoyoreamapplication.core.infra.extensions.findNullableSingle

@Service
class StocksSelectionService(
    private val stocksRepository: StocksRepository
) {
    fun findStocksById(stocksId: UUID): Stocks? {
        return stocksRepository.findNullableSingle {
            select(
                entity(Stocks::class)
            ).from(
                entity(Stocks::class)
            ).where(
                path(Stocks::id).eq(stocksId)
            )
        }
    }
}
