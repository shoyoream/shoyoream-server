package shoyoream.server.shoyoreamapplication.application.client.service

import shoyoream.server.shoyoreamapplication.application.client.http.model.enumerations.PayGateway
import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.PayClientRequest
import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.PayResponse

interface PayClient {
    fun getPayGateway(): PayGateway

    fun request(payClientRequest: PayClientRequest): PayResponse
}
