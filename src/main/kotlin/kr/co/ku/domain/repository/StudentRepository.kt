package kr.co.ku.domain.repository

import kr.co.ku.domain.entity.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface StudentRepository : JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.lectures WHERE s.id = ?1")
    fun findWithLecturesById(id: Long): Student
}
