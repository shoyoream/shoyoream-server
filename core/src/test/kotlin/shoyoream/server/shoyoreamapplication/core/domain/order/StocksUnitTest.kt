package shoyoream.server.shoyoreamapplication.core.domain.order

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.math.BigDecimal
import java.util.UUID
import org.springframework.boot.test.context.SpringBootTest
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsSize
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsType
import shoyoream.server.shoyoreamapplication.core.domain.order.entity.Stocks
import shoyoream.server.shoyoreamapplication.core.domain.order.repository.StocksRepository
import shoyoream.server.shoyoreamapplication.core.domain.order.service.StocksDomainService

@SpringBootTest
class StocksUnitTest : StringSpec({
    val stocksRepository: StocksRepository = mockk(relaxed = true)
    val stocksDomainService = StocksDomainService(stocksRepository)

    "Stocks을 (내 제품을) 올린다." {
        val goodsId = UUID.randomUUID()
        val goodsType = GoodsType.GI
        val goodsSize = GoodsSize.L
        val price = BigDecimal.TEN
        val exampleStocks = Stocks.of(
            goodsId = goodsId,
            goodsType = goodsType,
            goodsSize = goodsSize,
            price = price
        )

        every { stocksRepository.save(any()) } returns exampleStocks

        val createStocks = stocksDomainService.createStocks(
            Stocks.of(
                goodsId = goodsId,
                goodsType = goodsType,
                goodsSize = goodsSize,
                price = price
            )
        )

        createStocks.goodsId shouldBe exampleStocks.goodsId
        createStocks.price shouldBe exampleStocks.price
        createStocks shouldBe exampleStocks
    }
})
