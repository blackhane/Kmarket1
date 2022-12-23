<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/_admin/_header.jsp"/>

<script>

	$(function() {
		
        if('${param.code}' == 100){
        	alert('유형당 등록할 수 있는 게시물을 10건입니다.');
        }
        
		//그룹 선택
		$("select[name=group]").change(function() {
			let group = $(this).val();
			let cate = $("select[name=cate]");
			
			cate.empty();
			if(group == '회원'){
				cate.append('<option value="">2차 선택</option>');
				cate.append('<option value="가입">가입</option>');
				cate.append('<option value="탈퇴">탈퇴</option>');
				cate.append('<option value="회원정보">회원정보</option>');
				cate.append('<option value="로그인">로그인</option>');
			}
			if(group == '쿠폰/혜택/이벤트'){
				cate.append('<option value="">2차 선택</option>');
				cate.append('<option value="쿠폰/할인혜텍">쿠폰/할인혜텍</option>');
				cate.append('<option value="포인트">포인트</option>');
				cate.append('<option value="제휴">제휴</option>');
				cate.append('<option value="이벤트">이벤트</option>');
			}
			if(group == '주문/결제'){
				cate.append('<option value="">2차 선택</option>');
				cate.append('<option value="상품">상품</option>');
				cate.append('<option value="결제">결제</option>');
				cate.append('<option value="구매내역">구매내역</option>');
				cate.append('<option value="영수증/증빙">영수증/증빙</option>');
			}
			if(group == '배송'){
				cate.append('<option value="">2차 선택</option>');
				cate.append('<option value="배송상태/기간">배송상태/기간</option>');
				cate.append('<option value="배송정보확인/변경">배송정보확인/변경</option>');
				cate.append('<option value="스마일배송">스마일배송</option>');
				cate.append('<option value="해외배송">해외배송</option>');
				cate.append('<option value="당일배송">당일배송</option>');
				cate.append('<option value="해외직구">해외직구</option>');
			}
			if(group == '취소/반품/교환'){
				cate.append('<option value="">2차 선택</option>');
				cate.append('<option value="반품신청/철회">반품신청/철회</option>');
				cate.append('<option value="배송정보확인/변경">배송정보확인/변경</option>');
				cate.append('<option value="교환.AS신청/철회">교환.AS신청/철회</option>');
				cate.append('<option value="교환정보확인/변경">교환정보확인/변경</option>');
				cate.append('<option value="취소신청/철회">취소신청/철회</option>');
				cate.append('<option value="취소확인/환불정보">취소확인/환불정보</option>');
			}
			if(group == '여행/숙박/항공'){
				cate.append('<option value="">2차 선택</option>');
				cate.append('<option value="여행/숙박">여행/숙박</option>');
				cate.append('<option value="항공">항공</option>');
			}
			if(group == '안전거래'){
				cate.append('<option value="">2차 선택</option>');
				cate.append('<option value="서비스 이용규칙 위반">서비스 이용규칙 위반</option>');
				cate.append('<option value="지식재산권침해">지식재산권침해</option>');
				cate.append('<option value="법령 및 정책위반 상품">법령 및 정책위반 상품</option>');
				cate.append('<option value="게시물정책위반">게시물정책위반</option>');
				cate.append('<option value="직거래/외부거래유도">직거래/외부거래유도</option>');
				cate.append('<option value="표시광고">표시광고</option>');
				cate.append('<option value="청소년위해상품/이미지">청소년위해상품/이미지</option>');
			}
		});
		
		//카테고리 선택
		$('select[name=cate]').change(function(){
			list();
		});
		
		//게시물 삭제
		$(document).on('click','#delete',function(e){
			e.stopImmediatePropagation();
			let no = $(this).data("no");
			console.log(no);
			let del = confirm('게시물을 삭제하시겠습니까?');
			
			if(del){
				$.ajax({
					url : '/Kmarket/admin/cs/faq/delete.do',
					method : 'get',
					data : {'no' : no},
					dataType : 'json',
					success : function(data){
						if(data.result > 0){
							alert('게시물이 삭제되었습니다.');
							$('.all').prop("checked",false);
							list();
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
					url : '/Kmarket/admin/cs/faq/delete.do',
					method : 'post',
					data : {'chkArr' : chkArr},
					traditional: true,
					dataType : 'json',
					success : function(data){
						if(data.result > 0){
							alert('게시물이 삭제되었습니다.');
							$('.all').prop("checked",false);
							list();
						}
					}
				});
			}
		});
		
		//리스트출력
		function list(){
			let group = $('select[name=group]').val();
			let cate = $('select[name=cate]').val();
			
			if(cate == ''){
				return false;
			}
			
			let jsonData = {
				'group' : group,
				'cate' : cate
			};
			
			$.ajax({
				url : '/Kmarket/admin/cs/faq/list.do',
				method : 'post',
				data : jsonData,
				dataType : 'json',
				success : function(data){
					$('.faq_list').remove();
					if(data.length > 0){
						let i = 0;
						for(let article of data){
							i += 1;
							let tag = "<tr class='faq_list'>";
								tag +="<td><input type='checkbox' name='chk' class='chk' id='chk' data-no='"+article.no+"'></td>";
								tag += "<td>"+i+"</td>";
								tag += "<td>"+article.group+"</td>";
								tag += "<td>"+article.cate+"</td>";
								tag += "<td><a href='/Kmarket/admin/cs/faq/view.do?no="+article.no+"'>"+article.title+"</a></td>";
								tag += "<td>"+article.hit+"</td>";
								tag += "<td>"+article.rdate+"</td>";
								tag += "<td><a href='#' id='delete' data-no='"+article.no+"'>[삭제]</a><a href='/Kmarket/admin/cs/faq/modify.do?no="+article.no+"'>[수정]</a></td>";
								tag += "</tr>";
							$('.admin_cs_list_div').children('table').append(tag);
						}
						return;
					}else{
						let tag = "<tr class='faq_list'>";
							tag += "<td colspan='8' align='center'>등록된 자주묻는질문이 없습니다.</td> "
							tag += "</tr>";
							$('.admin_cs_list_div').children('table').append(tag);
						return;
					}
				}
			});
		}
		
	 });

</script>

            <section id="admin-index">
                <nav>
                    <h3>자주묻는질문 목록</h3>
                    <p>
                        HOME > 고객센터 > <strong>자주묻는질문</strong>
                    </p>
                </nav>
	                <div id="admin_cs_list">
	                	<div class="group">
	                	<select name="group" class="group">
		                    <option value="회원">회원</option>
		                    <option value="쿠폰/혜택/이벤트">쿠폰/혜택/이벤트</option>
		                    <option value="주문/결제">주문/결제</option>
		                    <option value="배송">배송</option>
		                    <option value="취소/반품/교환">취소/반품/교환</option>
		                    <option value="여행/숙박/항공">여행/숙박/항공</option>
		                    <option value="안전거래">안전거래</option>
		                </select>
		                 <select name="cate" class="cate">
							<option value="">2차 선택</option>
							<option value="가입">가입</option>
							<option value="탈퇴">탈퇴</option>
							<option value="회원정보">회원정보</option>
							<option value="로그인">로그인</option>
	                 	</select>
	               	</div>
                    <div class="admin_cs_list_div">
                        <table>
                            <tr>
                                <th><input type="checkbox" class="all"/></th>
                                <th>번호</th>
                                <th>1차유형</th>
                                <th>2차유형</th>
                                <th>제목</th>
                                <th>조회</th>
                                <th>날짜</th>
                                <th>관리</th>
                            </tr>
				            <tr class="faq_list">
				            	<td colspan="8" align="center">카테고리를 선택해주세요.</td> 
				            </tr>
                        </table>
                        <div class="btn">
                            <button class="btn_red selectDelete">선택 삭제</button>
                            <button class="btn_blue" onclick = "location.href = '/Kmarket/admin/cs/faq/write.do' ">작성하기</button>
                        </div>
                    </div>
                </div>
            </section>
        </main>
<jsp:include page="/_admin/_footer.jsp"/>