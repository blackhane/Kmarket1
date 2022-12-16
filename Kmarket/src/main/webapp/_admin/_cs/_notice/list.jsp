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
                    <select name="" id="">
	                    <option value="고객 서비스">고객 서비스</option>
	                    <option value="안전거래">안전거래</option>
	                    <option value="위해상품">위해상품</option>
	                    <option value="이벤트 당첨">이벤트 당첨</option>
                	</select>
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
			                            <td>${item.title}</td>
			                            <td>${item.hit}</td>
			                            <td>${item.rdate}</td>
										<td>
			                                <a href="/Kmarket/Kmarket/admin/cs/notice/delete.do">[삭제]</a>
			                                <a href="#">[수정]</a>
		                          		</td>
						            </tr>
			           			 </c:forEach>
                                    <td><input type="checkbox"></td>
                                    <td>100</td>
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
                            <button><a href="/Kmarket/admin/cs/notice/delete.do">선택삭제</a></button>
                            <button><a href="/Kmarket/admin/cs/notice/write.do">작성하기</a></button>
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
