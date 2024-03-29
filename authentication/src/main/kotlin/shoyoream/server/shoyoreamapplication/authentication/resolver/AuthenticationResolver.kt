package shoyoream.server.shoyoreamapplication.authentication.resolver

import java.util.*
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import shoyoream.server.shoyoreamapplication.authentication.application.model.LoginInput
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse

@Controller
class AuthenticationResolver {
    @MutationMapping
    fun login(
        @Argument loginInput: LoginInput
    ): DefaultResponse<UUID> {
        val request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request

        return DefaultResponse.response(UUID.randomUUID())
    }
}
