<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>케이마켓 고객센터</title>
    <link rel="stylesheet" href="/Kmarket/css/css_member.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script>
		let code = "${param.code}";
		console.log("code : " + code);
		//로그인 체크 실패
		if(code == 100){
			alert('존재하지 않는 회원입니다.\n아이디와 비밀번호를 확인해주세요.');
		}
	</script>
</head>
<body>
    <div id="wrapper">
        <header>
            <div class="info">
                <div>
                    <ul>
                        <li><a href="/Kmarket/_member/login.do">로그인</a></li>
                        <li><a href="/Kmarket/_member/join.do">회원가입</a></li>
                        <li><a href="#">마이페이지</a></li>
                        <li><a href="#">장바구니</a></li>
                    </ul>
                </div>
            </div>
            <div class="cs_logo">
                <div>
                    <a href="/Kmarket/">
                        <img src="/Kmarket/img/img_main/header_logo.png" alt="HeaderLogo">
                    </a>
                </div>
            </div>
        </header>