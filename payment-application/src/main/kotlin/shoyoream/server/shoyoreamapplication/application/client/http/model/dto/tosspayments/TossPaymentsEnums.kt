package shoyoream.server.shoyoreamapplication.application.client.http.model.dto.tosspayments

class TossPaymentsEnums {
    enum class PaymentAcquiredStatus {
        READY,
        REQUESTED,
        COMPLETED,
        CANCEL_REQUESTED,
        CANCELED
    }

    enum class PaymentStatus {
        READY,
        IN_PROGRESS,
        WAITING_FOR_DEPOSIT,
        DONE,
        CANCELED,
        PARTIAL_CANCELED,
        ABORTED,
        EXPIRED
    }

    enum class PaymentType {
        NORMAL,
        BILLING,
        BRANDPAY
    }

    enum class InterestPayer {
        BUYER,
        CARD_COMPANY,
        MERCHANT
    }

    enum class RefundStatus {
        NONE,
        PENDING,
        FAILED,
        PARTIAL_FAILED,
        COMPLETED
    }

    enum class SettlementStatus {
        INCOMPLETED,
        COMPLETED
    }

    enum class CashTransactionType {
        CONFIRM,
        CANCEL
    }

    enum class IssueStatus {
        IN_PROGRESS,
        COMPLETED,
        FAILED
    }
}
