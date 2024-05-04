package shoyoream.server.shoyoreamapplication.application.dto

import java.io.Serializable
import java.util.UUID
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.entity.Brand

class BrandResponseDTO {
    data class BrandResponse(
        val brandId: UUID,
        val brandName: String
    ) : Serializable {
        companion object {
            fun Brand.ofResponse(): BrandResponse {
                return BrandResponse(
                    brandId = this.id,
                    brandName = this.brandName
                )
            }
        }
    }
}
