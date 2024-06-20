package shoyoream.server.shoyoreamapplication.application.dto

import shoyoream.server.shoyoreamapplication.domain.entity.Customer

data class UserInfo(
    val id: Long,
    val email: String
) {
    companion object {
        fun of(customer: Customer): UserInfo {
            return UserInfo(
                id = customer.customerId,
                email = customer.email
            )
        }
    }
}
