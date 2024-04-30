package shoyoream.server.shoyoreamapplication.token.entity

import jakarta.persistence.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed

@RedisHash("refresh-token", timeToLive = 86400L)
class RefreshToken(
    @Id
    val id: Long = 0L,

    @Indexed
    val email: String,

    val refreshToken: String
) {
    companion object {
        fun of(email: String, refreshToken: String): RefreshToken {
            return RefreshToken(
                email = email,
                refreshToken = refreshToken
            )
        }
    }
}
