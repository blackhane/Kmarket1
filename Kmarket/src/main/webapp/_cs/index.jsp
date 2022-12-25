<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/_cs/_header.jsp"/>
<script>
	$(function(){
		$('.write').click(function(){
			let uid = "${sessUser.uid}"
			if(uid == ''){
				alert('로그인 후 이용할 수 있습니다.');
				return false;
			}
		});
	});
</script>
        <main>
            <section class="help">
                <p><span>케이마켓</span>이 도와드릴게요!</p>
            </section>
            <section class="notice">
                <h1>공지사항 <a href="/Kmarket/cs/notice/list.do?group=all">전체보기</a></h1>
                <ul>
                <c:forEach items="${notice}" var="notice">
                    <li>
                        <a href="/Kmarket/cs/notice/view.do?kind=all&no=${notice.no}&pg=1">[${notice.cate}] ${notice.title} <span>${notice.rdate}</span></a>
                    </li>
                </c:forEach>
                </ul>
            </section>
            <section class="faq">
                <h1>자주 묻는 질문 <a href="/Kmarket/cs/faq/list.do?group=회원">전체보기</a></h1>
                <ul>
                    <li><a href="/Kmarket/cs/faq/list.do?group=회원"><span>회원</span></a></li>
                    <li><a href="/Kmarket/cs/faq/list.do?group=쿠폰/혜택/이벤트"><span>쿠폰/이벤트</span></a></li>
                    <li><a href="/Kmarket/cs/faq/list.do?group=주문/결제"><span>주문/결제</span></a></li>
                    <li><a href="/Kmarket/cs/faq/list.do?group=배송"><span>배송</span></a></li>
                    <li><a href="/Kmarket/cs/faq/list.do?group=취소/반품/교환"><span>취소/반품/교환</span></a></li>
                    <li><a href="/Kmarket/cs/faq/list.do?group=여행/숙박/항공"><span>여행/숙박/항공</span></a></li>
                    <li><a href="/Kmarket/cs/faq/list.do?group=안전거래"><span>안전거래</span></a></li>
                </ul>
            </section>
            <section class="inquiry">
                <h1>문의하기 <a href="/Kmarket/cs/qna/list.do?group=회원">전체보기</a></h1>
                <ul>
               	<c:forEach items="${qna}" var="qna">
                    <li>
                        <a href="/Kmarket/cs/qna/view.do?group=${qna.group}&no=${qna.no}&pg=1">[${qna.cate}] ${qna.title} <p>${qna.uid}<span>${qna.rdate}</span></p></a>
                    </li>
                </c:forEach>
                    <a href="/Kmarket/cs/qna/write.do?group=회원" class="write">문의글 작성 ></a>
                </ul>
            </section>
            <section class="consult">
                <h1>1:1 상담이 필요하신가요?</h1>
                <article>
                    <div>
                        <h3>고객센터 이용안내</h3>
                        <p>
                            <span>일반회원/비회원</span><br/>
                            <strong>1566-0001</strong>
                            <span>(평일 09:00 ~ 18:00)</span>
                        </p>
                        <p>
                            <span>스마일클럽 전용</span><br/>
                            <strong>1566-0002</strong>
                            <span>(365일 09:00 ~ 18:00)</span>
                        </p>
                    </div>
                </article>
                <article>
                    <div>
                        <h3>판매상담 이용안내</h3>
                        <p>
                            <span>판매고객</span><br/>
                            <strong>1566-5700</strong>
                            <span>(평일 09:00 ~ 18:00)</span>
                        </p>
                        <p>
                            <a href="#">판매자 가입 및 서류 접수 ></a>
                        </p>
                    </div>
                </article>  
            </section>
        </main>
<jsp:include page="/_cs/_footer.jsp"/>