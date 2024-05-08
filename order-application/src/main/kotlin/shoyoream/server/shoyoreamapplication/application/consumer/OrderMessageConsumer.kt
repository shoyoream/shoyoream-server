package shoyoream.server.shoyoreamapplication.application.consumer

import com.google.protobuf.InvalidProtocolBufferException
import java.util.*
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import payments.protobuf.PaymentMessage
import shoyoream.server.shoyoreamapplication.core.common.exception.DataNotFoundException
import shoyoream.server.shoyoreamapplication.core.domain.order.entity.OrderStatus
import shoyoream.server.shoyoreamapplication.core.domain.order.exception.OrderErrorType
import shoyoream.server.shoyoreamapplication.core.domain.order.service.OrderSelectionService

@Component
class OrderMessageConsumer(
    private val orderSelectionService: OrderSelectionService,
    private val kafkaTemplate: KafkaTemplate<UUID, Any>
) {
    // TODO : 결제에 따른 리스너 생성
    @Transactional
    @KafkaListener(topics = ["order-status"])
    fun listenOrderStatus(message: Any) {
        try {
            val paymentSuccessMessage = PaymentMessage.PaymentSuccessMessage.parseFrom(message as ByteArray)
            val targetOrder = orderSelectionService.findOrderById(UUID.fromString(paymentSuccessMessage.orderId))
                ?: throw DataNotFoundException(OrderErrorType.NOT_FOUND_ORDER)

            targetOrder.updateOrderStatus(OrderStatus.valueOf(paymentSuccessMessage.updatedStatus))
        } catch (e: InvalidProtocolBufferException) {
            throw e
        }
    }
}
