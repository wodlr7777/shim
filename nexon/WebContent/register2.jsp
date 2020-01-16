<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/reg2.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script>
	$(function(){
		$("#id").keyup(function(){
			var id=$("#id").val().trim();
			if(id.length<4){
				$(".id-txt").text("아이디는 최소 4글자 이상");
			}
			else{
				$.ajax({
					url:"idcheck.do",
						data:{"id":id},
						success:function(result){
							if(result==0){
								$(".id-txt").text("사용가능한 아이디입니다.");
							}
							else{
								$(".id-txt").text("중복된 아이디입니다.");
							}
						}
						});
			}
			});
		});
		
	
    function RegCheck(){
    	var id=$("#id").val();
    	var pw=$("#pw").val();
    	var pw2=$("#pw2").val();
    	var name=$("#name").val();
    	var email=$("#email").val();
        if(id==""){
        	swal("아이디를 입력해 주세요");
            return;
        }else if(pw==""){
        	swal("비밀번호를 입력해 주세요");
        	return;
        }else if(pw2==""){
        	swal("비밀번호를 입력해 주세요");
        	return;
        }else if(name==""){
        	swal("이름을 입력해 주세요");
        	return;
        }else if(email==""){
        	swal("이메일 입력해 주세요");
        	return;
        }
    	$.ajax({
			url:"idcheck.do",
				data:{"id":id},
				success:function(result){
					if(result==0){
						$("#reg").submit();
					}
					else{
						swal('중복된 아이디입니다.');
						$("#id").focus();
					}
				}
				});
    }
     
    

	</script>
</head>
<body>
	<header>
		<section class="header-wrap">
			<div class=left>
				<a href="#"><img
					src="https://ssl.nx.com/S2/membership/2011/global/tit_members.gif">
					</a>
			</div>
			<div class="right">
				<ul>
					<li><a href="index.jsp">넥슨닷컴</a></li>
					<li><a href="reg.do">회원가입</a></li>
					<li><a href="login.jsp">로그인</a></li>
				</ul>
			</div>
		</section>
	</header>
	<main>
		<section class="main-wrap">
			<div class="box">
			<form action="register.do" method="post" name="reg" id="reg">
			<input type="hidden" value="${token }" name="token">
				<ul>
					<li><input type="text" name="id" placeholder="아이디" id="id" required><span class="id-txt"></span></li>
					<li><input type="password" name="pw" placeholder="비밀번호" required id="pw"></li>
					<li><input type="password" name="pw2" placeholder="비밀번호 확인" required id="pw2"></li>
					<li><input type="text" name="name" placeholder="이름" required id="name"></li>
					<li><input type="email" name="email" placeholder="이메일" required id="email"></li>
				</ul>
					<button type="button" onclick="RegCheck()">회원가입</button>
				</form>
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