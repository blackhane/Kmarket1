<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/_admin/_header.jsp"/>

            <section id="admin-product-list">
                <nav>
                    <h3>상품목록</h3>
                    <p>
                        HOME > 상품관리 > <strong>상품목록</strong>
                    </p>
                </nav>
                <div>
                    <section class="search">
                        <select name="search" id="search">
                            <option value="search1">상품명</option>
                            <option value="search1">상품코드</option>
                            <option value="search1">제조사</option>
                            <option value="search1">판매자</option>
                        </select>
                        <input type="text" name="search">
                    </section>
                </div>
                <table>
                    <tbody>
                        <tr>
                            <th><input type="checkbox" name="all"></th>
                            <th>이미지</th>
                            <th>상품코드</th>
                            <th>상품명</th>
                            <th>판매가격</th>
                            <th>할인율</th>
                            <th>포인트</th>
                            <th>재고</th>
                            <th>판매자</th>
                            <th>조회</th>
                            <th>관리</th>
                        </tr>
                        <c:if test="${products eq null}">
	                        <tr>
	                        	<td colspan="11" align="center">등록된 상품이 없습니다.</td>
	                        </tr>
                        </c:if>
	                    <c:forEach var="item" items="${products}">
				            <tr>
				                <td><input type="checkbox" name="all"></td>
                           		<td><img src="/Kmarket/file/${item.thumb1}" class="thumb"></td>
	                            <td>${item.prodNo}</td>
	                            <td>${item.prodName}</td>
	                            <td>${item.price}</td>
	                            <td>${item.discount}</td>
	                            <td>${item.point}</td>
	                            <td>${item.stock}</td>
	                            <td>${item.seller}</td>
	                            <td>${item.hit}</td>
								<td>
	                                <a href="#">[삭제]</a>
	                                <a href="#">[수정]</a>
                          		</td>
				            </tr>
			            </c:forEach>
                    </tbody>
                </table>
                <input type="button" value="선택삭제">
                  <!-- 페이지 번호 -->
                <div class="paging">
                	<c:if test="${pageGroupStart gt 1}">
	                	<span class="prev">
	                        <a href="/Kmarket/admin/product/list.do?&company=${sessUser.company}&level=${sessUser.level}&pg=${pageGroupStart-1}">
	                            <&nbsp;이전</a>
	                    </span>
		        	</c:if>
                    <span class="num">
                        <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}">
			            	<a href="/Kmarket/admin/product/list.do?&company=${sessUser.company}&level=${sessUser.level}&pg=${num}" class="num ${currentPage eq num ? 'on' : 'off' }">${num}</a>
			            </c:forEach>
                    </span>
                    <c:if test="${pageGroupEnd lt lastPageNum}">
                   		<span class="next">
                        	<a href="/Kmarket/admin/product/list.do?list.do?&company=${sessUser.company}&level=${sessUser.level}&pg=${pageGroupEnd+1}">다음&nbsp;></a>
                    	</span>
		            </c:if>
                </div>
            </section>
            <div class="section_ico" >    
                <p class="ico info">
                    <strong>Tip!</strong>
                    전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
                </p>
            </div>
        </main>
<jsp:include page="/_admin/_footer.jsp"/>
        