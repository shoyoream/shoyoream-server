package shoyoream.server.shoyoreamapplication.application.client.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import shoyoream.server.shoyoreamapplication.application.client.http.model.property.PaymentProperty
import shoyoream.server.shoyoreamapplication.core.infra.http.config.WebClientConfig

@Configuration
class KakaoPayWebClientConfig(
    private val paymentProperty: PaymentProperty
) : WebClientConfig() {
    @Bean
    fun kakaoPayWebClient() = createWebClient(
        baseUrl = paymentProperty.kakaoPay.host.url,
        readTimeout = paymentProperty.timeout.readTime,
        connectTimeout = paymentProperty.timeout.connectTime
    )
}
