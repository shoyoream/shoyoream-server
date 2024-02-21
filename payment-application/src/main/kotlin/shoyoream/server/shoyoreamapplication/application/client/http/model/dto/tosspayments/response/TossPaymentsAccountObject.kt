package shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.response

import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.TossPaymentsEnums

data class TossPaymentsAccountObject(
    val bankCode: String,
    val settlementStatus: TossPaymentsEnums.SettlementStatus
)
