package shoyoream.server.shoyoreamapplication.application.consumer

import com.google.protobuf.InvalidProtocolBufferException
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import payments.protobuf.PaymentMessage
import shoyoream.server.shoyoreamapplication.core.domain.order.service.OrderSelectionService

@Component
class OrderMessageConsumer(
    private val orderSelectionService: OrderSelectionService,
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {
    // TODO : 결제에 따른 리스너 생성
    @Transactional
    @KafkaListener(topics = ["order-status"], containerFactory = "orderListenerContainerFactory")
    fun listenOrderStatus(message: ConsumerRecord<String, Any>) {
        try {
            val paymentSuccessMessage = PaymentMessage.PaymentSuccessMessage.parseFrom(message.value() as ByteArray)

            println(paymentSuccessMessage.toString())
//            val targetOrder = orderSelectionService.findOrderById(UUID.fromString(paymentSuccessMessage.orderId))
//                ?: throw DataNotFoundException(OrderErrorType.NOT_FOUND_ORDER)
//
//            targetOrder.updateOrderStatus(OrderStatus.valueOf(paymentSuccessMessage.updatedStatus))
        } catch (e: InvalidProtocolBufferException) {
            throw e
        }
    }
}
