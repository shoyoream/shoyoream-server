package shoyoream.server.shoyoreamapplication.application.service.user

import java.util.UUID
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.application.config.ProductCacheConfig.Companion.GOODS_CACHE_NAME
import shoyoream.server.shoyoreamapplication.application.dto.GoodsResponseDTO
import shoyoream.server.shoyoreamapplication.application.dto.GoodsResponseDTO.GoodsResponse.Companion.of
import shoyoream.server.shoyoreamapplication.core.common.exception.DataNotFoundException
import shoyoream.server.shoyoreamapplication.domain.goods.exception.GoodsErrorType
import shoyoream.server.shoyoreamapplication.domain.goods.service.GoodsSelectionService

interface GoodsSearchAppService {
    fun findGoodsByGoodsId(goodsId: UUID): GoodsResponseDTO.GoodsResponse
}

@Service
class GoodsSearchAppServiceImpl(
    private val goodsSelectionService: GoodsSelectionService
) : GoodsSearchAppService {
    @Cacheable(cacheNames = [GOODS_CACHE_NAME], key = "#goodsId")
    @Transactional(readOnly = true)
    override fun findGoodsByGoodsId(goodsId: UUID): GoodsResponseDTO.GoodsResponse {
        val targetGoods = goodsSelectionService.findGoodsByGoodsId(goodsId)
            ?: throw DataNotFoundException(GoodsErrorType.NOT_FOUND_GOODS)

        return targetGoods.of()
    }
}
