package shoyoream.server.shoyoreamapplication.application.client.service

import java.util.concurrent.ConcurrentHashMap
import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.application.client.http.model.enumerations.PayGateway

@Service
class PayClientStrategyService(
    services: Set<PayClient>
) {
    private val clientService: Map<PayGateway, PayClient> = createGateway(services)

    fun findPayClientByPayGateway(payGateway: PayGateway): PayClient {
        return clientService[payGateway]
            ?: throw IllegalArgumentException("Bad Pay Gateway.")
    }

    private fun createGateway(services: Set<PayClient>): Map<PayGateway, PayClient> {
        val map = ConcurrentHashMap<PayGateway, PayClient>()
        services.forEach { client ->
            map[client.getPayGateway()] = client
        }
        return map
    }
}
