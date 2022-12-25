<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/_admin/_header.jsp"/>
<script>

	$(function() {
		
		if(${param.resultCode eq 101}){
			alert('게시물이 삭제되었습니다.');
		}
		
		//카테고리 선택
		$('select[name=cate]').change(function(){
			list($(this).val(), 1);
			paging($(this).val(), 1, 1);
		});
		
		//게시물 삭제
		$(document).on('click','#delete',function(e){
			e.stopImmediatePropagation();
			let no = $(this).data("no");
			//console.log(no);
			let del = confirm('게시물을 삭제하시겠습니까?');
			
			if(del){
				$.ajax({
					url : '/Kmarket/admin/cs/notice/delete.do',
					method : 'get',
					data : {'no' : no},
					dataType : 'json',
					success : function(data){
						if(data.result > 0){
							alert('게시물이 삭제되었습니다.');
							$('.all').prop("checked",false);
							let cate = $('select[name=cate]').val();
							let pg = $('.current').data('pg');
							list(cate, pg);
						}
					}
				});
			}
		});
		
		//전체선택
		$('.all').click(function(){
			if($(this).is(":checked")){
				$('.chk').prop("checked",true);
			}else{
				$('.chk').prop("checked",false);
			}
		});
		$(document).on('click','#chk',function(e){
			e.stopImmediatePropagation();
			$('.all').prop("checked",false);
			if($('input[name=chk]:checked').length == $('.chk').length){
				$('.all').prop("checked",true);
			}
		});
		
		//선택삭제
		$('.selectDelete').click(function(){
			if($('input[name=chk]:checked').length == 0){
				alert('선택된 게시물이 없습니다.');
				return;
			}
			
			let answer = confirm('게시물을 삭제하시겠습니까?');
			if(answer){
				let chkArr = new Array();
				$('input[name=chk]:checked').each(function(){
					chkArr.push($(this).data("no"));
				});
				
				$.ajax({
					url : '/Kmarket/admin/cs/notice/delete.do',
					method : 'post',
					data : {'chkArr' : chkArr},
					traditional: true,
					dataType : 'json',
					success : function(data){
						if(data.result > 0){
							alert('게시물이 삭제되었습니다.');
							$('.all').prop("checked",false);
							let cate = $('select[name=cate]').val();
							let pg = $('.current').data('pg');
							list(cate, pg);
						}
					}
				});
			}
		});

		//console.log('${param.cate}' + '${param.pg}');
		list('${param.cate}', '${param.pg}');
		paging('${param.cate}', Math.ceil('${(Math.ceil(param.pg/10)-1) * 10 + 1}'), '${param.pg}');
		
		
		//리스트출력
		function list(cate, pg){
			let intPg = parseInt(pg);
			//console.log(intPg);
			let jsonData = {
				'cate' : cate,
				'pg' : pg
			};
			
			//console.log(jsonData);
			$.ajax({
				url : '/Kmarket/admin/cs/notice/list.do',
				method : 'post',
				data : jsonData,
				dataType : 'json',
				async: false,
				success : function(data){
					$('.notice_list').remove();
					if(data.length > 0){
						let i = (intPg-1) * 10 + 1;
						for(let article of data){
							let tag = "<tr class='notice_list'>";
								tag +="<td><input type='checkbox' name='chk' class='chk' id='chk' data-no='"+article.no+"'></td>";
								tag += "<td>"+i+"</td>";
								tag += "<td>"+article.cate+"</td>";
								tag += "<td><a href='/Kmarket/admin/cs/notice/view.do?no="+article.no+"&cate="+cate+"&pg="+pg+"'>"+article.title+"</a></td>";
								tag += "<td>"+article.hit+"</td>";
								tag += "<td>"+article.rdate+"</td>";
								tag += "<td><a href='#' id='delete' data-no='"+article.no+"'>[삭제]</a><a href='/Kmarket/admin/cs/notice/modify.do?no="+article.no+"&cate="+cate+"&pg="+pg+"'>[수정]</a></td>";
								tag += "</tr>";
							i += 1;
							$('.admin_cs_list_div').children('table').append(tag);
						}
						return;
					}else{
						let tag = "<tr class='notice_list'>";
							tag += "<td colspan='8' align='center'>등록된 공지사항이 없습니다.</td> "
							tag += "</tr>";
							$('.admin_cs_list_div').children('table').append(tag);
						return;
					}
				}
			});
		}
		
		//페이징
		function paging(cate, pg, current){
			let jsonData = {
				'cate' : cate,
				'pg' : pg
			};
		
			//console.log(jsonData + current);
			$.ajax({
				url : '/Kmarket/admin/cs/notice/page.do',
				method : 'get',
				data : jsonData,
				dataType : 'json',
				async: false,
				success : function(data){
					$('.page').empty();
					if(data.pageGroupEnd > data.lastPageNum){
						data.pageGroupEnd = data.lastPageNum;
					}
						let tag = "";
						if(data.pageGroupStart > 1){
							tag += "<a href='#page' id='prev' class='prev' data-last='"+ data.pageGroupStart +"'><&nbsp;이전</a>";
						}
						for(let i=data.pageGroupStart; i<=data.pageGroupEnd; i++){
							tag += "<a href='#page' id='num' data-pg='"+i+"' class=" + (i==current ? 'current':'off') + ">"+i+"</a>";
						}
						if(data.lastPageNum > data.pageGroupEnd){
							tag += "<a href='#page' id='next' class='next' data-last='"+ data.pageGroupEnd +"'>다음&nbsp;></a>";
						}
					$('.page').append(tag);
				}
			});
		}
		
		//페이지 클릭
		$(document).on('click','#num',function(e){
			e.stopImmediatePropagation();
			let cate = $('select[name=cate]').val();
			let pg = $(this).data('pg');
			
			$('a#num').addClass("off").removeClass("current");
		    $(this).addClass("current").removeClass("off");
		    
			list(cate, pg);
		});
		$(document).on('click', '#prev',function(e) {
	    	e.stopImmediatePropagation();
	    	let cate = $('select[name=cate]').val();
	    	let pg = $(this).data('last');
	    	list(cate, pg-1);
	    	paging(cate, pg-10, pg-1);
	    }); 
		$(document).on('click', '#next',function(e) {
	    	e.stopImmediatePropagation();
	    	let cate = $('select[name=cate]').val();
			let pg = $(this).data('last');
			list(cate, pg+1);
			paging(cate, pg+1, pg+1);
		});
		
		
		$('.register').click(function(){
			location.href ="/Kmarket/admin/cs/notice/write.do";
		});
		
	 });

