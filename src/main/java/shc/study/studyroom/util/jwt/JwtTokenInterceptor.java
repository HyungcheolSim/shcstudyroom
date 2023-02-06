/*
package shc.study.studyroom.util.jwt;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;
import shc.study.studyroom.util.security.AuthConstants;

import java.io.IOException;

@Log4j2
public class JwtTokenInterceptor implements HandlerInterceptor {
    // 토큰을 검증하도록 설정한 API에 대해 요청을 intercept하여 토큰의
    // 유효성 검사를 진행한다.
    // 유효성 검사에 실패하면 예외 API로 redirect를 시키고 있다.
    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws IOException {
        final String header = request.getHeader(AuthConstants.AUTH_HEADER);

        if (header != null) {
            final String token = TokenUtils.getTokenFromHeader(header);
            if (TokenUtils.isValidToken(token)) {
                return true;
            }
        }
        response.sendRedirect("/error/unauthorized");
        return false;
    }
}
*/
