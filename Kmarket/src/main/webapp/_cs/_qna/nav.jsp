<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<main>
    <section class="navigation">
        <div>
            <p>홈 > 문의하기</p>
        </div>
    </section>
    <div class="menu">
        <aside class="detail_menu">
                <p>문의하기</p>
                <ul>
                    <li><a href="/Kmarket/cs/qna/list.do?group=회원" class="${group eq '회원' ? 'current' : 'off'}">회원</a></li>
                    <li><a href="/Kmarket/cs/qna/list.do?group=쿠폰/이벤트" class="${group eq '쿠폰/이벤트' ? 'current' : 'off'}">쿠폰/이벤트</a></li>
                    <li><a href="/Kmarket/cs/qna/list.do?group=주문/결제" class="${group eq '주문/결제' ? 'current' : 'off'}">주문/결제</a></li>
                    <li><a href="/Kmarket/cs/qna/list.do?group=배송" class="${group eq '배송' ? 'current' : 'off'}">배송</a></li>
                    <li><a href="/Kmarket/cs/qna/list.do?group=취소/반품/교환" class="${group eq '취소/반품/교환' ? 'current' : 'off'}">취소/반품/교환</a></li>
                    <li><a href="/Kmarket/cs/qna/list.do?group=여행/숙박/항공" class="${group eq '여행/숙박/항공' ? 'current' : 'off'}">여행/숙박/항공</a></li>
                    <li><a href="/Kmarket/cs/qna/list.do?group=안전거래" class="${group eq '안전거래' ? 'current' : 'off'}">안전거래</a></li>
                </ul>
        </aside>