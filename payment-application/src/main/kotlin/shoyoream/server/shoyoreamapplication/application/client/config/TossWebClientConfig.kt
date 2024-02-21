package shoyoream.server.shoyoreamapplication.application.client.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import shoyoream.server.shoyoreamapplication.core.infra.http.config.WebClientConfig
import shoyoream.server.shoyoreamapplication.core.infra.model.PaymentProperty

@Configuration
class TossWebClientConfig(
    private val paymentProperty: PaymentProperty
) : WebClientConfig() {
    @Bean
    fun tossWebClient(): WebClient {
        return createWebClient(
            baseUrl = paymentProperty.toss.host.url,
            readTimeout = paymentProperty.timeout.readTime,
            connectTimeout = paymentProperty.timeout.connectTime
        )
    }
}
