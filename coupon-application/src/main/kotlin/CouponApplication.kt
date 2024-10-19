package commerce.eda

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
@PropertySource("classpath:/secure.properties")
class CouponApplication

fun main(args: Array<String>) {
    runApplication<CouponApplication>(*args)
}
