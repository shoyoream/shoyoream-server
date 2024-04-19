package shoyoream.server.shoyoreamapplication.core.domain.customer.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import shoyoream.server.shoyoreamapplication.core.common.model.BaseTimeEntity

@Entity
@Table(name = "customer")
class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    val customerId: Long = 0L,

    @Column(name = "email", unique = true)
    val email: String,

    @Column(name = "password")
    var password: String
) : BaseTimeEntity() {
    companion object {
        fun of(email: String, password: String): Customer {
            return Customer(
                email = email,
                password = password
            )
        }
    }
}
