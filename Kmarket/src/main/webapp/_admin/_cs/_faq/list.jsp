<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/_admin/_header.jsp"/>

<script>

	$(function() {
		  $("select[name=group]").change(function() {
		   var temp = $("select[name=cate]");
		   var a = $(this).val();
	
		   temp.children().remove();
		   temp.append('<option value="all">전체보기</option>');
		   
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

            <section id="admin-index">
                <nav>
                    <h3>자주묻는질문 목록</h3>
                    <p>
                        HOME > 고객센터 > <strong>자주묻는질문</strong>
                    </p>
                </nav>
                <form action="/Kmarket/admin/cs/faq/list.do" method="get">
	                <select name="group" id="">
	                    <option value="0">전체보기</option>
	                    <option value="회원">회원</option>
	                    <option value="쿠폰/혜택/이벤트">쿠폰/혜택/이벤트</option>
	                    <option value="주문/결제">주문/결제</option>
	                    <option value="배송">배송</option>
	                    <option value="취소/반품/교환">취소/반품/교환</option>
	                    <option value="여행/숙박/항공">여행/숙박/항공</option>
	                    <option value="안전거래">안전거래</option>
	                </select>
	                 <select name="cate" id="">
                	</select>
	                 <input type="submit" value="검색하기">
	            </form>
                <div id="admin_cs_list">
                    <div class="admin_cs_list_div">
                        <table>
                            <tbody>
                                <tr>
                                    <th><input type="checkbox"></th>
                                    <th>번호</th>
                                    <th>1차유형</th>
                                    <th>2차유형</th>
                                    <th>제목</th>
                                    <th>조회</th>
                                    <th>날짜</th>
                                    <th>관리</th>
                                </tr>
                                <tr>
                                   <c:forEach var="item" items="${faq}">
						            <tr class="faq_list">
						                <td><input type="checkbox" name="all"></td>
		                           		<td>${item.no}</td>
		                           		<td>${item.group}</td>
			                            <td>${item.cate}</td>
			                            <td><a href="/Kmarket/admin/cs/faq/view.do?no=${item.no}">${item.title}</a></td>
			                            <td>${item.hit}</td>
			                            <td>${item.rdate}</td>
										<td>
			                                <a href="/Kmarket/admin/cs/faq/delete.do?no=${item.no}">[삭제]</a>
			                                <a href="/Kmarket/admin/cs/faq/modify.do?no=${item.no}">[수정]</a>
		                          		</td>
						            </tr>
			           			 </c:forEach>
                                </tr>
                            </tbody>
                        </table>
                        <div class="btn">
                            <button class="btn_red" onclick = "location.href = '/Kmarket/admin/cs/faq/delete.do' ">선택 삭제</button>
                            <button class="btn_blue" onclick = "location.href = '/Kmarket/admin/cs/faq/write.do' ">작성하기</button>
                        </div>
                        <div class="page">
                            <a href="#">이전</a>
                            <a href="#" class="current">1</a>
                            <a href="#">2</a>
                            <a href="#">3</a>
                            <a href="#">다음</a>
                        </div>
                    </div>
                </div>
            </section>
        </main>
<jsp:include page="/_admin/_footer.jsp"/>