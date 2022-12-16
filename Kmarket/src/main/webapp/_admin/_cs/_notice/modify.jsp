<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/_admin/_header.jsp"/>
            <section id="admin-index">
                    <h3>공지사항 수정</h3>
                    <p>
                        HOME > 고객센터 > <strong>공지사항</strong>
                    </p>
                </nav>
                <div id="admin_cs_write">
                    <div class="admin_cs_write_div">
                        <table>
                            <tbody>
                                <tr>
                                    <td>유형</td>
                                    <td>
                                        <select name="" id="">
                                            <option value="1">유형 선택</option>
                                            <option value="1">고객 서비스</option>
                                            <option value="1">안전거래</option>
                                            <option value="1">위해상품</option>
                                            <option value="1">이벤트 당첨</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>제목</td>
                                    <td><input type="text"></td>
                                </tr>
                                <tr>
                                    <td>내용</td>
                                    <td><input type="textarea"></td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="btn">
                            <button>삭제</button>
                            <button>수정</button>
                            <button>목록</button>
                        </div>
                    </div>
                </div>
            </section>
        </main>
<jsp:include page="/_admin/_footer.jsp"/>
        