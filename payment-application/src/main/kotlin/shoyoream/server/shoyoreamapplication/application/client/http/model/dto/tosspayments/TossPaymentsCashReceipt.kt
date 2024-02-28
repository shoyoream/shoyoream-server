package shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments

data class TossPaymentsCashReceipt(
    val type: String,
    val receiptKey: String,
    val issueNumber: String,
    val receiptUrl: String,
    val amount: Double,
    val taxFreeAmount: Double
)
