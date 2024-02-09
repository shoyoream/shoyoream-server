package shoyoream.server.shoyoreamapplication.core.domain.product.brand.repository

import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.entity.Brand

interface BrandRepositoryRepository : JpaRepository<Brand, UUID>, BrandRepositorySupport
