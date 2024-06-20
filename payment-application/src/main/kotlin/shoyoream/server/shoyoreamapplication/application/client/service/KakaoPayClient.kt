package shoyoream.server.shoyoreamapplication.application.client.service

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.PayClientRequest
import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.PayResponse
import shoyoream.server.shoyoreamapplication.application.client.http.model.enumerations.PayGateway

@Component
class KakaoPayClient(
    private val kakaoPayWebClient: WebClient
) : PayClient {
    override fun getPayGateway(): PayGateway = PayGateway.KAKAO_PAY

    override fun request(payClientRequest: PayClientRequest): PayResponse {
        TODO("Not yet implemented")
    }
}
