<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/_cs/_header.jsp"/>
<jsp:include page="./nav.jsp"/>
<style>
	li.load {display:none;}
</style>
<script>
	$(function(){
		$('li:hidden').slice(0,3).show();
		$('.more').click(function(e){
			e.preventDefault();
			txt = $(this).text();
			console.log(txt);
			if(txt == '더보기'){
				$(this).text() = "간단히 보기";
				$('li:hidden').slice(0,7).show();
			}
			if(txt == "간단히 보기"){
				$(this).text() = "더보기";
				$('li:hidden').slice(0,7).hide();
			}
			
		});
	});
</script>
        <article class="cs_information">
                <p>
                    <strong>회원</strong><br/>
                    가장 자주 묻는 질문입니다.
                </p>
                <div class="question">
                    <p>가입</p>
                    <ul>
                    <c:forEach items="${articles1}" var="article">
                        <li class="load"><a href="/Kmarket/cs/faq/view.do?no=${article.no}"><span>Q. </span>${article.title}</a></li>
                    </c:forEach>
                    <c:if test="${articles1.size() gt 3}">
                        <li class="more">더보기</li>
                    </c:if>
                    </ul>
                </div>
                <div class="question">
                    <p>탈퇴</p>
                    <ul>
                    <c:forEach items="${articles2}" var="article">
                        <li class="load"><a href="/Kmarket/cs/faq/view.do?no=${article.no}"><span>Q. </span>${article.title}</a></li>
                    </c:forEach>
                    <c:if test="${articles2.size() gt 3}">
                        <li class="more">더보기</li>
                    </c:if>
                    </ul>
                </div>
                <div class="question">
                    <p>회원정보</p>
                    <ul>
                    <c:forEach items="${articles3}" var="article">
                        <li class="load"><a href="/Kmarket/cs/faq/view.do?no=${article.no}"><span>Q. </span>${article.title}</a></li>
                    </c:forEach>
                    <c:if test="${articles3.size() gt 3}">
                        <li class="more">더보기</li>
                    </c:if>
                    </ul>
                </div>
                <div class="question">
                    <p>로그인</p>
                    <ul>
                    <c:forEach items="${articles4}" var="article">
                        <li class="load"><a href="/Kmarket/cs/faq/view.do?no=${article.no}"><span>Q. </span>${article.title}</a></li>
                    </c:forEach>
                    <c:if test="${articles4.size() gt 3}">
                        <li class="more">더보기</li>
                    </c:if>
                    </ul>
                </div>
        </article>
    </div>
</main>
<jsp:include page="/_cs/_footer.jsp"/>