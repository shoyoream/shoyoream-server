package shoyoream.server.shoyoreamapplication.application.service.user

import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.entity.Brand
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.repository.BrandRepository
import shoyoream.server.shoyoreamapplication.core.infra.extensions.findNullableSingle

@Service
class BrandCacheService(
    private val brandRepository: BrandRepository
) {
    fun getBrandCache(brandName: String): Brand? {
        return brandRepository.findNullableSingle {
            select(
                entity(Brand::class)
            ).from(
                entity(Brand::class)
            ).where(
                path(Brand::brandName).equal(brandName)
            )
        }
    }
}
