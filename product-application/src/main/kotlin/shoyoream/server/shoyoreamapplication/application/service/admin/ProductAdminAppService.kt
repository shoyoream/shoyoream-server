package shoyoream.server.shoyoreamapplication.application.service.admin

import java.util.UUID
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.application.dto.BrandRequestDTO
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse
import shoyoream.server.shoyoreamapplication.core.common.exception.DataNotFoundException
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.exception.BrandErrorType
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.service.BrandDomainService
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.service.BrandSelectionService
import shoyoream.server.shoyoreamapplication.core.domain.product.goods.service.GoodsDomainService
import shoyoream.server.shoyoreamapplication.core.domain.product.goods.service.GoodsSelectionService

@Service
class ProductAdminAppService(
    private val brandDomainService: BrandDomainService,
    private val goodsDomainService: GoodsDomainService,
    private val brandSelectionService: BrandSelectionService,
    private val goodsSelectionService: GoodsSelectionService
) {
    @Transactional
    fun createNewBrand(brandName: String): DefaultResponse<UUID> {
        val newBrand = brandDomainService.createNewBrand(brandName)
        return DefaultResponse.uuidResponse(
            id = newBrand.id
        )
    }

    @Transactional
    fun createNewGoods(
        goodsInput: BrandRequestDTO.GoodsInput
    ): DefaultResponse<UUID> {
        val targetBrand = brandSelectionService.findBrandById(goodsInput.brandId)
            ?: throw DataNotFoundException(BrandErrorType.NOT_FOUND_BRAND)

        val newGoods = goodsDomainService.createNewGoods(
            goodsName = goodsInput.goodsName,
            goodsCode = goodsInput.goodsCode,
            goodsType = goodsInput.goodsType,
            goodsSize = goodsInput.goodsSize,
            brand = targetBrand
        )
        return DefaultResponse.uuidResponse(
            id = newGoods.id
        )
    }
}
