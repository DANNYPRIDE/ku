package kr.co.ku.lecture.controller

import kr.co.ku.lecture.controller.dto.request.LectureCreateRequest
import kr.co.ku.lecture.service.LectureService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LectureController(private val service: LectureService) {
    @PostMapping("lecture")
    fun createLecture(request: LectureCreateRequest) {
        service.createLecture(request)
    }
}
