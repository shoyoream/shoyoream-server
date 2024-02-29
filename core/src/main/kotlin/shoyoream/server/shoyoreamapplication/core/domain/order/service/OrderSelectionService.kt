package shoyoream.server.shoyoreamapplication.core.domain.order.service

import java.util.UUID
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.core.domain.order.entity.Order
import shoyoream.server.shoyoreamapplication.core.domain.order.repository.OrderRepository

@Service
class OrderSelectionService(
    private val orderRepository: OrderRepository
) {
    fun findOrderById(orderId: UUID): Order? {
        return orderRepository.findByIdOrNull(orderId)
    }
}
