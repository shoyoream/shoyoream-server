package shoyoream.server.shoyoreamapplication.resolver

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller
import shoyoream.server.shoyoreamapplication.application.service.BrandAdminAppService
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.entity.Brand

@Controller
class BrandAdminResolver(
    private val brandAdminAppService: BrandAdminAppService
) {
    @MutationMapping
    fun registerBrand(
        @Argument brandName: String
    ): Brand {
        return brandAdminAppService.createNewBrand(brandName)
    }
}
