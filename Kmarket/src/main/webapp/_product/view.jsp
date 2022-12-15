<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./_header.jsp"/>
<jsp:include page="./nagivation.jsp"/>
<script>
	$(function(){

		//장바구니
		$('.cart').click(function(){
			let stock = '${item.stock}';
			if(stock == 0){
				alert('죄송합니다. 현 제품은 현재 재고가 없습니다.');
				return;
			}
			
			let uid = "${sessUser.uid}";
			let prodNo = "${item.prodNo}";
			let count = $('input[name=num]').val();
			let price = "${item.price}";
			let discount = "${item.discount}";
			let point = ${item.point} * count;
			let delivery = "${item.delivery}";
			let total = (price - (price/100 * discount)) * count;
			
			let jsonData = {
					'uid' : uid,
					'prodNo' : prodNo,
					'count' : count,
					'price' : price,
					'discount' : discount,
					'point' : point,
					'delivery' : delivery,
					'total' : total
			};
			
			if(uid == ''){
				let answer = confirm('로그인 후 이용가능한 기능입니다. 로그인 하시겠습니까?');
				if(answer){
					location.href = "/Kmarket/member/login.do";
				}
			}else{
				$.ajax({
					url : '/Kmarket/product/addCart.do',
					method : 'get',
					data : jsonData,
					dataType : 'json',
					success : function(data){
						if(data.result > 0){
							let answer = confirm('선택하신 상품이 장바구니에 담겼습니다.\n장바구니로 이동하시겠습니까?');
							if(answer){
								location.href = "/Kmarket/product/cart.do?uid="+uid;
								return;
							}
						}
					}			
				});
			}
		});
		
		//주문하기
		$('.order').click(function(){
			let stock = '${item.stock}';
			if(stock == 0){
				alert('죄송합니다. 현 제품은 현재 재고가 없습니다.');
				return;
			}
			
			let uid = "${sessUser.uid}";
			let count = $('input[name=num]').val();
			if(uid == ''){
				let answer = confirm('로그인 후 이용가능한 기능입니다. 로그인 하시겠습니까?');
				if(answer){
					location.href = "/Kmarket/member/login.do";
				}
			}else{
				location.href = "/Kmarket/product/order.do?prodNo="+${item.prodNo}+"&count="+count;
			}
		});
		
		function delivery(){
			//오늘
			let today = new Date();
			
			//3일 뒤
			let after = new Date(today);
			after.setDate(today.getDate() + 3);
				
			let Month = after.getMonth() +1;
			let Day = after.getDate();
			const week = ['일','월','화','수','목','금','토'];
			let DayOfWeek = week[after.getDay()];
		
			$('.arrival').text("모레("+DayOfWeek+") "+Month+"/"+Day+" 도착예정");
		}
		delivery();
		
		function total(){
			let count = $('input[name=num]').val();
			let price = $('.dis_price').children('ins.ori').text();
			let total = (count*price).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
			console.log(total);
			$('.totalPrice').text(total);
		}
		total();
		
		$('.decrease').click(function(){
			let num = $('input[name=num]').val();
			if(num == 1){
				alert('1개 이상부터 주문 가능합니다.');
				return;
			}
			num--;
			$('input[name=num]').val(num);
			total();
		});
		
		$('.increase').click(function(){
			let num = $('input[name=num]').val();
			if(num == 20){
				alert('주문 가능한 최대 수량은 20개 입니다.');
				return;
			}
			num++;
			$('input[name=num]').val(num);
			total();
		});
		
	});
