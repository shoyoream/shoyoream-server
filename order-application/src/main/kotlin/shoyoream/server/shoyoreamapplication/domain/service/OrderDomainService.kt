package shoyoream.server.shoyoreamapplication.domain.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.domain.entity.Order
import shoyoream.server.shoyoreamapplication.domain.repository.OrderRepository

@Service
class OrderDomainService(
    private val orderRepository: OrderRepository
) {
    @Transactional
    fun createOrder(order: Order): Order {
        return orderRepository.save(order)
    }
}
