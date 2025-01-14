package org.gkdis6.session.controller;

import lombok.RequiredArgsConstructor;
import org.gkdis6.session.jwt.TokenProvider;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final TokenProvider tokenProvider;

    @PostMapping("/login")
    public String login(@RequestParam String memberId,
                        @RequestParam String password) {
        // 여기서는 간단히 예시로 처리 (실제론 DB조회 + 비밀번호 암호화 검증 필요)
        if ("testuser".equals(memberId) && "1234".equals(password)) {
            // 인증 성공 시 토큰 발급
            return tokenProvider.createToken(memberId);
        } else {
            throw new RuntimeException("로그인 실패");
        }
    }

    // 토큰이 필요한 API 예시
    @GetMapping("/check")
    public String checkAuth() {
        return "인증된 사용자만 접근할 수 있습니다!";
    }
}