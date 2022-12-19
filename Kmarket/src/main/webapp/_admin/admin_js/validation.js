/**
 * 
 */
 
 //게시판 유효성 검사
 
 $(function(){
	
	$("input[name=submit_board]").click(function(){
		if($("input[name=title]").val() == ""){
		    alert("제목을 입력해주세요.");
		    $("input[name=title]").focus();
		    return false;
		}
		
		if($("input[name=content]").val() == ""){
		    alert("내용을 입력해주세요.");
		    $("input[name=content]").focus();
		    return false;
		}
	})
	
	
 //상품등록 검사
 
	 $("input[name=submit]").click(function(){
		if($("input[name=title]").val() == ""){
		    alert("제목을 입력해주세요.");
		    $("input[name=title]").focus();
		    return false;
		}
		
		if($("input[name=content]").val() == ""){
		    alert("내용을 입력해주세요.");
		    $("input[name=content]").focus();
		    return false;
		}
	})




})
 

