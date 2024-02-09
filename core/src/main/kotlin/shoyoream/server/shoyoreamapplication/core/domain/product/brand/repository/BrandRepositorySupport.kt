package shoyoream.server.shoyoreamapplication.core.domain.product.brand.repository

import java.util.UUID
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.entity.Brand

interface BrandRepositorySupport {
    fun findBrandByBrandId(id: UUID): Brand?
}
