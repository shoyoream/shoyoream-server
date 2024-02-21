package shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.response

import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.PayResponse
import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments.TossPaymentsEnums

data class TossPaymentsCommonObject(
    val version: String,
    val paymentKey: String,
    val type: TossPaymentsEnums.PaymentType,
    val orderId: String,
    val orderName: String,
    val mId: String,
    val currency: String,
    val method: String,
    val totalAmount: Double,
    val balanceAmount: Double,
    val status: TossPaymentsEnums.PaymentStatus,
    val requestedAt: String,
    val approvedAt: String,
    val useEscrow: Boolean,
    val lastTransactionKey: String?,
    val suppliedAmount: Double,
    val vat: Double,
    val cultureExpense: Boolean,
    val taxFreeAmount: Double,
    val taxExemptionAmount: Int,
    val cancels: List<TossPaymentsCancelObject>,
    val isPartialCancelable: Boolean,
    val card: TossPaymentsCardObject?,
    val virtualAccount: TossPaymentsVirtualAccountObject,
    val secret: String?,
    val mobilePhone: TossPaymentsMobilePhoneObject?,
    val giftCertificate: TossPaymentsGiftCertificateObject?,
    val transfer: TossPaymentsAccountObject?,
    val receipt: TossPaymentsReceiptObject?,
    val checkout: TossPaymentsCheckoutObject?,
    val easyPay: TossPaymentsEasyPayObject,
    val country: String,
    val failure: TossPaymentsErrorResponse?,
    val cashReceipt: TossPaymentsCancelCashReceiptObject?,
    val cashReceipts: List<TossPaymentsCancelCashReceiptObject>,
    val discount: TossPaymentsDiscountObject?
) : PayResponse
