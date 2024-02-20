package shoyoream.server.shoyoreamapplication.core.domain.product.brand.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.entity.Brand
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.repository.BrandRepository
import shoyoream.server.shoyoreamapplication.core.infra.extensions.findNullableSingle

@Service
class BrandSelectionService(
    private val brandRepository: BrandRepository
) {
    @Transactional(readOnly = true)
    fun findBrandByBrandName(brandName: String): Brand? {
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
