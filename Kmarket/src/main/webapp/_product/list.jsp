<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./_header.jsp"/>
<jsp:include page="./nagivation.jsp"/>
            <!-- 상단 목록 -->
            <section class="list">
                <nav>
                    <h1>상품목록</h1>
                    <p>HOME > <span>${cate.c1Name}</span> > <strong>${cate.c2Name}</strong></p>
                </nav>

                <!-- 메뉴 -->
                <ul class="sort">
                	<input type="hidden" name="ls" value="${ls}"/>
                    <li><a href="/Kmarket/product/list.do?cate1=${cate.cate1}&cate2=${cate.cate2}&ls=1" class="${ls eq '1' ? 'on' : 'off'} highSold">판매많은순</a></li>
                    <li><a href="/Kmarket/product/list.do?cate1=${cate.cate1}&cate2=${cate.cate2}&ls=2" class="${ls eq '2' ? 'on' : 'off'} lowPrice">낮은가격순</a></li>
                    <li><a href="/Kmarket/product/list.do?cate1=${cate.cate1}&cate2=${cate.cate2}&ls=3" class="${ls eq '3' ? 'on' : 'off'} highPrice">높은가격순</a></li>
                    <li><a href="/Kmarket/product/list.do?cate1=${cate.cate1}&cate2=${cate.cate2}&ls=4" class="${ls eq '4' ? 'on' : 'off'} highScore">평점높은순</a></li>
                    <li><a href="/Kmarket/product/list.do?cate1=${cate.cate1}&cate2=${cate.cate2}&ls=5" class="${ls eq '5' ? 'on' : 'off'} highReview">후기많은순</a></li>
                    <li><a href="/Kmarket/product/list.do?cate1=${cate.cate1}&cate2=${cate.cate2}&ls=6" class="${ls eq '6' ? 'on' : 'off'} latest">최근등록순</a></li>
                </ul>
                <!-- 상품목록 -->
                <table border="0">
                <c:forEach items="${product}" var="item">
                    <tr>
                        <td>
                            <a href="/Kmarket/product/view.do?cate1=${cate.cate1}&cate2=${cate.cate2}&prodNo=${item.prodNo}" class="thumb">
                            <img src="/Kmarket/${item.thumb1}" alt="thumb1"> </a>
                        </td>
                        <td>
                            <h3 class="name">${item.prodName}</h3>
                            <a href="/Kmarket/product/view.do?cate1=${cate.cate1}&cate2=${cate.cate2}&prodNo=${item.prodNo}" class="desc">${item.descript}</a>
                        </td>
                        <td>
                            <ul>
                                <li>
                                    <ins class="dis-price"><fmt:formatNumber type="number" pattern="#,###" value="${item.price - (item.price/item.discount)}"/></ins>
                                </li>
                                <li>
                                    <del class="org-price">${item.price}</del>
                                    <span class="discount">${item.discount}%</span>
                                </li>
                                <li>
                                    <c:if test="${item.delivery eq '0'}">
										<span class="free">무료배송</span>
									</c:if>
                                </li>
                            </ul>
                        </td>
                        <td>
                            <h4 class="seller"><i class="fas fa-home"></i>&nbsp;${item.seller}</h4>
                            <!-- ??? 무슨 등급임 -->
                            <h5 class="badge power">판매자등급</h5>
                            <c:choose>
                            	<c:when test="${item.score/item.review ge 5}">
                            		<h6 class="rating star5">상품평</h6>
                            	</c:when>
                            	<c:when test="${item.score/item.review ge 4}">
                            		<h6 class="rating star4">상품평</h6>
                            	</c:when>
                            	<c:when test="${item.score/item.review ge 3}">
                            		<h6 class="rating star3">상품평</h6>
                            	</c:when>
                            	<c:when test="${item.score/item.review ge 2}">
                            		<h6 class="rating star2">상품평</h6>
                            	</c:when>
                            	<c:when test="${item.score/item.review ge 1}">
                            		<h6 class="rating star1">상품평</h6>
                            	</c:when>
                            	<c:otherwise>
                            		<h6 class="rating star0">상품평</h6>
                            	</c:otherwise>
                            </c:choose>
                            
                        </td>
                    </tr>
                </c:forEach>
                </table>
                <!-- 페이지 번호 -->
                <div class="paging">
                    <span class="prev">
                        <a href="#">
                            <&nbsp;이전</a>
                    </span>
                    <span class="num">
                        <a href="#" class="on">1</a>
                        <a href="#">2</a>
                        <a href="#">3</a>
                        <a href="#">4</a>
                        <a href="#">5</a>
                        <a href="#">6</a>
                        <a href="#">7</a>
                    </span>
                    <span class="next">
                        <a href="#">다음&nbsp;></a>
                    </span>
                </div>
            </section>
        </main>
<jsp:include page="./_footer.jsp"/>