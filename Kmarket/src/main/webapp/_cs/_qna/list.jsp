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
			location.href = "/Kmarket/cs/qna/write.do";
		});
	});
</script>
        <article class="cs_information">
                <p>
                    <strong>회원</strong><br/>
                    회원관련 문의 내용입니다.
                </p>
                <div>
                    <table>
                    	<c:forEach var="article" items="${articles}">
                        <tr>
                            <td><a href="/Kmarket/cs/qna/view.do?no=${article.no}">[${article.cate}] ${article.title}</a></td>
                            <td>${article.comment eq 0 ? "검토중" : "답변완료"}</td>
                            <td>${article.uid}</td> 
                            <td>${article.rdate}</td>
                        </tr>
                        </c:forEach>
                    </table>
                    <div class="page">
                        <a href="#">이전</a>
                        <a href="#" class="current">1</a>
                        <a href="#">2</a>
                        <a href="#">3</a>
                        <a href="#">다음</a>
                    </div>
                    <button type="button" class="btnInquiry">문의하기</button>
                </div>
        </article>
    </div>
</main>
<jsp:include page="/_cs/_footer.jsp"/>