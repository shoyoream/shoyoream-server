package shoyoream.server.shoyoreamapplication.resolver

import java.util.UUID
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import shoyoream.server.shoyoreamapplication.application.dto.PayRequest
import shoyoream.server.shoyoreamapplication.application.service.PayAppService
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse

@Controller
class PayResolver(
    private val payAppService: PayAppService
) {
    @MutationMapping
    fun requestPay(
        @Argument payRequest: PayRequest
    ): DefaultResponse<UUID> {
        return payAppService.pay(payRequest)
    }

    @QueryMapping
    fun getPayment(
        @Argument paymentId: UUID
    ): DefaultResponse<UUID> {
        return DefaultResponse.uuidResponse(paymentId)
    }
}
