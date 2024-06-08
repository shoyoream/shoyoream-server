package shoyoream.server.shoyoreamapplication.domain.exception

import shoyoream.server.shoyoreamapplication.core.common.exception.ErrorType

enum class OrderErrorType : ErrorType {
    NOT_FOUND_ORDER,
    NOT_FOUND_STOCKS,
    ALREADY_IN_ORDER
    ;

    override fun getErrorType() = this.name
}
