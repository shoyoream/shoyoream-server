package shoyoream.server.shoyoreamapplication.application.client.service

import java.util.UUID
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatusCode
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import shoyoream.server.shoyoreamapplication.application.client.http.model.enumerations.PayGateway
import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.PayClientRequest
import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.PayResponse
import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.request.TossPaymentsApproveRequest
import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.response.TossPaymentsCommonObject
import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.errorr.TossPaymentsErrorResponse
import shoyoream.server.shoyoreamapplication.application.exception.PayException
import shoyoream.server.shoyoreamapplication.core.common.utils.Base64UtilFunctions
import shoyoream.server.shoyoreamapplication.application.client.http.model.property.PaymentProperty

@Component
class TossPaymentsClient(
    private val tossPaymentsWebClient: WebClient,
    private val paymentProperty: PaymentProperty
) : PayClient {
    companion object {
        private const val IDEMPOTENCY_KEY = "Idempotency-Key"
        private const val BASIC_HEADER = "Basic "
    }

    override fun getPayGateway(): PayGateway = PayGateway.TOSS_PAYMENTS

    override fun request(payClientRequest: PayClientRequest): PayResponse {
        val tossPaymentsApproveRequest = payClientRequest as TossPaymentsApproveRequest

        return tossPaymentsWebClient.post()
            .uri(paymentProperty.tossPayments.endpoint.approve)
            .headers { it.addAll(generateHeaders()) }
            .bodyValue(tossPaymentsApproveRequest)
            .retrieve()
            .onStatus(HttpStatusCode::isError) { apiResponse ->
                apiResponse
                    .bodyToMono(TossPaymentsErrorResponse::class.java)
                    .flatMap { error -> Mono.error(PayException(error)) }
            }
            .bodyToMono(TossPaymentsCommonObject::class.java)
            .block()!!
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
