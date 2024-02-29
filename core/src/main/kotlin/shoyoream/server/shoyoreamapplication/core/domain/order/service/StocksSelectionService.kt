package shoyoream.server.shoyoreamapplication.core.domain.order.service

import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.core.domain.order.repository.StocksRepository

@Service
class StocksSelectionService(
    private val stocksRepository: StocksRepository
)
