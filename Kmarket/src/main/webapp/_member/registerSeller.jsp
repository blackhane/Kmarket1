<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="./_header.jsp"/>
        <main>
            <div class="registerForm">
                <div>
                    <p>판매자 회원가입</p>
                </div>
                <div>
                    <table>
                        <tr>
                            <th colspan="2">필수 정보입력</th>
                        </tr>
                        <tr>
                            <td><span>*</span> 아이디</td>
                            <td><input type="text" name="uid" placeholder="아이디를 입력하세요."> 영문,숫자로 4~12자까지 설정해 주세요.</td>
                        </tr>
                        <tr>
                            <td><span>*</span> 비밀번호</td>
                            <td><input type="password" pass1="pass" placeholder="비밀번호를 입력하세요."> 영문,숫자,특수문자를 조합하여 8~12자리까지 설정해 주세요.</td>
                        </tr>
                        <tr>
                            <td><span>*</span> 비밀번호 확인</td>
                            <td><input type="password" pass2="pass2" placeholder="비밀번호를 한번 더 입력하세요."> 비밀번호 재입력</td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <th colspan="2">판매자 정보입력</th>
                        </tr>
                        <tr>
                            <td><span>*</span> 회사명</td>
                            <td><input type="text" name="company" placeholder="회사명을 입력해주세요."> (주)포함 입력, 예) (주)케이마켓</td>
                        </tr>
                        <tr>
                            <td><span>*</span> 대표자</td>
                            <td><input type="text" name="ceo" placeholder="대표자를 입력해주세요."></td>
                        </tr>
                        <tr>
                            <td><span>*</span> 사업자등록번호</td>
                            <td><input type="text" name="bizRegNum" placeholder="사업자등록번호를 입력해주세요."> - 표시 포함 12자리 입력, 예) 123-45-67890</td>
                        </tr>
                        <tr>
                            <td><span>*</span> 통신판매업신고 번호</td>
                            <td><input type="text" name="comRegNum" placeholder="통신판매업신고번호를 입력해주세요."> - 표시 포함, 예) 강남-12345, 제 1-01-23-4567호, 2017-경기성남-0011</td>
                        </tr>
                        <tr>
                            <td><span>*</span> 전화번호</td>
                            <td><input type="text" name="tel" placeholder="전화번호를 입력하세요."> - 표시 포함, 지역번호 포함, 예) 02-234-1234</td>
                        </tr>
                        <tr>
                            <td><span>*</span> 팩스번호</td>
                            <td><input type="text" name="fax" placeholder="팩스번호를를 입력하세요."> - 표시 포함, 지역번호 포함, 예) 02-234-1234</td>
                        </tr>
                        <tr>
                            <td><span>*</span> EMAIL</td>
                            <td><input type="text" name="email" placeholder="이메일을 입력하세요."></td>
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
                            <td><input type="text" name="manager" placeholder="이름을 입력해주세요."></td>
                        </tr>
                        <tr>
                            <td><span>*</span> 휴대폰</td>
                            <td><input type="text" name="managerHp" placeholder="휴대폰을 입력해주세요."></td>
                        </tr>
                    </table>
                    <div>
                        <button type="submit" class="btnRegister">회원가입</button>
                    </div>
                </div>
            </div>
        </main>
<jsp:include page="./_footer.jsp"/>