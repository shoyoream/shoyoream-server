package shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.response

import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.TossPaymentsEnums

data class TossPaymentsMobilePhoneObject(
    val customerMobilePhone: String,
    val settlementStatus: TossPaymentsEnums.SettlementStatus,
    val receiptUrl: String
)
