package shoyoream.server.shoyoreamapplication.core.domain.product.brand.repository

import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.graphql.data.GraphQlRepository
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.entity.Brand

@GraphQlRepository
interface BrandRepository : JpaRepository<Brand, UUID>, BrandRepositorySupport
