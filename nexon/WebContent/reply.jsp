<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="js/myajax.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
	<main>
		<h1>메인영역</h1>
		<div class="main-wrap">
			<div class="reply">
				<input type="hidden" id="viewToken" value="${viewToken}" name="viewToken">
				 <input type="hidden" id="no" value="${no}" name="no"> 
				 <input type="text" placeholder="내용" name="content" id="content"> 
				 <input type="text" placeholder="작성자" readonly="readonly" value="${member.name }" name="writer" id="writer">
				  <a onclick="nullcheck()">저장하기</a> 
				  <a href="detail.do?no=${no}">취소하기</a>
			</div>
		</div>
	</main>
</body>
</html>