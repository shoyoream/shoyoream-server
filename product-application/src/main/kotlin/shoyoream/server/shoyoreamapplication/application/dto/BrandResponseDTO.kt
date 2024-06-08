package shoyoream.server.shoyoreamapplication.application.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import java.util.UUID
import shoyoream.server.shoyoreamapplication.domain.brand.entity.Brand

class BrandResponseDTO {
    data class BrandResponse(
        @JsonProperty("brandId")
        val brandId: UUID,
        @JsonProperty("brandName")
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
