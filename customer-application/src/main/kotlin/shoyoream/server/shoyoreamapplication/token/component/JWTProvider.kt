package shoyoream.server.shoyoreamapplication.token.component

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.Date
import org.springframework.stereotype.Component
import shoyoream.server.shoyoreamapplication.token.model.enums.TokenType
import shoyoream.server.shoyoreamapplication.token.model.property.TokenProperty
import shoyoream.server.shoyoreamapplication.token.utils.TokenUtils

@Component
class JWTProvider(
    private val tokenUtils: TokenUtils,
    private val tokenProperty: TokenProperty
) {
    companion object {
        private const val CUSTOMER_ID = "id"
        private const val CUSTOMER_EMAIL = "email"
    }

    fun getUserIdAndEmailFromAccessToken(token: String): Pair<Int, String> {
        val claims = Jwts.parser()
            .setSigningKey(tokenProperty.keys.accessKey)
            .parseClaimsJws(token)
            .body

        return Pair((claims.get(CUSTOMER_ID, Integer::class.java) as Integer).toInt(), claims.get(CUSTOMER_EMAIL, String::class.java))
    }

    fun generateToken(customerId: Int, customerEmail: String, tokenType: TokenType): String {
        val claims = hashMapOf<String, Any>(
            CUSTOMER_ID to customerId,
            CUSTOMER_EMAIL to customerEmail
        )

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(Date())
            .signWith(SignatureAlgorithm.HS256, tokenUtils.getTokenKey(tokenType))
            .compact()
    }
}
