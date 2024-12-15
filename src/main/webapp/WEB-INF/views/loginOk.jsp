<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login OK </title>
</head>
<body>
<%
    session = request.getSession();
    out.print("member ID: "+ session.getAttribute("memberId") + "<br>");
%>
member ID: <%= session.getAttribute("memberId") %><br>

<form action="logoutCheck" method="post">
    <input type="submit" value="log out">
</form>

</body>
</html>