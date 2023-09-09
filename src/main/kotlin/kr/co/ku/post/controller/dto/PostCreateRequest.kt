package kr.co.ku.post.controller.dto

data class PostCreateRequest(
    var title: String,
    var text: String,
    var teacherId: Long,
    var lectureId: Long
)
