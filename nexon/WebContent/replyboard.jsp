<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="js/myajax.js"></script>
</head>
<body>
	<main>
		<h1>메인영역</h1>
			<div class="reply">
			<c:forEach items="${board }" var="board">
			<ul>
				<li class="content">${board.content}</li>
				<li class="writer">${board.writer}</li>
				<li class="date">${board.reg_date}</li>
				<li><a onclick="replydel('${board.no }','${board.replyno}')">삭제</a></li>
			</ul>
			</c:forEach>
			</div>
	</main>
</body>
</html>