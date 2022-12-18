<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/_cs/_header.jsp"/>
<jsp:include page="./nav.jsp"/>
        <article class="cs_information">
            <div class="title">
                <h2>[${vo.group}] ${vo.title}</h2>
                <span>${vo.rdate}</span>
            </div>
            <div class="content">
                <p>
                   ${vo.content}
                </p>
                <a href="/Kmarket/cs/notice/list.do?group=${kind}" class="btn btnList">목록보기</a>
            </div>
        </article>
    </div>
</main>
<jsp:include page="/_cs/_footer.jsp"/>