<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/_admin/_header.jsp"/>

            <section id="admin-index">
                <nav>
                    <h3>자주믇는질문 보기</h3>
                    <p>
                        HOME > 고객센터 > <strong>자주묻는질문</strong>
                    </p>
                </nav>
                <div id="admin_cs_view">
                    <div class="admin_cs_view_div">
                        <table border="0">
                            <tbody>
                                <tr>
                                    <th>유형</th>
                                    <td>${faq.group} > ${faq.cate}</td>
                                </tr>
                                <tr>
                                    <th>제목</th>
                                    <td>${faq.title}</td>
                                </tr>
                                <tr>
                                    <th>내용</th>
                                    <td>${faq.content}</td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="btn_right">
                            <button class="btn_red">삭제</button>
                            <button class="btn_blue" onclick = "location.href = '/Kmarket/admin/cs/faq/modify.do?no=${faq.no}' ">수정</button>
                            <button class="btn_gray">작성하기</button>
                        </div>
                    </div>
                </div>
            </section>
        </main>
<jsp:include page="/_admin/_footer.jsp"/>
        