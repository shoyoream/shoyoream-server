package shoyoream.server.shoyoreamapplication.core.domain.product.goods.repository

import java.util.UUID
import shoyoream.server.shoyoreamapplication.core.domain.product.goods.entity.Goods

interface GoodsRepositorySupport {
    fun findGoodsByGoodsId(id: UUID): Goods?
}
