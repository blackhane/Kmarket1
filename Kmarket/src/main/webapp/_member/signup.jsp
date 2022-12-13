<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./_header.jsp"/>
<script>
	$(function(){
		$('.btnNext').click(function(){
			let terms = false;
			let finance = false;
			let privacy = false;
			let sign = $('input[name=sign]').val();
			
			terms = $('input[name=terms]').is(':checked');
			finance = $('input[name=finance]').is(':checked');
			privacy = $('input[name=privacy]').is(':checked');
			
			if(terms && finance && privacy){
				if(sign == 1){
					location.href = "/Kmarket/member/register.do";	
				}
				if(sign == 2){
					location.href = "/Kmarket/member/registerSeller.do";	
				}				
			}else{
				alert("필수 항목에는 동의하셔야합니다.");
			}
		});
	});
</script>
        <main>
            <div class="registerForm">
                <div>
                    <p>약관동의</p>
                </div>
                <div class="TermsForm">
                <input type="hidden" name="sign" value="${sign}">
                    <section>
                        <p><span>(필수)</span> 케이마켓 이용약관</p>
                        <c:choose>
	                       	<c:when test="${sign eq 1}">
	                        	<textarea readonly>${vo.terms}</textarea>	
	                       	</c:when>
	                       <c:otherwise>
	                        	<textarea readonly>${vo.tax}</textarea>
	                       </c:otherwise>
                        </c:choose>
                        <label><input type="checkbox" name="terms"/> 동의합니다.</label>
                    </section>
                    <section>
                        <p><span>(필수)</span> 전자금융거래 이용약관</p>
                        <textarea readonly>${vo.finance}</textarea>
                        <label><input type="checkbox" name="finance"/> 동의합니다.</label>
                    </section>
                    <section>
                        <p><span>(필수)</span> 개인정보 수집동의</p>
                        <textarea readonly>${vo.privacy}</textarea>
                        <label><input type="checkbox" name="privacy"/> 동의합니다.</label>
                    </section>
                    <section>
                        <p><span class="choice">(선택)</span> 위치정보 이용약관</p>
                        <textarea readonly>${vo.location}</textarea>
                        <label><input type="checkbox"/> 동의합니다.</label>
                    </section>
                    <div>
                        <button type="submit" class="btnNext">동의하기</button>
                    </div>
                </div>
            </div>
        </main>
<jsp:include page="./_footer.jsp"/>