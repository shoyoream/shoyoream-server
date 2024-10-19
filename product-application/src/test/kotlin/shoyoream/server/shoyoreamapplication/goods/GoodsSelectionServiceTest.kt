package shoyoream.server.shoyoreamapplication.goods

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsSize
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsType
import shoyoream.server.shoyoreamapplication.core.infra.extensions.findNullableSingle
import shoyoream.server.shoyoreamapplication.domain.brand.entity.Brand
import shoyoream.server.shoyoreamapplication.domain.goods.entity.Goods
import shoyoream.server.shoyoreamapplication.domain.goods.repository.GoodsRepository
import shoyoream.server.shoyoreamapplication.domain.goods.service.GoodsSelectionServiceImpl
import java.util.*

class GoodsSelectionServiceTest : BehaviorSpec({
    val goodsRepository: GoodsRepository = mockk(relaxed = true)
    val goodsSelectionService = GoodsSelectionServiceImpl(goodsRepository)

    Given("특정 상품이 있는 경우") {
        val existBrandName = "Exist Brand"
        val expectedBrand = Brand.of(
            brandId = UUID.randomUUID(),
            brandName = existBrandName
        )

        val existGoodsId = UUID.randomUUID()
        val expectedGoods = Goods.of(
            goodsId = existGoodsId,
            goodsName = "Exist Goods",
            goodsCode = "Exist Goods Code",
            goodsType = GoodsType.GI,
            goodsSize = GoodsSize.XXL,
            brand = expectedBrand
        )

        every {
            goodsRepository.findNullableSingle<Goods>(any())
        } returns expectedGoods

        When("해당 상품 ID로 조회하면") {
            val gotGoods = goodsSelectionService.findGoodsByGoodsId(existGoodsId)

            Then("해당 상품이 반환된다.") {
                gotGoods shouldBe expectedGoods
            }
        }
    }
})
