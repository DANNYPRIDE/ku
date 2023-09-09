package kr.co.ku.domain.repository

import kr.co.ku.domain.entity.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface PostRepository : JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p JOIN FETCH p.teacher t WHERE t.id =?1 ")
    fun findByTeacher(id: Long): List<Post>
}
