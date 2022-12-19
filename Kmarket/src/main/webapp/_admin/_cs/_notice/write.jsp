<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/_admin/_header.jsp"/>
            <section id="admin-index">
                <nav>
                    <h3>공지사항 작성</h3>
                    <p>
                        HOME > 고객센터 > <strong>공지사항</strong>
                    </p>
                </nav>
                <div id="admin_cs_write">
                    <div class="admin_cs_write_div">
                       <form id="form" action="/Kmarket/admin/cs/notice/write.do" method="post">   
	                        <table>
	                            <tbody>
	                                <tr>
	                                    <td>유형</td>
	                                    <input type="hidden" name="hit" value= "0">
	                                    <td>
	                                        <select name="cate" id="">
	                                            <option value="고객 서비스">고객 서비스</option>
	                                            <option value="안전거래">안전거래</option>
	                                            <option value="위해상품">위해상품</option>
	                                            <option value="이벤트 당첨">이벤트 당첨</option>
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
	                        <div class="btn_right">
	                            <button  class="btn_gray" onclick = "location.href = '/Kmarket/admin/cs/notice/list.do' ">목록</button>
	                            <input name="submit_board"  class="btn_blue" type="submit" value="작성하기">                  
                        	</div>
                        </form> 
                    </div>
                </div>
            </section>
        </main>
<jsp:include page="/_admin/_footer.jsp"/>