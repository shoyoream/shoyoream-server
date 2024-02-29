package shoyoream.server.shoyoreamapplication.core.domain.order.service

import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.core.domain.order.repository.OrderRepository

@Service
class OrderSelectionService(
    private val orderRepository: OrderRepository
)
