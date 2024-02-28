package shoyoream.server.shoyoreamapplication.core.common.exception

sealed class ShoyoreamException(val errorType: ErrorType) :
    RuntimeException(errorType.getErrorType())

sealed class PayWebClientException(val payError: PayError) :
    RuntimeException(payError.toString())

open class InvalidRequestException(errorType: ErrorType) :
    ShoyoreamException(errorType)

open class UnauthorizedException(errorType: ErrorType) :
    ShoyoreamException(errorType)

open class DataNotFoundException(errorType: ErrorType) :
    ShoyoreamException(errorType)

open class NotAllowedException(errorType: ErrorType) :
    ShoyoreamException(errorType)

open class PayErrorException(payError: PayError) :
    PayWebClientException(payError)

open class WebClientException(detail: String) :
    RuntimeException(detail)
