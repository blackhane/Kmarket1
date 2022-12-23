<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/_admin/_header.jsp"/>
            <section id="admin-index">
                <nav>
                    <h3>공지사항 보기</h3>
                    <p>
                        HOME > 고객센터 > <strong>공지사항</strong>
                    </p>
                </nav>
                <div id="admin_cs_view">
                    <div class="admin_cs_view_div">
                       <table border="0">
								<tr>
					                <th>글유형</th>
					                <td>${notice.cate}</td>
					            </tr>
					            <tr>
					                <th>제목</th>
					                <td>${notice.title}</td>
					            </tr>
					            <tr>
					                <th>내용</th>
					                <td>
					                    ${notice.content}
					                </td>
					            </tr>               
				        </table>
                        <div class="btn_right">
                            <button class="btn_red" onclick = "location.href = '/Kmarket/admin/cs/notice/delete2.do?no=${notice.no}' ">삭제</button>
                            <button class="btn_blue" onclick = "location.href = '/Kmarket/admin/cs/notice/modify.do?no=${notice.no}' ">수정</button>
                            <button class="btn_gray" onclick = "location.href = '/Kmarket/admin/cs/notice/list.do' ">목록</button>
                        </div>
                    </div>
                </div>
            </section>
        </main>
<jsp:include page="/_admin/_footer.jsp"/>