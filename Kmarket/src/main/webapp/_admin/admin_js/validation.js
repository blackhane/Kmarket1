/**
 * 
 */
 
 //게시판 유효성 검사
 
$(function(){
	
	//게시판 유효성검사
	$("input[name=submit_board]").click(function(){
		if($("input[name=title]").val() == ""){
		    alert("제목을 입력해주세요.");
		    $("input[name=title]").focus();
		    return false;
		};
		
	});
	
	$("input[name=submit_product]").click(function(){
		if($("input[name=prodName]").val() == ""){
		    alert("상품명을 입력해주세요.");
		    $("input[name=prodName]").focus();
		    return false;
		};
		
		if($("input[name=descript]").val() == ""){
		    alert("기본설명을 입력해주세요.");
		    $("input[name=descript]").focus();
		    return false;
		};
		
		if($("input[name=seller]").val() == ""){
		    alert("판매자를 입력해주세요.");
		    $("input[name=seller]").focus();
		    return false;
		};
		
		if($("input[name=price]").val() == ""){
		    alert("판매가격을 입력해주세요.");
		    $("input[name=price]").focus();
		    return false;
		};
		
		if($("input[name=thumb1]").val() == ""){
		    alert("썸네일을 등록해주세요.");
		    $("input[name=thumb1]").focus();
		    return false;
		};
	});
});