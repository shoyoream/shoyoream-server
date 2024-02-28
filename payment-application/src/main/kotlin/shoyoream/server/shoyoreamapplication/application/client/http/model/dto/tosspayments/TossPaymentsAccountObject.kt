package shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments

data class TossPaymentsAccountObject(
    val bankCode: String,
    val settlementStatus: TossPaymentsEnums.SettlementStatus
)
