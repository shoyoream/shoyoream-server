package shoyoream.server.shoyoreamapplication.application.service

import java.util.UUID
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.application.dto.OrderRequestDTO
import shoyoream.server.shoyoreamapplication.core.common.aop.annotation.DistributedLock
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse
import shoyoream.server.shoyoreamapplication.core.common.exception.DataNotFoundException
import shoyoream.server.shoyoreamapplication.core.domain.order.entity.Order
import shoyoream.server.shoyoreamapplication.core.domain.order.exception.OrderErrorType
import shoyoream.server.shoyoreamapplication.core.domain.order.service.OrderDomainService
import shoyoream.server.shoyoreamapplication.core.domain.order.service.OrderSelectionService

@Service
class OrderAppService(
    private val orderSelectionService: OrderSelectionService,
    private val orderDomainService: OrderDomainService
) {
    @Transactional(readOnly = true)
    fun getOrder(orderId: UUID): DefaultResponse<UUID> {
        val targetOrder = orderSelectionService.findOrderById(orderId)
            ?: throw DataNotFoundException(OrderErrorType.NOT_FOUND_ORDER)
        return DefaultResponse.uuidResponse(targetOrder.id)
    }

    @DistributedLock(key = "#orderInput.goodsId")
    fun registerOrder(orderInput: OrderRequestDTO.OrderInput): DefaultResponse<UUID> {
        val newOrder = orderDomainService.createOrder(
            Order.of(
                orderId = UUID.randomUUID(),
                goodsId = orderInput.goodsId,
                stocksId = orderInput.stocksId,
                buyerId = orderInput.buyerId
            )
        )

        return DefaultResponse.uuidResponse(newOrder.id)
    }
}
