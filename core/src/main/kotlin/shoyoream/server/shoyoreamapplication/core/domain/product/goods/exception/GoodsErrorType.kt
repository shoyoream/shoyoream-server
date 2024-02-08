package shoyoream.server.shoyoreamapplication.core.domain.product.goods.exception

import shoyoream.server.shoyoreamapplication.core.common.exception.ErrorType

enum class GoodsErrorType : ErrorType {
    NOT_FOUND_GOODS
    ;

    override fun getErrorType() = this.name
}
