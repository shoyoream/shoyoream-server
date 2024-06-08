package shoyoream.server.shoyoreamapplication.domain.brand.service

import java.util.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.domain.brand.entity.Brand
import shoyoream.server.shoyoreamapplication.domain.brand.repository.BrandRepository
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

    @Transactional
    fun findBrandById(brandId: UUID): Brand? {
        return brandRepository.findNullableSingle {
            select(
                entity(Brand::class)
            ).from(
                entity(Brand::class)
            ).where(
                path(Brand::id).equal(brandId)
            )
        }
    }
}
