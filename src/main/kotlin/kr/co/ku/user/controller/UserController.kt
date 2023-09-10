package kr.co.ku.user.controller

import kr.co.ku.domain.entity.Session
import kr.co.ku.user.controller.dto.request.LoginRequest
import kr.co.ku.user.controller.dto.request.SignUpRequest
import kr.co.ku.user.service.UserService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class UserController(private val service: UserService) {
    @PostMapping("/signup")
    fun signUp(
        @RequestBody
        request: SignUpRequest
    ) {
        return service.signUp(request)
    }

    @PostMapping("/login")
    fun login(
        @RequestBody
        request: LoginRequest
    ): Session {
        return service.login(request)
    }

    @PostMapping("test")
    fun test(): String {
        return "cookie is good to go"
    }
}
