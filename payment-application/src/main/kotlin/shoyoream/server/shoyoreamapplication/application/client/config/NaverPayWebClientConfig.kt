package shoyoream.server.shoyoreamapplication.application.client.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import shoyoream.server.shoyoreamapplication.core.infra.http.config.WebClientConfig
import shoyoream.server.shoyoreamapplication.application.client.http.model.property.PaymentProperty

@Configuration
class NaverPayWebClientConfig(
    private val paymentProperty: PaymentProperty
) : WebClientConfig() {
    @Bean
    fun naverPayWebClient(): WebClient {
        return createWebClient(
            baseUrl = paymentProperty.naverPay.host.url,
            readTimeout = paymentProperty.timeout.readTime,
            connectTimeout = paymentProperty.timeout.connectTime
        )
    }
}
