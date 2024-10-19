package commerce.eda.domain.exception

import shoyoream.server.shoyoreamapplication.core.common.exception.ErrorType

enum class CouponErrorType : ErrorType {
    NOT_FOUND_COUPON
    ;

    override fun getErrorType() = this.name
}
