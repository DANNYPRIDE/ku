package kr.co.ku.post.service

import kr.co.ku.domain.entity.Post
import kr.co.ku.domain.entity.dto.PostResult
import kr.co.ku.domain.repository.LectureRepository
import kr.co.ku.domain.repository.PostRepository
import kr.co.ku.domain.repository.StudentRepository
import kr.co.ku.domain.repository.TeacherRepository
import kr.co.ku.post.controller.dto.PostCreateRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Transactional
@Service
class PostService(
    private val repository: PostRepository,
    private val teacherRepository: TeacherRepository,
    private val studentRepository: StudentRepository,
    private val lectureRepository: LectureRepository
) {
    @Transactional(readOnly = true)
    fun findPosts(lectureId: Long): List<Post> {
        return lectureRepository.findWithPostsById(lectureId).posts?.toList()
    }

    @Transactional(readOnly = true)
    fun findPostsWithTeacher(teacherId: Long): List<PostResult> {
        return repository.findByTeacher(teacherId).map { it.toResult() }
    }

    @Transactional(readOnly = true)
    fun findPostsWithStudent(studentId: Long): List<PostResult> {
        return studentRepository.findWithLecturesById(studentId).lectures?.flatMap { lecture ->
            lecture.posts
        }?.map {
            it.toResult()
        } ?: emptyList()
    }

    fun createPost(request: PostCreateRequest) {
        val teacher = teacherRepository.findById(request.teacherId).orElseThrow()
        val lecture = lectureRepository.findById(request.lectureId).orElseThrow()
        repository.save(
            Post(
                null,
                request.title,
                request.text,
                teacher,
                LocalDateTime.now(),
                LocalDateTime.now(),
                lecture
            )
        )
    }
}
