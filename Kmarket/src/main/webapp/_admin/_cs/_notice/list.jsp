<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/_admin/_header.jsp"/>
<script>

	$(function() {
		list('전체보기');
		
		//카테고리 선택
		$('select[name=cate]').change(function(){
			list($(this).val());
		});
		
		//게시물 삭제
		$(document).on('click','#delete',function(e){
			e.stopImmediatePropagation();
			let no = $(this).data("no");
			console.log(no);
			let del = confirm('게시물을 삭제하시겠습니까?');
			
			if(del){
				$.ajax({
					url : '/Kmarket/admin/cs/notice/delete.do',
					method : 'get',
					data : {'no' : no},
					dataType : 'json',
					success : function(data){
						if(data.result > 0){
							alert('게시물이 삭제되었습니다.');
							$('.all').prop("checked",false);
							list('전체보기');
						}
					}
				});
			}
		});
		
		//전체선택
		$('.all').click(function(){
			if($(this).is(":checked")){
				$('.chk').prop("checked",true);
			}else{
				$('.chk').prop("checked",false);
			}
		});
		$(document).on('click','#chk',function(e){
			e.stopImmediatePropagation();
			$('.all').prop("checked",false);
			if($('input[name=chk]:checked').length == $('.chk').length){
				$('.all').prop("checked",true);
			}
		});
		
		//선택삭제
		$('.selectDelete').click(function(){
			if($('input[name=chk]:checked').length == 0){
				alert('선택된 게시물이 없습니다.');
				return;
			}
			
			let answer = confirm('게시물을 삭제하시겠습니까?');
			if(answer){
				let chkArr = new Array();
				$('input[name=chk]:checked').each(function(){
					chkArr.push($(this).data("no"));
				});
				
				$.ajax({
					url : '/Kmarket/admin/cs/notice/delete.do',
					method : 'post',
					data : {'chkArr' : chkArr},
					traditional: true,
					dataType : 'json',
					success : function(data){
						if(data.result > 0){
							alert('게시물이 삭제되었습니다.');
							$('.all').prop("checked",false);
							list('전체보기');
						}
					}
				});
			}
		});
		
		//리스트출력
		function list(cate){
			$.ajax({
				url : '/Kmarket/admin/cs/notice/list.do',
				method : 'post',
				data : {'cate' : cate},
				dataType : 'json',
				success : function(data){
					$('.notice_list').remove();
					if(data.length > 0){
						let i = 0;
						for(let article of data){
							i += 1;
							let tag = "<tr class='notice_list'>";
								tag +="<td><input type='checkbox' name='chk' class='chk' id='chk' data-no='"+article.no+"'></td>";
								tag += "<td>"+i+"</td>";
								tag += "<td>"+article.cate+"</td>";
								tag += "<td><a href='/Kmarket/admin/cs/notice/view.do?no="+article.no+"'>"+article.title+"</a></td>";
								tag += "<td>"+article.hit+"</td>";
								tag += "<td>"+article.rdate+"</td>";
								tag += "<td><a href='#' id='delete' data-no='"+article.no+"'>[삭제]</a><a href='/Kmarket/admin/cs/notice/modify.do?no="+article.no+"'>[수정]</a></td>";
								tag += "</tr>";
							$('.admin_cs_list_div').children('table').append(tag);
						}
						return;
					}else{
						let tag = "<tr class='notice_list'>";
							tag += "<td colspan='8' align='center'>등록된 공지사항이 없습니다.</td> "
							tag += "</tr>";
							$('.admin_cs_list_div').children('table').append(tag);
						return;
					}
				}
			});
		}
		
		$('.register').click(function(){
			location.href ="/Kmarket/admin/cs/notice/write.do";
		});
		
	 });

</script>
            <section id="admin-index">
                <nav>
                    <h3>공지사항 목록</h3>
                    <p>
                        HOME > 고객센터 > <strong>공지사항</strong>
                    </p>
                </nav>
                <div id="admin_cs_list">
                <div class="group">
                    <select name="cate" id="cate">
                    	<option value="전체보기">전체보기</option>
	                    <option value="고객 서비스">고객 서비스</option>
	                    <option value="안전거래">안전거래</option>
	                    <option value="위해상품">위해상품</option>
	                    <option value="이벤트 당첨">이벤트 당첨</option>
                	</select>
                	</div>
                    <div class="admin_cs_list_div">
                        <table>
                           <tr>
                               <th><input type="checkbox" class="all"/></th>
                               <th>번호</th>
                               <th>유형</th>
                               <th>제목</th>
                               <th>조회</th>
                               <th>날짜</th>
                               <th>관리</th>
                           </tr>
                          <tr class="notice_list"></tr>
                        </table>
                        <div class="btn">
                            <button class="btn_gray selectDelete">선택삭제</button>
                            <button class="btn_blue register">작성하기</button>
                        </div>
                        <div class="page">
                        </div>
                    </div>
                </div>
            </section>
        </main>
<jsp:include page="/_admin/_footer.jsp"/>
