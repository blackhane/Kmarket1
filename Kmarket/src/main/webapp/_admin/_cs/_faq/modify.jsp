<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/_admin/_header.jsp"/>

<script>

	$(function() {
		  $("select[name=group]").change(function() {
		   var temp = $("select[name=cate]");
		   var a = $(this).val();
	
		   temp.children().remove();
		   
		   if(a == '회원'){
		    temp.append('<option value="가입">가입</option>');
		    temp.append('<option value="탈퇴">탈퇴</option>');
		    temp.append('<option value="회원정보">회원정보</option>');
		    temp.append('<option value="로그인">로그인</option>');
		   }
		   if(a == '쿠폰/혜택/이벤트'){
		    temp.append('<option value="쿠폰/할인혜텍">쿠폰/할인혜텍</option>');
		    temp.append('<option value="포인트">포인트</option>');
		    temp.append('<option value="제휴">제휴</option>');
		    temp.append('<option value="이벤트">이벤트</option>');
		   }
		   if(a == '주문/결제'){
		    temp.append('<option value="상품">상품</option>');
		    temp.append('<option value="결제">결제</option>');
		    temp.append('<option value="구매내역">구매내역</option>');
		    temp.append('<option value="영수증/증빙">영수증/증빙</option>');
		   }
		   
		   if(a == '배송'){
			    temp.append('<option value="배송상태/기간">배송상태/기간</option>');
			    temp.append('<option value="배송정보확인/변경">배송정보확인/변경</option>');
			    temp.append('<option value="스마일배송">스마일배송</option>');
			    temp.append('<option value="해외배송">해외배송</option>');
			    temp.append('<option value="당일배송">당일배송</option>');
			    temp.append('<option value="해외직구">해외직구</option>');
			   }
		   
		   if(a == '취소/반품/교환'){
			    temp.append('<option value="반품신청/철회">반품신청/철회</option>');
			    temp.append('<option value="배송정보확인/변경">배송정보확인/변경</option>');
			    temp.append('<option value="교환.AS신청/철회">교환.AS신청/철회</option>');
			    temp.append('<option value="교환정보확인/변경">교환정보확인/변경</option>');
			    temp.append('<option value="취소신청/철회">취소신청/철회</option>');
			    temp.append('<option value="취소확인/환불정보">취소확인/환불정보</option>');
			   }
		   
		   if(a == '여행/숙박/항공'){
			    temp.append('<option value="여행/숙박">여행/숙박</option>');
			    temp.append('<option value="항공">항공</option>');
			   }
		   
		   if(a == '안전거래'){
			    temp.append('<option value="서비스 이용규칙 위반">서비스 이용규칙 위반</option>');
			    temp.append('<option value="지식재산권침해">지식재산권침해</option>');
			    temp.append('<option value="법령 및 정책위반 상품">법령 및 정책위반 상품</option>');
			    temp.append('<option value="게시물정책위반">게시물정책위반</option>');
			    temp.append('<option value="직거래/외부거래유도">직거래/외부거래유도</option>');
			    temp.append('<option value="표시광고">표시광고</option>');
			    temp.append('<option value="청소년위해상품/이미지">청소년위해상품/이미지</option>');
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
          oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
          $("input[name=submit_board]").submit();
      }); 
});
</script>

            <section id="admin-index">
                <nav>
                    <h3>자주묻는질문 수정</h3>
                    <p>
                        HOME > 고객센터 > <strong>자주묻는질문</strong>
                    </p>
                </nav>
               <div id="admin_cs_write">
                    <div class="admin_cs_write_div">
                         <form action="/Kmarket/admin/cs/faq/modify.do" method="post">   
	                       <input type="hidden" name="no" value="${vo.no}"/>
	                        <table>
	                            <tbody>
	                                <tr>
	                                    <td>유형</td>
	                                    <td>
	                                        <select name="group" id="">
                    							<option value="회원">회원</option>
                    							<option value="쿠폰/혜택/이벤트">쿠폰/혜택/이벤트</option>
                    							<option value="주문/결제">주문/결제</option>
                   								<option value="배송">배송</option>
                   								<option value="취소/반품/교환">취소/반품/교환</option>
                   								<option value="여행/숙박/항공">여행/숙박/항공</option>
                  								<option value="안전거래">안전거래</option>
	                                        </select>
	                                        <select name="cate" id="">
	                                    		<option value="가입">가입</option>
	                                    		<option value="탈퇴">탈퇴</option>
	                                    		<option value="회원정보">회원정보</option>
	                                    		<option value="로그인">로그인</option>
	                                        </select>
	                                    </td>
	                                </tr>
	                                <tr>
	                                    <td>제목</td>
	                                    <td><input type="text" name="title" value="${vo.title}"></td>
	                                </tr>
	                                <tr>
	                                    <td>내용</td>
	                                    <td><input type="textarea" name="content" id="content" value="${vo.content}">
	                                </tr>
	                            </tbody>
	                        </table>
	                        <div class="btn_right">
	                            <button class="btn_red" onclick ="/Kmarket/admin/cs/faq/view.do?no=${vo.no}">취소</button>
	                            <input class="btn_gray" type="submit" name="submit_board" value="수정하기">                    
                        	</div>
                        </form> 
                    </div>
                </div>
            </section>
        </main>
<jsp:include page="/_admin/_footer.jsp"/>
        