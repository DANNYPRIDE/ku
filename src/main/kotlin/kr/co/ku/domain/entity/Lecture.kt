package kr.co.ku.domain.entity

import kr.co.ku.domain.entity.dto.LectureResult
import javax.persistence.*

@Entity
class Lecture(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    @Column
    var name: String,
    @ManyToOne
    var teacher: Teacher? = null,
    @ManyToMany(mappedBy = "lectures")
    var students: MutableList<Student> = mutableListOf(),
    @OneToMany(mappedBy = "lecture", cascade = [CascadeType.ALL])
    var posts: MutableList<Post> = mutableListOf()
) {
    fun toResult() =
        LectureResult(
            this.id ?: 0,
            this.name,
            this.teacher?.name ?: ""
        )
}
