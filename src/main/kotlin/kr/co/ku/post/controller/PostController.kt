package kr.co.ku.post.controller

import kr.co.ku.common.const.TEACHER
import kr.co.ku.common.const.X_KU_ID
import kr.co.ku.domain.entity.dto.PostResult
import kr.co.ku.post.controller.dto.PostCreateRequest
import kr.co.ku.post.service.PostService
import org.springframework.web.bind.annotation.*

@RestController
class PostController(private val service: PostService) {
    @GetMapping("/api/v1/post")
    fun getPosts(
        @RequestHeader("ROLE") role: String,
        @RequestHeader(X_KU_ID) id: Long
    ): List<PostResult> {
        return if (role == TEACHER) {
            service.findPostsWithTeacher(id)
        } else {
            service.findPostsWithStudent(id)
        }
    }

    @PostMapping("/api/v1/post")
    fun createPost(
        @RequestHeader("ROLE") role: String,
        @RequestHeader(X_KU_ID) id: Long,
        @RequestBody request: PostCreateRequest
    ) {
        return service.createPost(request)
    }
}
