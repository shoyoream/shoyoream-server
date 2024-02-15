package shoyoream.server.shoyoreamapplication.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.entity.Brand
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.repository.BrandRepository

@Service
class BrandAdminAppService(
    private val brandRepository: BrandRepository
) {
    @Transactional
    fun createNewBrand(brandName: String): Brand {
        return brandRepository.save(Brand.from(brandName))
    }
}
