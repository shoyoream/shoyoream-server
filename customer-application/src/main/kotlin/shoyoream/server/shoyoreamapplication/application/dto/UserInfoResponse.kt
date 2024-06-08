package shoyoream.server.shoyoreamapplication.application.dto

import shoyoream.server.shoyoreamapplication.domain.entity.Customer

data class UserInfoResponse(
    val id: Long,
    val email: String
) {
    companion object {
        fun of(customer: Customer): UserInfoResponse {
            return UserInfoResponse(
                id = customer.customerId,
                email = customer.email
            )
        }
    }
}
