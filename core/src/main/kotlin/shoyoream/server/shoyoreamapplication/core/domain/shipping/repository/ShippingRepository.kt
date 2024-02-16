package shoyoream.server.shoyoreamapplication.core.domain.shipping.repository

import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.graphql.data.GraphQlRepository
import shoyoream.server.shoyoreamapplication.core.domain.shipping.entity.Shipping

@GraphQlRepository
interface ShippingRepository : JpaRepository<Shipping, UUID>, ShippingRepositorySupport
