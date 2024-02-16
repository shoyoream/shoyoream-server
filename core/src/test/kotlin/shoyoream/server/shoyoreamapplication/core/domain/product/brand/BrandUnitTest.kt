package shoyoream.server.shoyoreamapplication.core.domain.product.brand

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.boot.test.context.SpringBootTest
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.entity.Brand
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.repository.BrandRepository
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.service.BrandDomainService

@SpringBootTest
class BrandUnitTest : StringSpec({
    val brandRepository: BrandRepository = mockk()
    val brandDomainService = BrandDomainService(brandRepository)

    "브랜드 이름을 넣으면 새로운 브랜드가 생성된다." {
        val newBrandName = "Test Brand Name"
        val expectedBrand = Brand(brandName = newBrandName)
        every { brandRepository.save(any()) } returns expectedBrand

        val createdBrand = withContext(Dispatchers.IO) {
            brandDomainService.createNewBrand(newBrandName)
        }

        createdBrand shouldBe expectedBrand
    }

    "브랜드 이름을 넣으면 해당 브랜드를 가져온다." {
        val targetBrandName = "SHOYOROLL"
        val targetBrand = Brand(brandName = targetBrandName)
        every { brandRepository.findBrandByBrandName(any()) } returns targetBrand

        val gotBrand = brandRepository.findBrandByBrandName(targetBrandName)

        targetBrand.brandName shouldBe gotBrand!!.brandName
    }
})
