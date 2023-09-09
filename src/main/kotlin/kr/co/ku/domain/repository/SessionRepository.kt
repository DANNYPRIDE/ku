package kr.co.ku.domain.repository

import kr.co.ku.domain.entity.Session
import org.springframework.data.jpa.repository.JpaRepository

interface SessionRepository : JpaRepository<Session, Long> {
    fun findById(sessionId: String): Session?
}
