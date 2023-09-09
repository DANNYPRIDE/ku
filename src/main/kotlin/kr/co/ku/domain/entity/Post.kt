package kr.co.ku.domain.entity

import kr.co.ku.domain.entity.dto.PostResult
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    @Column
    var title: String,
    @Column
    var text: String,
    @ManyToOne
    var teacher: Teacher,
    @Column
    var createdAt: LocalDateTime,
    @Column
    var updatedAt: LocalDateTime,
    @ManyToOne
    var lecture: Lecture
) {
    fun toResult() =
        PostResult(
            this.id ?: 0,
            this.title,
            this.text,
            this.teacher.name,
            this.createdAt,
            this.updatedAt
        )
}
