package org.gkdis6.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginCheck")
public class loginCheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String userId = request.getParameter("userID");
        String userPwd = request.getParameter("userPwd");

        out.println(userId);
        out.println(userPwd);

        HttpSession session = request.getSession();
        session.setAttribute("memberId", userId);

        // view 페이지로 응답해줌
        response.sendRedirect("loginOk.jsp");
    }
}