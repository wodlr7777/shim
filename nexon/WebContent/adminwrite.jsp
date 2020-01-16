<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>
<body>
	<main>
		<h1>메인영역</h1>
		<div class="main-wrap">
			<div class="board">
				<input id="viewToken" type="hidden" value="${viewToken}" name="viewToken">
					<input id="subs" type="text" placeholder="제목" name="subject" > <input
						type="text" placeholder="내용" name="content" id="content"> <input
						type="text" placeholder="작성자" readonly="readonly" value="${member.name }" name="writer" id="writer">
					<a onclick="adminwrite2()">저장하기</a>
					<a onclick="board()">취소하기</a>
			</div>
		</div>
	</main>
</body>
</html>