package shoyoream.server.shoyoreamapplication

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.springframework.boot.test.context.SpringBootTest
import shoyoream.server.shoyoreamapplication.core.common.exception.DataNotFoundException
import shoyoream.server.shoyoreamapplication.core.infra.extensions.findNullableSingle
import shoyoream.server.shoyoreamapplication.domain.entity.Customer
import shoyoream.server.shoyoreamapplication.domain.exception.CustomerErrorType
import shoyoream.server.shoyoreamapplication.domain.repository.CustomerRepository
import shoyoream.server.shoyoreamapplication.domain.service.CustomerSelectionServiceImpl

@SpringBootTest
class CustomerSelectionServiceTest : BehaviorSpec({
    val customerRepository: CustomerRepository = mockk(relaxed = true)
    val customerSelectionService = CustomerSelectionServiceImpl(customerRepository)

    Given("특정 고객이 있는 경우") {
        val email = "example@example.com"
        val password = "password"
        val existsCustomer = Customer.of(
            email = email,
            password = password
        )

        every {
            customerRepository.findNullableSingle<Customer>(any())
        } returns existsCustomer

        When("해당 이메일과 비밀번호로 조회하면") {
            val gotCustomer = customerSelectionService.findCustomerForLogin(email, password)

            Then("해당 고객 ID가 반환된다.") {
                gotCustomer.email shouldBe existsCustomer.email
            }
        }
    }

    Given("특정 고객이 없는 경우") {
        val email = "example@example.com"
        val password = "password"

        every {
            customerRepository.findNullableSingle<Customer>(any())
        } returns null

        When("해당 이메일과 비밀번호로 조회하면") {
            val exception = shouldThrow<DataNotFoundException> {
                customerSelectionService.findCustomerForLogin(email, password)
            }

            Then("error가 반환된다.") {
                exception.errorType shouldBe CustomerErrorType.NOT_FOUND_CUSTOMER
            }
        }
    }
})
