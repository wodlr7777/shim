<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/account.css">
<script src="js/myajax.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(function() {
	$("#pinfo").css("font-weight","bold");
	$("#chpw").css("font-weight","500");
	$("#secession").css("font-weight","500");
	$.ajax({
		url:"privateinfo.jsp",
		success(result){
			$(".box2").html(result);
		}
	});
});
</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<main>
	<section class="main-wrap">
	<div class="myaccount">
	<h2><a href="#">내정보</a></h2>
	</div>
	<div class="menu">
	<ul>
	<li><a href="#">내정보홈</a></li>
	<li><a href="#">내정보관리</a></li>
	<li><a href="#">넥슨캐시</a></li>
	<li><a href="#">내정보보안설정</a></li>
	<li><a href="#">게임계정관리</a></li>
	</ul>
	</div>
	<div class="main-menu">
	<div class="left-menu">
	<h2><a href="#">내정보관리</a></h2>
	<ul>
	<li><a onclick="privateinfo()" id="pinfo">개인정보변경</a></li>
	<li><a onclick="chpw()" id="chpw">비밀번호변경</a></li>
	<li><a onclick="secession()" id="secession">회원탈퇴</a></li>
	</ul>
	</div>
	<div class="view">
	<div class="box2"></div>
	</div>
	</div>

	</section>
</main>
</body>
</html>