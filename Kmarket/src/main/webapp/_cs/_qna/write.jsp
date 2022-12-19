<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/_cs/_header.jsp"/>
<jsp:include page="./nav.jsp"/>
<script>
	$(function(){
		$('.btnWrite').click(function(){
			if($("select[name=type]").val() == ''){
				alert('유형을 선택해주세요.');
				return;
			}
			if($('input[name=title]').val() == ''){
				alert('제목을 입력해주세요.');
				return;
			}
			if($('textarea[name=content]').val() == ''){
				alert('내용을 입력해주세요.');
				return;
			}
			document.getElementById('frm').submit();
		});
	});
</script>
        <article class="cs_information">
            <div>
                <form action="/Kmarket/cs/qna/write.do" method="post" id="frm">
                <input type="hidden" name="uid" value="${sessUser.uid}">
                    <table>
                        <tr>
                            <td>문의유형</td>
                            <td>
                                <select name="type" id="type">
                                    <option value="">선택</option>
                                    <option value="가입">가입</option>
                                    <option value="탈퇴">탈퇴</option>
                                    <option value="회원정보">회원정보</option>
                                    <option value="로그인">로그인</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>문의제목</td>
                            <td><input type="text" name="title" placeholder="제목을 입력하세요."></td>
                        </tr>
                        <tr>
                            <td>문의내용</td>
                            <td><textarea name="content" placeholder="내용을 입력하세요."></textarea></td>
                        </tr>
                    </table>
                </form>
                <a href="/Kmarket/cs/qna/list.do" class="btn btnCancel">취소하기</a>
                <a href="#" class="btn btnWrite">등록하기</a>
            </div>
        </article>
    </div>
</main>
<jsp:include page="/_cs/_footer.jsp"/>