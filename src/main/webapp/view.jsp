<%--
  Created by IntelliJ IDEA.
  User: ynnyh
  Date: 2022-11-22
  Time: 오후 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%= "뷰 페이지"%>
<br/>
<%
    String[] baseball = (String[]) request.getAttribute("baseball");
    for(String b : baseball)
        out.println(b + "<br/>");
%>
<c:forEach items="${baseball}" var="ball">
    ${ball}<br/>
</c:forEach>
</body>
</html>
