package shoyoream.server.shoyoreamapplication.core.domain.brand.repository

import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import shoyoream.server.shoyoreamapplication.core.domain.brand.entity.Brand

interface BrandRepository : JpaRepository<Brand, UUID>
