package kr.co.ku.domain.entity

import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Session(
    @Id
    val id: String,
    @Column
    val role: String,
    @Column
    val createdAt: LocalDateTime,
    @Column
    val expiresAt: LocalDateTime,
    @Column
    val userId: Long
) {
    companion object {
        fun createSession(
            role: String,
            userId: Long
        ): Session {
            return Session(
                id = UUID.randomUUID().toString(),
                role = role,
                createdAt = LocalDateTime.now(),
                expiresAt = LocalDateTime.now().plusHours(12),
                userId = userId
            )
        }
    }
}
