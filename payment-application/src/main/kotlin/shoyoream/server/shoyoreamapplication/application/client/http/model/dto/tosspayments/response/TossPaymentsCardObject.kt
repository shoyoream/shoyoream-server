package shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.response

import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.TossPaymentsEnums

data class TossPaymentsCardObject(
    val amount: Double,
    val issuerCode: String,
    val acquirerCode: String?,
    val number: String,
    val installmentPlanMonths: Int,
    val approveNo: String,
    val useCardPoint: Boolean,
    val cardType: String,
    val acquireStatus: TossPaymentsEnums.PaymentAcquiredStatus,
    val isInterestFree: Boolean,
    val interestPayer: TossPaymentsEnums.InterestPayer?
)
