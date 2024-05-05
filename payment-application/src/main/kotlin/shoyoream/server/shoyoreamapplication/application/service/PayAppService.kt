package shoyoream.server.shoyoreamapplication.application.service

import java.util.UUID
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.application.client.service.PayClientStrategyService
import shoyoream.server.shoyoreamapplication.application.dto.PayRequest
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse

@Service
class PayAppService(
    private val payClientStrategyService: PayClientStrategyService
) {
    @Transactional
    fun pay(payRequest: PayRequest): DefaultResponse<UUID> {
        // TODO : PayType 에 따라 결제 분기처리 하기

        return DefaultResponse.uuidResponse(UUID.randomUUID())
    }
}
