package kr.co.ku.lecture.controller

import kr.co.ku.lecture.controller.dto.request.LectureCreateRequest
import kr.co.ku.lecture.service.LectureService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class LectureController(private val service: LectureService) {
    @GetMapping("v1/lectures")
    fun getLectures(
        @RequestParam id: Long
    ) {
        service.findStudentWithLectures(id)
    }

    @PostMapping("v1/lectures")
    fun createLecture(request: LectureCreateRequest) {
        service.createLecture(request)
    }
}
