<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/_cs/_header.jsp"/>
<jsp:include page="./nav.jsp"/>
        <article class="cs_information">
            <div class="title">
                <h2>[${article.cate}] ${article.title}</h2>
                <span>${article.uid} ${article.rdate}</span>
            </div>
            <div class="content">
                <p>
                	${article.content}
                </p>
                <a href="/Kmarket/cs/qna/list.do?group=${article.group}" class="btn btnList">목록보기</a>
            </div>
        </article>
    </div>
</main>
<jsp:include page="/_cs/_footer.jsp"/>