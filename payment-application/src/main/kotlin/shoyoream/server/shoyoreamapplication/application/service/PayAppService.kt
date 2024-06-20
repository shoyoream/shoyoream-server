package shoyoream.server.shoyoreamapplication.application.service

import java.util.UUID
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.application.client.http.model.enumerations.PayGateway
import shoyoream.server.shoyoreamapplication.application.client.service.PayClientStrategyService
import shoyoream.server.shoyoreamapplication.application.dto.PayRequest
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse
import shoyoream.server.shoyoreamapplication.core.domain.enums.OrderStatus
import shoyoream.server.shoyoreamapplication.core.infra.model.PaymentOrderTopics
import shoyoream.server.shoyoreamapplication.core.infra.model.PaymentSuccessMessage

@Service
class PayAppService(
    private val payClientStrategyService: PayClientStrategyService,
    private val paymentProducerTemplate: KafkaTemplate<String, Any>
) {
    @OptIn(ExperimentalSerializationApi::class)
    @Transactional
    fun pay(payRequest: PayRequest): DefaultResponse<UUID> {
        // TODO : PayType 에 따라 결제 분기처리 하기
        val payClient = payClientStrategyService.findPayClientByPayGateway(PayGateway.valueOf(payRequest.payType.name))

        val paymentSuccessMessage = ProtoBuf.encodeToByteArray(
            PaymentSuccessMessage(
                orderId = payRequest.orderId.toString(),
                updatedStatus = OrderStatus.PAYMENT_COMPLETED.name
            )
        )

        paymentProducerTemplate.send(PaymentOrderTopics.ORDER_STATUS, UUID.randomUUID().toString(), paymentSuccessMessage)
        return DefaultResponse.uuidResponse(UUID.randomUUID())
    }
}
