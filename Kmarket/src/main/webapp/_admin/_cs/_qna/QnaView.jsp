<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/_admin/_header.jsp"/>
<script>
	$(function(){
		
		//댓글등록
		$('.btn_qna_blue').click(function(){
			let no = $('input[name=parent]').val();
			let uid = $('input[name=uid]').val();
			let comment = $('textarea[name=comment]').val();
			
			let jsonData = {
				'no' : no,
				'uid' : uid,
				'comment' : comment
			};
			console.log(jsonData);
			
			$.ajax({
				url : '/Kmarket/admin/cs/qna/comment.do',
				method : 'get',
				data : jsonData,
				dataType : 'json',
				success : function(data){
					if(data.result > 0){
						alert('댓글이 등록되었습니다.');
					}
				}
			});
		});
		
	});
</script>
        <section id="admin-index">
            <nav>
                <h3>문의하기 답변</h3>
                <p>
                    HOME > 고객센터 > <strong>문의하기</strong>
                </p>
            </nav>                 
               <input type="hidden" name="parent" value= "${qna.no}">
               <input type="hidden" name="uid" value="${qna.uid}">
                <div id="admin_cs_view">
                    <div class="admin_cs_view_div">
	                        <table>
	                            <tbody>
	                                <tr>
	                                    <td class = "td1">유형</td>
	                                    <td class = "td2">${qna.group} - ${qna.cate}</td>
	                                </tr>
	                                <tr>
	                                    <td class = "td1">제목</td>
	                                    <td class = "td2">${qna.title}</td>
	                                </tr>
	                                <tr>
	                                    <td class = "td1">내용</td>
	                                    <td class = "td2">${qna.content}</td>
	                                </tr>
	                                 <c:choose>
			                        	<c:when test="${comment.content ne null}">
			                        		<div class="comment">
			                        			<tr>
				                        			<td class = "td1">답변</td>
				                        			<td class = "td2"><textarea name="comment" class="text_width"></textarea></td>
				                        			<td>
					                        			<input type="button" class="btn_qna_gray" name ="submit_board" value="답변수정">
							                            <input type="button" class="btn_qna_red" name ="submit_board" value="답변삭제">
							                            <input type="button" class="btn_qna_blue" name ="submit_board" value="답변등록">
				                        			</td>
			                        			</tr>
			  								</div>
			  								  </tbody>
					                        </table>	
											<div class="btn_right">
				                            <button class="btn_red">삭제</button>
				                            <button class="btn_gray">목록</button>
			                        	</c:when>
			                        	<c:otherwise>
				                        		<div class="comment">
				                        			<tr>
					                        			<td class = "td1">답변</td>
					                        			<td class = "td2"><textarea name="comment" class="text_width" border="0">${comment.content}</textarea></td>
					                        			<td>
						                        			<input type="button" class="btn_qna_gray" name ="submit_board" value="답변수정">
								                            <input type="button" class="btn_qna_red" name ="submit_board" value="답변삭제">
								                            <input type="button" class="btn_qna_blue" name ="submit_board" value="답변등록">
					                        			</td>
			                        				</tr>
				  								</div>
			  								</tbody>
					                      </table>
			                        	</c:otherwise>
			                        </c:choose>
	                            </tbody>
	                        </table>	
							<div class="btn_right">
                            <button class="btn_red" onclick = "location.href = '/Kmarket/admin/cs/qna/delete.do' ">삭제</button>
                            <button class="btn_gray" onclick = "location.href = '/Kmarket/admin/cs/qna/list.do' ">목록</button>
                       		</div>	                                                
	                    </div>
	                </div>
            </section>
         </main>
<jsp:include page="/_admin/_footer.jsp"/>
