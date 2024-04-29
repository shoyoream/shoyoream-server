package shoyoream.server.shoyoreamapplication.core.infra.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class SecurityConfig {
    @Bean
    fun filterChain(
        httpSecurity: HttpSecurity
    ): SecurityFilterChain {
        val http = httpSecurity
            .csrf().disable()
            .authorizeHttpRequests { requests ->
                requests
                    .requestMatchers(
                        "/**"
                    ).permitAll()
                    .anyRequest().authenticated()
            }
        return http.build()
    }
}
