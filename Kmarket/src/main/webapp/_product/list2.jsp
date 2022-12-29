<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./_header.jsp" />
<jsp:include page="./nagivation.jsp" />
<style>
	strong {
		font-weight : bold;
	}
</style>
<script>
	$(function(){
		//페이지 로딩시 처음 출력
		productList(1,1);
		page();
		
		//정렬
		$('.highSold').click(function(){
			$('a.on').removeClass("on");
			$(this).addClass("on");
			productList(1,1);
			page();
		});
		$('.lowPrice').click(function(){
			$('a.on').removeClass("on");
			$(this).addClass("on");
			productList(2,1);
			page();
		});
		$('.highPrice').click(function(){
			$('a.on').removeClass("on");
			$(this).addClass("on");
			productList(3,1);
			page();
		});
		$('.highScore').click(function(){
			$('a.on').removeClass("on");
			$(this).addClass("on");
			productList(4,1);
			page();
		});
		$('.highReview').click(function(){
			$('a.on').removeClass("on");
			$(this).addClass("on");
			productList(5,1);
			page();
		});
		$('.latest').click(function(){
			$('a.on').removeClass("on");
			$(this).addClass("on");
			productList(6,1);
			page();
		});
		
		//페이지 클릭
		$(document).on('click','#num',function(e){
			e.stopImmediatePropagation();
			$('a#num').removeClass('on');
			$(this).addClass('on');
			let start = $(this).data('no');
			let sort = $('a.sort.on').data('ls');
			productList(sort, start);
		});
		
		//상품리스트 출력
		function productList(sort, start){
			//정렬기준, 페이지에 맞는 출력 시작번호
			//카테고리1,2 값
			let cate1 = '${cate.cate1}';
			let cate2 = '${cate.cate2}';
			let jsonData = {
				'sort' : sort,
				'start' : start,
				'cate1' : cate1,
				'cate2' : cate2
			}
			console.log(jsonData);
			
			$.ajax({
				url : '/Kmarket/product/list2.do',
				method : 'post',
				data : jsonData,
				dataType : 'json',
				success : function(data){
					if(data.length > 0){
						$('table').empty();
						for(let product of data){
							let tag = "<tr>";
								tag += "<td>";
								tag += "<a href='/Kmarket/product/view.do?cate1="+product.cate1+"&cate2="+product.cate2+"&prodNo="+product.prodNo+"' class='thumb'>";
								tag += "<img src='/Kmarket/file/"+product.thumb1+"' alt='thumb1'/> </a>";
								tag += "</td>";
								tag += "<td>";
								tag += "<h3 class='name'>"+product.prodName+"</h3>";
								tag += "<a href='/Kmarket/product/view.do?cate1="+product.cate1+"&cate2="+product.cate2+"&prodNo="+product.prodNo+"' class='desc'>"+product.descript+"</a>";
								tag += "</td><td><ul><li>";
								let disPrice = addComma(product.disPrice.toString())
								tag += "<ins class='dis-price'>"+disPrice+"원</ins>";
								tag += "</li>";
								if(product.discount != 0){
									tag += "<li>";
									let oriPrice = addComma(product.price.toString())
									tag += "<del class='org-price'>"+oriPrice+"원</del>";
									tag += "<span class='discount'>"+product.discount+"%</span>";
									tag += "</li>";
								}
								if(product.delivery == 0){
									tag += "<li>";
									tag += "<span class='free'>무료배송</span>";
									tag += "</li>";
								}
								tag += "</ul></td>";
								tag += "<td>";
								tag += "<h4 class='seller'><i class='fas fa-home'></i>&nbsp;"+product.seller+"</h4>";
								tag += "<h5 class='badge power'>판매자등급</h5>";
								tag += "<h6 class='rating star"+product.score+"'>상품평</h6>";
								tag += "</td></tr>";
							$('table').append(tag);
						}
					}
				}
			});
		}
		
		//페이징
		function page(){
			//카테고리1,2 값
			let cate1 = '${cate.cate1}';
			let cate2 = '${cate.cate2}';
			let jsonData = {
				'cate1' : cate1,
				'cate2' : cate2
			}
			
			$.ajax({
				url : '/Kmarket/product/page.do',
				method : 'get',
				data : jsonData,
				dataType : 'json',
				success : function(data){
					$('.num').empty();
					if(1 < data.pageGroupStart){
						let tag = "<a href='#'><&nbsp;이전</a>";
						$('.prev').append(tag);
					}
					for(let i=data.pageGroupStart; i<=data.pageGroupEnd; i++){
						let tag = "<a href='#sort' id='num' data-no='"+i+"' class='" + (data.currentPage == i?'on':'off') +"'>"+ i +"</a>";
						$('.num').append(tag);
					}
					if(data.pageGroupEnd < data.lastPageNum){
						let tag = "<a href='#'>다음&nbsp;></a>";
						$('.next').append(tag);
					}
				}
			});
		}
		
		function addComma(value){
	        value = value.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	        return value; 
	    }
	});
</script>
<!-- 상단 목록 -->
<section class="list">
    <nav>
        <h1>상품목록</h1>
        <p>HOME > <span>${cate.c1Name}</span> > <strong>${cate.c2Name}</strong></p>
    </nav>

    <!-- 메뉴 -->
    <ul class="sort" id="sort">
        <li><a href="#" class="sort highSold on" data-ls="1">판매많은순</a></li>
        <li><a href="#" class="sort lowPrice" data-ls="2">낮은가격순</a></li>
        <li><a href="#" class="sort highPrice" data-ls="3">높은가격순</a></li>
        <li><a href="#" class="sort highScore" data-ls="4">평점높은순</a></li>
        <li><a href="#" class="sort highReview" data-ls="5">후기많은순</a></li>
        <li><a href="#" class="sort latest" data-ls="6">최근등록순</a></li>
    </ul>
    <!-- 상품목록 -->
    <table></table>
    <!-- 페이지 번호 -->
    <div class="paging">
        <span class="prev"></span>
        <span class="num"></span>
        <span class="next"></span>
    </div>
</section>
</main>
<jsp:include page="./_footer.jsp" />