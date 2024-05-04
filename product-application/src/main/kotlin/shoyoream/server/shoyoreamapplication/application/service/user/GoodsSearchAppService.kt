package shoyoream.server.shoyoreamapplication.application.service.user

import java.util.UUID
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.application.config.ProductCacheConfig.Companion.GOODS_CACHE_NAME
import shoyoream.server.shoyoreamapplication.application.dto.GoodsResponseDTO
import shoyoream.server.shoyoreamapplication.application.dto.GoodsResponseDTO.GoodsResponse.Companion.of
import shoyoream.server.shoyoreamapplication.core.common.exception.DataNotFoundException
import shoyoream.server.shoyoreamapplication.core.domain.product.goods.exception.GoodsErrorType
import shoyoream.server.shoyoreamapplication.core.domain.product.goods.service.GoodsSelectionService

@Service
class GoodsSearchAppService(
    private val goodsSelectionService: GoodsSelectionService
) {
    @Cacheable(cacheNames = [GOODS_CACHE_NAME], key = "#goodsId")
    @Transactional(readOnly = true)
    fun findGoodsByGoodsId(goodsId: UUID): GoodsResponseDTO.GoodsResponse {
        val targetGoods = goodsSelectionService.findGoodsByGoodsId(goodsId)
            ?: throw DataNotFoundException(GoodsErrorType.NOT_FOUND_GOODS)

        return targetGoods.of()
    }
}
