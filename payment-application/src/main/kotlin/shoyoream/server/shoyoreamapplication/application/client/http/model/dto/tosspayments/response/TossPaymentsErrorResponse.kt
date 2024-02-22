package shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.response

import shoyoream.server.shoyoreamapplication.core.common.exception.PayError

data class TossPaymentsErrorResponse(
    val code: String,
    val message: String
) : PayError
