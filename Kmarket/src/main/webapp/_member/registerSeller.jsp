<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="./_header.jsp"/>
<script src="/Kmarket/js/postcode.js"></script>
<script>
	$(function(){
		let regId = /^[A-za-z0-9]{4,12}$/;
		let regPass = /^(?=.*[a-zA-Z0-9])(?=.*\W)(?=\S+$).{8,12}$/;
		let regCompany = /^[가-힣]{2,20}$/;
		let regName = /^[가-힣]{2,4}$/;
		let regBizReg = /^\d{3}-\d{2}-\d{5}$/;
		let regTel = /^\d{2,3}-\d{3,4}-\d{4}$/;
		let regEmail = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+$/;
		let regHp = /^\d{3}-\d{3,4}-\d{4}$/;
		
		let chkId = false;
		let chkPass1 = false;
		let chkPass2 = false;
		let chkCompany = false;
		let chkCeo= false;
		let chkBizRegNum = false;
		let chkComRegNum = false;
		let chkTel = false;
		let chkFax = false;
		let chkEmail = false;
		let chkManager = false;
		let chkManagerHp = false;
		
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
			
			console.log(uid);
			$.ajax({
				url : '/Kmarket/member/chkUid.do',
				method : 'get',
				data : {'uid' : uid},
				dataType : 'json',
				success : function(data){
					if(data.result == 1){
						//실패
						$('.resultId').css({'font-weight':'bold','color':'#e86444'}).text('이미 사용중인 아이디입니다.');
						chkId = false;
						return;
					}else{
						//성공
						$('.resultId').css({'font-weight':'bold','color':'#33b354'}).text('유효한 아이디입니다.');
						chkId = true;
						console.log(chkId);
						return;
					}
				}
			});
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
		
		//회사명
		$('input[name=company]').focusout(function(){
				let name = $('input[name=company]').val();
			
			if(name == ''){
				$('.resultCompany').css({'font-weight':'bold','color':'#e86444'}).text('필수 정보입니다.');
				return;
			}
			
			//유효성검사
			if(!name.match(regCompany)){
				//실패
				$('.resultCompany').css({'font-weight':'bold','color':'#e86444'}).text('(주)포함 입력하여 입력해주세요.');
				chkCompany = false;
				return;
			}
			
			$('.resultCompany').css({'font-weight':'bold','color':'#33b354'}).text('유효한 회사명입니다.');
			chkCompany = true;
			return;
		});
		
		//대표자
		$('input[name=ceo]').focusout(function(){
			let name = $('input[name=ceo]').val();
			
			if(name == ''){
				$('.resultCeo').css({'font-weight':'bold','color':'#e86444'}).text('필수 정보입니다.');
				return;
			}
			
			//유효성검사
			if(!name.match(regName)){
				//실패
				$('.resultCeo').css({'font-weight':'bold','color':'#e86444'}).text('한글 2자리 이상을 사용해주세요.');
				chkCeo = false;
				return;
			}
			
			$('.resultCeo').text('');
			chkCeo = true;
			return;
		});
		
		//사업자등록번호
		$('input[name=bizRegNum]').focusout(function(){
			let name = $('input[name=bizRegNum]').val();
			
			if(name == ''){
				$('.resultBizReg').css({'font-weight':'bold','color':'#e86444'}).text('필수 정보입니다.');
				return;
			}
			
			//유효성검사
			if(!name.match(regBizReg)){
				//실패
				$('.resultBizReg').css({'font-weight':'bold','color':'#e86444'}).text('- 표시 포함 12자리 입력, 예) 123-45-67890');
				chkBizRegNum = false;
				return;
			}
			
			$('.resultBizReg').css({'font-weight':'bold','color':'#33b354'}).text('유효한 등록번호입니다..');
			chkBizRegNum = true;
			return;
		});
		
		//통신판매업신고번호
		$('input[name=comRegNum]').focusout(function(){
			let name = $('input[name=comRegNum]').val();
			
			if(name == ''){
				$('.resultComReg').css({'font-weight':'bold','color':'#e86444'}).text('필수 정보입니다.');
				return;
			}
			
			$('.resultComReg').css({'font-weight':'bold','color':'#33b354'}).text('유효한 등록번호입니다..');
			chkComRegNum = true;
			return;
		});
		
		//전화번호
		$('input[name=tel]').focusout(function(){
			let name = $('input[name=tel]').val();
			
			if(name == ''){
				$('.resultTel').css({'font-weight':'bold','color':'#e86444'}).text('필수 정보입니다.');
				return;
			}
			
			//유효성검사
			if(!name.match(regTel)){
				//실패
				$('.resultTel').css({'font-weight':'bold','color':'#e86444'}).text('- 표시 포함, 지역번호 포함, 예) 02-234-1234');
				chkTel = false;
				return;
			}
			
			$('.resultTel').css({'font-weight':'bold','color':'#33b354'}).text('유효한 전화번호입니다..');
			chkTel = true;
			return;
		});
		
		//팩스번호
		$('input[name=fax]').focusout(function(){
			let name = $('input[name=fax]').val();
			
			if(name == ''){
				$('.resultFax').css({'font-weight':'bold','color':'#e86444'}).text('필수 정보입니다.');
				return;
			}
			
			//유효성검사
			if(!name.match(regTel)){
				//실패
				$('.resultFax').css({'font-weight':'bold','color':'#e86444'}).text('- 표시 포함, 지역번호 포함, 예) 02-234-1234');
				chkFax  = false;
				return;
			}
			
			$('.resultFax').css({'font-weight':'bold','color':'#33b354'}).text('유효한 팩스번호입니다..');
			chkFax  = true;
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
		
		//담당자
		$('input[name=manager]').focusout(function(){
			let name = $('input[name=manager]').val();
			
			if(name == ''){
				$('.resultManager').css({'font-weight':'bold','color':'#e86444'}).text('필수 정보입니다.');
				return;
			}
			
			//유효성검사
			if(!name.match(regName)){
				//실패
				$('.resultManager').css({'font-weight':'bold','color':'#e86444'}).text('한글 2자리 이상을 사용해주세요.');
				chkManager  = false;
				return;
			}
			
			$('.resultManager').text('');
			chkManager  = true;
			return;
		});
		
		//담당자휴대폰
		$('input[name=managerHp]').focusout(function(){
			let name = $('input[name=managerHp]').val();
			
			if(name == ''){
				$('.resultManagerHp').css({'font-weight':'bold','color':'#e86444'}).text('필수 정보입니다.');
				return;
			}
			
			//유효성검사
			if(!name.match(regHp )){
				//실패
				$('.resultManagerHp').css({'font-weight':'bold','color':'#e86444'}).text('- 포함 13자리를 입력하세요.');
				chkManagerHp  = false;
				return;
			}
			
			$('.managerHp').text('');
			chkManagerHp  = true;
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
			if(!chkCompany){
				alert('회사명을 확인해주세요.');
				$('input[name=company]').focus();
				return false;
			}
			if(!chkCeo){
				alert('대표자를 확인해주세요.');
				$('input[name=ceo]').focus();
				return false;
			}
			if(!chkBizRegNum){
				alert('사업자등록번호를 확인해주세요.');
				$('input[name=bizRegNum]').focus();
				return false;
			}
			if(!chkComRegNum){
				alert('통신판매업신고 번호를 확인해주세요.');
				$('input[name=comRegNum]').focus();
				return false;
			}
			if(!chkTel){
				alert('전화번호를 확인해주세요.');
				$('input[name=tel]').focus();
				return false;
			}
			if(!chkFax){
				alert('팩스번호를 확인해주세요.');
				$('input[name=fax]').focus();
				return false;
			}
			if(!chkEmail){
				alert('이메일을 확인해주세요.');
				$('input[name=email]').focus();
				return false;
			}
			if(!chkManager){
				alert('담당자를 확인해주세요.');
				$('input[name=manager]').focus();
				return false;
			}
			if(!chkManagerHp){
				alert('담당자 연락처를 확인해주세요.');
				$('input[name=managerHp]').focus();
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