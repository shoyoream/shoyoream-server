package shoyoream.server.shoyoreamapplication.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.*
import org.hibernate.annotations.GenericGenerator
import shoyoream.server.shoyoreamapplication.core.common.utils.UUIDGenerator

@Entity
@Table(name = "payment")
class Payment(
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "payment_id")
    val id: UUID = UUIDGenerator.randomUUID(),

    // customer id
    @Column(name = "customer_id")
    val customerId: Long,

    // easy pay (many)
    @OneToMany(mappedBy = "payment", fetch = FetchType.LAZY)
    val easyPayMethods: List<EasyPayMethod> = mutableListOf(),

    // card pay (many)
    @OneToMany(mappedBy = "payment", fetch = FetchType.LAZY)
    val cardPayMethods: List<CardPayMethod> = mutableListOf()
)
