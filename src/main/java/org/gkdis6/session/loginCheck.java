package org.gkdis6.session;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
public class loginCheck {
    @PostMapping("/loginCheck")
    protected String doPost(@RequestParam String userID,
                          @RequestParam String userPwd,
                          HttpSession session){
        return doGet(userID, userPwd, session);
    }

    @GetMapping("/loginCheck")
    protected String doGet(@RequestParam String userID,
                           @RequestParam String userPwd,
                           HttpSession session){

        session.setAttribute("memberId", userID);
        session.setAttribute("memberPwd", userPwd);
//        session.setMaxInactiveInterval(3);

        return "loginOk";
    }

    @GetMapping("/loginOk")
    public String showLoginOkPage() {
        return "loginOk"; // loginOk.jsp
    }

    @GetMapping("/reLogin")
    protected String doReLogin(HttpServletRequest request) {
        // 현재 세션 무효화
        HttpSession session = request.getSession(false); // 현재 세션 가져오기
        if (session != null) {
            session.invalidate(); // 세션 무효화
        }

        // 새로운 세션 생성
        session = request.getSession(true);

        // 필요한 경우 새 세션에 속성 설정 가능
        session.setAttribute("isNew", true);
        session.setAttribute("memberId", "new");

        // 로그인 페이지로 이동
        return "loginOk"; // View 이름 반환
    }
}