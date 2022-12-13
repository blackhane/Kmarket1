<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main id="product">
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
    </aside>