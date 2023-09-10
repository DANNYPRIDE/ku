// package kr.co.ku.common.filter
//
// import kr.co.ku.common.const.X_KU_SESSION
// import kr.co.ku.domain.repository.SessionRepository
// import org.slf4j.LoggerFactory
// import org.springframework.stereotype.Component
// import org.springframework.web.filter.OncePerRequestFilter
// import java.time.LocalDateTime
// import javax.servlet.FilterChain
// import javax.servlet.http.HttpServletRequest
// import javax.servlet.http.HttpServletResponse
//
// @Component
// class CookieFilter(private val sessionRepository: SessionRepository) : OncePerRequestFilter() {
//    companion object {
//        val logger = LoggerFactory.getLogger(CookieFilter.javaClass)
//    }
//
//    override fun shouldNotFilter(request: HttpServletRequest): Boolean {
//        val uri = request.requestURI
//        return uri in listOf("/login", "/signup")
//    }
//
//    override fun doFilterInternal(
//        request: HttpServletRequest,
//        response: HttpServletResponse,
//        filterChain: FilterChain
//    ) {
//        val sessionId = request.getHeader(X_KU_SESSION)
//        val role = request.getHeader("ROLE")
//        val session = sessionRepository.findById(sessionId) ?: throw RuntimeException("cookie")
//        if (session.expiresAt.isBefore(LocalDateTime.now())) throw RuntimeException("expired")
//        if (session.role != role) throw RuntimeException("cookie")
//        return filterChain.doFilter(request, response)
//    }
// }
