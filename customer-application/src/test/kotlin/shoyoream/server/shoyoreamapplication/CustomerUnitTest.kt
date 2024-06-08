package shoyoream.server.shoyoreamapplication

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.boot.test.context.SpringBootTest
import shoyoream.server.shoyoreamapplication.domain.entity.Customer
import shoyoream.server.shoyoreamapplication.domain.repository.CustomerRepository
import shoyoream.server.shoyoreamapplication.domain.service.CustomerDomainService

@SpringBootTest
class CustomerUnitTest : StringSpec({
    val customerRepository: CustomerRepository = mockk(relaxed = true)
    val customerDomainService = CustomerDomainService(customerRepository)

    "회원가입을 한다." {
        val email = "moonpiderman@gmail.com"
        val password = "password"

        val newCustomer = Customer.of(
            email = email,
            password = password
        )

        every { customerRepository.save(any()) } returns newCustomer

        val createdCustomer = withContext(Dispatchers.IO) {
            val customer = Customer.of(
                email = email,
                password = password
            )
            customerDomainService.createCustomer(customer)
        }

        createdCustomer shouldBe newCustomer
    }
})
