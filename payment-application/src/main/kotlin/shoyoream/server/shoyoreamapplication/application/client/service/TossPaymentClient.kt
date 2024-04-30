package shoyoream.server.shoyoreamapplication.application.client.service

import java.util.UUID
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import shoyoream.server.shoyoreamapplication.application.client.http.model.enumerations.PayGateway
import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.PayRequest
import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.PayResponse
import shoyoream.server.shoyoreamapplication.core.common.utils.Base64UtilFunctions
import shoyoream.server.shoyoreamapplication.application.client.http.model.property.PaymentProperty

@Component
class TossPaymentClient(
    private val tossPaymentsWebClient: WebClient,
    private val paymentProperty: PaymentProperty
) : PayClient {
    companion object {
        private const val IDEMPOTENCY_KEY = "Idempotency-Key"
        private const val BASIC_HEADER = "Basic "
    }

    override fun getPayGateway(): PayGateway = PayGateway.TOSS_PAYMENTS

    override fun request(payRequest: PayRequest): PayResponse {
        TODO("Not yet implemented")
    }

    private fun generateIdempotencyKeyHeaders(): HttpHeaders {
        val headers = generateHeaders()
        headers.add(IDEMPOTENCY_KEY, UUID.randomUUID().toString())
        return headers
    }

    private fun generateHeaders(): HttpHeaders {
        val secretKey = paymentProperty.tossPayments.authentication.secretKey

        val encodedCredentials = Base64UtilFunctions.encodeToString("$secretKey:")
        val authorizationHeader = "$BASIC_HEADER$encodedCredentials"

        val httpHeaders = HttpHeaders()
        httpHeaders.add(HttpHeaders.AUTHORIZATION, authorizationHeader)
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        return httpHeaders
    }
}
