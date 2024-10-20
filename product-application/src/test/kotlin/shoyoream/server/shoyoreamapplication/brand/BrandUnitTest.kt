package shoyoream.server.shoyoreamapplication.brand

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.boot.test.context.SpringBootTest
import shoyoream.server.shoyoreamapplication.domain.brand.entity.Brand
import shoyoream.server.shoyoreamapplication.domain.brand.repository.BrandRepository
import shoyoream.server.shoyoreamapplication.domain.brand.service.BrandDomainServiceImpl
import java.util.UUID

@SpringBootTest
class BrandUnitTest : StringSpec({
    val brandRepository: BrandRepository = mockk(relaxed = true)
    val brandDomainService = BrandDomainServiceImpl(brandRepository)

    "브랜드 이름을 넣으면 새로운 브랜드가 생성된다." {
        val newBrandName = "Test Brand Name"
        val expectedBrand = Brand.of(
            brandId = UUID.randomUUID(),
            brandName = newBrandName
        )
        every { brandRepository.save(any()) } returns expectedBrand

        val createdBrand = withContext(Dispatchers.IO) {
            brandDomainService.createNewBrand(newBrandName)
        }

        createdBrand shouldBe expectedBrand
    }
})
