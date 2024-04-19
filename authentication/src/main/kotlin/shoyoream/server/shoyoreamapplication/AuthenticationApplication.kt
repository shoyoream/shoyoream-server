package shoyoream.server.shoyoreamapplication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
@PropertySource("classpath:/secure.properties")
@EnableCaching
class AuthenticationApplication

fun main(args: Array<String>) {
    runApplication<AuthenticationApplication>(*args)
}
