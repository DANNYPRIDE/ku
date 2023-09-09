package kr.co.ku.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class BcryptEncoderConfiguration {
    @Bean
    fun bcryptEncoder(): BCryptPasswordEncoder  {
        return BCryptPasswordEncoder(5)
    }
}
