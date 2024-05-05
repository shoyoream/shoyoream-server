package shoyoream.server.shoyoreamapplication.resolver

import java.util.UUID
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import shoyoream.server.shoyoreamapplication.application.dto.OrderRequestDTO
import shoyoream.server.shoyoreamapplication.application.service.OrderAppService
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse

@Controller
class OrderResolver(
    private val orderAppService: OrderAppService
) {
    @QueryMapping
    fun getOrder(
        @Argument orderId: UUID
    ): DefaultResponse<UUID> {
        return orderAppService.getOrder(orderId)
    }

    @MutationMapping
    fun registerOrder(
        @Argument orderInput: OrderRequestDTO.OrderInput
    ): DefaultResponse<UUID> {
        return orderAppService.registerOrder(orderInput)
    }
}
