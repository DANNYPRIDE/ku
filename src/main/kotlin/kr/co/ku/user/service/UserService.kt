package kr.co.ku.user.service

import kr.co.ku.domain.entity.Student
import kr.co.ku.domain.entity.Teacher
import kr.co.ku.domain.repository.StudentRepository
import kr.co.ku.domain.repository.TeacherRepository
import kr.co.ku.user.controller.dto.request.LoginRequest
import kr.co.ku.user.controller.dto.request.SignUpRequest
import org.springframework.stereotype.Service

@Service
class UserService(private val studentRepository: StudentRepository, private val teacherRepository: TeacherRepository) {
    fun signUp(request: SignUpRequest) {
        if (request.isTeacher) {
            teacherRepository.save(
                Teacher(
                    id = null,
                    email = request.email,
                    password = request.password,
                    name = request.name
                )
            )
        } else
            {
                studentRepository.save(
                    Student(
                        id = null,
                        email = request.email,
                        password = request.password,
                        name = request.name
                    )
                )
            }
    }

    fun login(request: LoginRequest) {
    }
}
