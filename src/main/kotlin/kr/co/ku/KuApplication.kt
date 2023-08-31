package kr.co.ku

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class KuApplication

fun main(args: Array<String>) {
    runApplication<KuApplication>(*args)
}
