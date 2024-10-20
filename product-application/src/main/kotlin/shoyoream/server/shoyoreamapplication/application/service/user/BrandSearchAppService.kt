package shoyoream.server.shoyoreamapplication.application.service.user

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.application.config.ProductCacheConfig.Companion.BRAND_CACHE_NAME
import shoyoream.server.shoyoreamapplication.application.dto.BrandResponseDTO
import shoyoream.server.shoyoreamapplication.application.dto.BrandResponseDTO.BrandResponse.Companion.ofResponse
import shoyoream.server.shoyoreamapplication.core.common.exception.DataNotFoundException
import shoyoream.server.shoyoreamapplication.domain.brand.exception.BrandErrorType
import shoyoream.server.shoyoreamapplication.domain.brand.service.BrandSelectionService

interface BrandSearchAppService {
    fun findBrandByBrandName(brandName: String): BrandResponseDTO.BrandResponse
}

@Service
class BrandSearchAppServiceImpl(
    private val brandSelectionService: BrandSelectionService
) : BrandSearchAppService {
    @Cacheable(cacheNames = [BRAND_CACHE_NAME], key = "#brandName")
    @Transactional(readOnly = true)
    override fun findBrandByBrandName(brandName: String): BrandResponseDTO.BrandResponse {
        val targetBrand = brandSelectionService.findBrandByBrandName(brandName)
            ?: throw DataNotFoundException(BrandErrorType.NOT_FOUND_BRAND)

        return targetBrand.ofResponse()
    }
}
