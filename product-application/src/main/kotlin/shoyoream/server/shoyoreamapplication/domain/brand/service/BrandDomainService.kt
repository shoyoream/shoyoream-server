package shoyoream.server.shoyoreamapplication.domain.brand.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.domain.brand.entity.Brand
import shoyoream.server.shoyoreamapplication.domain.brand.repository.BrandRepository
import java.util.*

interface BrandDomainService {
    fun createNewBrand(brandName: String): Brand
}

@Service
class BrandDomainServiceImpl(
    private val brandRepository: BrandRepository
) : BrandDomainService {
    @Transactional
    override fun createNewBrand(brandName: String): Brand {
        return brandRepository.save(
            Brand.of(
                brandId = UUID.randomUUID(),
                brandName = brandName
            )
        )
    }
}
