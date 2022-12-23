<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/_cs/_header.jsp"/>
<jsp:include page="./nav.jsp"/>
        <article class="cs_information">
        	<p>
                    <strong>${group}</strong><br/>
                    ${group} 관련 문의 내용입니다.
            </p>
            <div class="title">
                <h2>[${article.cate}] ${article.title}</h2>
                <span>${article.uid} ${article.rdate}</span>
            </div>
            <div class="content">
                <p>
                	<br/>
                	${article.content}
                	<br/><br/>
                	<c:if test="${comment.content ne null}">
                		<hr/>
                		<div class=comment>
                			[답변] ${article.title}
          				<br/><br/>
          				<p>${comment.content}</p>
          				</div>
                	</c:if>
                </p>
                <a href="/Kmarket/cs/qna/list.do?group=${article.group}&pg=${pg}" class="btn btnList">목록보기</a>
            </div>
        </article>
    </div>
</main>
<jsp:include page="/_cs/_footer.jsp"/>