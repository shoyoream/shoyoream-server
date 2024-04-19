package shoyoream.server.shoyoreamapplication.core.common.constant

import java.util.UUID

class DefaultResponse<T>(
    val id: Any
) {
    companion object {
        fun <T> uuidResponse(id: UUID): DefaultResponse<T> {
            return DefaultResponse(
                id = id
            )
        }

        fun <T> successResponse(id: Long): DefaultResponse<T> {
            return DefaultResponse(
                id = id
            )
        }
    }
}
