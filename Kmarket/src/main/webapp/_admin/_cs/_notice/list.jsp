<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/_admin/_header.jsp"/>

            <section id="admin-index">
                <nav>
                    <h3>공지사항 목록</h3>
                    <p>
                        HOME > 고객센터 > <strong>공지사항</strong>
                    </p>
                </nav>
                <div id="admin_cs_list">
                <form action="/Kmarket/admin/cs/notice/list.do" method="get">
                    <select name="ls" id="">
                    	<option value="전체보기">전체보기</option>
	                    <option value="고객 서비스">고객 서비스</option>
	                    <option value="안전거래">안전거래</option>
	                    <option value="위해상품">위해상품</option>
	                    <option value="이벤트 당첨">이벤트 당첨</option>
                	</select>
                	<input type="submit" value="검색하기">
                </form>
                    <div class="admin_cs_list_div">
                        <table>
                            <tbody>
                                <tr>
                                    <th><input type="checkbox"></th>
                                    <th>번호</th>
                                    <th>유형</th>
                                    <th>제목</th>
                                    <th>조회</th>
                                    <th>날짜</th>
                                    <th>관리</th>
                                </tr>
                                <tr>
                                 <c:forEach var="item" items="${notice}">
						            <tr>
						                <td><input type="checkbox" name="all"></td>
		                           		<td>${item.no}</td>
			                            <td>${item.cate}</td>
			                            <td><a href="/Kmarket/admin/cs/notice/view.do?no=${item.no}">${item.title}</a></td>
			                            <td>${item.hit}</td>
			                            <td>${item.rdate}</td>
										<td>
			                                <a href="/Kmarket/admin/cs/notice/delete.do?no=${item.no}">[삭제]</a>
			                                <a href="/Kmarket/admin/cs/notice/modify.do?no=${item.no}">[수정]</a>
		                          		</td>
						            </tr>
			           			 </c:forEach>
                                </tr>
                            </tbody>
                        </table>
                        <div class="btn">
                            <button class="btn_gray"><a href="/Kmarket/admin/cs/notice/delete.do?no=${item.no}">선택삭제</a></button>
                            <button class="btn_blue"><a href="/Kmarket/admin/cs/notice/write.do">작성하기</a></button>
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
