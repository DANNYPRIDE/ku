package kr.co.ku.domain.entity.dto

import java.time.LocalDateTime

data class PostResult(
    var id: Long,
    var title: String,
    var text: String,
    var teacherName: String,
    var createdAt: LocalDateTime,
    var updatedAt: LocalDateTime
)
