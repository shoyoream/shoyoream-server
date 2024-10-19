package shoyoream.server.shoyoreamapplication

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.util.*
import org.springframework.boot.test.context.SpringBootTest
import shoyoream.server.shoyoreamapplication.domain.entity.Order
import shoyoream.server.shoyoreamapplication.domain.entity.Stocks
import shoyoream.server.shoyoreamapplication.domain.repository.OrderRepository
import shoyoream.server.shoyoreamapplication.core.infra.extensions.findNullableSingle
import shoyoream.server.shoyoreamapplication.domain.service.OrderSelectionServiceImpl

@SpringBootTest
class OrderSelectionServiceTest : BehaviorSpec({
    val orderRepository: OrderRepository = mockk(relaxed = true)
    val orderSelectionService = OrderSelectionServiceImpl(orderRepository)

    Given("특정 주문이 있는 경우") {
        val mockStock = mockk<Stocks>()

        val existsOrderId = UUID.randomUUID()
        val goodsId = UUID.randomUUID()
        val buyerId = 1L
        val expectedOrder = Order.of(
            orderId = existsOrderId,
            goodsId = goodsId,
            stocks = mockStock,
            buyerId = buyerId
        )

        every {
            orderRepository.findNullableSingle<Order>(any())
        } returns expectedOrder

        When("해당 주문 ID로 조회하면") {
            val gotOrder = orderSelectionService.findOrderById(expectedOrder.id)

            Then("해당 주문이 반환된다.") {
                gotOrder shouldBe expectedOrder
            }
        }
    }

    Given("특정 주문이 없는 경우") {
        val notExistOrderId = UUID.randomUUID()
        every {
            orderRepository.findNullableSingle<Order>(any())
        } returns null

        When("해당 주문 ID로 조회하면") {
            val gotOrder = orderSelectionService.findOrderById(notExistOrderId)

            Then("null이 반환된다.") {
                gotOrder shouldBe null
            }
        }
    }
})
