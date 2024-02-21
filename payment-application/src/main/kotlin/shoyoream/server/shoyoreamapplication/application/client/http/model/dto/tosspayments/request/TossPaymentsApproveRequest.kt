package shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.request

import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.PayRequest

data class TossPaymentsApproveRequest(
    val paymentKey: String,
    val orderId: String,
    val amount: Int
) : PayRequest
