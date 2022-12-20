<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/_cs/_header.jsp"/>
<jsp:include page="./nav.jsp"/>
<script>
	$(function(){
		$('.btnWrite').click(function(){
			if($("select[name=type1]").val() == ''){
				alert('유형1을 선택해주세요.');
				return;
			}
			if($("select[name=type2]").val() == ''){
				alert('유형2을 선택해주세요.');
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
		
		$("select[name=type1]").change(function(){
			if($(this).val() == '회원'){
				$('select[name=type2]').empty();
				let tag = "<option value=''>선택</option>";
					tag += "<option value='가입'>가입</option>";
					tag += "<option value='탈퇴'>탈퇴</option>";
					tag += "<option value='회원정보'>회원정보</option>";
					tag += "<option value='로그인'>로그인</option>";
				$('select[name=type2]').append(tag);
				return;
			}
			if($(this).val() == '쿠폰/이벤트'){
				$('select[name=type2]').empty();
				let tag = "<option value=''>선택</option>";
					tag += "<option value='쿠폰/할인혜택'>쿠폰/할인혜택</option>";
					tag += "<option value='포인트'>포인트</option>";
					tag += "<option value='제휴'>제휴</option>";
					tag += "<option value='이벤트'>이벤트</option>";
				$('select[name=type2]').append(tag);
				return;
			}
			if($(this).val() == '주문/결제'){
				$('select[name=type2]').empty();
				let tag = "<option value=''>선택</option>";
					tag += "<option value='상품'>상품</option>";
					tag += "<option value='결제'>결제</option>";
					tag += "<option value='구매내역'>구매내역</option>";
					tag += "<option value='영수증/증빙'>영수증/증빙</option>";
				$('select[name=type2]').append(tag);
				return;
			}
			if($(this).val() == '배송'){
				$('select[name=type2]').empty();
				let tag = "<option value=''>선택</option>";
					tag += "<option value='배송상태/기간'>배송상태/기간</option>";
					tag += "<option value='배송정보확인/변경'>배송정보확인/변경</option>";
					tag += "<option value='해외배송'>해외배송</option>";
					tag += "<option value='당일배송'>당일배송</option>";
					tag += "<option value='해외직구'>해외직구</option>";
				$('select[name=type2]').append(tag);
				return;
			}
			if($(this).val() == '취소/반품/교환'){
				$('select[name=type2]').empty();
				let tag = "<option value=''>선택</option>";
					tag += "<option value='반품신청/철회'>반품신청/철회</option>";
					tag += "<option value='반품정보확인/변경'>반품정보확인/변경</option>";
					tag += "<option value='교환 AS신청/철회'>교환 AS신청/철회</option>";
					tag += "<option value='교환정보확인/변경'>교환정보확인/변경</option>";
					tag += "<option value='취소신청/철회'>취소신청/철회</option>";
					tag += "<option value='취소확인/환불정보'>취소확인/환불정보</option>";
				$('select[name=type2]').append(tag);
				return;
			}
			if($(this).val() == '여행/숙박/항공'){
				$('select[name=type2]').empty();
				let tag = "<option value=''>선택</option>";
					tag += "<option value='여행/숙박'>여행/숙박</option>";
					tag += "<option value='항공'>항공</option>";
				$('select[name=type2]').append(tag);
				return;
			}
			if($(this).val() == '안전거래'){
				$('select[name=type2]').empty();
				let tag = "<option value=''>선택</option>";
					tag += "<option value='서비스 이용규칙 위반'>서비스 이용규칙 위반</option>";
					tag += "<option value='지식재산권침해'>지식재산권침해</option>";
					tag += "<option value='법령 및 정책위반 상품'>법령 및 정책위반 상품</option>";
					tag += "<option value='게시물 정책위반'>게시물 정책위반</option>";
					tag += "<option value='직거래/외부거래유도'>직거래/외부거래유도</option>";
					tag += "<option value='표시광고'>표시광고</option>";
					tag += "<option value='청소년 위해상품/이미지'>청소년 위해상품/이미지</option>";
				$('select[name=type2]').append(tag);
				return;
			}
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
                                <select name="type1" id="type1">
                                    <option value="">선택</option>
                                    <option value="회원">회원</option>
                                    <option value="쿠폰/이벤트">쿠폰/이벤트</option>
                                    <option value="주문/결제">주문/결제</option>
                                    <option value="배송">배송</option>
                                    <option value="취소/반품/교환">취소/반품/교환</option>
                                    <option value="여행/숙박/항공">여행/숙박/항공</option>
                                    <option value="안전거래">안전거래</option>
                                </select>
                                <select name="type2" id="type2">
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
                <a href="/Kmarket/cs/qna/list.do?group=${group}" class="btn btnCancel">취소하기</a>
                <a href="#" class="btn btnWrite">등록하기</a>
            </div>
        </article>
    </div>
</main>
<jsp:include page="/_cs/_footer.jsp"/>