<%@ page import="javax.servlet.annotation.WebServlet" %><%--
  Created by IntelliJ IDEA.
  User: ynnyh
  Date: 2022-11-01
  Time: 오후 4:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- HTML 주석: Tomcat에서 처리하고, 웹브라우저에서 처리 안 함 -->
    <%-- JSP 주석 : Tomcat에서 처리 안함 --%>
    <%-- Scriptlet : JSP 문서를 구성하는 스크립팅 요소(scriptlet, expression, declaration) 중의 하나
    Java 문법을 기준으로 JSP 기본 객체를 사용하여 프로그래밍 할 수 있다.
    --%>
    <%
        String[] teams = {
                "삼성라이온즈", "두산베이스", "기아타이거즈", "SSG랜더스", "키움히어로즈"
        };
        for(int i = 0; i < teams.length; i++)
            out.println(teams[i] + "<br/>");
        //enhanced loop statement, enhanced for statement : sequential access
        for(String team : teams)
            out.println(teams[i] + "<br/>");
        System.out.println("LG트윈스");



    %>
    @WebServlet(name = "FormController", value = "/controllers")
</head>
<body>

</body>
</html>
