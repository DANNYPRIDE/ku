package kr.co.ku.domain.repository

import kr.co.ku.domain.entity.Teacher
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.Repository

interface TeacherRepository : Repository<Teacher, Long> {
    fun findById(id: Long): Teacher?

    @Query("SELECT t FROM Teacher t LEFT JOIN FETCH t.lectures WHERE t.id = ?1")
    fun findWithLecturesById(id: Long): Teacher
}
