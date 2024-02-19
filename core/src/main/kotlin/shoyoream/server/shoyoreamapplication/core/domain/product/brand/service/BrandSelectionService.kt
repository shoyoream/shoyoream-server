package shoyoream.server.shoyoreamapplication.core.domain.product.brand.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.entity.Brand
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.repository.BrandRepository

@Service
class BrandSelectionService(
    private val brandRepository: BrandRepository
) {
    @Transactional(readOnly = true)
    fun findBrandByBrandName(brandName: String): Brand? {
        return brandRepository.findBrandByBrandName(brandName)
    }
}
