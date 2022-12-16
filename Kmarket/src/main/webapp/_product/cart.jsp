<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./_header.jsp"/>
<jsp:include page="./nagivation.jsp"/>
<script src="/Kmarket/js/cart.js"></script>
<script>
	$(function(){
		let count = 0;
		let price = 0;
		let disPrice = 0;
		let delivery = 0;
		let point = 0;
		let totalPrice = 0;
		
		let uid = "${sessUser.uid}";
		if(uid == ''){
			$('.cartList').hide();
			$('.total').hide();
		}
		
		//장바구니 합계 정보창
		if(uid != null){
			allCart();
			totalCart();
		}
		
		//장바구니 체크된것만 합계
		function sumCart(){
			count = 0;
			price = 0;
			disPrice = 0;
			delivery = 0;
			point = 0;
			totalPrice = 0;
			
			let cartNo = new Array();
			$('input[name=chk]:checked').each(function(){
				cartNo.push($(this).data("no"));
			});
			
			cartNo.forEach(function(number){
				<c:forEach items="${cart}" var="cart">
				console.log(number);
				console.log(${cart.cartNo});
				if(number == ${cart.cartNo}){
					count += ${cart.count};
					price += ${cart.price} * ${cart.count};
					disPrice += ${cart.disPrice} * -1 * ${cart.count};
					delivery += ${cart.delivery};
					point += ${cart.point};
					totalPrice += (${cart.price} + (${cart.disPrice} * -1) + ${cart.delivery} ) * ${cart.count};
				}
				</c:forEach>
			});
		}

		//장바구니 전체 합계
		function allCart(){
			count = 0;
			price = 0;
			disPrice = 0;
			delivery = 0;
			point = 0;
			totalPrice = 0;
			
			let allNo = new Array();
			$('.chk').each(function(){
				allNo.push($(this).data("no"));
			});
			
			allNo.forEach(function(number){
				<c:forEach items="${cart}" var="cart">
				if(number == ${cart.cartNo}){
					count += ${cart.count};
					price += ${cart.price} * ${cart.count};
					disPrice += ${cart.disPrice} * -1 * ${cart.count};
					delivery += ${cart.delivery};
					point += ${cart.point};
					totalPrice += (${cart.price} + (${cart.disPrice} * -1) + ${cart.delivery} ) * ${cart.count};
				}
				</c:forEach>
			});
		}
			
		function totalCart(){
   			let tag = "<h2>전체합계</h2>";
			tag += "<table>";
			tag += "<tr>";
			tag += "<td>상품수</td>";
			tag += "<td>"+count.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+"건</td>";
			tag += "</tr>";
			tag += "<tr>";
			tag += "<td>상품금액</td>";
			tag += "<td>"+price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+"원</td>";
			tag += "</tr>";
			tag += "<tr>";
			tag += "<td>할인금액</td>";
			tag += "<td>"+disPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+"원</td>";
			tag += "</tr>";
			tag += "<tr>";
			tag += "<td>배송비</td>";
			tag += "<td>"+delivery.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+"원</td>";
			tag += "</tr>";
			tag += "<tr>";
			tag += "<td>포인트</td>";
			tag += "<td>"+point.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+"점</td>";
			tag += "</tr>";
			tag += "<tr>";
			tag += "<td>전체주문금액</td>";
			tag += "<td>"+totalPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+"원</td>";
			tag += "</tr>";
			tag += "</table>";
			tag += "<input type='submit' class='orderCart' value='주문하기'>";
			tag += "</div>";
			$('.total').append(tag);
		}
		
		//주문하기 클릭
		$('form').submit(function(){
			
			//장바구니에 물건이 없으면
			if($('.chk').length == 0){
				alert('장바구니에 등록된 상품이 없습니다.');
				return false;
			}
			
			//물건 체크된 값이 없으면 전체 체크
			if($('input[name=chk]:checked').length == 0){
				$('.chk').prop("checked",true);
			}
			
			let ordArray = new Array();
			
			$('input[name=chk]:checked').each(function(){
				ordArray.push($(this).data("no"));
			});
			let jsonData =  {'jsonData' : ordArray};
			console.log(jsonData);
			alert('');
			$.ajax({
				url : '/Kmarket/product/order.do',
				method : 'post',
				data : {'jsonData' : ordArray}, 
				traditional : true,
				dataType : 'data'
			});
		});

		//전체선택
		$('.all').click(function(){
			if($(this).is(":checked")){
				$('.chk').prop("checked",true);
			}else{
				$('.chk').prop("checked",false);
			}
			$('.total').empty();
			allCart();
			totalCart();
		});

		//선택해제
		$('.chk').click(function(){
			$('.all').prop("checked",false);
			$('.total').empty();
			if($('input[name=chk]').is(':checked')){
				sumCart();
			}else{
				allCart();
			}
			if($('input[name=chk]:checked').length == $('.chk').length){
				$('.all').prop("checked",true);
			}
			totalCart();
		});
		

		//선택삭제
		$('.cartDelete').click(function(){
			if($('input[name=chk]:checked').length == 0){
				alert('선택된 상품이 없습니다.');
				return;
			}
			
			let answer = confirm('장바구니에서 삭제하시겠습니까?');
			if(answer){
				let checkArr = new Array();
				$('input[name=chk]:checked').each(function(){
					checkArr.push($(this).val());
				});
				
				allCart();
				checkArr.forEach(function(number){
					<c:forEach items="${cart}" var="cart">
					if(number == ${cart.cartNo}){
						count -= ${cart.count};
						price -= ${cart.price} * ${cart.count};
						disPrice -= ${cart.disPrice} * -1 * ${cart.count};
						delivery -= ${cart.delivery};
						point -= ${cart.point};
						totalPrice -= (${cart.price} + (${cart.disPrice} * -1) + ${cart.delivery} ) * ${cart.count};
					}
					</c:forEach>
				});
				
				$.ajax({
					url : '/Kmarket/product/cartHelper.do',
					method : 'get',
					traditional: true,					
					data : {'chkBox' : checkArr},
					dataType : 'json',
					success : function(data){
						if(data.result > 0){
							$('input[name=chk]:checked').parent().parent().remove();
							let chk = document.getElementsByName('chk');
							console.log("chk : "+chk);
							$('.total').empty();
							totalCart();
							if(chk.length == 0){
								let tag = "<tr><td colspan='8' rowspan='5' align='center' style='height:95px; color:black;'>장바구니에 등록된 상품이 없습니다.</td></tr>";
								$('.cartList').append(tag);
							}
						}
					}
				});
				alert('삭제되었습니다.');
				$('.all').prop("checked",false);
				$('.total').empty();
				totalCart();
			}
		});
		
	});
