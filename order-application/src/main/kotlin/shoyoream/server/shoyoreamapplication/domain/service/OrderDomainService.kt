package shoyoream.server.shoyoreamapplication.domain.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.domain.entity.Order
import shoyoream.server.shoyoreamapplication.domain.repository.OrderRepository

interface OrderDomainService {
    fun createOrder(order: Order): Order
}

@Service
class OrderDomainServiceImpl(
    private val orderRepository: OrderRepository
) : OrderDomainService {
    @Transactional
    override fun createOrder(order: Order): Order {
        return orderRepository.save(order)
    }
}
