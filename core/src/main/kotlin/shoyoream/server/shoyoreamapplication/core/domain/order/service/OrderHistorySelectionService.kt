package shoyoream.server.shoyoreamapplication.core.domain.order.service

import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.core.domain.order.repository.OrderHistoryRepository

@Service
class OrderHistorySelectionService(
    private val orderHistoryRepository: OrderHistoryRepository
)
