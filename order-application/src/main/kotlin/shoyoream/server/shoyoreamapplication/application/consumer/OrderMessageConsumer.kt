package shoyoream.server.shoyoreamapplication.application.consumer

import com.google.protobuf.InvalidProtocolBufferException
import java.util.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.core.common.exception.DataNotFoundException
import shoyoream.server.shoyoreamapplication.core.domain.enums.OrderStatus
import shoyoream.server.shoyoreamapplication.domain.exception.OrderErrorType
import shoyoream.server.shoyoreamapplication.domain.service.OrderSelectionService
import shoyoream.server.shoyoreamapplication.core.infra.model.PaymentOrderTopics
import shoyoream.server.shoyoreamapplication.core.infra.model.PaymentSuccessMessage

@Component
class OrderMessageConsumer(
    private val orderSelectionService: OrderSelectionService
) {
    @OptIn(ExperimentalSerializationApi::class)
    @Transactional
    @KafkaListener(topics = [PaymentOrderTopics.ORDER_STATUS], containerFactory = "orderListenerContainerFactory")
    fun listenOrderStatus(message: ConsumerRecord<String, Any>) {
        try {
            val paymentSuccessMessage = ProtoBuf.decodeFromByteArray<PaymentSuccessMessage>(message.value() as ByteArray)

            val targetOrder = orderSelectionService.findOrderById(UUID.fromString(paymentSuccessMessage.orderId))
                ?: throw DataNotFoundException(OrderErrorType.NOT_FOUND_ORDER)

            targetOrder.updateOrderStatus(OrderStatus.valueOf(paymentSuccessMessage.updatedStatus))
        } catch (e: InvalidProtocolBufferException) {
            throw e
        }
    }
}
