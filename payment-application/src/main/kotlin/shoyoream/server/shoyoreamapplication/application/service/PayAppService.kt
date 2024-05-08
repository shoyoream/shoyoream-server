package shoyoream.server.shoyoreamapplication.application.service

import java.util.UUID
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import payments.protobuf.PaymentMessage
import shoyoream.server.shoyoreamapplication.application.client.service.PayClientStrategyService
import shoyoream.server.shoyoreamapplication.application.dto.PayRequest
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse
import shoyoream.server.shoyoreamapplication.core.domain.order.entity.OrderStatus

@Service
class PayAppService(
    private val payClientStrategyService: PayClientStrategyService,
    private val paymentProducerTemplate: KafkaTemplate<UUID, Any>
) {
    @Transactional
    fun pay(payRequest: PayRequest): DefaultResponse<UUID> {
        // TODO : PayType 에 따라 결제 분기처리 하기
        // TODO : 결제 완료시에 해당 order 정보 업데이트 보내기
        val orderStatusMessage = PaymentMessage.PaymentSuccessMessage.newBuilder()
            .setOrderId(payRequest.orderId.toString())
            .setUpdatedStatus(OrderStatus.PAYMENT_COMPLETED.name)
            .build()

        paymentProducerTemplate.send("order-status", UUID.randomUUID(), orderStatusMessage)
        return DefaultResponse.uuidResponse(UUID.randomUUID())
    }
}
