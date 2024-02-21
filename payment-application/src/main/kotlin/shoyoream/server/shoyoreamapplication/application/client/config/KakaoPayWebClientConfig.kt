package shoyoream.server.shoyoreamapplication.application.client.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import shoyoream.server.shoyoreamapplication.core.infra.http.config.WebClientConfig
import shoyoream.server.shoyoreamapplication.core.infra.model.PaymentProperty

@Configuration
class KakaoPayWebClientConfig(
    private val paymentProperty: PaymentProperty
) : WebClientConfig() {
    @Bean
    fun kakaoPayWebClient(): WebClient {
        return createWebClient(
            baseUrl = paymentProperty.kakaoPay.host.url,
            readTimeout = paymentProperty.timeout.readTime,
            connectTimeout = paymentProperty.timeout.connectTime
        )
    }
}
