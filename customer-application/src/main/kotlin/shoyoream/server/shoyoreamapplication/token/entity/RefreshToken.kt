package shoyoream.server.shoyoreamapplication.token.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed

@RedisHash("refresh-token", timeToLive = 86400L)
class RefreshToken(
    @Id
    val refreshToken: String,

    @Indexed
    val email: String
) {
    companion object {
        fun of(refreshToken: String, email: String): RefreshToken {
            return RefreshToken(
                refreshToken = refreshToken,
                email = email
            )
        }
    }
}
