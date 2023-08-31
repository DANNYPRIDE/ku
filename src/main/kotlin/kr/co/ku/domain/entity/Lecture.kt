package kr.co.ku.domain.entity

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
    var posts: MutableList<Post> = mutableListOf(),

)
