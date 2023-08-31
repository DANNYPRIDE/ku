package kr.co.ku.domain.repository

import kr.co.ku.domain.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long>
