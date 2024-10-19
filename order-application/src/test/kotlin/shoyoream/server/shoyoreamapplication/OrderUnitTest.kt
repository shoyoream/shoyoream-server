package shoyoream.server.shoyoreamapplication

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.util.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.boot.test.context.SpringBootTest
import shoyoream.server.shoyoreamapplication.domain.entity.Order
import shoyoream.server.shoyoreamapplication.domain.entity.Stocks
import shoyoream.server.shoyoreamapplication.domain.repository.OrderRepository
import shoyoream.server.shoyoreamapplication.domain.service.OrderDomainServiceImpl

@SpringBootTest
class OrderUnitTest : StringSpec({
    val orderRepository: OrderRepository = mockk(relaxed = true)
    val orderDomainService = OrderDomainServiceImpl(orderRepository)

    "주문을 생성한다" {
        val orderId = UUID.randomUUID()
        val goodsId = UUID.randomUUID()
        val mockStock = mockk<Stocks>()
        val buyerId = 1L

        val newOrder = Order.of(
            orderId = orderId,
            goodsId = goodsId,
            stocks = mockStock,
            buyerId = buyerId
        )

        every { orderRepository.save(any()) } returns newOrder

        val createOrder = withContext(Dispatchers.IO) {
            val order = Order.of(
                orderId = orderId,
                goodsId = goodsId,
                stocks = mockStock,
                buyerId = buyerId
            )
            orderDomainService.createOrder(order)
        }

        createOrder shouldBe newOrder
    }
})
