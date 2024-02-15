package shoyoream.server.shoyoreamapplication.core.domain.product.brand.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.UUID
import org.hibernate.annotations.GenericGenerator
import shoyoream.server.shoyoreamapplication.core.common.model.BaseTimeEntity
import shoyoream.server.shoyoreamapplication.core.common.utils.UUIDGenerator
import shoyoream.server.shoyoreamapplication.core.domain.product.goods.entity.Goods

@Entity
@Table(name = "brands")
class Brand(
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "brands_id")
    val id: UUID = UUIDGenerator.randomUUID(),

    @Column(name = "brand_name")
    val brandName: String,

    @OneToMany(mappedBy = "brand")
    val goods: MutableList<Goods> = mutableListOf()
) : BaseTimeEntity() {
    companion object {
        fun from(brandName: String): Brand {
            return Brand(
                brandName = brandName
            )
        }
    }
}
