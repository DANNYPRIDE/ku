package kr.co.ku.domain.repository

import kr.co.ku.domain.entity.Lecture
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface LectureRepository : JpaRepository<Lecture, Long> {
    @Query("SELECT DISTINCT l FROM Lecture l LEFT JOIN FETCH l.posts WHERE l.id = ?1")
    fun findWithPostsById(id: Long): Lecture

    @Query("SELECT DISTINCT l FROM Lecture l JOIN FETCH l.teacher")
    fun findAllWithTeacher(): List<Lecture>

    @Query("SELECT DISTINCT l FROM Lecture l JOIN FETCH l.students")
    fun findAllWithStudent(): List<Lecture>
}
