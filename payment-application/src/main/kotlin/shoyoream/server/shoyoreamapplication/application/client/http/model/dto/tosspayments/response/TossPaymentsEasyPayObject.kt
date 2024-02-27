package shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.response

data class TossPaymentsEasyPayObject(
    val provider: String,
    val amount: Double,
    val discountAmount: Double
)