</script>
<section class="cart">
	<nav>
	    <h1>장바구니</h1>
	    <p>
	        HOME > <strong>장바구니</strong>
	    </p>
	</nav>
    
	<form action="/Kmarket/product/order.do" method="post"/>
	    <table>
	        <thead>
	            <tr>
	                <th><input type="checkbox"name="all" class="all" ></th>
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
        <!-- 로그인을 하지 않았을 때 -->
        <c:if test="${sessUser.uid eq null}">
     	<tr>
     		<td colspan="8" rowspan="5" align="center" style="height:95px; color:black;">로그인을 하시면, 장바구니에 보관된 상품을 확인하실 수 있습니다.</td>
     	</tr>
    	</c:if>
    	<!-- 로그인을 했을 때 -->
		<tbody class="cartList">
		<!-- 장바구니에 상품이 없을 때 && 로그인을 했을 때 -->
		 <c:if test="${cart.size() eq 0 && sessUser.uid ne null}">
			<tr>
				<td colspan="8" rowspan="5" align="center" style="height:95px; color:black;">장바구니에 등록된 상품이 없습니다.</td>
			</tr>
		</c:if>
		<!--  장바구니에 상품이 있을 때 -->
		<c:forEach items="${cart}" var="cart">
		    <tr>
		        <td>
		        	<input type="checkbox" class="chk" name="chk" value="${cart.prodNo}" data-no="${cart.cartNo}">
		        	<input type="hidden" name="count" value="${cart.count}" data-no="${cart.cartNo}">		
		        </td>
		        <td><article><a href="#"><img src="/Kmarket/file/${cart.thumb1}" alt="thumb1"></a>
		        <div>
		            <h2><a href="#">${cart.prodName}</a></h2>
		            <p>${cart.descript}</p>
		        </div>
		        </article>
		        </td>
		        <td>${cart.count}</td>
		        <td><fmt:formatNumber type="number" pattern="#,###" value="${cart.price}"/>원</td>
		        <td>${cart.discount}%</td>
		        <td><fmt:formatNumber type="number" pattern="#,###" value="${cart.point}"/>점</td>
		        <c:choose>
		        	<c:when test="${cart.delivery eq 0}">
		        		<td>무료배송</td>
		        	</c:when>
		        	<c:otherwise>
		        		<td><fmt:formatNumber type="number" pattern="#,###" value="${cart.delivery}"/>원</td>
		        	</c:otherwise>
		        </c:choose>
		        <td><fmt:formatNumber type="number" pattern="#,###" value="${cart.total}"/>원</td>
		    </tr>
		</c:forEach>
		</tbody>
	</table>
	<input type="button" name="del" value="선택삭제" class="cartDelete">
	<!-- 전체 합계 -->
	<div class="total"></div>
	</form>
</section>
</main>
<jsp:include page="./_footer.jsp"/>