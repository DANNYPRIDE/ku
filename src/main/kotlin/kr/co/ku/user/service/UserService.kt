package kr.co.ku.user.service

import kr.co.ku.common.const.STUDENT
import kr.co.ku.common.const.TEACHER
import kr.co.ku.domain.entity.Session
import kr.co.ku.domain.entity.Session.Companion.createSession
import kr.co.ku.domain.entity.Student
import kr.co.ku.domain.entity.Teacher
import kr.co.ku.domain.repository.SessionRepository
import kr.co.ku.domain.repository.StudentRepository
import kr.co.ku.domain.repository.TeacherRepository
import kr.co.ku.user.controller.dto.request.LoginRequest
import kr.co.ku.user.controller.dto.request.SignUpRequest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val bcryptEncoder: BCryptPasswordEncoder,
    private val studentRepository: StudentRepository,
    private val teacherRepository: TeacherRepository,
    private val sessionRepository: SessionRepository
) {
    fun signUp(request: SignUpRequest) {
        if (request.isTeacher) {
            teacherRepository.save(
                Teacher(
                    id = null,
                    email = request.email,
                    password = bcryptEncoder.encode(request.password),
                    name = request.name
                )
            )
        } else {
            studentRepository.save(
                Student(
                    id = null,
                    email = request.email,
                    password = bcryptEncoder.encode(request.password),
                    name = request.name
                )
            )
        }
    }

    @Transactional
    fun login(request: LoginRequest): Session {
        val encryptedPassword = findEncryptedPasswordByEmail(request)
        require(bcryptEncoder.matches(request.password, encryptedPassword)) {
            throw RuntimeException("")
        }
        return sessionRepository.save(createSession(role = if (request.isTeacher) TEACHER else STUDENT))
    }

    private fun findEncryptedPasswordByEmail(request: LoginRequest): String {
        return if (request.isTeacher) {
            teacherRepository.findByEmail(request.email)?.password
        } else {
            studentRepository.findByEmail(request.email)?.password
        } ?: throw RuntimeException("")
    }
}
