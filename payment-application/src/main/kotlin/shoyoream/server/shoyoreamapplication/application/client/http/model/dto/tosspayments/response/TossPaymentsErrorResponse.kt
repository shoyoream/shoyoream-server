package shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.response

import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.PayErrorResponse

data class TossPaymentsErrorResponse(
    val code: String,
    val message: String
) : PayErrorResponse
