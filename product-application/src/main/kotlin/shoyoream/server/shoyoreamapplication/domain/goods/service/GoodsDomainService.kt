package shoyoream.server.shoyoreamapplication.domain.goods.service

import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.domain.brand.entity.Brand
import shoyoream.server.shoyoreamapplication.domain.goods.entity.Goods
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsSize
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsType
import shoyoream.server.shoyoreamapplication.domain.goods.repository.GoodsRepository
import java.util.*

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
                goodsId = UUID.randomUUID(),
                goodsName = goodsName,
                goodsCode = goodsCode,
                goodsType = goodsType,
                goodsSize = goodsSize,
                brand = brand
            )
        )
    }
}
