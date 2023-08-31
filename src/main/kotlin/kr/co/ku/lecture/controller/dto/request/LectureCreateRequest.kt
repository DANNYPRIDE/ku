package kr.co.ku.lecture.controller.dto.request

data class LectureCreateRequest(
    val teacherId: Long,
    val name: String,
)
