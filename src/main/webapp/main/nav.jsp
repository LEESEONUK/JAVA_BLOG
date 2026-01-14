<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light" id="mainNav">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="../index.jsp">Lee</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto py-4 py-lg-0">
                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="../blogs/get.do">블로그 목록</a></li>
                <c:choose>
                <c:when test="${logined ==null }">
                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="../members/create-form.jsp">등록</a></li>
                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="../members/login-form.jsp">로그인</a></li>
                </c:when>
                <c:otherwise>
                <!-- Controller를 호출 -> Reposi list.jsp -->

                    <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="../blogs/post-form.do">블로그작성</a></li>
                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="../members/list.do">목록조회</a></li>
                    <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="../members/detail.do">상세보기</a></li>
                    <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="../members/logout.do">로그아웃</a></li>
                </c:otherwise>
            </c:choose>
            </ul>
        </div>
    </div>
</nav>