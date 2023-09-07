package kr.co.ku.user.controller.dto.request

data class SignUpRequest(
    val email: String,
    val password: String,
    val name: String,
    val isTeacher: Boolean
)
