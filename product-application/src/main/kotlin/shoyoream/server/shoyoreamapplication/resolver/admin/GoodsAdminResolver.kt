package shoyoream.server.shoyoreamapplication.resolver.admin

import java.util.*
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller
import shoyoream.server.shoyoreamapplication.application.dto.BrandRequestDTO
import shoyoream.server.shoyoreamapplication.application.service.admin.ProductAdminAppService
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse

@Controller
class GoodsAdminResolver(
    private val productAdminAppService: ProductAdminAppService
) {
    @MutationMapping
    fun registerGoods(
        @Argument goodsInput: BrandRequestDTO.GoodsInput
    ): DefaultResponse<UUID> {
        return productAdminAppService.createNewGoods(goodsInput)
    }
}
