package shoyoream.server.shoyoreamapplication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
@PropertySource("classpath:/secure.properties")
@EnableCaching
@ConfigurationPropertiesScan
class CustomerApplication

fun main(args: Array<String>) {
    runApplication<CustomerApplication>(*args)
}
