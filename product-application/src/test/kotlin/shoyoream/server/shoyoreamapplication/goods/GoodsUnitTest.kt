package shoyoream.server.shoyoreamapplication.goods

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.boot.test.context.SpringBootTest
import shoyoream.server.shoyoreamapplication.domain.brand.entity.Brand
import shoyoream.server.shoyoreamapplication.domain.goods.entity.Goods
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsSize
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsType
import shoyoream.server.shoyoreamapplication.domain.goods.repository.GoodsRepository
import shoyoream.server.shoyoreamapplication.domain.goods.service.GoodsDomainServiceImpl
import java.util.UUID

@SpringBootTest
class GoodsUnitTest : StringSpec({
    val goodsRepository: GoodsRepository = mockk(relaxed = true)
    val goodsDomainService = GoodsDomainServiceImpl(goodsRepository)

    "새 상품을 브랜드와 같이 넣으면 새로운 상품이 생성된다." {
        val goodsId = UUID.randomUUID()
        val newGoodsName = "newGoodsName"
        val brandId = UUID.randomUUID()
        val targetBrand = Brand.of(
            brandId = brandId,
            brandName = "targetBrand"
        )
        val newGoods = Goods.of(
            goodsId = goodsId,
            goodsName = newGoodsName,
            goodsCode = "newGoodsCode",
            goodsType = GoodsType.GI,
            goodsSize = GoodsSize.A0,
            brand = targetBrand
        )

        every { goodsRepository.save(any()) } returns newGoods

        val createdGoods = withContext(Dispatchers.IO) {
            goodsDomainService.createNewGoods(
                goodsName = newGoodsName,
                goodsCode = "newGoodsCode",
                goodsType = GoodsType.GI,
                goodsSize = GoodsSize.A0,
                brand = targetBrand
            )
        }

        createdGoods shouldBe newGoods
    }
})
