package shoyoream.server.shoyoreamapplication.resolver.user

import java.util.UUID
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import shoyoream.server.shoyoreamapplication.application.dto.GoodsResponseDTO
import shoyoream.server.shoyoreamapplication.application.service.user.GoodsSearchAppService

@Controller
class GoodsSearchResolver(
    private val goodsSearchAppService: GoodsSearchAppService
) {
    @QueryMapping
    fun getGoods(
        @Argument goodsId: UUID
    ): GoodsResponseDTO.GoodsResponse {
        return goodsSearchAppService.findGoodsByGoodsId(goodsId)
    }
}
