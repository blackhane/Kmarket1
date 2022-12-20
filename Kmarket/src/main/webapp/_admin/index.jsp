<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/_admin/_header.jsp"/>
            
            <section id="admin-index">
                <nav>
                    <h3>관리자 메인</h3>
                    <p>
                        HOME > <strong>메인</strong>
                    </p>
                </nav>
                <h4>쇼핑몰 운영현황</h4>
                <article>
                    <table>
                        <tbody>
                            <tr>
                                <td>
                                    <strong>주무건수(건)</strong>
                                    <span>131</span>
                                </td>
                                <td>
                                    <strong>주무건수(건)</strong>
                                    <span>131</span>
                                </td>
                                <td>
                                    <strong>주무건수(건)</strong>
                                    <span>131</span>
                                </td>
                                <td>
                                    <strong>주무건수(건)</strong>
                                    <span>131</span>
                                </td>
                                <td>
                                    <strong>주무건수(건)</strong>
                                    <span>131</span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>
                                        <span>PC</span>
                                        <span>60</span>
                                    </p>
                                    <p>
                                        <span>Mobile</span>
                                        <span>60</span>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <span>PC</span>
                                        <span>60</span>
                                    </p>
                                    <p>
                                        <span>Mobile</span>
                                        <span>60</span>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <span>PC</span>
                                        <span>60</span>
                                    </p>
                                    <p>
                                        <span>Mobile</span>
                                        <span>60</span>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <span>PC</span>
                                        <span>60</span>
                                    </p>
                                    <p>
                                        <span>Mobile</span>
                                        <span>60</span>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <span>PC</span>
                                        <span>60</span>
                                    </p>
                                    <p>
                                        <span>Mobile</span>
                                        <span>60</span>
                                    </p>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>
                                        <span>어제</span>
                                        <span>4</span>
                                    </p>
                                    <p>
                                        <span>주간</span>
                                        <span>10</span>
                                    </p>
                                    <p>
                                        <span>월간</span>
                                        <span>30</span>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <span>어제</span>
                                        <span>4</span>
                                    </p>
                                    <p>
                                        <span>주간</span>
                                        <span>10</span>
                                    </p>
                                    <p>
                                        <span>월간</span>
                                        <span>30</span>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <span>어제</span>
                                        <span>4</span>
                                    </p>
                                    <p>
                                        <span>주간</span>
                                        <span>10</span>
                                    </p>
                                    <p>
                                        <span>월간</span>
                                        <span>30</span>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <span>어제</span>
                                        <span>4</span>
                                    </p>
                                    <p>
                                        <span>주간</span>
                                        <span>10</span>
                                    </p>
                                    <p>
                                        <span>월간</span>
                                        <span>30</span>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <span>어제</span>
                                        <span>4</span>
                                    </p>
                                    <p>
                                        <span>주간</span>
                                        <span>10</span>
                                    </p>
                                    <p>
                                        <span>월간</span>
                                        <span>30</span>
                                    </p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </article>
                <h4>주문 업무현황</h4>
                <article>
                    <table>
                        <tbody>
                            <tr>
                                <td>
                                    <strong>입금대기(건)</strong>
                                    <span>100</span>
                                </td>
                                <td>
                                    <strong>입금대기(건)</strong>
                                    <span>100</span>
                                </td>
                                <td>
                                    <strong>입금대기(건)</strong>
                                    <span>100</span>
                                </td>
                                <td>
                                    <strong>입금대기(건)</strong>
                                    <span>100</span>
                                </td>
                                <td>
                                    <strong>입금대기(건)</strong>
                                    <span>100</span>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </article>
                <div>
                    <div>
                        <h4>공지사항</h4>
                        <article>
                        	<c:forEach var="item" items="${notice}">
					            <tr>
					                <td><input type="checkbox" name="all"></td>
	                           		<td>${item.no}</td>
		                            <td>${item.cate}</td>
		                            <td><a href="/Kmarket/admin/cs/notice/view.do?no=${item.no}">${item.title}</a></td>
		                            <td>${item.hit}</td>
		                            <td>${item.rdate}</td>
									<td>
		                                <a href="/Kmarket/admin/cs/notice/delete.do?no=${item.no}">[삭제]</a>
		                                <a href="/Kmarket/admin/cs/notice/modify.do?no=${item.no}">[수정]</a>
	                          		</td>
					            </tr>
		           			 </c:forEach>
                            <p>
                                <span>[공지] 케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.</span>
                                <span>20-07-08 12:23</span>
                            </p>
                            <p>
                                <span>[공지] 1주년 기념 신규가입 사은품 안내</span>
                                <span>20-07-08 12:23</span>
                            </p>
                            <p>
                                <span>[공지] 케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.</span>
                                <span>20-07-08 12:23</span>
                            </p>
                            <p>
                                <span>[공지] 케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.</span>
                                <span>20-07-08 12:23</span>
                            </p>
                            <p>
                                <span>[공지] 케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.</span>
                                <span>20-07-08 12:23</span>
                            </p>
                            <p>
                                <span>[공지] 케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.</span>
                                <span>20-07-08 12:23</span>
                            </p>
                        </article>
                    </div>
                    <div>
                        <h4>고객문의</h4>
                        <article>
                            <p>
                                <span>[공지] 케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.</span>
                                <span>20-07-08 12:23</span>
                            </p>
                            <p>
                                <span>[공지] 케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.</span>
                                <span>20-07-08 12:23</span>
                            </p>
                            <p>
                                <span>[공지] 케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.</span>
                                <span>20-07-08 12:23</span>
                            </p>
                            <p>
                                <span>[공지] 케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.</span>
                                <span>20-07-08 12:23</span>
                            </p>
                            <p>
                                <span>[공지] 케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.</span>
                                <span>20-07-08 12:23</span>
                            </p>
                            <p>
                                <span>[공지] 케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.케이마켓 판매자님들은 주기적인 비밀번호 변경을 하세요.</span>
                                <span>20-07-08 12:23</span>
                            </p>
                        </article>
                    </div> 
                </div>
            </section>
        </main>
<jsp:include page="/_admin/_footer.jsp"/>
        