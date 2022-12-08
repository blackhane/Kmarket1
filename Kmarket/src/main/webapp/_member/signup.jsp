<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="./_header.jsp"/>
        <main>
            <div class="registerForm">
                <div>
                    <p>약관동의</p>
                </div>
                <div class="TermsForm">
                    <section>
                        <p><span>(필수)</span> 케이마켓 이용약관</p>
                        <textarea readonly></textarea>
                    </section>
                    <section>
                        <p><span>(필수)</span> 전자금융거래 이용약관</p>
                        <textarea readonly></textarea>
                    </section>
                    <section>
                        <p><span>(필수)</span> 개인정보 수집동의</p>
                        <textarea readonly></textarea>
                    </section>
                    <section>
                        <p><span class="choice">(선택)</span> 위치정보 이용약관</p>
                        <textarea readonly></textarea>
                    </section>
                    <div>
                        <button type="submit" class="btnNext">동의하기</button>
                    </div>
                </div>
            </div>
        </main>
<jsp:include page="./_footer.jsp"/>