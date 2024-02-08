package shoyoream.server.shoyoreamapplication.core.domain.product.brand.exception

import shoyoream.server.shoyoreamapplication.core.common.exception.ErrorType

enum class BrandErrorType : ErrorType {
    NOT_FOUND_BRAND
    ;

    override fun getErrorType() = this.name
}
