<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/_cs/_header.jsp"/>
<jsp:include page="./nav.jsp"/>
<script>
	$(function(){
		$('.btnInquiry').click(function(){
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
                            <td><a href="/Kmarket/cs/qna/view.do">[${article.cate}] ${article.title}</a></td>
                            <td>${article.uid}</td> 
                            <td>${article.rdate.substring(2, 10)}</td>
                        </tr>
                        </c:forEach>
                        <tr>
                            <td><a href="#">[탈퇴] 탈퇴 문의내용</a></td>
                            <td>******</td>
                            <td>2022-12-06</td>
                        </tr>
                        <tr>
                            <td><a href="#">[회원정보] 회원정보 문의내용</a></td>
                            <td>******</td>
                            <td>2022-12-06</td>
                        </tr>
                        <tr>
                            <td><a href="#">[로그인] 회원정보 문의내용</a></td>
                            <td>******</td>
                            <td>2022-12-06</td>
                        </tr>
                        <tr>
                            <td><a href="#">[로그인] 회원정보 문의내용</a></td>
                            <td>******</td>
                            <td>2022-12-06</td>
                        </tr>
                        <tr>
                            <td><a href="#">[로그인] 회원정보 문의내용</a></td>
                            <td>******</td>
                            <td>2022-12-06</td>
                        </tr>
                        <tr>
                            <td><a href="#">[회원정보] 회원정보 문의내용</a></td>
                            <td>******</td>
                            <td>2022-12-06</td>
                        </tr>
                        <tr>
                            <td><a href="#">[회원정보] 회원정보 문의내용</a></td>
                            <td>******</td>
                            <td>2022-12-06</td>
                        </tr>
                        <tr>
                            <td><a href="#">[탈퇴] 회원정보 문의내용</a></td>
                            <td>******</td>
                            <td>2022-12-06</td>
                        </tr>
                        <tr>
                            <td><a href="#">[탈퇴] 회원정보 문의내용</a></td>
                            <td>******</td>
                            <td>2022-12-06</td>
                        </tr>
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