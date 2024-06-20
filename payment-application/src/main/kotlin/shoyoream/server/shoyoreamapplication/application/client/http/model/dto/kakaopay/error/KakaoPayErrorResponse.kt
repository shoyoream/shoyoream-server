package shoyoream.server.shoyoreamapplication.application.client.http.model.dto.kakaopay.error

import shoyoream.server.shoyoreamapplication.core.common.exception.PayError

data class KakaoPayErrorResponse(
    val error_code: Int,
    val error_message: String
) : PayError
