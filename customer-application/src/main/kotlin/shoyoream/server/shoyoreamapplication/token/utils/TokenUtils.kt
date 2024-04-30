package shoyoream.server.shoyoreamapplication.token.utils

import org.springframework.stereotype.Component
import shoyoream.server.shoyoreamapplication.token.model.enums.TokenType
import shoyoream.server.shoyoreamapplication.token.model.property.TokenProperty

@Component
class TokenUtils(
    private val tokenProperty: TokenProperty
) {
    fun getTokenKey(tokenType: TokenType): String {
        return when (tokenType) {
            TokenType.ACCESS -> tokenProperty.keys.accessKey
            TokenType.REFRESH -> tokenProperty.keys.refreshKey
        }
    }
}
