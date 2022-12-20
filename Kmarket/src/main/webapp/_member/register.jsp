<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="./_header.jsp"/>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/Kmarket/js/postcode.js"></script>
<script src="/Kmarket/js/register.js"></script>
        <main>
            <div class="registerForm">
                <div>
                    <p>일반 회원가입</p>
                </div>
                <form action="/Kmarket/member/register.do" method="post">
                <div>
                    <table>
                        <tr>
                            <th colspan="2">필수 정보입력</th>
                        </tr>
                        <tr>
                            <td><span>*</span> 아이디</td>
                            <td><input type="text" name="uid" placeholder="아이디를 입력하세요.">&nbsp;&nbsp;<p class="resultId">영문,숫자로 이루어진 4~12자까지 설정해주세요.</p></td>
                        </tr>
                        <tr>
                            <td><span>*</span> 비밀번호</td>
                            <td><input type="password" name="pass1" placeholder="비밀번호를 입력하세요.">&nbsp;&nbsp;<p class="resultPw1">영문,숫자,특수문자를 조합하여 8~12자리까지 설정해주세요.</p></td>
                        </tr>
                        <tr>
                            <td><span>*</span> 비밀번호 확인</td>
                            <td><input type="password" name="pass2" placeholder="비밀번호를 한번 더 입력하세요.">&nbsp;&nbsp;<p class="resultPw2"></p></td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <th colspan="2">기본 정보입력</th>
                        </tr>
                        <tr>
                            <td><span>*</span> 이름</td>
                            <td><input type="text" name="name" placeholder="이름을 입력하세요.">&nbsp;&nbsp;<p class="resultName"></p></td>
                        </tr>
                        <tr>
                            <td><span>*</span> 성별</td>
                            <td>
	                            <label><input type="radio" name="gender" value="1"> 남</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                            <label><input type="radio" name="gender" value="2"> 여</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                            <label><input type="radio" name="gender" value="3"> 선택안함</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                            <p class="resultGender"></p>
                            </td>
                        </tr>
                        <tr>
                            <td><span>*</span> EMAIL</td>
                            <td><input type="text" name="email" placeholder="이메일을 입력하세요.">&nbsp;&nbsp;<p class="resultEmail"></p></td>
                        </tr>
                        <tr>
                            <td><span>*</span> 휴대폰</td>
                            <td><input type="text" name="hp" placeholder="휴대폰을 입력하세요.">&nbsp;&nbsp;<p class="resultHp">- 포함 13자리를 입력하세요.</p></td>
                        </tr>
                        <tr>
                            <td>주소</td>
                            <td>
                                <input type="text" class="addr" name="zip" id="zip" placeholder="우편번호 입력 클릭" style="cursor: pointer; outline:none;"><br/>
                                <input type="text" class="addr" name="addr1" id="addr1" placeholder="주소를 검색하세요." readonly><br/>
                                <input type="text" class="addr" name="addr2" id="addr2" placeholder="상세주소를 입력하세요.">
                            </td>
                        </tr>
                    </table>
                    <div>
                        <button type="submit" class="btnRegister">회원가입</button>
                    </div>
                </div>
                </form>
            </div>
        </main>
<jsp:include page="./_footer.jsp"/>