package shoyoream.server.shoyoreamapplication.core.domain.order.repository

import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.graphql.data.GraphQlRepository
import shoyoream.server.shoyoreamapplication.core.domain.order.entity.Order

@GraphQlRepository
interface OrderRepository : JpaRepository<Order, UUID>, OrderRepositorySupport
