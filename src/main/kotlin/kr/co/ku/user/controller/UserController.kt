package kr.co.ku.user.controller

import kr.co.ku.user.controller.dto.request.LoginRequest
import kr.co.ku.user.controller.dto.request.SignUpRequest
import kr.co.ku.user.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val service: UserService) {
    @PostMapping("/signup")
    fun signUp(request: SignUpRequest) {
        return service.signUp(request)
    }

    @PostMapping("/login")
    fun login(request: LoginRequest) {
        return service.login(request)
    }
}
