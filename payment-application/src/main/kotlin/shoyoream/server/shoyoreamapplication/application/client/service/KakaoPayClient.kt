package shoyoream.server.shoyoreamapplication.application.client.service

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import shoyoream.server.shoyoreamapplication.application.client.http.model.enumerations.PayGateway
import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.PayRequest
import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.PayResponse

@Component
class KakaoPayClient(
    private val kakaoPayWebClient: WebClient
) : PayClient {
    override fun getPayGateway(): PayGateway = PayGateway.KAKAO_PAY

    override fun request(payRequest: PayRequest): PayResponse {
        TODO("Not yet implemented")
    }
}
