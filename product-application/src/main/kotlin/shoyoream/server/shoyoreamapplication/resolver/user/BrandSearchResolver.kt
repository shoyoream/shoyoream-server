package shoyoream.server.shoyoreamapplication.resolver.user

import java.util.*
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import shoyoream.server.shoyoreamapplication.application.service.user.BrandSearchAppService
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse

@Controller
class BrandSearchResolver(
    private val brandSearchAppService: BrandSearchAppService
) {
    @QueryMapping
    fun getBrand(
        @Argument brandName: String
    ): DefaultResponse<UUID> {
        return brandSearchAppService.findBrandByBrandName(brandName)
    }
}
