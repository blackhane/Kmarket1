<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/_admin/_header.jsp"/>
            <section id="admin-index">
                <nav>
                    <h3>자주묻는질문 목록</h3>
                    <p>
                        HOME > 고객센터 > <strong>자주묻는질문</strong>
                    </p>
                </nav>
                <select name="group" id="">
                    <option value="회원">회원</option>
                </select>
                <select name="cate" id="">
                    <option value="가입">가입</option>
                    <option value="탈퇴">탈퇴</option>
                </select>
                <div id="admin_cs_list">
                    <div class="admin_cs_list_div">
                        <table>
                            <tbody>
                                <tr>
                                    <th><input type="checkbox"></th>
                                    <th>번호</th>
                                    <th>1차유형</th>
                                    <th>2차유형</th>
                                    <th>제목</th>
                                    <th>조회</th>
                                    <th>날짜</th>
                                    <th>관리</th>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>100</td>
                                    <td>가입</td>
                                    <td>고객서비스</td>
                                    <td><a href="/Kmarket/_cs/_notice/view.do">[안내] 해외결제 사칭 문자 주의</a></td>
                                    <td>조회</td>
                                    <td>2022-12-06</td>
                                    <td>
                                        <a href="#">[수정]</a>
                                        <a href="#">[삭제]</a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="btn">
                            <button class="btn_red">선택 삭제</button>
                            <button>작성하기</button>
                        </div>
                        <div class="page">
                            <a href="#">이전</a>
                            <a href="#" class="current">1</a>
                            <a href="#">2</a>
                            <a href="#">3</a>
                            <a href="#">다음</a>
                        </div>
                    </div>
                </div>
            </section>
        </main>
<jsp:include page="/_admin/_footer.jsp"/>