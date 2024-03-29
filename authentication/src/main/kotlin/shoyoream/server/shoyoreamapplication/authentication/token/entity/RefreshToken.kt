package shoyoream.server.shoyoreamapplication.authentication.token.entity

import jakarta.persistence.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("refresh_token", timeToLive = 86400L)
class RefreshToken(
    @Id
    val id: Long = 0L
    // id 로 설정해야 @EnableRedisRepositories 가 동작함

)
