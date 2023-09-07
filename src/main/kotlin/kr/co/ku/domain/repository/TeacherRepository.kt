package kr.co.ku.domain.repository

import kr.co.ku.domain.entity.Teacher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TeacherRepository : JpaRepository<Teacher, Long> {
    @Query("SELECT t FROM Teacher t LEFT JOIN FETCH t.lectures WHERE t.id = ?1")
    fun findWithLecturesById(id: Long): Teacher
}
