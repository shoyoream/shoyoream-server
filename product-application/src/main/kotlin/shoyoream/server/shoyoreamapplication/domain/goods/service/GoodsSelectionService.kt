package shoyoream.server.shoyoreamapplication.domain.goods.service

import java.util.UUID
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.domain.goods.entity.Goods
import shoyoream.server.shoyoreamapplication.domain.goods.repository.GoodsRepository
import shoyoream.server.shoyoreamapplication.core.infra.extensions.findNullableSingle

interface GoodsSelectionService {
    fun findGoodsByGoodsId(goodsId: UUID): Goods?
}

@Service
class GoodsSelectionServiceImpl(
    private val goodsRepository: GoodsRepository
) : GoodsSelectionService {
    @Transactional(readOnly = true)
    override fun findGoodsByGoodsId(goodsId: UUID): Goods? {
        return goodsRepository.findNullableSingle {
            select(
                entity(Goods::class)
            ).from(
                entity(Goods::class)
            ).where(
                path(Goods::id).equal(goodsId)
            )
        }
    }
}
