package shoyoream.server.shoyoreamapplication.core.domain.product.brand

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.springframework.boot.test.context.SpringBootTest
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.entity.Brand
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.repository.BrandRepository
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.service.BrandSelectionService

@SpringBootTest
class BrandSelectionServiceTest : BehaviorSpec({
    val brandRepository: BrandRepository = mockk()
    val brandSelectionService = BrandSelectionService(brandRepository)

    Given("특정 브랜드가 있는 경우") {
        val shoyorollName = "Shoyoroll"
        val shoyoroll = Brand(brandName = shoyorollName)

        every { brandRepository.findBrandByBrandName(any()) } returns shoyoroll

        When("해당 브랜드 이름으로 검색하면") {
            val gotShoyoroll = brandSelectionService.findBrandByBrandName(shoyorollName)

            Then("해당 브랜드가 조회 된다.") {
                gotShoyoroll!!.brandName shouldBe shoyorollName
            }
        }
    }

    Given("특정 브랜드가 없는 경우") {
        val albinoName = "AP"
        every { brandRepository.findBrandByBrandName(any()) } returns null

        When("해당 브랜드 이름으로 검색하면") {
            val albinoAndPreto = brandSelectionService.findBrandByBrandName(albinoName)

            Then("null이 반환된다.") {
                albinoAndPreto shouldBe null
            }
        }
    }
})
