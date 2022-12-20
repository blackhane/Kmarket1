<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/_cs/_header.jsp"/>
<jsp:include page="./nav.jsp"/>
<script>
	$(function(){
		$('.btnInquiry').click(function(){
			let uid = "${sessUser.uid}"
			if(uid == ''){
				alert('로그인 후 이용할 수 있습니다.');
				return;
			}
			location.href = "/Kmarket/cs/qna/write.do?group=${group}";
		});
	});
</script>
        <article class="cs_information">
                <p>
                    <strong>${group}</strong><br/>
                    ${group} 관련 문의 내용입니다.
                </p>
                <div>
                    <table>
                    	<c:if test="${articles.size() eq '0'}">
                    	<tr>
                    		<td colspan="4" align="center">등록된 게시물이 없습니다.</td>
                    	</tr>
                    	</c:if>
                    	<c:forEach var="article" items="${articles}">
                        <tr>
                            <td><a href="/Kmarket/cs/qna/view.do?group=${group}&no=${article.no}">[${article.cate}] ${article.title}</a></td>
                            <td>${article.comment eq 0 ? "검토중" : "답변완료"}</td>
                            <td>${article.uid}</td> 
                            <td>${article.rdate}</td>
                        </tr>
                        </c:forEach>
                    </table>
                    <div class="page">
	                    <c:if test="${pageGroupStart gt 1}">
                     		<a href="/Kmarket/cs/qna/list.do?group=${group}&pg=${pageGroupStart-1}" class="prev">이전</a>
			        	</c:if>
                        <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}">
			            	<a href="/Kmarket/cs/qna/list.do?group=${group}&pg=${num}" class="num ${currentPage eq num ? 'current' : 'off' }">${num}</a>
			            </c:forEach>
	                    <c:if test="${pageGroupEnd lt lastPageNum}">
	                    	 <a href="/Kmarket/cs/qna/list.do?group=${group}&pg=${pageGroupEnd+1}" class="next">다음</a>
			            </c:if>
                    </div>
                    <button type="button" class="btnInquiry">문의하기</button>
                </div>
        </article>
    </div>
</main>
<jsp:include page="/_cs/_footer.jsp"/>