</script>
            <section class="view">
                <nav>
                    <h1>상품보기</h1>
                    <p>HOME > <span>${cate.c1Name}</span> > <strong>${cate.c2Name}</strong></p>
                </nav>

                <article class="info">
                    <div class="image">
                        <img src="/Kmarket/file/${item.thumb3}" alt="thumb3" />
                    </div>
                    <div class="summary">
                        <nav>
                            <h1>${item.company}</h1>
                            <h2>상품번호&nbsp;:&nbsp;<span>${item.prodNo}</span></h2>
                        </nav>
                        <nav>
                            <h3>${item.prodName}</h3>
                            <p>${item.descript}</p>
                            <c:choose>
                            	<c:when test="${item.score ge 5}">
                            		<h5 class="rating star5">${item.score}<a href="#review">상품평보기</a></h5>
                            	</c:when>
                            	<c:when test="${item.score ge 4}">
                            		<h5 class="rating star4">${item.score}<a href="#review">상품평보기</a></h5>
                            	</c:when>
                            	<c:when test="${item.score ge 3}">
                            		<h5 class="rating star3">${item.score}<a href="#review">상품평보기</a></h5>
                            	</c:when>
                            	<c:when test="${item.score ge 2}">
                            		<h5 class="rating star2">${item.score}<a href="#review">상품평보기</a></h5>
                            	</c:when>
                            	<c:when test="${item.score ge 1}">
                            		<h5 class="rating star1">${item.score}<a href="#review">상품평보기</a></h5>
                            	</c:when>
                            	<c:otherwise>
                            		<h5 class="rating star0">${item.score}<a href="#review">상품평보기</a></h5>
                            	</c:otherwise>
                            </c:choose>
                            
                        </nav>
                        <nav>
                        <c:choose>
                        	<c:when test="${item.discount gt 0}">
	                            <div class="org_price">
	                                <del><fmt:formatNumber type="number" pattern="#,###" value="${item.price}"/></del>
	                                <span>${item.discount}%</span>
	                            </div>
	                            <div class="dis_price">
	                                <ins class="ori" style="display:none;">
	                                	<fmt:formatNumber type="number" pattern="0" value="${item.price - (item.price/100 *item.discount)}"/>
	                                </ins>
	                                <ins>
	                                	<fmt:formatNumber type="number" pattern="#,###" value="${item.price - (item.price/100 *item.discount)}"/>
                                	</ins>
	                            </div>
                            </c:when>
                            <c:otherwise>
                            	<div class="dis_price">
	                                <ins class="ori" style="display:none;">
	                                	<fmt:formatNumber type="number" pattern="0" value="${item.price}"/>
	                                </ins>
	                                <ins>
	                                	<fmt:formatNumber type="number" pattern="#,###" value="${item.price}"/>
	                                </ins>
                            	</div>
                            </c:otherwise>
                        </c:choose>
                        </nav>
                        <nav>
                        	<c:choose>
                        		<c:when test="${item.delivery eq 0}">
                        			<span class="delivery">무료배송</span>
                        		</c:when>
                        		<c:otherwise>
                        			<span class="delivery">배송비 ${item.delivery}원</span>
                        		</c:otherwise>
                        	</c:choose>
                            <span class="arrival"></span>
                            <span class="desc">본 상품은 국내배송만 가능합니다.</span>
                        </nav>
                        <nav>
                            <span class="card cardfree"><i>아이콘</i>무이자할부</span>&nbsp;&nbsp;
                            <span class="card cardadd"><i>아이콘</i>카드추가혜택</span>
                        </nav>
                        <nav>
                            <span class="origin">원산지-상세설명 참조</span>
                        </nav>
                        <img src="/Kmarket/img/img_main/vip_plcc_banner.png" alt="100원만 결제해도 1만원 적립!" class="banner" />

                        <div class="count">
                            <button class="decrease">-</button>
                            <input type="text" name="num" value="1" readonly />
                            <button class="increase">+</button>
                        </div>

                        <div class="total">
                            <span class="totalPrice">35,000</span>
                            <em>총 상품금액</em>
                        </div>

                        <div class="button">
                            <input type="button" class="cart" value="장바구니" />
                            <input type="button" class="order" value="구매하기" />
                        </div>
                    </div>
                </article>

                <article class="detail">
                    <nav>
                        <h1>상품정보</h1>
                    </nav>
                    <img src="/Kmarket/file/${item.detail}" alt="detail">
                </article>

                <article class="notice">
                    <nav>
                        <h1>상품 정보 제공 고시</h1>
                        <p>[전자상거래에 관한 상품정보 제공에 관한 고시] 항목에 의거 등록된 정보입니다.</p>
                    </nav>
                    <table border="0">
                        <tr>
                            <td>상품번호</td>
                            <td>${item.prodNo}</td>
                        </tr>
                        <tr>
                            <td>상품상태</td>
                            <td>${item.status}</td>
                        </tr>
                        <tr>
                            <td>부가세 면세여부</td>
                            <td>${item.duty}</td>
                        </tr>
                        <tr>
                            <td>영수증발행</td>
                            <td>${item.receipt}</td>
                        </tr>
                        <tr>
                            <td>사업자구분</td>
                            <td>${item.bizType}</td>
                        </tr>
                        <tr>
                            <td>브랜드</td>
                            <td>${item.brand}</td>
                        </tr>
                        <tr>
                            <td>원산지</td>
                            <td>국내생산</td>
                        </tr>
                    </table>
                    <table border="0">
                        <tr>
                            <td>제품소재</td>
                            <td>${item.material}</td>
                        </tr>
                        <tr>
                            <td>색상</td>
                            <td>${item.color}</td>
                        </tr>
                        <tr>
                            <td>치수</td>
                            <td>${item.size}</td>
                        </tr>
                        <tr>
                            <td>제조자/수입국</td>
                            <td>${item.manufacturer}</td>
                        </tr>
                        <tr>
                            <td>제조국</td>
                            <td>${item.country}</td>
                        </tr>
                        <tr>
                            <td>취급시 주의사항</td>
                            <td>${item.precautions}</td>
                        </tr>
                        <tr>
                            <td>제조연월</td>
                            <td>${item.date}</td>
                        </tr>
                        <tr>
                            <td>품질보증기준</td>
                            <td>${item.standard}</td>
                        </tr>
                        <tr>
                            <td>A/S 책임자와 전화번호</td>
                            <td>${item.as}</td>
                        </tr>
                        <tr>
                            <td>주문후 예상 배송기간</td>
                            <td>${item.delivery_date}</td>
                        </tr>
                        <tr>
                            <td colspan="2">구매, 교환, 반품, 배송, 설치 등과 관련하여 추가비용, 제한조건 등의 특이사항이 있는 경우</td>
                        </tr>
                    </table>
                    <p class="notice">
                        소비자가 전자상거래등에서 소비자 보호에 관한 법률 제 17조 제1항 또는 제3항에 따라 청약철회를 하고
                        동법 제 18조 제1항 에 따라 청약철회한 물품을 판매자에게 반환하였음에도 불구 하고 결제 대금의
                        환급이 3영업일을 넘게 지연된 경우, 소비자 는 전자상거래등에서 소비자보호에 관한 법률 제18조
                        제2항 및 동법 시행령 제21조 2에 따라 지연일수에 대하여 전상법 시행령으로 정하는 이율을 곱하여
                        산정한 지연이자(“지연배상금”)를 신청할 수 있습니다. 아울러, 교환∙반품∙보증 및 결제대금의
                        환급신청은 [나의쇼핑정보]에서 하실 수 있으며, 자세한 문의는 개별 판매자에게 연락하여 주시기 바랍니다.
                    </p>
                </article>

                <article class="review" id="review">
                    <nav>
                        <h1>상품리뷰</h1>
                    </nav>
                    <ul>
                        <li>
                            <div>
                                <h5 class="rating star4">상품평</h5>
                                <span>seo****** 2018-07-10</span>
                            </div>
                            <h3>상품명1/BLUE/L</h3>
                            <p>
                                가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요.
                                아주 약간 루즈한정도...?그래도 이만한 옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는
                                제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~
                            </p>
                        </li>
                        <li>
                            <div>
                                <h5 class="rating star4">상품평</h5>
                                <span>seo****** 2018-07-10</span>
                            </div>
                            <h3>상품명1/BLUE/L</h3>
                            <p>
                                가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요.
                                아주 약간 루즈한정도...?그래도 이만한 옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는
                                제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~
                            </p>
                        </li>
                        <li>
                            <div>
                                <h5 class="rating star4">상품평</h5>
                                <span>seo****** 2018-07-10</span>
                            </div>
                            <h3>상품명1/BLUE/L</h3>
                            <p>
                                가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요.
                                아주 약간 루즈한정도...?그래도 이만한 옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는
                                제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~
                            </p>
                        </li>
                        <li>
                            <div>
                                <h5 class="rating star4">상품평</h5>
                                <span>seo****** 2018-07-10</span>
                            </div>
                            <h3>상품명1/BLUE/L</h3>
                            <p>
                                가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요.
                                아주 약간 루즈한정도...?그래도 이만한 옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는
                                제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~
                            </p>
                        </li>
                        <li>
                            <div>
                                <h5 class="rating star4">상품평</h5>
                                <span>seo****** 2018-07-10</span>
                            </div>
                            <h3>상품명1/BLUE/L</h3>
                            <p>
                                가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요.
                                아주 약간 루즈한정도...?그래도 이만한 옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는
                                제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~
                            </p>
                        </li>
                    </ul>
                    <div class="paging">
                        <span class="prev">
                            <a href="#">
                                <&nbsp;이전</a>
                        </span>
                        <span class="num">
                            <a href="#" class="on">1</a>
                            <a href="#">2</a>
                            <a href="#">3</a>
                            <a href="#">4</a>
                            <a href="#">5</a>
                            <a href="#">6</a>
                            <a href="#">7</a>
                        </span>
                        <span class="next">
                            <a href="#">다음&nbsp;></a>
                        </span>
                    </div>

                </article>

            </section>
        </main>

 <jsp:include page="./_footer.jsp"/>