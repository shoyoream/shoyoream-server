package shoyoream.server.shoyoreamapplication.core.domain.order.repository

import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import shoyoream.server.shoyoreamapplication.core.domain.order.entity.OrderHistory

interface OrderHistoryRepository : JpaRepository<OrderHistory, UUID>, OrderHistoryRepositorySupport
