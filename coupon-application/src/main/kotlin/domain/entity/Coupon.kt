package commerce.eda.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Column
import jakarta.persistence.Enumerated
import jakarta.persistence.EnumType
import jakarta.persistence.Table
import org.hibernate.annotations.GenericGenerator
import shoyoream.server.shoyoreamapplication.core.common.model.BaseTimeEntity
import java.util.*

@Entity
@Table(name = "coupon")
class Coupon(
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "coupon_id")
    val id: UUID,

    @Enumerated(EnumType.STRING)
    val policy: CouponPolicy
) : BaseTimeEntity()
