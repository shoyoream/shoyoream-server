package shoyoream.server.shoyoreamapplication.application.service.user

import java.util.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse
import shoyoream.server.shoyoreamapplication.core.common.exception.DataNotFoundException
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.exception.BrandErrorType
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.service.BrandSelectionService

@Service
class BrandSearchAppService(
    private val brandSelectionService: BrandSelectionService
) {
    @Transactional(readOnly = true)
    fun findBrandByBrandName(brandName: String): DefaultResponse<UUID> {
        // FIX : Cacheable 추가 필요
        // TODO : 캐시 저장 방식 필수 (key pattern)
        val targetBrand = brandSelectionService.findBrandByBrandName(brandName)
            ?: throw DataNotFoundException(BrandErrorType.NOT_FOUND_BRAND)

        return DefaultResponse.uuidResponse(
            id = targetBrand.id
        )
    }
}
