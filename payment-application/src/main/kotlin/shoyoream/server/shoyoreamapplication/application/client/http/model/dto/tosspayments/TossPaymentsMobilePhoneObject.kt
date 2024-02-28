package shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments

data class TossPaymentsMobilePhoneObject(
    val customerMobilePhone: String,
    val settlementStatus: TossPaymentsEnums.SettlementStatus,
    val receiptUrl: String
)
