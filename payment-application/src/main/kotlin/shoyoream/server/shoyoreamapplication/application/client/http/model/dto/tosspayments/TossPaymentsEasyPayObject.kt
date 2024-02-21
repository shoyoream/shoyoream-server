package shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments

data class TossPaymentsEasyPayObject(
    val provider: String,
    val amount: Double,
    val discountAmount: Double
)
