<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>케이마켓</title>
    <link rel="stylesheet" href="/Kmarket/css/css_product.css">
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
	   $( document ).ready( function() {
	     $( window ).scroll( function() {
	       if ( $( this ).scrollTop() > 200 ) {
	         $( '#top' ).fadeIn();
	       } else {
	         $( '#top' ).fadeOut();
	       }
	     } );
	     $( '#top' ).click( function() {
	       $( 'html, body' ).animate( { scrollTop : 0 }, 400 );
	       return false;
	     } );
	   } );
    </script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <div id="wrapper">
        <header>
            <div class="info">
                <div>
                    <ul>
                      <c:choose>
                      	<c:when test="${not empty sessUser.uid}">
                      		<li style="font-weight:bold;">${sessUser.name}${sessUser.company}님, 환영합니다.</li>
                      		<li><a href="/Kmarket/logout.do?uid=${sessUser.uid}">로그아웃</a></li>
                      		<c:if test="${sessUser.level ge 5}">	                      		
	                      		<li><a href="/Kmarket/admin/index.do">관리자</a></li>	                     		
	                      	</c:if>
	                  		<li><a href="#">마이페이지</a></li>
                      	</c:when>
                      	<c:otherwise>
                      		<li><a href="/Kmarket/member/login.do">로그인</a></li>
                     		<li><a href="/Kmarket/member/join.do">회원가입</a></li>
                      	</c:otherwise>
                      </c:choose>
	                  <li><a href="/Kmarket/product/cart.do?uid=${sessUser.uid}">장바구니</a></li>
                    </ul>
                </div>
            </div>
            <div class="search">
                <div>
                    <a href="/Kmarket/"><img src="/Kmarket/img/img_main/header_logo.png" alt="headerLogo"></a>
                    <form action="#">
                        <input type="search">
                        <button><span class="material-symbols-outlined">search</span></button>
                    </form>
                </div>    
            </div>
            <div class="menu">
                <nav>
                    <ul class="hitProduct">
                        <li><a href="/Kmarket/#hit">히트상품</a></li>
                        <li><a href="/Kmarket/#recommend">추천상품</a></li>
                        <li><a href="/Kmarket/#new">최신상품</a></li>
                        <li><a href="/Kmarket/#">인기상품</a></li>
                        <li><a href="/Kmarket/#discount">할인상품</a></li>
                    </ul>
                    <ul class="cs">
                        <li><a href="#">쿠폰존</a></li>
                        <li><a href="#">사용후기</a></li>
                        <li><a href="#">개인결제</a></li>
                        <li><a href="/Kmarket/cs/index.do">고객센터</a></li>
                        <li><a href="#">FAQ</a></li>
                    </ul>
                </nav>
            </div>
        </header>