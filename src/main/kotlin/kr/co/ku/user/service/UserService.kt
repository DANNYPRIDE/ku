package kr.co.ku.user.service

import kr.co.ku.domain.entity.Student
import kr.co.ku.domain.repository.StudentRepository
import kr.co.ku.domain.repository.TeacherRepository
import kr.co.ku.user.controller.dto.request.LoginRequest
import kr.co.ku.user.controller.dto.request.SignUpRequest
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: StudentRepository, private val teacherRepository: TeacherRepository) {

    fun signUp(request: SignUpRequest) {
        repository.save(
            Student(
                id = null,
                email = request.email,
                password = request.password,
                name = request.name,
            ),
        )
    }

    fun login(request: LoginRequest) {
    }
}
