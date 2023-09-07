package kr.co.ku.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun bCryptPasswordEncoder():BCryptPasswordEncoder {
        return BCryptPasswordEncoder();
    }

    @Override
    protected fun configure(http: HttpSecurity) {
        http
            .csrf().disable() // post 방식으로 값을 전송할 때 token을 사용해야하는 보안 설정을 해제
            .authorizeRequests()
            .antMatchers("/", "/user/signUp").permitAll()
            .anyRequest().authenticated();
    }
}