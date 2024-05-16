package shoyoream.server.shoyoreamapplication.core.domain.payment.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
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
import shoyoream.server.shoyoreamapplication.core.domain.payment.entity.enums.CardType

@Entity
@Table(name = "card_pay_method")
class CardPayMethod(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "card_number")
    val cardNumber: String,

    @Enumerated(EnumType.STRING)
    val cardType: CardType,

    @ManyToOne(targetEntity = Payment::class, cascade = [CascadeType.ALL])
    @JoinColumn(name = "payment_id", foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    var payment: Payment
) : BaseTimeEntity()
