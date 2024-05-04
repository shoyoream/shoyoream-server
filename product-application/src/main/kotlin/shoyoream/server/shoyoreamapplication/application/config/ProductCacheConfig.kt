package shoyoream.server.shoyoreamapplication.application.config

import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import java.time.Duration
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext

@EnableCaching
@Configuration
class ProductCacheConfig {
    companion object {
        const val BRAND_CACHE_NAME = "brandCache"
        const val GOODS_CACHE_NAME = "goodsCache"
    }

    @Bean
    fun redisCacheManagerBuilderCustomizer(): RedisCacheManagerBuilderCustomizer {
        val ptv: PolymorphicTypeValidator = BasicPolymorphicTypeValidator
            .builder()
            .allowIfSubType(Any::class.java)
            .build()

        val objectMapper = ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerModule(JavaTimeModule())
            .activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.EVERYTHING, JsonTypeInfo.As.PROPERTY)
            .disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)

        val cacheProperties = listOf(
            ProductCacheProperty(BRAND_CACHE_NAME, 60),
            ProductCacheProperty(GOODS_CACHE_NAME, 60)
        )

        return RedisCacheManagerBuilderCustomizer { builder ->
            cacheProperties.forEach { property ->
                builder.withCacheConfiguration(
                    property.cacheName,
                    RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofSeconds(property.ttl))
                        .serializeValuesWith(
                            RedisSerializationContext.SerializationPair.fromSerializer(
                                GenericJackson2JsonRedisSerializer(objectMapper)
                            )
                        )
                )
            }
        }
    }
}
