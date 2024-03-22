package shoyoream.server.shoyoreamapplication.core.domain.order.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.core.domain.order.entity.Order
import shoyoream.server.shoyoreamapplication.core.domain.order.repository.OrderRepository

@Service
class OrderDomainService(
    private val orderRepository: OrderRepository
) {
    @Transactional
    fun createOrder(order: Order): Order {
        return orderRepository.save(order)
    }
}
