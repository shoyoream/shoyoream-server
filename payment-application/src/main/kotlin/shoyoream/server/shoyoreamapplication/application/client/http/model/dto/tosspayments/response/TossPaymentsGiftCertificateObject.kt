package shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.response

import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.TossPaymentsEnums

data class TossPaymentsGiftCertificateObject(
    val approveNo: String,
    val settlementStatus: TossPaymentsEnums.SettlementStatus
)
