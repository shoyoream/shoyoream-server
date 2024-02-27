package shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.response

data class TossPaymentsCancelObject(
    val cancelAmount: Double,
    val cancelReason: String,
    val taxFreeAmount: Double,
    val taxExemptionAmount: Int,
    val refundableAmount: Double,
    val easyPayDiscountAmount: Double,
    val canceledAt: String,
    val transactionKey: String,
    val receiptKey: String?
)
