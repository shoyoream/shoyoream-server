package shoyoream.server.shoyoreamapplication.core.domain.shipping.repository

import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import shoyoream.server.shoyoreamapplication.core.domain.shipping.entity.Shipping

interface ShippingRepository : JpaRepository<Shipping, UUID>, ShippingRepositorySupport
