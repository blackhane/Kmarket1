<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./_header.jsp"/>
<jsp:include page="./nagivation.jsp"/>
<script>
	$(function(){
		
		let uid = "${sessUser.uid}";
		if(uid == ''){
			$('.cartList').hide();
			$('.total').hide();
		}
		
		$('.all').click(function(){
			if($(this).is(":checked")){
				$('.chk').prop("checked",true);
			}else{
				$('.chk').prop("checked",false);
			}
		});
		
		$('.cartDelete').click(function(){
			let answer = confirm('장바구니에서 삭제하시겠습니까?');
			if(answer){
				let checkBoxArr = [];
				let formData = new FormData();
				$('input[name=chk]:checked').each(function(i){
					checkBoxArr.push($(this).val());
				});
				
				let jsonData = Object.assign({}, checkBoxArr);
				console.log(jsonData);

				$.ajax({
					url : '/Kmarket/product/deleteCart.do',
					method : 'get',
					data : jsonData,
					dataType : 'json',
					success : function(data){
						console.log(data.result);
					}
				});
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
    
    <form action="#">
        <table>
            <thead>
                <tr>
                    <th><input type="checkbox"name="all" class="all"></th>
                    <th>상품명</th>
                    <th>총수량</th>
                    <th>판매가</th>
                    <th>할인</th>
                    <th>포인트</th>
                    <th>배송비</th>
                    <th>소계</th>
                </tr>
            </thead>
            <c:if test="${sessUser.uid == null}">
            	<tr>
            		<td colspan="8" rowspan="5" align="center" style="height:100px;">로그인을 하시면, 장바구니에 보관된 상품을 확인하실 수 있습니다.</td>
            	</tr>
            </c:if>
            <!-- 장바구니 목록 -->
            <tbody class="cartList">
            <c:forEach items="${cart}" var="cart">
                <tr>
                    <td><input type="checkbox" class="chk" name="chk" value="${cart.cartNo}"></td>
                    <td><article><a href="#"><img src="/Kmarket/${cart.thumb1}" alt="thumb1"></a>
                    <div>
                        <h2><a href="#">${cart.prodName}</a></h2>
                        <p>${cart.descript}</p>
                    </div>
                    </article>
                    </td>
                    <td>${cart.count}</td>
                    <td>${cart.price}</td>
                    <td>${cart.discount}%</td>
                    <td>${cart.point}</td>
                    <c:choose>
                    	<c:when test="${cart.delivery eq 0}">
                    		<td>무료배송</td>
                    	</c:when>
                    	<c:otherwise>
                    		<td>${cart.delivery}</td>
                    	</c:otherwise>
                    </c:choose>
                    <td>${cart.total}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <input type="button" name="del" value="선택삭제" class="cartDelete">

        <!-- 전체 합계 -->
            <div class="total">
                <h2>전체합계</h2>
                <table border="0">
                    <tr>
                        <td>상품수</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>상품금액</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>할인금액</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>배송비</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>포인트</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>전체주문금액</td>
                        <td></td>
                    </tr>
                </table>
                <input type="submit" value="주문하기">
            </div>
        </form>
    </section>
</main>
<jsp:include page="./_footer.jsp"/>