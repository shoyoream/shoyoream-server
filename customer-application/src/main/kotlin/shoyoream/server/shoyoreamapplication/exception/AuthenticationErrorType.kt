package shoyoream.server.shoyoreamapplication.exception

import shoyoream.server.shoyoreamapplication.core.common.exception.ErrorType

enum class AuthenticationErrorType : ErrorType {
    INVALID_TOKEN
    ;

    override fun getErrorType() = this.name
}
