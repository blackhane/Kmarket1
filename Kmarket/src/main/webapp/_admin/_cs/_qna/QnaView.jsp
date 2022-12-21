<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/_admin/_header.jsp"/>

            <section id="admin-index">
                <nav>
                    <h3>문의하기 답변</h3>
                    <p>
                        HOME > 고객센터 > <strong>문의하기</strong>
                    </p>
                </nav>
                <div id="admin_cs_view">
                    <div class="admin_cs_view_div">
	                        <table>
	                            <tbody>
	                                <tr>
	                                    <td>유형</td>
	                                    <td>${qna.group} - ${qna.cate}</td>
	                                </tr>
	                                <tr>
	                                    <td>제목</td>
	                                    <td>${qna.title}</td>
	                                </tr>
	                                <tr>
	                                    <td>내용</td>
	                                    <td>${qna.content}</td>
	                                </tr>
	                                <tr>
	                                    <td>답변</td>
	                                    <form action="/Kmarket/admin/cs/qna/view.do" method="post">
	                                    	<td><input type="textarea"></td>
	                                    	<input type="submit" value="검색하기">
	                                    </form>
	                                </tr>
	                            </tbody>
	                        </table>
	                        <div class="btn_right">
	                            <button class="btn_red">삭제</button>
	                            <button class="btn_gray">목록</button>
	                        </div>
                    </div>
                </div>
            </section>
                </main>
<jsp:include page="/_admin/_footer.jsp"/>
