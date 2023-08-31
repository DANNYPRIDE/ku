package kr.co.ku.domain.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Post(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

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
    var lecture: Lecture,
)
