package kr.co.ku.lecture.service

import kr.co.ku.domain.entity.Lecture
import kr.co.ku.domain.entity.dto.LectureResult
import kr.co.ku.domain.repository.LectureRepository
import kr.co.ku.domain.repository.PostRepository
import kr.co.ku.domain.repository.StudentRepository
import kr.co.ku.domain.repository.TeacherRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class LectureService(
    private val repository: LectureRepository,
    private val teacherRepository: TeacherRepository,
    private val studentRepository: StudentRepository,
    private val postRepository: PostRepository
) {
    fun findAll(): List<LectureResult> {
        return repository.findAll().map { it.toResult() }
    }

    @Transactional(readOnly = true)
    fun findStudentWithLectures(id: Long): List<LectureResult> {
        return repository.findAllWithStudent().map { it.toResult() }
    }

    @Transactional(readOnly = true)
    fun findTeacherWithLectures(id: Long): List<LectureResult> {
        return repository.findAllWithTeacher().map { it.toResult() }
    }

    fun createLecture(
        teacherId: Long,
        lectureName: String
    ) {
        val teacher = teacherRepository.findById(teacherId).orElseThrow()
        val lecture = repository.save(Lecture(id = null, name = lectureName, teacher = teacher))
    }

    fun enrollLecture(
        studentId: Long,
        lectureId: Long
    ) {
        val student = studentRepository.findById(studentId).orElseThrow()
        val lecture = repository.findById(lectureId).orElseThrow()
        student.lectures?.add(lecture)
    }
}
