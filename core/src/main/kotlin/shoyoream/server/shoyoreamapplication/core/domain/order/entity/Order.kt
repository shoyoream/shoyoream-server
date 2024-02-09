package shoyoream.server.shoyoreamapplication.core.domain.order.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*
import org.hibernate.annotations.GenericGenerator
import shoyoream.server.shoyoreamapplication.core.common.utils.UUIDGenerator

@Entity
@Table(name = "orders")
class Order(
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "order_id")
    val id: UUID = UUIDGenerator.randomUUID()
)
