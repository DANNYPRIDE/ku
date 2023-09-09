package kr.co.ku.user.controller.dto.request

data class LoginRequest(
    val email: String,
    val password: String,
    val isTeacher: Boolean
)
