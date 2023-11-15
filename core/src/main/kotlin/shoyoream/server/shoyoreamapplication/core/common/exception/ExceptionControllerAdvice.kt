package shoyoream.server.shoyoreamapplication.core.common.exception

import jakarta.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionControllerAdvice {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @ExceptionHandler(value = [DataNotFoundException::class])
    fun notFound(e: ShoyoreamException) =
        ResponseEntity(
            ErrorResponse(e.errorType.getErrorType()),
            HttpStatus.NOT_FOUND
        )

    @ExceptionHandler(value = [UnauthorizedException::class])
    fun unauthorized(e: ShoyoreamException) =
        ResponseEntity(
            ErrorResponse(e.errorType.getErrorType()),
            HttpStatus.UNAUTHORIZED
        )

    @ExceptionHandler(value = [InvalidRequestException::class])
    fun badRequest(e: ShoyoreamException) =
        ResponseEntity(
            ErrorResponse(e.errorType.getErrorType()),
            HttpStatus.BAD_REQUEST
        )

    @ExceptionHandler(value = [NotAllowedException::class])
    fun notAllowed(e: ShoyoreamException) =
        ResponseEntity(
            ErrorResponse(e.errorType.getErrorType()),
            HttpStatus.FORBIDDEN
        )

    @ExceptionHandler(value = [ConflictException::class])
    fun conflict(e: ShoyoreamException) =
        ResponseEntity(
            ErrorResponse(e.errorType.getErrorType()),
            HttpStatus.CONFLICT
        )

    @ExceptionHandler(value = [Exception::class])
    fun exceptionHandle(ex: Exception, request: HttpServletRequest): ResponseEntity<ErrorResponse> {
        val clientInfo = "${request.remoteAddr} (${request.getHeader("user-agent")})"
        val errorMessage = "An error occurred during processing of request : [${request.method}] / [${request.requestURI}]. \n Error message : ${ex.message}"

        logger.error("Error occurred while processing request from {} - {}", clientInfo, errorMessage)

        return ResponseEntity(
            ErrorResponse(ErrorType.INTERNAL_ERROR),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }
}
