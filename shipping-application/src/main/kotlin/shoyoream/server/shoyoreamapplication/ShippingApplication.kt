package shoyoream.server.shoyoreamapplication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
@PropertySource("classpath:/secure.properties")
class ShippingApplication

fun main(args: Array<String>) {
    runApplication<ShippingApplication>(*args)
}
