package shoyoream.server.shoyoreamapplication.core.domain.order.exception

import shoyoream.server.shoyoreamapplication.core.common.exception.ErrorType

enum class StocksErrorType : ErrorType {
    NOT_FOUND_STOCKS
    ;

    override fun getErrorType() = this.name
}
