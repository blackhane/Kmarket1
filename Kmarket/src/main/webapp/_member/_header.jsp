<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>케이마켓 고객센터</title>
    <link rel="stylesheet" href="/Kmarket/css/css_member.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script>
		let code = "${param.code}";
		console.log("code : " + code);
		
		//로그인 체크 실패
		if(code == 100){
			alert('존재하지 않는 회원입니다.\n아이디와 비밀번호를 확인해주세요.');
		}
		
		//회원가입 완료
		if(code == 101){
			alert('회원가입이 완료되었습니다.\n환영합니다.');
		}
	</script>
</head>
<body>
    <div id="wrapper">
        <header>
            <div class="info">
                <div>
                    <ul>
                      <c:choose>
                      	<c:when test="${empty sessUser.name}">
                      		<li><a href="/Kmarket/member/login.do">로그인</a></li>
                     		<li><a href="/Kmarket/member/join.do">회원가입</a></li>
                      	</c:when>
                      	<c:when test="${sessUser.name eq 'java1_team1'}">
                      		<li style="font-weight:bold;">${sessUser.name}님, 환영합니다.</li>
                      		<li><a href="/Kmarket/admin/index.do">관리자</a></li>
                     		<li><a href="/Kmarket/logout.do">로그아웃</a></li>
                      	</c:when>
                      	<c:otherwise>
                      		<li style="font-weight:bold;">${sessUser.name}님, 환영합니다.</li>
                      		<li><a href="/Kmarket/logout.do">로그아웃</a></li>
                      	</c:otherwise>
                      </c:choose>
                      <li><a href="#">마이페이지</a></li>
                      <li><a href="/Kmarket/product/cart.do">장바구니</a></li>
                    </ul>
                </div>
            </div>
            <div class="cs_logo">
                <div>
                    <a href="/Kmarket/">
                        <img src="/Kmarket/img/img_main/header_logo.png" alt="HeaderLogo">
                    </a>
                </div>
            </div>
        </header>