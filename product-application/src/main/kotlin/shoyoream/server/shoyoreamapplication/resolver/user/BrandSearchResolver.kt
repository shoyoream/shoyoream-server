package shoyoream.server.shoyoreamapplication.resolver.user

import java.util.*
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import shoyoream.server.shoyoreamapplication.application.dto.BrandResponseDTO
import shoyoream.server.shoyoreamapplication.application.service.user.BrandSearchAppService

@Controller
class BrandSearchResolver(
    private val brandSearchAppService: BrandSearchAppService
) {
    @QueryMapping
    fun getBrand(
        @Argument brandName: String
    ): BrandResponseDTO.BrandResponse {
        return brandSearchAppService.findBrandByBrandName(brandName)
    }
}