</script>
            <section id="admin-index">
                <nav>
                    <h3>공지사항 목록</h3>
                    <p>
                        HOME > 고객센터 > <strong>공지사항</strong>
                    </p>
                </nav>
                <div id="admin_cs_list">
                <div class="group">
                    <select name="cate" id="cate">
                    	<option value="전체보기"  <c:if test="${param.cate == '전체보기'}">selected="selected"</c:if> >전체보기</option>
	                    <option value="고객 서비스" <c:if test="${param.cate == '고객 서비스'}">selected="selected"</c:if> >고객 서비스</option>
	                    <option value="안전거래" <c:if test="${param.cate == '안전거래'}">selected="selected"</c:if> >안전거래</option>
	                    <option value="위해상품" <c:if test="${param.cate == '위해상품'}">selected="selected"</c:if> >위해상품</option>
	                    <option value="이벤트 당첨" <c:if test="${param.cate == '이벤트'}">selected="selected"</c:if> >이벤트 당첨</option>
                	</select>
                	</div>
                    <div class="admin_cs_list_div">
                        <table>
                           <tr>
                               <th><input type="checkbox" class="all"/></th>
                               <th>번호</th>
                               <th>유형</th>
                               <th>제목</th>
                               <th>조회</th>
                               <th>날짜</th>
                               <th>관리</th>
                           </tr>
                          <tr class="notice_list"></tr>
                        </table>
                        <div class="btn">
                            <button class="btn_gray selectDelete">선택삭제</button>
                            <button class="btn_blue register">작성하기</button>
                        </div>
                        <div class="page">
                        </div>
                    </div>
                </div>
            </section>
        </main>
<jsp:include page="/_admin/_footer.jsp"/>
