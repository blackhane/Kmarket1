<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/Kmarket/js/postcode.js"></script>
<jsp:include page="./_header.jsp"/>
<jsp:include page="./nagivation.jsp"/>
<script>
	$(function(){
		let count = '${iCount}';
		let price = '${item.price * iCount}';
		let discount = '${item.discount}';
		let disPrice = Math.floor('${(item.price / 100 * item.discount) * iCount}');
		let delivery = parseInt('${item.delivery * iCount}');
		let point = 0;
		let totalPrice = price - disPrice + delivery - point;
		
		//포인트사용
		$('input[name=usePoint]').click(function(){
			if($('input[name=point]').val() < 5000){
				alert('5000점 이상부터 사용 가능합니다.');
				$('.pointDiscount').text("0원");
				$('input[name=point]').val('').focus();
				point = 0;
			}else{
				point = $('input[name=point]').val();
				totalPrice = price - disPrice + delivery - point;
				$('.pointDiscount').text(point +"원");
				console.log(point);
				if(totalPrice < 0){
					alert('주문금액이 0원 이하로 포인트를 사용할 수 없습니다.');
					$('.pointDiscount').text("0원");
					$('input[name=point]').val('').focus();
					point = 0;
				}
			}
			$('.final').empty();
			finalOrder();
		});
		
		//상품보기 => 주문
		if(${sessionScope.item ne null}){
			finalOrder();
		}
		function finalOrder(){
			totalPrice = price - disPrice + delivery - point;
				let tag = "<h2>최종결제 정보</h2>";
					tag += "<table>";
					tag += "<tr><td>총</td>";
					tag += "<td>"+count+"건</td></tr>";
					tag += "<tr><td>상품금액</td>";
					tag += "<td>"+price+"원</td></tr>";
					tag += "<tr><td>할인금액</td>";
					tag += "<td>"+disPrice+"원</td></tr>";
	                tag += "<tr><td>배송비</td>";
					tag += "<td>"+delivery+"원</td></tr>";
	                tag += "<tr><td>포인트 할인</td><td class='pointDiscount'>"+point+"원</td></tr>";
					tag += "<tr><td>전체주문금액</td>";
					tag += "<td>"+totalPrice+"원</td></tr>";
					tag += "</table>";
					tag += "<button type='sumbit' class='complete'>결제하기</button>";
				$('.final').append(tag);
		}
		
		//주소
		$('input[name=zipSearch]').click(function(){
			postcode();
		});
		
		//엔터 막기
		document.addEventListener('keydown', function(event) {
		  if (event.keyCode === 13) {
		    event.preventDefault();
		  };
		}, true);
		
		//주문전 검사
		$('form.complete').click(function(){
			alert('전송멈춰!');
			if($('input[name=orderer]').val() == ''){
				alert('주문자를 확인하세요.');
				$('input[name=orderer]').focus();
				return false;
			}
			if($('input[name=hp]').val() == ''){
				alert('휴대폰을 확인하세요.');
				$('input[name=hp]').focus();
				return false;
			}
			if($('input[name=addr1]').val() == ''){
				alert('주소를 확인하세요.');
				$('input[name=addr1]').focus();
				return false;
			}
			if($('input[name=addr2]').val() == ''){
				alert('상세주소를 확인하세요.');
				$('input[name=addr2]').focus();
				return false;
			}
			let pay = $('input[name=payment]').is(':checked');
			if(pay == 0){
				alert('결제방법을 확인해주세요.');
				return false;
			}
			
			let uid = '${sessUser.uid}';
			let count = '${iCount}';
			let price = '${item.price * iCount}';
			let discount = (price / 100 * discount) * count;
			let savePoint = '${itme.point}';
			let point = $('input[name=point]').val();
			let ordTotPrice = price - discount + delivery - point;
			let orderer = $('input[name=orderer]').val();
			let hp = $('input[name=hp]').val();
			let zip = $('input[name=zip]').val();
			let addr1 = $('input[name=addr1]').val();
			let addr2 = $('input[name=addr2]').val();
			let payment = $('input[name=payment]').val();
				
			let jsonData = {
				'uid':uid,
				'count':count,
				'price':price,
				'discount':discount,
				'savePoint':savePoint,
				'usedPoint':usedPoint,
				'ordToPrice':ordTotPrice,
				'orderer':orderer,
				'hp':hp,
				'zip':zip,
				'addr1':addr1,
				'addr2':addr2,
				'payment':payment
			}
			
			$.ajax({
				url : '/Kmarket/product/order.do',
				method : 'post',
				data : jsonData,
				dataType : 'json',
				success : function(data){
					if(data > 0){
					 	alert('주문이 완료되었습니다.');
					}else{
						alert('주문에 실패하였습니다.');
						return false;
					}
				}
			});
			return true;
		});
	});   
