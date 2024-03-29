package shoyoream.server.shoyoreamapplication.core.domain.order.exception

import shoyoream.server.shoyoreamapplication.core.common.exception.ErrorType

enum class OrderErrorType : ErrorType {
    NOT_FOUND_ORDER
    ;

    override fun getErrorType() = this.name
}
