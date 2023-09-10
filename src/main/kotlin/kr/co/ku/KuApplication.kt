package kr.co.ku

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class, SecurityFilterAutoConfiguration::class, UserDetailsServiceAutoConfiguration::class ])
@EnableJpaRepositories
class KuApplication

fun main(args: Array<String>) {
    runApplication<KuApplication>(*args)
}
