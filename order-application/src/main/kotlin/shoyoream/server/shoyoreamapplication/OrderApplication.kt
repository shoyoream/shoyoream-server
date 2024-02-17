package shoyoream.server.shoyoreamapplication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
@PropertySource("classpath:/secure.properties")
class OrderApplication

fun main(args: Array<String>) {
    runApplication<OrderApplication>(*args)
}
