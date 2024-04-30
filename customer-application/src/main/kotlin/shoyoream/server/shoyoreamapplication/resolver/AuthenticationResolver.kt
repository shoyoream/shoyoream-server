package shoyoream.server.shoyoreamapplication.resolver

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import shoyoream.server.shoyoreamapplication.application.client.service.AuthenticationAppService
import shoyoream.server.shoyoreamapplication.application.dto.LoginInput
import shoyoream.server.shoyoreamapplication.application.dto.RegisterUserInput
import shoyoream.server.shoyoreamapplication.application.dto.UserInfoResponse
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse
import shoyoream.server.shoyoreamapplication.token.model.TokenVariable.ACCESS_TOKEN

@Controller
class AuthenticationResolver(
    private val authenticationAppService: AuthenticationAppService
) {
    @MutationMapping
    fun login(
        @Argument loginInput: LoginInput
    ): DefaultResponse<Long> {
        val request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
        return authenticationAppService.login(loginInput, request)
    }

    @MutationMapping
    fun registerUser(
        @Argument registerUserInput: RegisterUserInput
    ): DefaultResponse<Long> {
        return authenticationAppService.registerCustomer(registerUserInput)
    }

    @QueryMapping
    fun getUserInfoBySession(): UserInfoResponse {
        val request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
        val session = request.session
        val accessToken = session.getAttribute(ACCESS_TOKEN) as String
        return authenticationAppService.getUserInfo(accessToken)
    }
}
