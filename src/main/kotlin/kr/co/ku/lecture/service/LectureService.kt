package kr.co.ku.lecture.service

import kr.co.ku.domain.entity.Lecture
import kr.co.ku.domain.entity.Post
import kr.co.ku.domain.repository.LectureRepository
import kr.co.ku.domain.repository.PostRepository
import kr.co.ku.domain.repository.StudentRepository
import kr.co.ku.domain.repository.TeacherRepository
import kr.co.ku.lecture.controller.dto.request.LectureCreateRequest
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
    fun createLecture(request: LectureCreateRequest) {
        val teacher = teacherRepository.findById(request.teacherId).orElseThrow()
        val lecture = repository.save(Lecture(id = null, name = request.name, teacher = teacher))
    }

    @Transactional(readOnly = true)
    fun findPosts(id: Long): List<Post> {
        return repository.findWithPostsById(id).posts?.toList()
    }

    @Transactional(readOnly = true)
    fun findStudentWithLectures(id: Long): List<Lecture> {
        return studentRepository.findWithLecturesById(id).lectures?.toList() ?: emptyList()
    }

    @Transactional(readOnly = true)
    fun findTeacherWithLectures(id: Long): List<Lecture> {
        return teacherRepository.findWithLecturesById(id).lectures?.toList() ?: emptyList()
    }
}
