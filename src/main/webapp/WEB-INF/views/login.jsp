<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%--<%--%>
<%--    // session 객체에 memberId라는 session이 있으면,--%>
<%--    if(session.getAttribute("memberId") != null){--%>

<%--        // loginOk.jsp로 응답--%>
<%--        response.sendRedirect("loginOk.jsp");--%>
<%--    }--%>
<%--%>--%>
<form action="loginCheck" method="post">
    ID: <input type="text" name="userID"><br>
    Password: <input type="password" name="userPwd"><br>
    <input type="submit" value="login">
</form>
</body>
</html>