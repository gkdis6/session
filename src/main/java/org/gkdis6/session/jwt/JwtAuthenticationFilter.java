package org.gkdis6.session.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final TokenProvider tokenProvider;

    public JwtAuthenticationFilter(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        // 1) 헤더에서 토큰 추출
        String token = resolveToken(request);

        // 2) 토큰 유효성 검사
        if (token != null && tokenProvider.validateToken(token)) {
            String memberId = tokenProvider.getMemberId(token);

            // (선택) SecurityContext에 인증 정보 세팅
            // 시큐리티를 사용하는 경우 Authentication 객체를 생성하여 세팅 가능
            // 예:
            // UsernamePasswordAuthenticationToken auth =
            //    new UsernamePasswordAuthenticationToken(memberId, null, new ArrayList<>());
            // SecurityContextHolder.getContext().setAuthentication(auth);
        }

        // 다음 필터로 진행
        filterChain.doFilter(request, response);
    }

    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        // 보통 'Bearer 토큰값' 형태이므로, 파싱
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // "Bearer " 제거
        }
        return null;
    }
}