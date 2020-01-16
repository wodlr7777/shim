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
<script src="js/ajax.js"></script>
</head>
<body>
	<main>
		<h1>메인영역</h1>
					<div class="board">
			<ul>
				<li class="no">번호</li>
				<li class="subject">제목</li>
				<li class="content">내용</li>
				<li class="writer">작성자</li>
				<li class="date">작성일</li>
			</ul>
			<ul>
				<li class="no">${board.no}</li>
				<li class="subject">${board.subject}</li>
				<li class="content">${board.content}</li>
				<li class="writer">${board.writer}</li>
				<li class="date">${board.reg_date}</li>
			</ul>
			<a onclick="detaildel('${board.no}')" style="cursor: pointer">삭제</a>
			<a onclick="board()">메인으로</a>
			</div>
	</main>
</body>
</html>