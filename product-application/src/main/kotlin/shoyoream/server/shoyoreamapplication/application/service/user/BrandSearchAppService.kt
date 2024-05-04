package shoyoream.server.shoyoreamapplication.application.service.user

import java.util.*
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.application.dto.BrandResponseDTO
import shoyoream.server.shoyoreamapplication.application.dto.BrandResponseDTO.BrandResponse.Companion.ofResponse
import shoyoream.server.shoyoreamapplication.core.common.exception.DataNotFoundException
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.exception.BrandErrorType
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.service.BrandSelectionService

@Service
class BrandSearchAppService(
    private val brandCacheService: BrandCacheService,
    private val brandSelectionService: BrandSelectionService
) {
    @Cacheable(cacheNames = ["brand"], key = "'brand:' + #brandName")
    @Transactional(readOnly = true)
    fun findBrandByBrandName(brandName: String): BrandResponseDTO.BrandResponse {
        val targetBrand = brandCacheService.getBrandCache(brandName)
            ?: throw DataNotFoundException(BrandErrorType.NOT_FOUND_BRAND)

        return targetBrand.ofResponse()
    }
}
