package shoyoream.server.shoyoreamapplication.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.util.*
import org.hibernate.annotations.GenericGenerator
import shoyoream.server.shoyoreamapplication.core.common.model.BaseTimeEntity
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsSize
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsType

@Entity
@Table(name = "stocks")
class Stocks(
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "stocks_id")
    val id: UUID,

    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "goods_id")
    val goodsId: UUID,

    @Enumerated(EnumType.STRING)
    val goodsType: GoodsType,

    @Enumerated(EnumType.STRING)
    val goodsSize: GoodsSize,

    @Column(name = "price")
    val price: BigDecimal,

    @Column(name = "seller_id")
    val sellerId: Long

    // TODO : 유저 관련 추가 되어야함.
) : BaseTimeEntity() {
    companion object {
        fun of(
            stocksId: UUID,
            goodsId: UUID,
            goodsType: GoodsType,
            goodsSize: GoodsSize,
            price: BigDecimal,
            sellerId: Long
        ): Stocks {
            return Stocks(
                id = stocksId,
                goodsId = goodsId,
                goodsType = goodsType,
                goodsSize = goodsSize,
                price = price,
                sellerId = sellerId
            )
        }
    }
}
