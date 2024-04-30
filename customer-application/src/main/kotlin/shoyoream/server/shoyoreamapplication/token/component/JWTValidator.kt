package shoyoream.server.shoyoreamapplication.token.component

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.Date
import org.springframework.stereotype.Component
import shoyoream.server.shoyoreamapplication.token.model.TokenProperty

@Component
class JWTValidator(
    private val tokenProperty: TokenProperty
) {
    companion object {
        private const val CUSTOMER_ID = "id"
        private const val CUSTOMER_EMAIL = "email"
    }

    fun generateTokenWithoutPrefix(customerId: Long, customerEmail: String): String {
        val claims = hashMapOf<String, Any>(
            CUSTOMER_ID to customerId,
            CUSTOMER_EMAIL to customerEmail
        )

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(Date())
            .signWith(SignatureAlgorithm.HS256, tokenProperty.keys.accessKey)
            .compact()
    }
}
