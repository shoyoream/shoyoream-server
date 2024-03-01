package shoyoream.server.shoyoreamapplication.resolver

import java.util.UUID
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import shoyoream.server.shoyoreamapplication.application.dto.StockRequestDTO
import shoyoream.server.shoyoreamapplication.application.service.StockAppService
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse

@Controller
class StockResolver(
    private val stockAppService: StockAppService
) {
    @MutationMapping
    fun registerStock(
        @Argument stockInput: StockRequestDTO.StockInput
    ): DefaultResponse<UUID> {
        return stockAppService.registerStock(stockInput)
    }

    @QueryMapping
    fun getStocks(
        @Argument stockId: UUID
    ): DefaultResponse<UUID> {
        return stockAppService.getStocks(stockId)
    }
}
