package shoyoream.server.shoyoreamapplication.application.service

import java.util.UUID
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shoyoream.server.shoyoreamapplication.core.common.constant.DefaultResponse
import shoyoream.server.shoyoreamapplication.core.common.exception.DataNotFoundException
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.exception.BrandErrorType
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.service.BrandDomainService
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.service.BrandSelectionService
import shoyoream.server.shoyoreamapplication.core.domain.product.goods.entity.GoodsSize
import shoyoream.server.shoyoreamapplication.core.domain.product.goods.entity.GoodsType
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
        return DefaultResponse.response(
            id = newBrand.id
        )
    }

    @Transactional
    fun createNewGoods(
        goodsName: String,
        goodsCode: String,
        goodsType: GoodsType,
        goodsSize: GoodsSize,
        brandId: UUID
    ): DefaultResponse<UUID> {
        val targetBrand = brandSelectionService.findBrandById(brandId)
            ?: throw DataNotFoundException(BrandErrorType.NOT_FOUND_BRAND)

        val newGoods = goodsDomainService.createNewGoods(
            goodsName = goodsName,
            goodsCode = goodsCode,
            goodsType = goodsType,
            goodsSize = goodsSize,
            brand = targetBrand
        )
        return DefaultResponse.response(
            id = newGoods.id
        )
    }

    @Transactional(readOnly = true)
    fun findBrandByBrandName(brandName: String): DefaultResponse<UUID> {
        val targetBrand = brandSelectionService.findBrandByBrandName(brandName)
            ?: throw DataNotFoundException(BrandErrorType.NOT_FOUND_BRAND)

        return DefaultResponse.response(
            id = targetBrand.id
        )
    }
}
