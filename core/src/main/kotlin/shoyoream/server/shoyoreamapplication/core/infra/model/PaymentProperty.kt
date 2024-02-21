package shoyoream.server.shoyoreamapplication.core.infra.model

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "pay")
class PaymentProperty(
    val kakaoPay: KakaoPay,
    val naverPay: NaverPay,
    val tossPayments: TossPayments,
    val timeout: Timeout
) {
    data class KakaoPay(
        val authentication: Authentication,
        val host: Host
    )

    data class NaverPay(
        val authentication: Authentication,
        val host: Host
    )

    data class TossPayments(
        val authentication: Authentication,
        val host: Host,
        val endpoint: Endpoint
    ) {
        data class Endpoint(
            val approve: String
        )
    }

    data class Authentication(
        val accessKey: String,
        val secretKey: String
    )

    data class Host(
        val url: String
    )

    data class Timeout(
        val readTime: Long,
        val connectTime: Long
    )
}
