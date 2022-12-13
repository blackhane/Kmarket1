<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="./_header.jsp"/>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/Kmarket/js/postcode.js"></script>
<script>
	$(function(){
		let regId = /^[A-za-z0-9]{4,12}$/;
		let regPass = /^(?=.*[a-zA-Z0-9])(?=.*\W)(?=\S+$).{8,12}$/;
		let regName = /^[가-힣]{2,4}$/;
		let regEmail = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+$/;
		let regHp = /^\d{3}-\d{3,4}-\d{4}$/;
		
		let chkId = false;
		let chkPass1 = false;
		let chkPass2 = false;
		let chkName = false;
		let chkGender = false;
		let chkEmail = false;
		let chkHp = false;
		
		//아이디
		$('input[name=uid]').focusout(function(){
			let uid = $('input[name=uid]').val();
			
			if(uid == ''){
				$('.resultId').css({'font-weight':'bold','color':'#e86444'}).text('필수 정보입니다.');
				return;
			}
			
			//유효성검사
			if(!uid.match(regId)){
				//실패
				$('.resultId').css({'font-weight':'bold','color':'#e86444'}).text('영문,숫자로 이루어진 4~12자까지 설정해주세요.');
				chkId = false;
				console.log(chkId);
				return;
			}
			
			//성공
			$('.resultId').css({'font-weight':'bold','color':'#33b354'}).text('유효한 아이디입니다.');
			chkId = true;
			console.log(chkId);
			return;
		});
		
		//비밀번호 유효성검사
		$('input[name=pass1]').focusout(function(){
			let pass1= $(this).val();
			chkPass2 = false;
			
			if(pass1 == ''){
				$('.resultPw1').css({'font-weight':'bold','color':'#e86444'}).text('필수 정보입니다.');
				return;
			}
			
			//유효성검사
			if(!pass1.match(regPass)){
				//실패
				$('.resultPw1').css({'font-weight':'bold','color':'#e86444'}).text('영문,숫자,특수문자를 조합하여 8~12자리까지 설정해주세요.');
				chkPass1 = false;
				return;
			}
			
			$('.resultPw1').css({'font-weight':'bold','color':'#33b354'}).text('유효한 비밀번호입니다.');
			chkPass1 = true;
			return;
		});

		//비밀번호 일치여부
		$('input[name=pass2]').focusout(function(){
			let pass1= $('input[name=pass1]').val();
			let pass2= $(this).val();
			
			if(pass2 == ''){
				$('.resultPw2').css({'font-weight':'bold','color':'#e86444'}).text('필수 정보입니다.');
				return;
			}
			
			if(pass1 != pass2){
				//실패
				$('.resultPw2').css({'font-weight':'bold','color':'#e86444'}).text('비밀번호가 일치하지 않습니다. 다시 확인해주세요.');
				chkPass2 = false;
				return;
			}
			//성공
			$('.resultPw2').css({'font-weight':'bold','color':'#33b354'}).text('비밀번호가 일치합니다.');
			chkPass2 = true;
			return;
		});
		
		//이름
		$('input[name=name]').focusout(function(){
			let name = $('input[name=name]').val();
			
			if(name == ''){
				$('.resultName').css({'font-weight':'bold','color':'#e86444'}).text('필수 정보입니다.');
				return;
			}
			
			//유효성검사
			if(!name.match(regName)){
				//실패
				$('.resultName').css({'font-weight':'bold','color':'#e86444'}).text('한글 2자리 이상을 사용해주세요.');
				chkName = false;
				return;
			}
			
			$('.resultName').text('');
			chkName = true;
			return;
		});
		
		//성별
		$('input[name=gender]').change(function(){
			$('.resultGender').text('');
			chkGender = true;
			return;
		});
		
		//email
		$('input[name=email]').focusout(function(){
			let email = $('input[name=email]').val();
			
			if(email == ''){
				$('.resultEmail').css({'font-weight':'bold','color':'#e86444'}).text('필수 정보입니다.');
				return;
			}
			
			//유효성검사
			if(!email.match(regEmail)){
				//실패
				$('.resultEmail').css({'font-weight':'bold','color':'#e86444'}).text('이메일 주소를 다시 확인해주세요.');
				chkEmail = false;
				return;
			}
			
			$('.resultEmail').text('');
			chkEmail = true;
			return;
		});
		
		//휴대폰
		$('input[name=hp]').focusout(function(){
			let hp = $('input[name=hp]').val();
			
			if(hp == ''){
				$('.resultHp').css({'font-weight':'bold','color':'#e86444'}).text('필수 정보입니다.');
				return;
			}
			
			//유효성검사
			if(!hp.match(regHp)){
				//실패
				$('.resultHp').css({'font-weight':'bold','color':'#e86444'}).text('- 포함 13자리를 입력하세요.');
				chkHp = false;
				return;
			}
			
			$('.resultHp').text('');
			chkHp = true;
			return;
		});
		
		//유효성검사
		$('form').submit(function(){
			if(!chkId){
				alert('아이디를 확인해주세요.');
				$('input[name=uid]').focus();
				return false;
			}
			if(!chkPass1){
				alert('비밀번호를 확인해주세요.');
				$('input[name=pass1]').focus();
				return false;
			}
			if(!chkPass2){
				alert('비밀번호 확인해주세요.');
				$('input[name=pass2]').focus();
				return false;
			}
			if(!chkName){
				alert('이름을 확인해주세요.');
				$('input[name=name]').focus();
				return false;
			}
			if(!chkGender){
				let gender = $('input[name=gender]').is(':checked');
				if(gender == 0){
					alert('성별를 확인해주세요.');
					$('.resultGender').css({'font-weight':'bold','color':'#e86444'}).text('필수 정보입니다.');
					return false;
				}
				
			}
			if(!chkEmail){
				alert('이메일을 확인해주세요.');
				$('input[name=email]').focus();
				return false;
			}
			if(!chkHp){
				alert('전화번호를 확인해주세요.');
				$('input[name=hp]').focus();
				return false;
			}
			
			return true;
		});
		
		//주소
		$('input[name=zip]').click(function(){
			postcode();
		});
		
		//엔터 막기
		document.addEventListener('keydown', function(event) {
		  if (event.keyCode === 13) {
		    event.preventDefault();
		  };
		}, true);
		
	});
</script>
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
                            <td><input type="text" name="uid" placeholder="아이디를 입력하세요.">&nbsp;&nbsp;<p class="resultId"></p></td>
                        </tr>
                        <tr>
                            <td><span>*</span> 비밀번호</td>
                            <td><input type="password" name="pass1" placeholder="비밀번호를 입력하세요.">&nbsp;&nbsp;<p class="resultPw1"></p></td>
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
                            <td><input type="text" name="hp" placeholder="휴대폰을 입력하세요.">&nbsp;&nbsp;<p class="resultHp"></p></td>
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