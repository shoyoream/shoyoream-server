package shoyoream.server.shoyoreamapplication.application.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import java.util.UUID
import shoyoream.server.shoyoreamapplication.domain.goods.entity.Goods

class GoodsResponseDTO {
    data class GoodsResponse(
        @JsonProperty("goodsId")
        val goodsId: UUID,
        @JsonProperty("goodsName")
        val goodsName: String,
        @JsonProperty("goodsCode")
        val goodsCode: String,
        @JsonProperty("goodsType")
        val goodsType: String,
        @JsonProperty("goodsSize")
        val goodsSize: String
    ) : Serializable {
        companion object {
            fun Goods.of(): GoodsResponse {
                return GoodsResponse(
                    goodsId = this.id,
                    goodsName = this.goodsName,
                    goodsCode = this.goodsCode,
                    goodsType = this.goodsType.name,
                    goodsSize = this.goodsSize.name
                )
            }
        }
    }
}
