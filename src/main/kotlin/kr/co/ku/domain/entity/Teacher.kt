package kr.co.ku.domain.entity

import javax.persistence.*

@Entity
class Teacher(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column
    var email: String,

    @Column
    var password: String,

    @Column
    var name: String,

    @OneToMany(mappedBy = "teacher", cascade = [javax.persistence.CascadeType.ALL])
    var lectures: MutableList<Lecture>? = mutableListOf(),

)
