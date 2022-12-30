<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/Kmarket/js/postcode.js"></script>
<jsp:include page="./_header.jsp"/>
<jsp:include page="./nagivation.jsp"/>
<script>
	$(function(){
		
		let count = 0;
		let price = 0;
		let disPrice = 0;
		let delivery = 0;
		let point = 0;
		let totalPrice = 0;

		//최종주문
		finalOrder();
		function finalOrder(){
			let count = 0;
			let price = 0;
			let disPrice = 0;
			let delivery = 0;
			let totalPrice = 0;
			let savePoint = 0;
			<c:forEach items="${orderList}" var="order">
				//console.log("${order.prodName}");
				//console.log("${order.count}");
				count += ${order.count};
				price += ${order.price * order.count};
				disPrice += ${(order.price / 100 * order.discount) * order.count} * -1;
				delivery += ${order.delivery};
				savePoint += ${order.point};
				totalPrice += ((${order.price} + (${order.price / 100 * order.discount} * -1) + ${order.delivery}) * ${order.count});
			</c:forEach>
				let tag = "<h2>최종결제 정보</h2>";
					tag += "<table>";
					tag += "<tr><td>총</td>";
					tag += "<input type='hidden' name='count' value="+count+">";
					tag += "<td>"+count.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+"건</td></tr>";
					tag += "<tr><td>상품금액</td>";
					tag += "<input type='hidden' name='price' value="+price+">";
					tag += "<td>"+price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+"원</td></tr>";
					tag += "<tr><td>할인금액</td>";
					tag += "<input type='hidden' name='disPrice' value="+disPrice+">";
					tag += "<td>"+disPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+"원</td></tr>";
	                tag += "<tr><td>배송비</td>";
	                tag += "<input type='hidden' name='delivery' value="+delivery+">";
					tag += "<td>"+delivery.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+"원</td></tr>";
					tag += "<input type='hidden' name='used' value="+point+">";
					tag += "<input type='hidden' name='save' value="+savePoint+">";
	                tag += "<tr><td>포인트 할인</td><td class='pointDiscount'>"+point.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+"원</td></tr>";
					tag += "<tr><td>전체주문금액</td>";
					tag += "<input type='hidden' name='totalPrice' value="+totalPrice+">";
					tag += "<td>"+(totalPrice - point).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+"원</td></tr>";
					tag += "</table>";
					tag += "<button type='sumbit' class='complete'>결제하기</button>";
					$('.final').append(tag);
		}
		
		//포인트사용
		let maxPoint = Number('${sessUser.point}');
		$('input[name=usePoint]').click(function(){
			let usedPoint = $('input[name=point]').val();
			//사용포인트 < 최소포인트
			if(usedPoint < 5000){
				//console.log(usedPoint);
				alert('5000점 이상부터 사용 가능합니다.');
				$('.pointDiscount').text("0원");
				$('input[name=point]').val('').focus();
				point = 0;
				$('.final').empty();
				finalOrder();
				return;
			}
			//사용포인트 > 보유포인트
			if(usedPoint > maxPoint){
				//console.log($('input[name=point]').val());
				alert('최대 사용가능한 포인트는 '+maxPoint+'입니다.');
				$('.pointDiscount').text("0원");
				$('input[name=point]').val('').focus();
				point = 0;
				$('.final').empty();
				finalOrder();
				return;
			}
			
			//주문금액 재계산
			point = usedPoint;
			//포인트 > 주문금액
			if($('input[name=totalPrice]').val() - usedPoint < 0){
				alert('주문금액의 0원 이하로 포인트를 사용할 수 없습니다.');
				$('.pointDiscount').text("0원");
				$('input[name=point]').val('').focus();
				point = 0;
				$('.final').empty();
				finalOrder();
				return;
			}
			
			$('.final').empty();
			finalOrder();
		});
		
		//휴대폰 유효성 검사
		let regHp = /^\d{3}-\d{3,4}-\d{4}$/;
		let chkHp = true;
		$('input[name=hp]').focusout(function(){
			let hp = $('input[name=hp]').val();
			//유효성검사
			if(!hp.match(regHp)){
				//실패
				alert('- 포함 13자리를 입력하세요.');
				chkHp = false;
				return;
			}
			chkHp = true;
		});
		
		//주소
		$('input[name=zipSearch]').click(function(){
			postcode();
		});
		
		//검사
		$('form').submit(function(){
			
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
			if(!chkHp){
				alert('휴대폰을 확인하세요.');
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

			let ordUid = '${sessUser.uid}';
			let ordCount =  $('input[name=count]').val();
			let ordPrice =  $('input[name=price]').val();
			let ordDisPrice =  $('input[name=disPrice]').val();
			let ordDelivery =  $('input[name=delivery]').val();
			let ordUsed =  $('input[name=used]').val();
			let ordSave =  $('input[name=save]').val();
			let ordTotalPrice =  $('input[name=totalPrice]').val()-$('input[name=used]').val();
			let recipName = $('input[name=orderer]').val();
			let recipHp = $('input[name=hp]').val();	
			let recipZip = $('input[name=zip]').val();
			let recipAddr1 = $('input[name=addr1]').val();
			let recipAddr2 = $('input[name=addr2]').val();
			let payment = $('input[name=payment]:checked').val();
			
			let jsonData = {
				'ordUid':ordUid,
				'ordCount':ordCount,
				'ordPrice':ordPrice,
				'ordDiscount':ordDisPrice,
				'ordDelivery':ordDelivery,
				'savePoint':ordSave,
				'usedPoint':ordUsed,
				'totalPrice':ordTotalPrice,
				'recipName':recipName,
				'recipHp':recipHp,
				'recipZip':recipZip,
				'recipAddr1':recipAddr1,
				'recipAddr2':recipAddr2,
				'payment':payment
			}
			//console.log(jsonData);
			
			let cartNo = new Array();
			<c:forEach items="${orderList}" var="order">
				cartNo.push(${order.cartNo});
			</c:forEach>
			//console.log(cartNo);
			$.ajax({
				url : '/Kmarket/product/orderHelper.do',
				method : 'get',
				data : jsonData,
				dataType : 'json',
				success : function(data){
					console.log(data.result);
				}
			});
			
			$.ajax({
				url : '/Kmarket/product/orderHelper.do',
				method : 'post',
				traditional: true,
				async : false,
				data : {'cartNo' : cartNo},
				dataType : 'json',
				success : function(data){
					if(data.result > 0){
						alert('주문이 완료되었습니다.');
						return true;
					}else{
						return false;
					}
				}
			});
			
	  	});
		
		//엔터 막기
		document.addEventListener('keydown', function(event) {
		  if (event.keyCode === 13) {
		    event.preventDefault();
		  };
		}, true);
	});   
</script>
    <section class="order">

        <nav>
            <h1>주문결제</h1>
            <p>
                HOME > <span>장바구니</span> > <strong>주문결제</strong>
            </p>
        </nav>

        <form action="/Kmarket//product/complete.do?uid=${sessUser.uid}" method="post">
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
                <!-- 주문 목록 -->
                <tbody>
                <c:forEach items="${orderList}" var="order">
                    <tr>
                        <td>
                            <article><a href="#"><img src="/Kmarket/file/${order.thumb1}" alt="thumb1"></a>
                                <div>
                                    <h2><a href="#">${order.prodName}</a></h2>
                                    <p>${order.descript}</p>
                                </div>
                            </article>
                        </td>
                        <td>${order.count}</td>
                        <td><fmt:formatNumber type="number" pattern="#,###" value="${order.price}"/>원</td>
                        <td>${order.discount}%</td>
                        <c:set var="disPrice" value="${order.price / 100 * order.discount}"/>
                        <td><fmt:formatNumber type="number" pattern="#,###" value="${order.point}"/>점</td>
                        <c:choose>
                        	<c:when test="${order.delivery eq 0}">
                        		<td>무료배송</td>
                        	</c:when>
                        	<c:otherwise>
                        		<td><fmt:formatNumber type="number" pattern="#,###" value="${order.delivery}"/>원</td>
                        	</c:otherwise>
                        </c:choose>
                        <td><fmt:formatNumber type="number" pattern="#,###" value="${(order.price - disPrice) * order.count + order.delivery}"/>원</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <!-- 최종결제 정보 -->
            <div class="final">
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
                        <td><input type="text" name="zip" id="zip" value="${sessUser.zip}" readonly>
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
                    <p>현재 포인트 : <span><fmt:formatNumber type="number" pattern="#,###" value="${sessUser.point}"/></span>점</p>
                    <label>
                        <input type="text" name="point" value="" style="text-align: right;">점
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