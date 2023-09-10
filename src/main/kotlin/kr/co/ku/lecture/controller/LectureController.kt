package kr.co.ku.lecture.controller

import kr.co.ku.common.const.STUDENT
import kr.co.ku.common.const.TEACHER
import kr.co.ku.common.const.X_KU_ID
import kr.co.ku.domain.entity.dto.LectureResult
import kr.co.ku.lecture.controller.dto.LectureCreateRequest
import kr.co.ku.lecture.controller.dto.request.LectureEnrollRequest
import kr.co.ku.lecture.service.LectureService
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
class LectureController(private val service: LectureService) {
    @GetMapping("v1/lectures/all")
    fun getLecturesAll(): List<LectureResult> {
        return service.findAll()
    }

    @GetMapping("v1/lectures")
    fun getLectures(
        @RequestHeader("ROLE") role: String,
        @RequestHeader(X_KU_ID) id: Long
    ): List<LectureResult> {
        return if (role == STUDENT) {
            service.findStudentWithLectures(id)
        } else {
            service.findTeacherWithLectures(id)
        }
    }

    @PostMapping("v1/lectures")
    fun createLecture(
        @RequestHeader("ROLE") role: String,
        @RequestHeader(X_KU_ID) id: Long,
        @RequestBody request: LectureCreateRequest
    ) {
        if (role == TEACHER) service.createLecture(teacherId = id, request.lectureName)
    }

    @PostMapping("v1/lectures/enroll")
    fun enrollLecture(
        @RequestHeader("ROLE") role: String,
        @RequestHeader(X_KU_ID) id: Long,
        @RequestBody
        request: LectureEnrollRequest
    ) {
        if (role == STUDENT) service.enrollLecture(studentId = id, lectureId = request.lectureId)
    }
}
