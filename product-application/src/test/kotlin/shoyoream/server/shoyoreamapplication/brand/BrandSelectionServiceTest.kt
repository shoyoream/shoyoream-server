package shoyoream.server.shoyoreamapplication.brand

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.boot.test.context.SpringBootTest
import shoyoream.server.shoyoreamapplication.domain.brand.entity.Brand
import shoyoream.server.shoyoreamapplication.domain.brand.repository.BrandRepository
import shoyoream.server.shoyoreamapplication.core.infra.extensions.findNullableSingle
import shoyoream.server.shoyoreamapplication.domain.brand.service.BrandSelectionServiceImpl
import java.util.UUID

@SpringBootTest
class BrandSelectionServiceTest : BehaviorSpec({
    val brandRepository: BrandRepository = mockk(relaxed = true)
    val brandSelectionService = BrandSelectionServiceImpl(brandRepository)

    Given("특정 브랜드가 있는 경우") {
        val existBrandName = "Exist Brand"
        val expectedBrand = Brand.of(
            brandId = UUID.randomUUID(),
            brandName = existBrandName
        )

        every {
            brandRepository.findNullableSingle<Brand>(any())
        } returns expectedBrand

        When("해당 브랜드 이름으로 조회하면") {
            val gotBrand = withContext(Dispatchers.IO) {
                brandSelectionService.findBrandByBrandName(existBrandName)
            }

            Then("해당 브랜드가 반환된다.") {
                gotBrand shouldBe expectedBrand
            }
        }
    }

    Given("특정 브랜드가 없는 경우") {
        val notExistBrandName = "Not Exist Brand"
        every {
            brandRepository.findNullableSingle<Brand>(any())
        } returns null

        When("해당 브랜드 이름으로 조회하면") {
            val gotBrand = withContext(Dispatchers.IO) {
                brandSelectionService.findBrandByBrandName(notExistBrandName)
            }

            Then("null이 반환된다.") {
                gotBrand shouldBe null
            }
        }
    }
})
