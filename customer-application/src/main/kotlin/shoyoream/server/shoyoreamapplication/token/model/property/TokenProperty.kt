package shoyoream.server.shoyoreamapplication.token.model.property

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "token")
class TokenProperty(
    val keys: Keys
) {
    data class Keys(
        val accessKey: String,
        val refreshKey: String
    )
}
