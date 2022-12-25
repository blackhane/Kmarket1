<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/_admin/_header.jsp"/>

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
                    <h3>공지사항 수정하기</h3>
                    <p>
                        HOME > 고객센터 > <strong>공지사항</strong>
                    </p>
                </nav>
                <div id="admin_cs_write">
                    <div class="admin_cs_write_div">
                         <form action="/Kmarket/admin/cs/notice/modify.do" method="post">   
	                       <input type="hidden" name="no" value="${vo.no}"/>
	                        <table>
	                            <tbody>
	                                <tr>
	                                    <td>유형</td>
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
	                                    <td><input type="text" name="title" value="${vo.title}"></td>
	                                </tr>
	                                <tr>
	                                    <td>내용</td>
	                                    <td><textarea name="content" id="content">${vo.content}</textarea></td>
	                                </tr>
	                            </tbody>
	                        </table>
	                        <div class="btn_right">
	                            <a href="/Kmarket/admin/cs/notice/view.do?cate=${cate}&pg=${pg}&no=${vo.no}" class="btn_red">취소</a>
	                            <input class="btn_gray" type="submit" name="submit_board" value="수정하기">                    
                        	</div>
                        </form> 
                    </div>
                </div>
            </section>
        </main>
<jsp:include page="/_admin/_footer.jsp"/>
        