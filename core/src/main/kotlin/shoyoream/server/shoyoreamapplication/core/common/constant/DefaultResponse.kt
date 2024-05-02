package shoyoream.server.shoyoreamapplication.core.common.constant

import java.util.UUID

class DefaultResponse<T>(
    val data: Any
) {
    companion object {
        fun <T> uuidResponse(id: UUID): DefaultResponse<T> {
            return DefaultResponse(
                data = id
            )
        }

        fun <T> successResponse(id: Long): DefaultResponse<T> {
            return DefaultResponse(
                data = id
            )
        }
    }
}
