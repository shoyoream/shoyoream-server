package shoyoream.server.shoyoreamapplication.core.domain.product.goods.service

import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.entity.Brand
import shoyoream.server.shoyoreamapplication.core.domain.product.goods.entity.Goods
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsSize
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsType
import shoyoream.server.shoyoreamapplication.core.domain.product.goods.repository.GoodsRepository

@Service
class GoodsDomainService(
    private val goodsRepository: GoodsRepository
) {
    fun createNewGoods(
        goodsName: String,
        goodsCode: String,
        goodsType: GoodsType,
        goodsSize: GoodsSize,
        brand: Brand
    ): Goods {
        return goodsRepository.save(
            Goods.of(
                goodsName = goodsName,
                goodsCode = goodsCode,
                goodsType = goodsType,
                goodsSize = goodsSize,
                brand = brand
            )
        )
    }
}
