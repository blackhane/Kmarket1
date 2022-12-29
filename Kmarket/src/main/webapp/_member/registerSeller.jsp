<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="./_header.jsp"/>
<script src="/Kmarket/js/postcode.js"></script>
<script src="/Kmarket/js/registerSeller.js"></script>
        <main>
            <div class="registerForm">
                <div>
                    <p>판매자 회원가입</p>
                </div>
            	<form action="/Kmarket/member/registerSeller.do" method="post">
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
                            <th colspan="2">판매자 정보입력</th>
                        </tr>
                        <tr>
                            <td><span>*</span> 회사명</td>
                            <td><input type="text" name="company" placeholder="회사명을 입력해주세요.">&nbsp;&nbsp;<p class="resultCompany">(주)포함 입력, 예) (주)케이마켓</p></td>
                        </tr>
                        <tr>
                            <td><span>*</span> 대표자</td>
                            <td><input type="text" name="ceo" placeholder="대표자를 입력해주세요.">&nbsp;&nbsp;<p class="resultCeo"></p></td>
                        </tr>
                        <tr>
                            <td><span>*</span> 사업자등록번호</td>
                            <td><input type="text" name="bizRegNum" placeholder="사업자등록번호를 입력해주세요.">&nbsp;&nbsp;<p class="resultBizReg">- 표시 포함 12자리 입력, 예) 123-45-67890</p></td>
                        </tr>
                        <tr>
                            <td><span>*</span> 통신판매업신고 번호</td>
                            <td><input type="text" name="comRegNum" placeholder="통신판매업신고번호를 입력해주세요.">&nbsp;&nbsp;<p class="resultComReg">- 표시 포함, 예) 강남-12345, 제 1-01-23-4567호, 2017-경기성남-0011</p></td>
                        </tr>
                        <tr>
                            <td><span>*</span> 전화번호</td>
                            <td><input type="text" name="tel" placeholder="전화번호를 입력하세요.">&nbsp;&nbsp;<p class="resultTel">- 표시 포함, 지역번호 포함, 예) 02-234-1234</p></td>
                        </tr>
                        <tr>
                            <td><span>*</span> 팩스번호</td>
                            <td><input type="text" name="fax" placeholder="팩스번호를를 입력하세요.">&nbsp;&nbsp;<p class="resultFax">- 표시 포함, 지역번호 포함, 예) 02-234-1234</p></td>
                        </tr>
                        <tr>
                            <td><span>*</span> EMAIL</td>
                            <td><input type="text" name="email" placeholder="이메일을 입력하세요.">&nbsp;&nbsp;<p class="resultEmail"></p></td>
                        </tr>
                        <tr>
                            <td>회사주소</td>
                            <td>
                                <input type="text" name="zip" placeholder="우편번호 입력 클릭"><br/>
                                <input type="text" name="addr1" placeholder="주소를 검색하세요." readonly><br/>
                                <input type="text" name="addr2" placeholder="상세주소를 입력하세요.">
                            </td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <th colspan="2">담당자 정보입력</th>
                        </tr>
                        <tr>
                            <td><span>*</span> 이름</td>
                            <td><input type="text" name="manager" placeholder="이름을 입력해주세요.">&nbsp;&nbsp;<p class="resultManager"></p></td>
                        </tr>
                        <tr>
                            <td><span>*</span> 휴대폰</td>
                            <td><input type="text" name="managerHp" placeholder="휴대폰을 입력해주세요.">&nbsp;&nbsp;<p class="resultManagerHp"></p></td>
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