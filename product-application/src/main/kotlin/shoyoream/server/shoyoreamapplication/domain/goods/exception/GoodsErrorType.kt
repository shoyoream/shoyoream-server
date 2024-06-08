package shoyoream.server.shoyoreamapplication.domain.goods.exception

import shoyoream.server.shoyoreamapplication.core.common.exception.ErrorType

enum class GoodsErrorType : ErrorType {
    NOT_FOUND_GOODS
    ;

    override fun getErrorType() = this.name
}
