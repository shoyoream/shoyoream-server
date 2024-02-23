package shoyoream.server.shoyoreamapplication.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.application.client.http.model.enumerations.PayGateway
import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.PayRequest
import shoyoream.server.shoyoreamapplication.application.client.service.PayClientStrategyService

@Service
class PayAppService(
    private val payClientStrategyService: PayClientStrategyService
) {
    @Transactional
    fun pay(payGateway: PayGateway, payRequest: PayRequest) {
        val payClient = payClientStrategyService.findPayClientByPayGateway(payGateway)

        val approveResponse = payClient.request(payRequest)
    }
}
