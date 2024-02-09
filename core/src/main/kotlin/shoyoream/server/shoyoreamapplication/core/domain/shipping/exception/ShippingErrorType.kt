package shoyoream.server.shoyoreamapplication.core.domain.shipping.exception

import shoyoream.server.shoyoreamapplication.core.common.exception.ErrorType

enum class ShippingErrorType : ErrorType {
    NOT_FOUND_SHIPPING
    ;

    override fun getErrorType() = this.name
}
