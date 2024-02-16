package shoyoream.server.shoyoreamapplication.application.service

import java.util.UUID
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse
import shoyoream.server.shoyoreamapplication.core.common.exception.DataNotFoundException
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.entity.Brand
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.exception.BrandErrorType
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.repository.BrandRepository

@Service
class BrandAdminAppService(
    private val brandRepository: BrandRepository
) {
    @Transactional
    fun createNewBrand(brandName: String): DefaultResponse<UUID> {
        val newBrand = brandRepository.save(Brand.from(brandName))
        return DefaultResponse(
            id = newBrand.id
        )
    }

    @Transactional(readOnly = true)
    fun findBrandByBrandName(brandName: String): DefaultResponse<UUID> {
        val targetBrand = brandRepository.findBrandByBrandName(brandName)
            ?: throw DataNotFoundException(BrandErrorType.NOT_FOUND_BRAND)

        return DefaultResponse(
            id = targetBrand.id
        )
    }
}
