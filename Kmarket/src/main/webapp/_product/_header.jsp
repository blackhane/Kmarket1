<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>케이마켓</title>
    <link rel="stylesheet" href="/Kmarket/css/css_product.css">
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
</head>

<body>
    <div id="wrapper">
        <header>
            <div class="info">
                <div>
                    <ul>
                      <li><a href="/Kmarket/_member/login.html">로그인</a></li>
                      <li><a href="/Kmarket/_member/signup.html">회원가입</a></li>
                      <li><a href="/Kmarket/_admin/index.html">마이페이지</a></li>
                      <li><a href="/Kmarket/_product/cart.html">장바구니</a></li>
                    </ul>
                </div>
            </div>
            <div class="search">
                <div>
                    <a href="/Kmarket/index.html"><img src="/Kmarket/img/img_main/header_logo.png" alt="headerLogo"></a>
                    <form action="#">
                        <input type="search">
                        <button><span class="material-symbols-outlined">search</span></button>
                    </form>
                </div>    
            </div>
            <div class="menu">
                <nav>
                    <ul class="hitProduct">
                        <li><a href="/Kmarket/_product/list.html">히트상품</a></li>
                        <li><a href="/Kmarket/_product/list.html">추천상품</a></li>
                        <li><a href="/Kmarket/_product/list.html">최신상품</a></li>
                        <li><a href="/Kmarket/_product/list.html">인기상품</a></li>
                        <li><a href="/Kmarket/_product/list.html">할인상품</a></li>
                    </ul>
                    <ul class="cs">
                        <li><a href="#">쿠폰존</a></li>
                        <li><a href="#">사용후기</a></li>
                        <li><a href="#">개인결제</a></li>
                        <li><a href="#">고객센터</a></li>
                        <li><a href="#">FAQ</a></li>
                    </ul>
                </nav>
            </div>
        </header>