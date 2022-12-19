<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/_cs/_header.jsp"/>
<jsp:include page="./nav.jsp"/>
        <article  class="cs_information">
            <div class="title">
                <h2><span>Q.</span>${article.title}</h2>
                <span>${article.rdate}</span>
            </div>
            <div class="content">
                <p>
                    ${article.content}
                    <br/><br/>※ 피싱 관련 피해신고
                    <br/><br/>▶ 경찰청 사이버수사국 (국번없이)182 : http://cyberbureau.police.go.kr
                    <br/>▶ KISA 인터넷침해대응센터 (국번없이)118 : http://www.krcert.or.kr
                    <br/>감사합니다.
                </p>
                <a href="/Kmarket/cs/faq/list.do" class="btn btnList">목록보기</a>
            </div>
        </article>
    </div>
</main>
<jsp:include page="/_cs/_footer.jsp"/>