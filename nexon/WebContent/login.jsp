<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/log.css">
<script>
$(document).ready(function(){
	  $(".dropdown").click(function(){
	    $(".dropdown-content").css("transform","translate3d(0,0,0)").css("transition","0.5s");
	    $("body").css("filter","grayscale(30%)");
	  });
	  $(".dropdown").mouseleave(function(){
		    $(".dropdown-content").css("transform","translate3d(-100%,0,0)").css("transition","0.5s");
		    $("body").css("filter","grayscale(0)");
		  });
	});
	function nullch() {
		var id=$("#id").val().trim()
		var pw=$("#pw").val().trim()
		if(id==""){
			swal("아이디를 입력해주세요")
		}else if(pw==""){
			swal("비밀번호를 입력해주세요")
		}
		if(id!=""&&pw!=""){
		$("#login").submit();
		}
	}
</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main>
		<section class="main-wrap">
			<div>
				<h2>로그인</h2>
			</div>
			<div class="log-box">
					
				<ul>
				<li>넥슨ID 로그인</li>
					<li>일회용 로그인</li>
					<li>QR 로그인</li>
				</ul>
			</div>
			<form action="login.do" method="post" id="login">
			<div class="log">
				<input id="id" type="text" name="id" placeholder="넥슨ID(아이디 또는 이메일)를 입력해주세요">
				<input id="pw" type="password" name="pw" placeholder="비밀번호를 입력해주세요">
			</div>
			<div class="log-btn">
				<button style="cursor: pointer;" type="button" onclick="nullch()">넥슨ID 로그인</button>
			</div>
			</form>
			<div class="user-help">
				<ul>
					<li><a href="#">넥슨ID 찾기</a></li>
					<li><a href="#">비밀번호 찾기</a></li>
					<li><a href="#">넥슨 회원가입</a></li>
				</ul>
			</div>
			<div class="box">
				<ul>
					<li><a href="#"><img src="https://ssl.nx.com/S2/p3/login/2016/bt_facebook1.gif"></a></li>
					<li><a href="#"><img src="https://ssl.nx.com/S2/p3/login/2016/bt_google1.gif"></a></li>
					<li><a href="#"><img src="https://ssl.nx.com/S2/p3/login/2016/bt_naver1.gif"></a></li>
				</ul>
			</div>

		</section>
	</main>
		<footer>
		<section class="footer-wrap">
			<div class="copy-right"><p>© 2004 NEXON Korea Corporation All Rights Reserved.</div>
		</section>
	</footer>
</body>
</html>