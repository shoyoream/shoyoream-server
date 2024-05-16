package shoyoream.server.shoyoreamapplication.core.domain.order

import io.kotest.core.spec.style.BehaviorSpec
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
import shoyoream.server.shoyoreamapplication.core.domain.order.service.StocksSelectionService
import shoyoream.server.shoyoreamapplication.core.infra.extensions.findNullableSingle

@SpringBootTest
class StocksSelectionServiceTest : BehaviorSpec({
    val stocksRepository: StocksRepository = mockk(relaxed = true)
    val stocksSelectionService = StocksSelectionService(stocksRepository)

    Given("특정 제품이 있는 경우") {
        val existsStocksId = UUID.randomUUID()
        val goodsId = UUID.randomUUID()
        val stockPrice = BigDecimal.TEN
        val sellerId = 1L
        val expectedStocks = Stocks.of(
            stocksId = existsStocksId,
            goodsId = goodsId,
            goodsType = GoodsType.BELTS,
            goodsSize = GoodsSize.A2,
            price = stockPrice,
            sellerId = sellerId
        )

        every {
            stocksRepository.findNullableSingle<Stocks>(any())
        } returns expectedStocks

        When("해당 제품 ID로 조회하면") {
            val gotStocks = stocksSelectionService.findStocksById(goodsId)

            Then("해당 제품이 반환된다.") {
                gotStocks shouldBe expectedStocks
            }
        }
    }

    Given("특정 제품이 없는 경우") {
        val notExistStocksId = UUID.randomUUID()
        every {
            stocksRepository.findNullableSingle<Stocks>(any())
        } returns null

        When("해당 제품 ID로 조회하면") {
            val gotStocks = stocksSelectionService.findStocksById(notExistStocksId)

            Then("null이 반환된다.") {
                gotStocks shouldBe null
            }
        }
    }
})
