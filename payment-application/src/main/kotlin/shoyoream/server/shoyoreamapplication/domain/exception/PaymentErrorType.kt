package shoyoream.server.shoyoreamapplication.domain.exception

import shoyoream.server.shoyoreamapplication.core.common.exception.ErrorType

enum class PaymentErrorType : ErrorType {
    NOT_FOUND_PAYMENT
    ;

    override fun getErrorType() = this.name
}
