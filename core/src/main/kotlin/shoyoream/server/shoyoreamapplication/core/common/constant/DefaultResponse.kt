package shoyoream.server.shoyoreamapplication.core.common.constant

import java.util.UUID

class DefaultResponse<T>(
    val id: UUID
) {
    companion object {
        fun <T> response(id: UUID): DefaultResponse<T> {
            return DefaultResponse(
                id = id
            )
        }
    }
}
