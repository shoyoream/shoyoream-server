package shoyoream.server.shoyoreamapplication.core.domain.product.goods.entity

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.Column
import jakarta.persistence.ConstraintMode
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import shoyoream.server.shoyoreamapplication.core.common.model.BaseTimeEntity
import shoyoream.server.shoyoreamapplication.core.common.utils.UUIDGenerator
import java.util.UUID
import org.hibernate.annotations.GenericGenerator
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsSize
import shoyoream.server.shoyoreamapplication.core.domain.enums.GoodsType
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.entity.Brand

@Entity
@Table(name = "goods")
class Goods(
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "goods_id")
    val id: UUID = UUIDGenerator.randomUUID(),

    @Column(name = "goods_name")
    val goodsName: String,

    @Column(name = "goods_code")
    val goodsCode: String,

    @Enumerated(EnumType.STRING)
    val goodsType: GoodsType,

    @Enumerated(EnumType.STRING)
    val goodsSize: GoodsSize,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brands_id", foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    val brand: Brand
) : BaseTimeEntity() {
    companion object {
        fun of(
            goodsName: String,
            goodsCode: String,
            goodsType: GoodsType,
            goodsSize: GoodsSize,
            brand: Brand
        ): Goods {
            return Goods(
                goodsName = goodsName,
                goodsCode = goodsCode,
                goodsType = goodsType,
                goodsSize = goodsSize,
                brand = brand
            )
        }
    }

    // TODO : update domain logic
}
