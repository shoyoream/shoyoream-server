package shoyoream.server.shoyoreamapplication.core.domain.product.brand.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.entity.Brand
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.repository.BrandRepository
import java.util.*

@Service
class BrandDomainService(
    private val brandRepository: BrandRepository
) {
    @Transactional
    fun createNewBrand(brandName: String): Brand {
        return brandRepository.save(
            Brand.of(
                brandId = UUID.randomUUID(),
                brandName = brandName
            )
        )
    }
}
