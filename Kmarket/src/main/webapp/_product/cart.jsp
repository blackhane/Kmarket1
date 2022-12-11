<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./_header.jsp"/>
<jsp:include page="./nagivation.jsp"/>
<script>
	$(function(){
		cartList();
		
		function cartList(){
			let uid = "${sessUser.uid}";
			
			$.ajax({
				url : '/Kmarket/product/listCart.do',
				method : 'get',
				data : {'uid' : uid},
				dataType : 'json',
				success : function(data){
					if(data == 0){
						let	tag = "<tr><td colspan='8'>장바구니에 상품이 없습니다.</td></tr>";
					}
					if(data != null){
						console.log(data);
						for(let item of data){
							let	tag = "<tr>";
								tag += "<td><input type='checkbox'></td>";
								tag += "<td><article><a href='#'><img src='https://via.placeholder.com/80x80'></a>";
								tag += "<div><h2><a href='#'>상품명</a></h2><p>상품설명</p></div></article></td>";
								tag += "<td>1</td><td>27,000</td><td>5%</td><td>270</td>";
								tag += "<td>무료배송</td><td>27,000</td></tr>";
						}
					}
				}
			});
		}
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
                                <th><input type="checkbox"name="all"></th>
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
                            <tr>
                                <td><input type="checkbox"></td>
                                <td><article><a href="#"><img src="https://via.placeholder.com/80x80" alt=""></a>
                                <div>
                                    <h2><a href="#">상품명</a></h2>
                                    <p>상품설명</p>
                                </div>
                                </article>
                                </td>
                                <td>1</td>
                                <td>27,000</td>
                                <td>5%</td>
                                <td>270</td>
                                <td>무료배송</td>
                                <td>27,000</td>
                            </tr>
                            <tr>
                                <td><input type="checkbox"></td>
                                <td><article><a href="#"><img src="https://via.placeholder.com/80x80" alt=""></a>
                                <div>
                                    <h2><a href="#">상품명</a></h2>
                                    <p>상품설명</p>
                                </div>
                                </article>
                                </td>
                                <td>1</td>
                                <td>27,000</td>
                                <td>5%</td>
                                <td>270</td>
                                <td>무료배송</td>
                                <td>27,000</td>
                            </tr>
                            <tr>
                                <td><input type="checkbox"></td>
                                <td><article><a href="#"><img src="https://via.placeholder.com/80x80" alt=""></a>
                                <div>
                                    <h2><a href="#">상품명</a></h2>
                                    <p>상품설명</p>
                                </div>
                                </article>
                                </td>
                                <td>1</td>
                                <td>27,000</td>
                                <td>5%</td>
                                <td>270</td>
                                <td>무료배송</td>
                                <td>27,000</td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="button" name="del" value="선택삭제">

                    <!-- 전체 합계 -->
                    <div class="total">
                        <h2>전체합계</h2>
                        <table border="0">
                            <tr>
                                <td>상품수</td>
                                <td>1</td>
                            </tr>
                            <tr>
                                <td>상품금액</td>
                                <td>27,000</td>
                            </tr>
                            <tr>
                                <td>할인금액</td>
                                <td>-1,000</td>
                            </tr>
                            <tr>
                                <td>배송비</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>포인트</td>
                                <td>260</td>
                            </tr>
                            <tr>
                                <td>전체주문금액</td>
                                <td>26,000</td>
                            </tr>
                        </table>
                        <input type="submit" value="주문하기">
                    </div>
                </form>
            </section>
        </main>

<jsp:include page="./_footer.jsp"/>