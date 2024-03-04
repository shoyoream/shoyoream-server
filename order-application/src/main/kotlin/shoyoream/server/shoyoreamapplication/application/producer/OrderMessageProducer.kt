package shoyoream.server.shoyoreamapplication.application.producer

import java.util.UUID
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import shoyoream.server.shoyoreamapplication.application.dto.OrderMessageDTO

@Component
class OrderMessageProducer(
    private val kafkaTemplate: KafkaTemplate<UUID, OrderMessageDTO>
) {
    fun sendOrderMessage(orderMessageDTO: OrderMessageDTO) {
        kafkaTemplate.send("order", orderMessageDTO.orderId, orderMessageDTO)
    }
}
