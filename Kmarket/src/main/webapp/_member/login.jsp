<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="./_header.jsp"/>
        <main>
            <div class="loginForm">
                <div>
                    <p>로그인</p>
                    <p>Home > <span>로그인</span></p>
                </div>
                <div class="login">   
                	<form action="/Kmarket/_member/login.jsp" method="post">       
                    <table>
                        <tr>
                            <td>아이디</td>
                            <td><input type="text" name="uid" placeholder="아이디 입력"></td>
                            <td rowspan="2"><button type="submit" class="btnLogin"></button></td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td><input type="password" name="pass" placeholder="비밀번호 입력"></td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <label><input type="checkbox"> 자동 로그인 |</label>
                                <a href="#">아이디 찾기 |</a>
                                <a href="#">비밀번호 찾기 |</a>
                                <a href="/Kmarket/_member/signup.html">회원가입</a>
                            </td>
                        </tr>
                    </table>
                   	</form>  
                    <img src="/Kmarket/img/img_user/member_login_banner.jpg" alt="로그인배너">
                </div>
                <div class="certifi">
                    <img src="/Kmarket/img/img_user/member_certifi_logo.gif" alt="인증배너">
                </div>
            </div>
        </main>
<jsp:include page="./_footer.jsp"/>