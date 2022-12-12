<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>케이마켓 고객센터</title>
    <link rel="stylesheet" href="/Kmarket/css/css_cs.css">
</head>
<body>
    <div id="wrapper">
        <header>
            <div class="info">
                <div>
                    <ul>
                      <c:choose>
                      	<c:when test="${not empty sessUser.uid}">
                      		<li style="font-weight:bold;">${sessUser.uid}님, 환영합니다.</li>
                      		<li><a href="/Kmarket/logout.do?uid=${sessUser.uid}">로그아웃</a></li>
                      		<c:if test="${sessUser.name eq '관리자'}">	                      		
	                      		<li><a href="/Kmarket/admin/index.do">관리자</a></li>	                     		
	                      	</c:if>
                      	</c:when>
                      	<c:otherwise>
                      		<li><a href="/Kmarket/member/login.do">로그인</a></li>
                     		<li><a href="/Kmarket/member/join.do">회원가입</a></li>
                      	</c:otherwise>
                      </c:choose>
	                  <li><a href="#">마이페이지</a></li>
	                  <li><a href="/Kmarket/product/cart.do?uid=${sessUser.uid}">장바구니</a></li>
                    </ul>
                </div>
            </div>
            <div class="cs_logo">
                <div>
                    <a href="/Kmarket/cs/index.do">
                        <img src="/Kmarket/img/img_cs/logo.png" alt="고객센터">
                        고객센터
                    </a>
                </div>
            </div>
        </header>