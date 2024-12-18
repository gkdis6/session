package org.gkdis6.session;

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
}