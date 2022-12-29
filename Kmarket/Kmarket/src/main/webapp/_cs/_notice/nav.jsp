<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
    <section class="navigation">
        <div>
            <p>홈 > 공지사항</p>
        </div>
    </section>
    <div class="menu">
        <aside class="detail_menu">
                <p>공지사항</p>
                <ul>
                    <li><a href="/Kmarket/cs/notice/list.do?group=all" class="${kind eq 'all' ? 'current' : 'off' }">전체</a></li>
                    <li><a href="/Kmarket/cs/notice/list.do?group=service" class="${kind eq 'service' ? 'current' : 'off' }">고객서비스</a></li>
                    <li><a href="/Kmarket/cs/notice/list.do?group=safe" class="${kind eq 'safe' ? 'current' : 'off' }">안전거래</a></li>
                    <li><a href="/Kmarket/cs/notice/list.do?group=danger" class="${kind eq 'danger' ? 'current' : 'off' }">위해상품</a></li>
                    <li><a href="/Kmarket/cs/notice/list.do?group=event" class="${kind eq 'event' ? 'current' : 'off' }">이벤트당첨</a></li>
                </ul>
        </aside>
                