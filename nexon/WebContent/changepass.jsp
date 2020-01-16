<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/account.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="js/myajax.js"></script>
</head>
<body>
	<div class="view-top">
	<h2>비밀번호 변경</h2>
	<ul>
	<li><a href="#">내정보&nbsp;></a></li>
	<li><a href="#">내정보관리&nbsp;></a></li>
	<li>비밀번호변경</li>
	</ul>
	</div>
	<div class="box">
	<ul><li>본인확인</li></ul>
	<ul><li>고객님의 소중한 개인정보보호를 위해서 본인확인을 진행합니다.</li></ul>
	<ul class="pass">
	<li>넥슨 비밀번호</li>
	<li><input type="password" id="pw"></li>
	<li><a onclick="pwcheck()">확인</a></li>
	</ul>
	</div>
</body>
</html>