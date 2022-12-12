<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kmarket</title>
    <link rel="stylesheet" href="/Kmarket/css/css_admin.css">
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<script>
    /* 제이쿼리 시작 */
    $(function(){

        $('#gnb > li > a').click(function(){
            $(this).siblings().slideToggle(300);
        })

    /* 제이쿼리 끝 */
    })
</script>
<body>
    <div id="admin-wrapper">
        <header>
            <div>
                <a href="index.do" class="logo">
                    <img src="/Kmarket/img/img_admin/admin_logo.png" alt="로고">
                </a>
                <p>
                    <span>홍길동님 반갑습니다. &nbsp;&nbsp; </span>
                    <a href="#">HOME |</a>
                    <a href="#">로그아웃 |</a>
                    <a href="#">고객센터</a>
                </p>
            </div>
        </header>
        <main>
            <aside>
                <ul id="gnb">
                    <li>
                        <a href="#">
                            <i class="fa fa-cogs" aria-hidden="true"></i>
                            환경설정
                        </a>
                        <ol>
                            <li><a href="#">기본환경설정</a></li>
                            <li><a href="#">배너관리</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fas fa-store" aria-hidden="true"></i>
                            상점관리
                        </a>
                        <ol>
                            <li><a href="#">판매자현황</a></li>
                            <li><a href="/Kmarket/_admin/_product/list.html">재고관리</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-users" aria-hidden="true"></i>
                            회원관리
                        </a>
                        <ol>
                            <li><a href="#">회원현황</a></li>
                            <li><a href="#">포인트관리</a></li>
                            <li><a href="#">비회원관리</a></li>
                            <li><a href="#">접속자집계</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fas fa-box-open" aria-hidden="true"></i>
                            상품관리
                        </a>
                        <ol>
                            <li><a href="/Kmarket/_admin/_product/list.html">상품현황</a></li>
                            <li><a href="/Kmarket/_admin/_product/register.html">상품등록</a></li>
                            <li><a href="/Kmarket/_admin/_product/list.html">재고관리</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-credit-card" aria-hidden="true"></i>
                            주문관리
                        </a>
                        <ol>
                            <li><a href="#">주문현황</a></li>
                            <li><a href="#">매출현황</a></li>
                            <li><a href="#">결제관리</a></li>
                            <li><a href="#">배송관리</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                            게시판관리
                        </a>
                        <ol>
                            <li><a href="#">게시판 현황</a></li>
                            <li><a href="#">고객문의</a></li>
                        </ol>
                    </li>
                </ul>
            </aside>