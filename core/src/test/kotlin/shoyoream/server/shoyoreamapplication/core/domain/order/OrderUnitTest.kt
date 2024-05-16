package shoyoream.server.shoyoreamapplication.core.domain.order

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.util.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.boot.test.context.SpringBootTest
import shoyoream.server.shoyoreamapplication.core.domain.order.entity.Order
import shoyoream.server.shoyoreamapplication.core.domain.order.repository.OrderRepository
import shoyoream.server.shoyoreamapplication.core.domain.order.service.OrderDomainService

@SpringBootTest
class OrderUnitTest : StringSpec({
    val orderRepository: OrderRepository = mockk(relaxed = true)
    val orderDomainService = OrderDomainService(orderRepository)

    "주문을 생성한다" {
        val orderId = UUID.randomUUID()
        val goodsId = UUID.randomUUID()
        val stocksId = UUID.randomUUID()
        val buyerId = 1L

        val newOrder = Order.of(
            orderId = orderId,
            goodsId = goodsId,
            stocksId = stocksId,
            buyerId = buyerId
        )

        every { orderRepository.save(any()) } returns newOrder

        val createOrder = withContext(Dispatchers.IO) {
            val order = Order.of(
                orderId = orderId,
                goodsId = goodsId,
                stocksId = stocksId,
                buyerId = buyerId
            )
            orderDomainService.createOrder(order)
        }

        createOrder shouldBe newOrder
    }
})
