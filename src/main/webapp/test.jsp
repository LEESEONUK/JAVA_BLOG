<%@ page import="javax.servlet.annotation.WebServlet" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: ynnyh
  Date: 2022-11-08
  Time: 오전 1:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/test.jsp" method="post">
    <input name="userId" value="admin" /><br/>
    <input type="submit" value="send" />
</form>
<%
    @WebServlet(name = "MemberController")
    class MemberController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println(request.getParameter("userId"));
    }
}
%>
</body>
</html>
