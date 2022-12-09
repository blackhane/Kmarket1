<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/_cs/_header.jsp"/>
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
                            <li class="current">회원</li>
                            <li>쿠폰/이벤트</li>
                            <li>주문/결제</li>
                            <li>배송</li>
                            <li>취소/반품/교환</li>
                            <li>여행/숙박/항공</li>
                            <li>안전거래</li>
                        </ul>
                </aside>
                <article class="cs_information">
                    <div>
                        <form action="#">
                            <table>
                                <tr>
                                    <td>문의유형</td>
                                    <td>
                                        <select name="type" id="type">
                                            <option value="">선택</option>
                                            <option value="type1">가입</option>
                                            <option value="type1">탈퇴</option>
                                            <option value="type1">회원정보</option>
                                            <option value="type1">로그인</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>문의제목</td>
                                    <td><input type="text" placeholder="제목을 입력하세요."></td>
                                </tr>
                                <tr>
                                    <td>문의내용</td>
                                    <td><textarea placeholder="내용을 입력하세요."></textarea></td>
                                </tr>
                            </table>
                        </form>
                        <a href="#" class="btn btnCancel">취소하기</a>
                        <a href="#" class="btn btnWrite">등록하기</a>
                    </div>
                </article>
            </div>
        </main>
<jsp:include page="/_cs/_footer.jsp"/>