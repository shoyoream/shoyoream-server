package shoyoream.server.shoyoreamapplication.core.domain.product.brand

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.mockito.InjectMocks
import org.springframework.boot.test.context.SpringBootTest
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.entity.Brand
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.repository.BrandRepository
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.service.BrandDomainService

val brandRepository: BrandRepository = mockk()

@InjectMocks
val brandDomainService: BrandDomainService = BrandDomainService(brandRepository)

@SpringBootTest
class BrandUnitTest : StringSpec({
    "브랜드 이름을 넣으면 새로운 브랜드가 리턴된다." {
        val newBrandName = "Test Brand Name"
        val expectedBrand = Brand(brandName = newBrandName)
        every { brandRepository.save(any<Brand>()) } returns expectedBrand

        val createdBrand = withContext(Dispatchers.IO) {
            brandDomainService.createNewBrand(newBrandName)
        }

        createdBrand shouldBe expectedBrand
    }
})
