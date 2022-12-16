<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/_admin/_header.jsp"/>

            <section id="admin-index">
                <nav>
                    <h3>자주묻는질문 작성</h3>
                    <p>
                        HOME > 고객센터 > <strong>자주묻는질문</strong>
                    </p>
                </nav>
                <div id="admin_cs_write">
                    <div class="admin_cs_write_div">
                        <form action="/Kmarket/Kmarket/admin/cs/faq/write.do" method="post">   
	                        <input type="hidden" name="hit" value= "0">
	                        <table>
	                            <tbody>
	                                <tr>
	                                    <td>유형</td>
	                                    <td>
	                                         <select name="cate1" id="">
						                        <option value="0">1차 선택</option>
						                        <option value="1">고객 서비스</option>
						                        <option value="2">안전거래</option>
						                        <option value="3">위해상품</option>
						                        <option value="4">이벤트 당첨</option>
						                    </select>
						                    <select name="cate2" id="">
						                        <option value="0">2차 선택</option>
						                        <option value="1">고객 서비스</option>
						                        <option value="2">안전거래</option>
						                        <option value="3">위해상품</option>
						                        <option value="4">이벤트 당첨</option>
						                    </select>
	                                    </td>
	                                </tr>
	                                <tr>
	                                    <td>제목</td>
	                                    <td><input type="text" name="title"></td>
	                                </tr>
	                                <tr>
	                                    <td>내용</td>
	                                    <td><input type="textarea" name="content"></td>
	                                </tr>
	                            </tbody>
	                        </table>
		                    <div class="btn">
                            <button>삭제</button>
                            <button>수정</button>
							<input type="submit" value="작성하기">                    
                        	</div>
	                    </form>
                    </div>
                </div>
            </section>
        </main>
<jsp:include page="/_admin/_footer.jsp"/>