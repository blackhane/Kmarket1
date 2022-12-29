<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/_admin/_header.jsp"/>
<script>

$(function(){
	
	$('#cate1').change(function(){
		let cate1 = $(this).val();
		$('#cate2').empty();
		let jsonData = {
				'cate1' : cate1
		}
		console.log(jsonData);
		
	 	$.ajax({
		    url : '/Kmarket/admin/product/findCate2.do',
		    method : 'get',
		    data: jsonData,
		    dataType: 'json',
		    success: function (data) {
		    	for(let cate2 of data){
		    		let tag = "<option value= "+cate2.cate2+">"+cate2.c2Name+"</option>";
		    		$('#cate2').append(tag);
		    	}
		    }
		});
	});
	
	$('input[name="price"]').focusout(function(){
		let price = $(this).val();
		
		$('input[name="point"]').val(price/100);
	});
	
})



</script>


          <section id="admin-product-register">
                <nav>
                    <h3>상품등록</h3>
                    <p>
                        HOME > 상품관리 > <strong>상품등록</strong>
                    </p>
                </nav>
                <article>
                    <form action="/Kmarket/admin/product/register.do" method="post" enctype="multipart/form-data">
                        <!-- 상품분류 -->
                        <section>
                            <h4>상품분류</h4>
                            <p>
                                기본분류는 반드시 선택하셔야 합니다. 하나의 상품에 1개의 분류를 지정 합니다.
                            </p>
                            <table>
                                <tbody>
                                <tr>
                                    <td>1차 분류</td>
                                    <td>
                                        <select name="cate1" id = "cate1">
                                            <option value= "10">브랜드패션</option>
                                            <option value= "11">패션·의류·뷰티</option>
                                            <option value= "12">유아동</option>
                                            <option value= "13">식품·생필품</option>
                                            <option value= "14">홈데코·문구·취미·반려</option>  
                                            <option value= "15">컴퓨터·디지털·가전</option>                                              
                                            <option value= "16">스포츠·건강·렌탈</option>                                              
                                            <option value= "17">자동차·공구</option>                                              
                                            <option value= "18">여행·도서·티켓·e쿠폰</option>                                              
                                        </select>
                                    </td>
                                </tr>
                                      <td>2차 분류</td>
                                    <td>
                                        <select name="cate2" id="cate2">
                                            <option value="10">브랜드 여성의류</option>
                                            <option value="11">브랜드 남성의류</option>
                                            <option value="12">브랜드 진/캐쥬얼</option>
                                            <option value="13">브랜드 신발/가방</option>
                                            <option value="14">브랜드 쥬얼리/시계</option>
                                            <option value="15">브랜드 아웃도어</option>             
                                        </select>
                                    </td>
                                </tr>
                            </tbody>    
                            </table>
                        </section>
                        <!-- 기본정보 -->
                        <section>
                            <h4>기본정보</h4>
                            <p>
                                기본정보는 반드시 입력해야 합니다.
                            </p>
                            <table>
                                <tbody><tr>
                                    <td>상품명</td>
                                    <td><input type="text" name="prodName"></td>
                                </tr>
                                <tr>
                                    <td>기본설명</td>
                                    <td>
                                        <span>상품명 하단에 상품에 대한 추가적인 설명이 필요한 경우에 입력</span>
                                        <input type="text" name="descript">
                                    </td>
                                </tr>
                                <tr>
                                    <td>제조사</td>
                                    <td><input type="text" name="company"></td>
                                </tr>
                                 <tr>
                                    <td>판매자</td>
                                    <td><input type="text" name="seller"></td>
                                </tr>
                                <tr>
                                    <td>판매가격</td>
                                    <td><input type="text" name="price">원</td>
                                </tr>                                    
                                <tr>
                                    <td>할인율</td>
                                    <td>
                                        <span>0을 입력하면 할인율 없음</span>
                                        <input type="text" name="discount">율
                                    </td>
                                </tr>
                                <tr>
                                    <td>포인트</td>
                                    <td>
                                        <span>0을 입력하면 포인트 없음</span>
                                        <input type="text" name="point">점
                                    </td>
                                </tr>
                                <tr>
                                    <td>재고수량</td>
                                    <td><input type="text" name="stock">개</td>
                                </tr>
                                <tr>
                                    <td>배송비</td>
                                    <td>
                                        <span>0을 입력하면 배송비 무료</span>
                                        <input type="text" name="delivery">원
                                    </td>
                                </tr>
                                <tr>
                                    <td>상품 썸네일</td>
                                    <td>
                                        <span>크기 120 x 120, 상품 목록에 출력될 이미지 입니다. </span>
                                        <input type="file" name="thumb1">

                                        <span>크기 240 x 240, 상품 메인에 출력될 이미지 입니다. </span>
                                        <input type="file" name="thumb2">

                                        <span>크기 480 x 480, 상품 상세에 출력될 이미지 입니다. </span>
                                        <input type="file" name="thumb3">
                                    </td>
                                </tr>
                                <tr>
                                    <td>상세 상품정보</td>
                                    <td>
                                        <span>크기 가로 940px 높이 제약없음, 크기 최대 1MB, 상세페이지 상품정보에 출력될 이미지 입니다.</span>
                                        <input type="file" name="detail">
                                    </td>
                                </tr>
                            </tbody></table>                                
                        </section>
                        <!-- 상품정보 제공 고시 -->
                        <section>
                            <h4>상품정보 제공고시</h4>
                            <p>
                                [전자상거래에 관한 상품정보 제공에 관한 고시] 항목에 의거 등록해야 되는 정보입니다.
                            </p>
                            <table>
                                <tbody>
