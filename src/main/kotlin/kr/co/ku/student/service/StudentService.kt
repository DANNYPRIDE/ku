package kr.co.ku.student.service

import kr.co.ku.domain.entity.Lecture
import kr.co.ku.domain.repository.StudentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StudentService(private val repository: StudentRepository) {
    @Transactional(readOnly = true)
    fun findLectures(id: Long): List<Lecture> {
        return repository.findWithLecturesById(id).lectures?.toList() ?: emptyList()
    }
}
