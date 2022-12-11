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
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/Kmarket/css/css_index.css">
    <link rel="stylesheet" href="/Kmarket/css/css_product.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- bxslider -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
	
</head>
<script>
  $(document).ready(function () {
    $(".slider > ul").bxSlider({
      easing: "linear",
      auto: true,
      autoHover: true,
      pager: true 
    });
  });
  
  $(function () {
    var best = $("aside > .best");

    $(window).scroll(function () {
      var t = $(this).scrollTop();

      if (t > 620) {
        best.css({
          position: "fixed",
          top: "0",
        });
      } else {
        best.css({ position: "static" });
      }
    });
  });
</script>
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
                        <li><a href="#hit">히트상품</a></li>
                        <li><a href="#recommend">추천상품</a></li>
                        <li><a href="#new">최신상품</a></li>
                        <li><a href="#">인기상품</a></li>
                        <li><a href="#discount">할인상품</a></li>
                    </ul>
                    <ul class="cs">
                        <li><a href="/Kmarket/cs/notice/list.do">공지사항</a></li>
                        <li><a href="/Kmarket/cs/faq/list.do">자주묻는질문</a></li>
                        <li><a href="/Kmarket/cs/qna/list.do">문의하기</a></li>
                        <li><a href="/Kmarket/cs/index.do">고객센터</a></li>
                    </ul>
                </nav>
            </div>
        </header>
        <main>
            <aside>
                <ul class="category">
                    <li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>
                    <li><a href="#"><i class="fas fa-tshirt"></i>패션의류·잡화·뷰티</a>
                        <ol>
                            <li><a href="/Kmarket/product/list.do?cate1=11&cate2=10">여성의류</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=11&cate2=11">남성의류</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=11&cate2=12">언더웨어</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=11&cate2=13">신발</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=11&cate2=14">가방/잡화</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=11&cate2=15">쥬얼리/시계</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=11&cate2=16">화장품/향수</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=11&cate2=17">바디/헤어</a></li>
                        </ol>
                    </li>
                    <li><a href="#"><i class="fas fa-child"></i>유아동</a>
                        <ol>
                            <li><a href="/Kmarket/product/list.do?cate1=12&cate2=10">출산/육아</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=12&cate2=11">장난감/완구</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=12&cate2=12">유아동 의류</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=12&cate2=13">유아동 신발/잡화</a></li>
                        </ol>
                    </li>
                    <li><a href="#"><i class="fas fa-utensils"></i>식품·생필품</a>
                        <ol>
                            <li><a href="/Kmarket/product/list.do?cate1=13&cate2=10">신선식품</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=13&cate2=11">가공식품</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=13&cate2=12">건강식품</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=13&cate2=13">커피/음료</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=13&cate2=14">생필품</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=13&cate2=15">바디/헤어</a></li>
                        </ol>
                    </li>
                    <li><a href="#"><i class="fas fa-home"></i>홈데코·문구·취미·반려</a>
                        <ol>
                            <li><a href="/Kmarket/product/list.do?cate1=14&cate2=10">가구/DIY</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=14&cate2=11">침구·커튼</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=14&cate2=12">조명/인테리어</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=14&cate2=13">생활용품</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=14&cate2=14">주방용품</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=14&cate2=15">문구/사무용품</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=14&cate2=16">사무기기</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=14&cate2=17">악기/취미</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=14&cate2=18">반려동물용품</a></li>
                        </ol>
                    </li>
                    <li><a href="#"><i class="fas fa-laptop"></i>컴퓨터·디지털·가전</a>
                        <ol>
                            <li><a href="/Kmarket/product/list.do?cate1=15&cate2=10">노트북/PC</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=15&cate2=11">모니터/프린터</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=15&cate2=12">PC주변기기</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=15&cate2=13">모바일/태블릿</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=15&cate2=14">카메라</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=15&cate2=15">게임</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=15&cate2=16">영상가전</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=15&cate2=17">주방가전</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=15&cate2=18">계절가전</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=15&cate2=19">생활/미용가전</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=15&cate2=20">음향가전</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=15&cate2=21">건강가전</a></li>
                        </ol>
                    </li>
                    <li><a href="#"><i class="fas fa-dumbbell"></i>스포츠·건강·렌탈</a>
                        <ol>
                            <li><a href="/Kmarket/product/list.do?cate1=16&cate2=10">스포츠의류/운동화</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=16&cate2=11">휘트니스/수영</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=16&cate2=12">구기/라켓</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=16&cate2=13">골프</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=16&cate2=14">자전거/보드/기타레저</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=16&cate2=15">캠핑/낚시</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=16&cate2=16">등산/아웃도어</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=16&cate2=17">건강/의료용품</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=16&cate2=18">건강식품</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=16&cate2=19">렌탈서비스</a></li>
                        </ol>
                    </li>
                    <li><a href="#"><i class="fas fa-car"></i>자동차·공구</a>
                        <ol>
                            <li><a href="/Kmarket/product/list.do?cate1=17&cate2=10">스포츠의류/운동화</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=17&cate2=11">휘트니스/수영</a></li>
                        </ol>
                    </li>
                    <li><a href="#"><i class="fas fa-plane"></i>여행·도서·티켓·e쿠폰</a>
                        <ol>
                            <li><a href="/Kmarket/product/list.do?cate1=18&cate2=10">여행/항공권</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=18&cate2=11">도서/음반/e교육</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=18&cate2=12">공연티켓</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=18&cate2=13">e쿠폰</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=18&cate2=14">상품권</a></li>
                        </ol>
                    </li>
                </ul>
                <!-- 베스트 상품 -->
                <article class="best">
                    <h1><i class="fas fa-crown"> <span>베스트 상품</span></i></h1>
                    <ol>
                    <c:set var="i" value="1"/>
					<c:forEach items="${best}" var="item">
						<li>
						    <a href="/Kmarket/product/view.do?cate1=${item.cate1}&cate2=${item.cate2}&prodNo=${item.prodNo}">
						        <div class="thumb">
						            <i>${i}</i>
						            <img style="width:100%;" src="/Kmarket/${item.thumb2}" alt="thumb2" class="best_thumb2">
						        </div>
						        <h2>${item.prodName}</h2>
						        <div class="org_price">
						            <del>${item.price}원</del>
						            <span>${item.discount}%</span>
						        </div>
						        <div class="dis_price">
						            <ins><fmt:formatNumber type="number" pattern="#,###" value="${item.price - (item.price/item.discount)}"/>원</ins>
						        </div>
						    </a>
						</li>
					 <c:set var="i" value="i+1"/>
					 </c:forEach>
                    </ol>
                </article>
            </aside>
            <section class="content">
            <!-- 슬라이더 영역 -->
            <section class="slider">
                    <ul>
                        <li>
                            <a href="#">
                                <img src="/Kmarket/img/img_main/slider_item1.jpg" alt="item1">
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <img src="/Kmarket/img/img_main/slider_item2.jpg" alt="item2">
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <img src="/Kmarket/img/img_main/slider_item3.jpg" alt="item3">
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <img src="/Kmarket/img/img_main/slider_item4.jpg" alt="item4">
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <img src="/Kmarket/img/img_main/slider_item5.jpg" alt="item5">
                            </a>
                        </li>
                    </ul>
                </section>
            <!-- 히트상품영역 -->
			<section class="hit" id="hit">
				<h3><span>히트상품</span></h3>
				<article>
					<c:forEach items="${hit}" var="item">
						<a href="/Kmarket/product/view.do?cate1=${item.cate1}&cate2=${item.cate2}&prodNo=${item.prodNo}">
							<div class="thumb"><img src="/Kmarket/${item.thumb2}" alt="thumb2" /></div>
							<h2>${item.prodName}</h2>
							<p>${item.descript}</p>
							<div class="org_price">
								<del>${item.price}원</del>
								<span>${item.discount}%</span>
							</div>
							<div class="dis_price">
								<ins><fmt:formatNumber type="number" pattern="#,###" value="${item.price - (item.price/item.discount)}"/>원</ins>
								<c:if test="${item.delivery eq '0'}">
									<span class="free">무료배송</span>
								</c:if>
							</div>
						</a>
					</c:forEach>
				</article>
			</section>
			<section class="recommend" id="recommend">
				<h3><span>추천상품</span></h3>
				<article>
					<c:forEach items="${recommend}" var="item">
						<a href="/Kmarket/product/view.do?cate1=${item.cate1}&cate2=${item.cate2}&prodNo=${item.prodNo}">
							<div class="thumb"><img src="/Kmarket/${item.thumb2}" alt="thumb2" /></div>
							<h2>${item.prodName}</h2>
							<p>${item.descript}</p>
							<div class="org_price">
								<del>${item.price}원</del>
								<span>${item.discount}%</span>
							</div>
							<div class="dis_price">
								<ins><fmt:formatNumber type="number" pattern="#,###" value="${item.price - (item.price/item.discount)}"/>원</ins>
								<c:if test="${item.delivery eq '0'}">
									<span class="free">무료배송</span>
								</c:if>
							</div>
						</a>
					</c:forEach>
				</article>
			</section>
			<section class="new" id="new">
				<h3><span>최신상품</span></h3>
				<article>
					<c:forEach items="${newItem}" var="item">
						<a href="/Kmarket/product/view.do?cate1=${item.cate1}&cate2=${item.cate2}&prodNo=${item.prodNo}">
							<div class="thumb"><img src="/Kmarket/${item.thumb2}" alt="thumb2" /></div>
							<h2>${item.prodName}</h2>
							<p>${item.descript}</p>
							<div class="org_price">
								<del>${item.price}원</del>
								<span>${item.discount}%</span>
							</div>
							<div class="dis_price">
								<ins><fmt:formatNumber type="number" pattern="#,###" value="${item.price - (item.price/item.discount)}"/>원</ins>
								<c:if test="${item.delivery eq 0}">
									<span class="free">무료배송</span>
								</c:if>
							</div>
						</a>
					</c:forEach>
				</article>
			</section>
			<section class="discount" id="discount">
				<h3><span>할인상품</span></h3>
				<article>
					<c:forEach items="${discount}" var="item">
						<a href="/Kmarket/product/view.do?cate1=${item.cate1}&cate2=${item.cate2}&prodNo=${item.prodNo}">
							<div class="thumb"><img src="/Kmarket/${item.thumb2}" alt="thumb2" /></div>
							<h2>${item.prodName}</h2>
							<p>${item.descript}</p>
							<div class="org_price">
								<del>${item.price}원</del>
								<span>${item.discount}%</span>
							</div>
							<div class="dis_price">
								<ins><fmt:formatNumber type="number" pattern="#,###" value="${item.price - (item.price/item.discount)}"/>원</ins>
								<c:if test="${item.delivery eq 0}">
									<span class="free">무료배송</span>
								</c:if>
							</div>
						</a>
					</c:forEach>
				</article>
			</section>
		</section>
        </main>
        <footer>
            <div>
                <ul>
                    <li><a href="#">회사소개</a></li>
                    <li><a href="#">서비스이용약관</a></li>
                    <li><a href="#">개인정보처리방침</a></li>
                    <li><a href="#">전자금융거래약관</a></li>
                </ul>
            </div>
            <div>
                <p>
                    <img src="/Kmarket/img/img_main/footer_logo.png" alt="footerLogo">
                </p>
                <p>
                    <strong>(주)KMARKET</strong><br/>
                    부산시 강남구 테헤란로 152 (역삼동 강남파이낸스센터)<br/>
                    대표이사 : 홍길동<br/>
                    사업자등록번호 : 220-81-83676 사업자정보확인<br/>
                    통신판매업신고 : 강남 10630호 Fax : 02-589-8842
                </p>
                <p>
                    <strong>고객센터</strong><br/>
                    Tel : 1234-5678 (평일 09:00~18:00)<br/>
                    스마일클럽/SVIP 전용 : 1522-5700 (365일 09:00~18:00)<br/>
                    경기도 부천시 원미구 부일로 233(상동) 투나빌딩 6층<br/>
                    Fax : 051-123-4567 | Mail : kmaerket@kmarket.co.kr<br/>
                </p>
            </div>
        </footer>
    </div>
</body>
</html>