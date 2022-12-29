<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/_admin/_header.jsp"/>
<script>
	$(function() {
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
		
	});
</script>


<script type="text/javascript">
	//스마트에디터
	var oEditors = [];
	$(function(){
	      nhn.husky.EZCreator.createInIFrame({
	          oAppRef: oEditors,
	          elPlaceHolder: "content", //textarea에서 지정한 id와 일치해야 합니다. 
	          //SmartEditor2Skin.html 파일이 존재하는 경로
	          sSkinURI: "/Kmarket/smarteditor/SmartEditor2Skin.html",  
	          htParams : {
	              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
	              bUseToolbar : true,             
	              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
	              bUseVerticalResizer : true,     
	              // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
	              bUseModeChanger : true,         
	              fOnBeforeUnload : function(){               
	              }
	          }, 
	      });
	      
	      //저장버튼 클릭시 form 전송
	      $("input[name=submit_board]").click(function(){
	    	  if($('select[name=cate]').val() == ''){
	    		  alert('카테고리를 선택해주세요.');
	    		  return false;
	    	  }
	    	  
	          oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
	          $("input[name=submit_board]").submit();
	      }); 
	});
</script>
            <section id="admin-index">
                <nav>
                    <h3>자주묻는질문 작성</h3>
                    <p>
                        HOME > 고객센터 > <strong>자주묻는질문</strong>
                    </p>
                </nav>
                <div id="admin_cs_write">
                    <div class="admin_cs_write_div">
                        <form action="/Kmarket/admin/cs/faq/write.do" method="post">   
	                        <table>
	                            <tbody>
	                                <tr>
	                                    <td>유형</td>
	                                    <td>
							                <select name="group">
							                    <option value="회원">회원</option>
							                    <option value="쿠폰/혜택/이벤트">쿠폰/혜택/이벤트</option>
							                    <option value="주문/결제">주문/결제</option>
							                    <option value="배송">배송</option>
							                    <option value="취소/반품/교환">취소/반품/교환</option>
							                    <option value="여행/숙박/항공">여행/숙박/항공</option>
							                    <option value="안전거래">안전거래</option>
							                </select>
							                <select name="cate">
												<option value="">2차 선택</option>
												<option value="가입">가입</option>
												<option value="탈퇴">탈퇴</option>
												<option value="회원정보">회원정보</option>
												<option value="로그인">로그인</option>
							                </select>
	                                    </td>
	                                </tr>
	                                <tr>
	                                    <td>제목</td>
	                                    <td><input type="text" name="title"></td>
	                                </tr>
	                                <tr>
	                                    <td>내용</td>
	                                    <td><input type="textarea" name="content" id="content" rows="22"></td>
	                                </tr>
	                            </tbody>
	                        </table>
		                    <div class="btn_right">
	                            <a href="/Kmarket/admin/cs/faq/list.do" class="btn_gray">목록</a>
								<input class="btn_blue" type="submit" name="submit_board" value="작성하기">                    
                        	</div>
	                    </form>
                    </div>
                </div>
            </section>
        </main>
<jsp:include page="/_admin/_footer.jsp"/>