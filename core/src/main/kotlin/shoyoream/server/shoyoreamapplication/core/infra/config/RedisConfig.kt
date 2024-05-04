package shoyoream.server.shoyoreamapplication.core.infra.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession

@Configuration
@EnableRedisHttpSession
@EnableRedisRepositories
class RedisConfig(
    @Value("\${spring.data.redis.host}") private val host: String,
    @Value("\${spring.data.redis.port}") private val port: Int
) {
    @Bean
    fun redisConnectionFactory(): LettuceConnectionFactory {
        val redisStandaloneConfiguration = RedisStandaloneConfiguration(host, port)
        return LettuceConnectionFactory(redisStandaloneConfiguration)
    }

//    @Bean
//    fun redisTemplate(): RedisTemplate<*, *> {
//        val redisTemplate = RedisTemplate<ByteArray, ByteArray>()
//        redisTemplate.connectionFactory = redisConnectionFactory()
//        return redisTemplate
//    }

    @Bean
    fun redisTemplate(): RedisTemplate<Any, Any> {
        val template = RedisTemplate<Any, Any>()
        template.keySerializer = StringRedisSerializer()
        template.valueSerializer = Jackson2JsonRedisSerializer(Any::class.java)
        template.connectionFactory = redisConnectionFactory()
        return template
    }
}
