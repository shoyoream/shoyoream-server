package shoyoream.server.shoyoreamapplication.token.component

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.SignatureException
import io.jsonwebtoken.UnsupportedJwtException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import shoyoream.server.shoyoreamapplication.token.model.enums.TokenType
import shoyoream.server.shoyoreamapplication.token.model.property.TokenProperty
import shoyoream.server.shoyoreamapplication.token.utils.TokenUtils

@Component
class JWTValidator(
    private val tokenUtils: TokenUtils,
    private val tokenProperty: TokenProperty
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    fun validateToken(token: String?, tokenType: TokenType): Boolean {
        if (token.isNullOrEmpty()) {
            logger.error("Token is not provided.")
            return false
        }

        try {
            Jwts.parser().setSigningKey(tokenUtils.getTokenKey(tokenType)).parseClaimsJws(token)
            return true
        } catch (ex: SignatureException) {
            logger.error("Invalid Token Signature.")
        } catch (ex: MalformedJwtException) {
            logger.error("Invalid Token")
        } catch (ex: UnsupportedJwtException) {
            logger.error("Unsupported Token")
        } catch (ex: IllegalArgumentException) {
            logger.error("string is empty.")
        }
        return false
    }
}
