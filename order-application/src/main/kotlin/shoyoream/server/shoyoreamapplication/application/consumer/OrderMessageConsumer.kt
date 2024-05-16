package shoyoream.server.shoyoreamapplication.application.consumer

import com.google.protobuf.InvalidProtocolBufferException
import java.util.*
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import payments.protobuf.PaymentMessage
import shoyoream.server.shoyoreamapplication.core.common.exception.DataNotFoundException
import shoyoream.server.shoyoreamapplication.core.domain.order.entity.OrderStatus
import shoyoream.server.shoyoreamapplication.core.domain.order.exception.OrderErrorType
import shoyoream.server.shoyoreamapplication.core.domain.order.service.OrderSelectionService
import shoyoream.server.shoyoreamapplication.core.infra.model.PaymentOrderTopics

@Component
class OrderMessageConsumer(
    private val orderSelectionService: OrderSelectionService
) {
    @Transactional
    @KafkaListener(topics = [PaymentOrderTopics.ORDER_STATUS], containerFactory = "orderListenerContainerFactory")
    fun listenOrderStatus(message: ConsumerRecord<String, Any>) {
        try {
            val paymentSuccessMessage = PaymentMessage.PaymentSuccessMessage.parseFrom(message.value() as ByteArray)

            val targetOrder = orderSelectionService.findOrderById(UUID.fromString(paymentSuccessMessage.orderId))
                ?: throw DataNotFoundException(OrderErrorType.NOT_FOUND_ORDER)

            targetOrder.updateOrderStatus(OrderStatus.valueOf(paymentSuccessMessage.updatedStatus))
        } catch (e: InvalidProtocolBufferException) {
            throw e
        }
    }
}
