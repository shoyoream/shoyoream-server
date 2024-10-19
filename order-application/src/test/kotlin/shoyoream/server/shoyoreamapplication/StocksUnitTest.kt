package shoyoream.server.shoyoreamapplication

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.math.BigDecimal
import java.util.UUID
import org.springframework.boot.test.context.SpringBootTest
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsSize
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsType
import shoyoream.server.shoyoreamapplication.domain.entity.Stocks
import shoyoream.server.shoyoreamapplication.domain.repository.StocksRepository
import shoyoream.server.shoyoreamapplication.domain.service.StocksDomainServiceImpl

@SpringBootTest
class StocksUnitTest : StringSpec({
    val stocksRepository: StocksRepository = mockk(relaxed = true)
    val stocksDomainService = StocksDomainServiceImpl(stocksRepository)

    "Stocks을 (내 제품을) 올린다." {
        val uploaderId = 1L
        val targetStocksId = UUID.randomUUID()
        val goodsId = UUID.randomUUID()
        val goodsType = GoodsType.GI
        val goodsSize = GoodsSize.L
        val price = BigDecimal.TEN
        val exampleStocks = Stocks.of(
            stocksId = targetStocksId,
            goodsId = goodsId,
            goodsType = goodsType,
            goodsSize = goodsSize,
            price = price,
            sellerId = uploaderId
        )

        every { stocksRepository.save(any()) } returns exampleStocks

        val createStocks = stocksDomainService.createStocks(
            Stocks.of(
                stocksId = targetStocksId,
                goodsId = goodsId,
                goodsType = goodsType,
                goodsSize = goodsSize,
                price = price,
                sellerId = uploaderId
            )
        )

        createStocks.id shouldBe exampleStocks.id
        createStocks.price shouldBe exampleStocks.price
        createStocks shouldBe exampleStocks
    }
})
