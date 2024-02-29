package shoyoream.server.shoyoreamapplication.core.domain.order

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.util.*
import org.springframework.boot.test.context.SpringBootTest
import shoyoream.server.shoyoreamapplication.core.domain.order.entity.Order
import shoyoream.server.shoyoreamapplication.core.domain.order.repository.OrderRepository
import shoyoream.server.shoyoreamapplication.core.domain.order.service.OrderSelectionService
import shoyoream.server.shoyoreamapplication.core.infra.extensions.findNullableSingle

@SpringBootTest
class OrderSelectionServiceTest : BehaviorSpec({
    val orderRepository: OrderRepository = mockk(relaxed = true)
    val orderSelectionService = OrderSelectionService(orderRepository)

    Given("특정 주문이 있는 경우") {
        val existGoodsId = UUID.randomUUID()
        val expectedOrder = Order.of(
            goodsId = existGoodsId,
            stocksId = UUID.randomUUID()
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
