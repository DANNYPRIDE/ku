package kr.co.ku.teacher.service

import kr.co.ku.domain.entity.Lecture
import kr.co.ku.domain.repository.TeacherRepository
import org.springframework.stereotype.Service

@Service
class TeacherService(private val repository: TeacherRepository) {
    fun findLecture(id: Long): List<Lecture> {
        return repository.findWithLecturesById(id).lectures?.toList() ?: emptyList()
    }
}
