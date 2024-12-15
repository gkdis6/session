package org.gkdis6.session;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/login")
    public String login(HttpSession session) {
        if (session.getAttribute("memberId") != null) {
            return "redirect:/loginOk";
        }
        return "login";
    }
}
