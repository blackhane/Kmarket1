<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/_cs/_header.jsp"/>
<jsp:include page="./nav.jsp"/>
<script>
	$(function(){
		$('ul').children('li.load:nth-child(n+4)').hide();
		
		$('.more').click(function(){
			if($(this).text() == '더보기'){
				$(this).parent().children('li:hidden').slideDown(200);
				$(this).text('간단히 보기');
			}else{
				$(this).parent().children('li.load').slice(3,10).slideUp(200);
				$(this).text('더보기');
			}
		});
	});
</script>
        <article class="cs_information">
                <p>
                    <strong>${group}</strong><br/>
                    가장 자주 묻는 질문입니다.
                </p>
                
                <c:forEach var="cate" items="${cate}">
               	<div class="question">
                    <p>${cate}</p>
                    <ul>
                    	<c:set var="i" value="1"/>
	                    <c:forEach items="${articles}" var="article">
	                    	<c:if test="${article.cate eq cate}">
	                    		<li class="load"><a href="/Kmarket/cs/faq/view.do?group=${article.group}&no=${article.no}"><span>Q. </span>${article.title}</a></li>
	                    		<c:set var="i" value="${i+1}"/>
	                    	</c:if>
	                    </c:forEach>
	                    <c:if test="${i gt 4}">
                    		<li class="more">더보기</li>
                    	</c:if>
                    </ul>
                </div>
                </c:forEach>
        </article>
    </div>
</main>
<jsp:include page="/_cs/_footer.jsp"/>