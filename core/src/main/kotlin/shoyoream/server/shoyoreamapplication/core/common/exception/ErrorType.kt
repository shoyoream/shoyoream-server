package shoyoream.server.shoyoreamapplication.core.common.exception

interface ErrorType {
    companion object {
        const val INTERNAL_ERROR: String = "INTERNAL_ERROR"
    }

    fun getErrorType(): String
}
