<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/_cs/_header.jsp"/>
<jsp:include page="./nav.jsp"/>
        <article class="cs_information">
                <p>
                <c:choose>
                	<c:when test="${kind eq 'service'}">
                		<strong>고객서비스</strong><br/>고객서비스 전체 내용입니다.
                	</c:when>
                	<c:when test="${kind eq 'safe'}">
                		<strong>안전거래</strong><br/>안전거래 전체 내용입니다.
                	</c:when>
                	<c:when test="${kind eq 'danger'}">
                		<strong>위해상품</strong><br/>위해상품 전체 내용입니다.
                	</c:when>
                	<c:when test="${kind eq 'event'}">
                		<strong>이벤트당첨</strong><br/>이벤트당첨 전체 내용입니다.
                	</c:when>
					<c:otherwise>
						<strong>전체</strong><br/>공지사항 전체 내용입니다.
					</c:otherwise>                
                </c:choose>
                </p>
                <div>
                    <table>
                    <c:if test="${articles.size() eq 0}">
                    	<tr>
                    		<td colspan="3" align="center">등록된 글이 없습니다.</td>
                    	</tr>
                    </c:if>
                    <c:forEach items="${articles}" var="article">
                        <tr>
                            <td colspan="2"><a href="/Kmarket/cs/notice/view.do?kind=${kind}&no=${article.no}&pg=${currentPage}">[${article.cate}] ${article.title}</a></td>
                            <td>${article.rdate}</td>
                        </tr>
                    </c:forEach>
                    </table>
                    <div class="page">
                        <c:if test="${pageGroupStart gt 1}">
                     		<a href="/Kmarket/cs/notice/list.do?group=${kind}&pg=${pageGroupStart-1}" class="prev">이전</a>
			        	</c:if>
                        <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}">
			            	<a href="/Kmarket/cs/notice/list.do?group=${kind}&pg=${num}" class="num ${currentPage eq num ? 'current' : 'off' }">${num}</a>
			            </c:forEach>
	                    <c:if test="${pageGroupEnd lt lastPageNum}">
	                    	 <a href="/Kmarket/cs/notice/list.do?group=${kind}&pg=${pageGroupEnd+1}" class="next">다음</a>
			            </c:if>
                    </div>
                </div>
        </article>
    </div>
</main>
<jsp:include page="/_cs/_footer.jsp"/>