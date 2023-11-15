package shoyoream.server.shoyoreamapplication.core.domain.product.exception

import shoyoream.server.shoyoreamapplication.core.common.exception.ErrorType

enum class ProductErrorType : ErrorType {
    NOT_FOUND_PRODUCT
    ;

    override fun getErrorType() = this.name
}
