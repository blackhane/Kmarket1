<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./_header.jsp"/>
<jsp:include page="./nagivation.jsp"/>
    <section class="complete">
        <nav>
            <h1>주문완료</h1>
            <p>
                HOME > <span>장바구니</span> > <strong>주문결제</strong>> <strong>주문완료</strong>
            </p>
        </nav>

        <!-- 주문 완료 알림 -->
        <article class="message">
            <h2>고객님의 주문이 정상적으로 완료되었습니다.<i class="far fa-smile"></i></h2>
            <p>즐거운 쇼핑이 되셨습니까? 항상 고객님을 최우선으로 생각하는 케이마켓이 되겠습니다.</p>
        </article>

        <!-- 상품정보 -->
        <article class="info">
            <h1>상품정보</h1>
            <table border="0">
                <tr>
                    <th>상품명</th>                                    
                    <th>상품금액</th>
                    <th>할인금액</th>
                    <th>수량</th>
                    <th>주문금액</th>
                </tr>
                <c:forEach items="${sessItem}" var="item">
                <tr>
                    <td>
                        <article><img src="/Kmarket/file/${item.thumb1}" alt="thumb1">
                            <div>
                                <h2><a href="#">${item.prodName}</a></h2>
                                <p>${item.descript}</p>
                            </div>
                        </article>
                    </td>
                    <td><fmt:formatNumber type="number" pattern="#,###" value="${item.price}"/>원</td>
                    <td><fmt:formatNumber type="number" pattern="#,###" value="${(item.price/100*item.discount)}"/>원</td>
                    <td>${item.count}</td>
                    <td><fmt:formatNumber type="number" pattern="#,###" value="${(item.price - (item.price/100*item.discount))*item.count}"/>원</td>
                </tr>
                </c:forEach>
                <tr class="total">
                    <td colspan="4"></td>
                    <td>
                        <table border="0">
                            <tr>
                                <td>총 상품금액</td>
                                <td><span><fmt:formatNumber type="number" pattern="#,###" value="${order.ordPrice}"/></span>원</td>
                            </tr>
                            <tr>
                                <td>총 할인금액</td>
                                <td><span><fmt:formatNumber type="number" pattern="#,###" value="${order.ordDiscount}"/></span>원</td>
                            </tr>
                            <tr>
                                <td>배송비</td>
                                <td><span><fmt:formatNumber type="number" pattern="#,###" value="${order.ordDelivery}"/></span>원</td>
                            </tr>
                            <tr>
                                <td>총 결제금액</td>
                                <td><span><fmt:formatNumber type="number" pattern="#,###" value="${order.totalPrice}"/></span>원</td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </article>

            <!-- 배송정보 -->
            <article class="delivery">
                <h1>배송정보</h1>
                <table>
                    <tr>
                        <td>수취인</td>
                        <td>${order.recipName}</td>
                        <td>주문자 정보</td>
                    </tr>
                    <tr>
                        <td>연락처</td>
                        <td>${order.recipHp }</td>
                        <td rowspan="2">
                            ${sessUser.name}<br>
                            ${sessUser.hp}
                        </td>
                    </tr>
                    <tr>
                        <td>배송지 주소</td>
                        <td>${order.recipZip} ${order.recipAddr1} ${order.recipAddr2} </td>
                    </tr>
                </table>
                </article>

            <!-- 꼭 알아두세요. -->
            <article class="alert">
                <h1>꼭 알아두세요.</h1>
                <ul>
                    <li><span>케이마켓은 통신판매중개자이며 통신판매의 당사자가 아닙니다. 따라서 케이마켓은 상품, 거래정보 및 거래에 대하여 책임을 지지 않습니다.</span></li>
                    <li><span>구매주문내역, 배송상태 확인, 구매영수증 출력, 구매취소/반품/교환은 사이트 상단의 주문/배송조회에서 확인 할 수 있습니다.</span></li>
                    <li><span>고객님의 주문이 체결된 후 상품품절 및 단종 등에 의해 배송이 불가능할 경우, 전자상거래등에서의 소비자 보호에 관한 법률 제15조 2항에 의거하여 3영업일(공휴일 제외) 이내에 자동으로 취소될 수 있으며, 이 경우 취소 안내 메일이 고객님께 발송되오니 양지 바랍니다.</span></li>
                    <li><span>극히 일부 상품에 대해 수량부족, 카드결제승인 오류등의 사례가 간혹 있을 수 있으니 `나의쇼핑정보`에서 다시 한번 확인해 주세요.</span></li>
                    <li><span>현금잔고로 구매하셨을 경우, 나의 쇼핑정보에서 입금확인이 되었는지를 다시 한번 확인해 주세요.</span></li>
                    <li><span>배송주소를 추가하거나 변경, 삭제 등의 관리는 `나의쇼핑정보 > 나의정보` 에서 가능합니다.</span></li>
                </ul>
            </article>
    </section>
</main>
  <jsp:include page="./_footer.jsp"/>