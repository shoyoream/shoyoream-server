package shoyoream.server.shoyoreamapplication.resolver

import java.util.UUID
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import shoyoream.server.shoyoreamapplication.application.dto.BrandRequestDTO
import shoyoream.server.shoyoreamapplication.application.service.ProductAdminAppService
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse

@Controller
class BrandAdminResolver(
    private val productAdminAppService: ProductAdminAppService
) {
    @MutationMapping
    fun registerBrand(
        @Argument brandName: String
    ): DefaultResponse<UUID> {
        return productAdminAppService.createNewBrand(brandName)
    }

    @MutationMapping
    fun registerGoods(
        @Argument goodsInput: BrandRequestDTO.GoodsInput
    ): DefaultResponse<UUID> {
        return productAdminAppService.createNewGoods(goodsInput)
    }

    @QueryMapping
    fun getBrand(
        @Argument brandName: String
    ): DefaultResponse<UUID> {
        return productAdminAppService.findBrandByBrandName(brandName)
    }
}
