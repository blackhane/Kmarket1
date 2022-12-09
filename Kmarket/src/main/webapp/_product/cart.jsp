<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="./_header.jsp"/>
        <main id="product">
            <aside>
                <ul class="category">
                    <li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>
                    <li><a href="#"><i class="fas fa-tshirt"></i>패션·의류·뷰티</a>
                        <ol>
                            <li><a href="/Kmarket/_product/list.html">남성의류</a></li>
                            <li><a href="/Kmarket/_product/list.html">여성의류</a></li>
                            <li><a href="/Kmarket/_product/list.html">잡화</a></li>
                            <li><a href="/Kmarket/_product/list.html">뷰티</a></li>
                        </ol>
                    </li>
                    <li><a href="#"><i class="fas fa-laptop"></i>가전·디지털</a>
                        <ol>
                            <li><a href="/Kmarket/_product/list.html">노트북/PC</a></li>
                            <li><a href="/Kmarket/_product/list.html">가전</a></li>
                            <li><a href="/Kmarket/_product/list.html">휴대폰</a></li>
                            <li><a href="/Kmarket/_product/list.html">기타</a></li>
                        </ol>
                    </li>
                    <li><a href="#"><i class="fas fa-utensils"></i>식품·생필품</a>
                        <ol>
                            <li><a href="/Kmarket/_product/list.html">신선식품</a></li>
                            <li><a href="/Kmarket/_product/list.html">가공식품</a></li>
                            <li><a href="/Kmarket/_product/list.html">건강식품</a></li>
                            <li><a href="/Kmarket/_product/list.html">생필품</a></li>
                        </ol>
                    </li>
                    <li><a href="#"><i class="fas fa-home"></i>홈·문구·취미</a>
                        <ol>
                            <li><a href="/Kmarket/_product/list.html">가구/DIY</a></li>
                            <li><a href="/Kmarket/_product/list.html">침구·커튼</a></li>
                            <li><a href="/Kmarket/_product/list.html">생활용품</a></li>
                            <li><a href="/Kmarket/_product/list.html">사무용품</a></li>
                        </ol>
                    </li>
                </ul>
            </aside>

            <section class="cart">

                <nav>
                    <h1>장바구니</h1>
                    <p>
                        HOME > <span>패션·의류·뷰티</span> > <strong>장바구니</strong>
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