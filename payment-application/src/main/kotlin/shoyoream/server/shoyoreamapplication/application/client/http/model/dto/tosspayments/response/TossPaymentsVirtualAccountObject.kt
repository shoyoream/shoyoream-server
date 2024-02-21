package shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.response

import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.TossPaymentsEnums

data class TossPaymentsVirtualAccountObject(
    val accountType: String,
    val accountNumber: String,
    val customerName: String,
    val dueDate: String,
    val refundStatus: TossPaymentsEnums.RefundStatus,
    val expired: Boolean,
    val settlementStatus: TossPaymentsEnums.SettlementStatus,
    val refundReceiveAccount: TossRefundReceiveAccount
) {
    data class TossRefundReceiveAccount(
        val bankCode: String,
        val accountNumber: String,
        val holderName: String
    )
}