</script>
            <section class="order">

                <nav>
                    <h1>주문결제</h1>
                    <p>
                        HOME > <span>장바구니</span> > <strong>주문결제</strong>
                    </p>
                </nav>

                <form action="/Kmarket/product/complete.do?uid=${sessUser.uid}">
                    <table>
                        <thead>
                            <tr>
                                <th>상품명</th>
                                <th>총수량</th>
                                <th>판매가</th>
                                <th>할인</th>
                                <th>포인트</th>
                                <th>배송비</th>
                                <th>소계</th>
                            </tr>
                        </thead>
                        <!-- 장바구니 목록 -->
                        <tbody>
                        <c:forEach items="${items}" var="order">
                            <tr>
                                <td>
                                    <article><a href="#"><img src="https://via.placeholder.com/80x80" alt="thumb1"></a>
                                        <div>
                                            <h2><a href="#">${order.prodName}</a></h2>
                                            <p>${order.descript}</p>
                                        </div>
                                    </article>
                                </td>
                                <td>${order.count}</td>
                                <td><fmt:formatNumber type="number" pattern="#,###" value="${cart.price}"/>원</td>
                                <td>${order.discount}%</td>
                                <td><fmt:formatNumber type="number" pattern="#,###" value="${order.point}"/>점</td>
                                <c:choose>
                                	<c:when test="${order.delivery eq 0}">
                                		<td>무료배송</td>
                                	</c:when>
                                	<c:otherwise>
                                		<td><fmt:formatNumber type="number" pattern="#,###" value="${order.delivery}"/>원</td>
                                	</c:otherwise>
                                </c:choose>
                                <td><fmt:formatNumber type="number" pattern="#,###" value="${order.price - (order.price/100*order.discount)}"/>원</td>
                            </tr>
                        </c:forEach>    
                        </tbody>
                    </table>

                    <!-- 최종결제 정보 -->
                    <div class="final">
                        <c:if test="${items ne null}">
                            <tr>
                                <td>총</td>
                                <td>${total.count} 건</td>
                            </tr>
                            <tr>
                                <td>상품금액</td>
                                <td><fmt:formatNumber type="number" pattern="#,###" value="${total.price}"/>원</td>
                            </tr>
                            <tr>
                                <td>할인금액</td>
                                <td><fmt:formatNumber type="number" pattern="#,###" value="${total.discount}"/>원</td>
                            </tr>
                            <tr>
                                <td>배송비</td>
                                <td><fmt:formatNumber type="number" pattern="#,###" value="${total.delivery}"/>원</td>
                            </tr>
                            <tr>
                                <td>포인트 할인</td>
                                <td class="pointDiscount">원</td>
                            </tr>
                            <tr>
                                <td>전체주문금액</td>
                                <td><fmt:formatNumber type="number" pattern="#,###" value="${total.total}"/>원</td>
                            </tr>
                        </c:if>
                        
                    </div>

                    <!-- 배송정보 -->
                    <article class="delivery">
                        <h1>배송정보</h1>
                        <table>
                            <tr>
                                <td>주문자</td>
                                <td><input type="text" name="orderer" value="${sessUser.name}"></td>
                            </tr>
                            <tr>
                                <td>휴대폰</td>
                                <td><input type="text" name="hp" value="${sessUser.hp}"><span> - 포함 입력</span></td>
                            </tr>
                            <tr>
                                <td>우편번호</td>
                                <td><input type="text" name="zip" id="zip" value="${sessUser.zip}">
                                    <input type="button" name="zipSearch" value="검색">
                                </td>
                            </tr>
                            <tr>
                                <td>기본주소</td>
                                <td><input type="text" name="addr1" id="addr1" value="${sessUser.addr1}"></td>
                            </tr>
                            <tr>
                                <td>상세주소</td>
                                <td><input type="text" name="addr2" id="addr2" value="${sessUser.addr2}"></td>
                            </tr>
                        </table>
                    </article>

                    <!-- 할인정보 -->
                    <article class="discount">
                        <h1>할인정보</h1>
                        <div>
                            <p>현재 포인트 : <span>${sessUser.point}</span>점</p>
                            <label>
                                <input type="text" name="point">점
                                <input type="button" name="usePoint" value="적용">
                            </label>
                            <span>포인트 5,000점 이상이면 현금처럼 사용 가능합니다.</span>
                        </div>
                    </article>

                    <!-- 결제방법 -->
                    <article class="payment">
                        <h1>결제방법</h1>
                        <div>
                            <span>신용카드</span>
                            <p>
                                <label><input type="radio" name="payment" value="1">신용카드 결제</label>
                                <label><input type="radio" name="payment" value="2">체크카드 결제</label>
                            </p>
                        </div>
                        <div>
                            <span>계좌이체</span>
                            <p>
                                <label><input type="radio" name="payment" value="3">실시간 계좌이체</label>
                                <label><input type="radio" name="payment" value="4">무통장 입금</label>
                            </p>
                        </div>
                        <div>
                            <span>기타</span>
                            <p>
                                <label><input type="radio" name="payment" value="5">휴대폰 결제</label>
                                <label><input type="radio" name="payment" value="6">카카오페이
                                    <img src="/Kmarket/img/img_product/ico_kakaopay.gif" alt="카카오페이">
                                </label>
                            </p>
                        </div>
                    </article>

                    <!-- 경고문 -->
                    <article class="alert">
                        <ul>
                            <li><span>케이마켓의 모든 판매자는 안전거래를 위해 구매금액, 결제수단에 상관없이 모든거래에 대하여 케이마켓 유한책임회사의 구매안전서비스(에스크로)를 제공하고
                                    있습니다.</span></li>
                            <li><span>케이마켓 유한책임회사의 전자금융거래법에 의해 결제대금예치업 등록번호는 02-006-00008 입니다.</span></li>
                            <li><span>등록여부는 금융감독원 홈페이지(www.fss.or.kr)의 업무자료>인허가업무안내>전자금융업등록현황에서 확인하실수 있습니다.</span></li>
                        </ul>
                    </article>
                </form>
            </section>
        </main>

<jsp:include page="./_footer.jsp"/>