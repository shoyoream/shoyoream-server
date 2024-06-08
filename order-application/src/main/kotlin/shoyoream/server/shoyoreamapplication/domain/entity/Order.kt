package shoyoream.server.shoyoreamapplication.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.util.*
import org.hibernate.annotations.GenericGenerator
import shoyoream.server.shoyoreamapplication.core.common.model.BaseTimeEntity
import shoyoream.server.shoyoreamapplication.core.domain.enums.OrderStatus

@Entity
@Table(name = "orders")
class Order(
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "order_id")
    val id: UUID,

    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "goods_id")
    val goodsId: UUID,

    @OneToOne
    @JoinColumn(name = "stocks_id")
    val stocks: Stocks,

    @Enumerated(EnumType.STRING)
    var orderStatus: OrderStatus = OrderStatus.ORDERED,

    @Column(name = "buyer_id")
    val buyerId: Long
) : BaseTimeEntity() {
    companion object {
        fun of(
            orderId: UUID,
            goodsId: UUID,
            stocks: Stocks,
            buyerId: Long
        ): Order {
            return Order(
                id = orderId,
                goodsId = goodsId,
                stocks = stocks,
                buyerId = buyerId
            )
        }
    }

    fun updateOrderStatus(orderStatus: OrderStatus) {
        this.orderStatus = orderStatus
    }
}
