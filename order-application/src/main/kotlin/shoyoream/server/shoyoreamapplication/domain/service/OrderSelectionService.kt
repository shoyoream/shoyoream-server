package shoyoream.server.shoyoreamapplication.domain.service

import java.util.UUID
import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.domain.entity.Order
import shoyoream.server.shoyoreamapplication.domain.repository.OrderRepository
import shoyoream.server.shoyoreamapplication.core.infra.extensions.findNullableSingle

@Service
class OrderSelectionService(
    private val orderRepository: OrderRepository
) {
    fun findOrderById(orderId: UUID): Order? {
        return orderRepository.findNullableSingle {
            select(
                entity(Order::class)
            ).from(
                entity(Order::class)
            ).where(
                path(Order::id).eq(orderId)
            )
        }
    }

    fun countOrdersByStocksId(stocksId: UUID): Long {
        return orderRepository.countOrdersByStocksId(stocksId)
    }
}
