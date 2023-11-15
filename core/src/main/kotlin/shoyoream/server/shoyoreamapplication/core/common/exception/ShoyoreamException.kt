package shoyoream.server.shoyoreamapplication.core.common.exception

sealed class ShoyoreamException(val errorType: ErrorType) :
    RuntimeException(errorType.getErrorType())

open class InvalidRequestException(errorType: ErrorType) :
    ShoyoreamException(errorType)

open class UnauthorizedException(errorType: ErrorType) :
    ShoyoreamException(errorType)

open class DataNotFoundException(errorType: ErrorType) :
    ShoyoreamException(errorType)

open class NotAllowedException(errorType: ErrorType) :
    ShoyoreamException(errorType)

open class ConflictException(errorType: ErrorType) :
    ShoyoreamException(errorType)
