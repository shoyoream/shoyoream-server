package shoyoream.server.shoyoreamapplication.resolver

import java.util.UUID
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import shoyoream.server.shoyoreamapplication.application.service.BrandAdminAppService
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse

@Controller
class BrandAdminResolver(
    private val brandAdminAppService: BrandAdminAppService
) {
    @MutationMapping
    fun registerBrand(
        @Argument brandName: String
    ): DefaultResponse<UUID> {
        return brandAdminAppService.createNewBrand(brandName)
    }

    @QueryMapping
    fun getBrand(
        @Argument brandName: String
    ): DefaultResponse<UUID> {
        return brandAdminAppService.findBrandByBrandName(brandName)
    }
}
