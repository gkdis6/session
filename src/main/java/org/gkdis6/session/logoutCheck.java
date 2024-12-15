package org.gkdis6.session;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class logoutCheck{
    @PostMapping("/logoutCheck")
    protected String doPost(HttpSession session)  {
        return doGet(session);
    }

    @GetMapping("/logoutCheck")
    protected String doGet(HttpSession session) {
        // 해당 session을 날려버림
        session.invalidate();

        return "login";
    }
}