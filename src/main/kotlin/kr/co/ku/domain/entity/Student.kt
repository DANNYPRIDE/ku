package kr.co.ku.domain.entity

import javax.persistence.*

@Entity
class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    @Column(unique = true)
    var email: String,
    @Column
    var password: String,
    @Column
    var name: String,
    @ManyToMany
    @JoinTable(name = "student_lecture")
    var lectures: MutableList<Lecture>? = mutableListOf()
)
