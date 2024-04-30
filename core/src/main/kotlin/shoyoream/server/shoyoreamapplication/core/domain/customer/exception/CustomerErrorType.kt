package shoyoream.server.shoyoreamapplication.core.domain.customer.exception

import shoyoream.server.shoyoreamapplication.core.common.exception.ErrorType

enum class CustomerErrorType : ErrorType {
    NOT_FOUND_CUSTOMER
    ;

    override fun getErrorType() = this.name
}