<!--                                 <tr> -->
<!--                                     <td>상품번호</td> -->
<!--                                     <td><input type="text" name=""></td> -->
<!--                                 </tr> -->
                                <tr>
                                    <td>상품상태</td>
                                    <td><input type="text" name="status" value="새상품"></td>
                                </tr>
                                <tr>
                                    <td>부가세 면세여부</td>
                                    <td><input type="text" name="duty" value="과세상품"></td>
                                </tr>
                                <tr>
                                    <td>영수증발행</td>
                                    <td><input type="text" name="receipt" value="발행가능-신용카드 전표, 온라인 현금영수증"></td>
                                </tr>
                                <tr>
                                    <td>사업자구분</td>
                                    <td><input type="text" name="bizType" value="사업자 판매자"></td>
                                </tr>
                                <tr>
                                    <td>브랜드</td>
                                    <td><input type="text" name="brand" value="국내산"></td>
                                </tr>
                                <tr>
                                    <td>원산지</td>
                                    <td><input type="text" name="origin"></td>
                                </tr>
                                <tr>
                                    <td>제품소재</td>
                                    <td><input type="text" name="material"></td>
                                </tr>
                                <tr>
                                    <td>색상</td>
                                    <td><input type="text" name="color"></td>
                                </tr>
                                <tr>
                                    <td>치수</td>
                                    <td><input type="text" name="size"></td>
                                </tr>
                                <tr>
                                    <td>제조자/수입국</td>
                                    <td><input type="text" name="manufacturer"></td>
                                </tr>
                                <tr>
                                    <td>제조국</td>
                                    <td><input type="text" name="country"></td>
                                </tr>
                                <tr>
                                    <td>취급시 주의사항</td>
                                    <td><input type="text" name="precautions"></td>
                                </tr>
                                <tr>
                                    <td>제조연월</td>
                                    <td><input type="text" name="date"></td>
                                </tr>
                                <tr>
                                    <td>품질보증기준</td>
                                    <td><input type="text" name="standard"></td>
                                </tr>
                                <tr>
                                    <td>A/S 책임자와 전화번호</td>
                                    <td><input type="text" name="as"></td>
                                </tr>
                                <tr>
                                    <td>주문후 예상 배송기간</td>
                                    <td><input type="text" name="delivery_date"></td>
                                </tr>
                            </tbody></table>  
                                   <input type="submit" name="submit_product"  class = "register_btn" value="등록하기">                       
                        </section>
                    </form>
                </article>
                <p class="ico alert">
                    <strong>Warning!</strong>
                    전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
                </p>
            </section>
        </main>
<jsp:include page="/_admin/_footer.jsp"/>
        