package shoyoream.server.shoyoreamapplication.core.domain.order.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.core.domain.order.entity.OrderHistory
import shoyoream.server.shoyoreamapplication.core.domain.order.repository.OrderHistoryRepository

@Service
class OrderHistoryDomainService(
    private val orderHistoryRepository: OrderHistoryRepository
) {
    @Transactional
    fun createOrderHistory(orderHistory: OrderHistory): OrderHistory {
        return orderHistoryRepository.save(orderHistory)
    }
}
