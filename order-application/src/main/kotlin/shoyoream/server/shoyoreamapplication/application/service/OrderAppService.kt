package shoyoream.server.shoyoreamapplication.application.service

import java.util.UUID
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse
import shoyoream.server.shoyoreamapplication.core.common.exception.DataNotFoundException
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
        return DefaultResponse.response(targetOrder.id)
    }
}
