function userinfo() {
	$.ajax({
		type : "GET",
		url : "userinfo.do",
		success : function(result) {
			$(".board").html(result);
			$(".board").css("display", "block");
		}
	});
}
function board() {
	$.ajax({
		type : "GET",
		url : "board2.do",
		success : function(result) {
			$(".board").html(result);
			$(".board").css("display", "block");
		}
	});
}
function reply(no,id) {
	if(id!=""){
	$.ajax({
		type : "GET",
		url : "reply.do",
		data:{"no":no},
		success : function(result) {
			$(".reply").html(result);
		}
	});
	}
	else{
		alert('로그인을 해주세요!!');
		location.href="login.jsp";
	}
}
function detail(num) {
	$.ajax({
		type : "GET",
		url : "detailview.do",
		data:{"no":num},
		success : function(result) {
			$(".board").html(result);
			$(".board").css("display", "block");
		}
	});
}
function detaildel(num) {
	$.ajax({
		type : "GET",
		url : "addelete.do",
		data : {
			"no" : num
		},
		success : function(result) {
			$(".board").html(result);
			$(".board").css("display", "block");
		}
	});
}
function del() {
	var lists=[];
	$("input[name='remove']:checked").each(function(i){
		lists.push($(this).val())
	});
	$.ajax({
		type : "GET",
		url : "delete3.do",
		data : {
			"remove" : lists.join(',')
		},
		success : function(result) {
			$(".board").html(result);
			$(".board").css("display", "block");
		}
	});
}
function boarddel() {
	var lists=[];
	$("input[name='remove']:checked").each(function(i){
		lists.push($(this).val())
	});
	if(lists!=""){
	$.ajax({
		type : "GET",
		url : "delete2.do",
		data : {
			"remove" : lists.join(',')
		},
		success : function(result) {
			$(".board").html(result);
			$(".board").css("display", "block");
			alert('삭제 되었습니다.');
		}
	});
	}
	else{
		alert('삭제할 게시물을 선택해주세요');
	}
}
function boardwrite(id){
	if(id!=""){
		location.href="write2.ch";
	}
	else{
		alert("로그인을 해주세요!!");
		location.href="login.jsp";
	}
}
function replydel(no,no2) {
	$.ajax({
		url:"replydelete.do",
		data:{"no":no,"no2":no2},
		success:function(result){
			$(".reply").html(result);
		}
	});
}
function paging(num) {
	$.ajax({
		type : "GET",
		url : "board2.do",
		data : {
			"pageNo" : num
		},
		success : function(result) {
			$(".board").html(result);
			$(".board").css("display", "block");
		}
	});
}
function prevpage(num) {
	$.ajax({
		type : "GET",
		url : "board2.do",
		data : {
			"pageNo" : num
		},
		success : function(result) {
			$(".board").html(result);
			$(".board").css("display", "block");
		}
	});
}
function nextpage(num) {
	$.ajax({
		type : "GET",
		url : "board2.do",
		data : {
			"pageNo" : num
		},
		success : function(result) {
			$(".board").html(result);
			$(".board").css("display", "block");
		}
	});
}
function search(search) {
		$.ajax({
			type : "GET",
			url : "adminsearch.do",
			data : {"search" : search},
			success : function(result) {
				$(".board").html(result);
				$(".board").css("display", "block");
			}
		});
}
function gamesearch(search) {
	$.ajax({
		type : "GET",
		url : "gamesearch.do",
		data : {"game" : search},
		success : function(result) {
			$(".pc-game").html(result);
		}
	});
}
function allgame() {
	$(".all-game2 a").css("color","#777").css("font-weight","500");
	$(".all").css("color","#07f").css("font-weight","bold");
	$.ajax({
		type : "GET",
		url : "gamesearch.do",
		data : {"game" : ""},
		success : function(result) {
			$(".pc-game").html(result);
		}
	});
}
function kind(kind) {
	$(".all-game2 a").css("color","#777").css("font-weight","500");
	$("."+kind).css("color","#07f").css("font-weight","bold");
	$.ajax({
		type : "GET",
		url : "kind.do",
		data : {"game" : kind},
		success : function(result) {
			$(".pc-game").html(result);
		}
	});
}
function adwrite(){
	$.ajax({
		type : "GET",
		url : "adminwrite.do",
		success : function(result) {
			$(".board").html(result);
			$(".board").css("display", "block");
		}
	});
}
function adminwrite2(){
	var viewToken=$("#viewToken").val();
	var subs=$("#subs").val();
	var content=$("#content").val();
	var writer=$("#writer").val();
	var subject=$("#subs").val();
	var content=$("#content").val();
		if(subject==""){
			alert("제목을 입력해 주세요");
		}
		else if(content==""){
			alert("내용을 입력해주세요");
		}
		if(subject!=""&&content!=""){
			$.ajax({
				type : "GET",
				url : "adminwrite2.do",
				data:{"viewToken":viewToken,"subject":subs,"content":content,"writer":writer},
				success : function(result) {
					$(".board").html(result);
					$(".board").css("display", "block");
					alert("등록되었습니다");
				}
			});
		}

}
function nullcheck(){
	var content=$("#content").val();
	var no=$("#no").val();
	var writer=$("#writer").val();
	var viewToken=$("#viewToken").val();
	if(content!=""){
		$.ajax({
			type : "GET",
			url : "reply2.do",
			data:{"no":no,"content":content,"writer":writer,"viewToken":viewToken},
			success : function(result) {
				$(".reply").html(result);
			}
		});
	}
	else{
		alert('내용을 입력해주세요');
	}
}
function chpw() {
	$("#pinfo").css("font-weight","500");
	$("#chpw").css("font-weight","bold");
	$("#secession").css("font-weight","500");
	$.ajax({
		url:"changepass.jsp",
		success(result){
			$(".box2").html(result);
		}
	});
}

function secession() {
	$("#pinfo").css("font-weight","500");
	$("#chpw").css("font-weight","500");
	$("#secession").css("font-weight","bold");
	$.ajax({
		url:"secession.jsp",
		success(result){
			$(".box2").html(result);
		}
	});
}
function privateinfo() {
	$("#pinfo").css("font-weight","bold");
	$("#chpw").css("font-weight","500");
	$("#secession").css("font-weight","500");
	$.ajax({
		url:"privateinfo.jsp",
		success(result){
			$(".box2").html(result);
		}
	});
}
function pwcheck() {
	var pw=$("#pw").val().trim();
	$.ajax({
		url:".jsp",
		success(result){
			$(".box2").html(result);
		}
	});
}
function del2(writer,name,no) {
		if(writer==name){
			location.href='delete.do?no='+no
		}
		else{
			alert("권한이 없습니다.");
		}
}	
function edit(writer,name,no) {
	if(writer==name){
		location.href='editdetail.do?no='+no
	}
	else{
		alert('권한이 없습니다.');
	}
}	