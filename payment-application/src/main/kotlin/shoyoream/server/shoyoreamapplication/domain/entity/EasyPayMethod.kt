package shoyoream.server.shoyoreamapplication.domain.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.ConstraintMode
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import shoyoream.server.shoyoreamapplication.core.common.model.BaseTimeEntity
import shoyoream.server.shoyoreamapplication.domain.entity.enums.EasyPayMethodType

@Entity
@Table(name = "easy_pay_method")
class EasyPayMethod(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Enumerated(EnumType.STRING)
    val easyPayMethodType: EasyPayMethodType,

    @ManyToOne(targetEntity = Payment::class, cascade = [CascadeType.ALL])
    @JoinColumn(name = "payment_id", foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    var payment: Payment
) : BaseTimeEntity()
