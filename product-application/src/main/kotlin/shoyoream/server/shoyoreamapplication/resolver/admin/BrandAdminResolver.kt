package shoyoream.server.shoyoreamapplication.resolver.admin

import java.util.UUID
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller
import shoyoream.server.shoyoreamapplication.application.service.admin.ProductAdminAppService
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
}
