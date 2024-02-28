package shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments

data class TossPaymentsCancelCashReceiptObject(
    val receiptKey: String,
    val orderId: String,
    val orderName: String,
    val type: String,
    val issueNumber: String,
    val receiptUrl: String,
    val businessNumber: String,
    val transactionType: TossPaymentsEnums.CashTransactionType,
    val amount: Int,
    val taxFreeAmount: Int,
    val issueStatus: TossPaymentsEnums.IssueStatus,
    val failure: TossPaymentsErrorResponse,
    val customerIdentityNumber: String,
    val requestedAt: String
)
