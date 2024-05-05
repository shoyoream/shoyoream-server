package shoyoream.server.shoyoreamapplication.application.consumer

import java.util.*
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class OrderMessageConsumer(
    private val kafkaTemplate: KafkaTemplate<UUID, Any>
) {
    // TODO : 결제에 따른 리스너 생성
}
