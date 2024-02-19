package shoyoream.server.shoyoreamapplication.application.service

import java.util.UUID
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse
import shoyoream.server.shoyoreamapplication.core.common.exception.DataNotFoundException
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.exception.BrandErrorType
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.service.BrandDomainService
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.service.BrandSelectionService

@Service
class BrandAdminAppService(
    private val brandDomainService: BrandDomainService,
    private val brandSelectionService: BrandSelectionService
) {
    @Transactional
    fun createNewBrand(brandName: String): DefaultResponse<UUID> {
        val newBrand = brandDomainService.createNewBrand(brandName)
        return DefaultResponse.response(
            id = newBrand.id
        )
    }

    @Transactional(readOnly = true)
    fun findBrandByBrandName(brandName: String): DefaultResponse<UUID> {
        val targetBrand = brandSelectionService.findBrandByName(brandName)
            ?: throw DataNotFoundException(BrandErrorType.NOT_FOUND_BRAND)

        return DefaultResponse.response(
            id = targetBrand.id
        )
    }
}
