<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mystyle2.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="js/myajax.js"></script>
<script>
$("#del").click(function(){
	alert('삭제 되었습니다.');
})
</script>
</head>
<body>
	<main>
		<h1>메인영역</h1>
		<div class="main-wrap">
			<div class="board">
				<ul>
					<li class="no">번호</li>
					<li class="subject">아이디</li>
					<li class="writer">이름</li>
					<li class="writer">이메일</li>
					<li class="date">가입일자</li>
				</ul>
				<c:forEach items="${member}" var="member">
					<ul>
						<li class="no">${member.no}</li>
						<li class="subject">${member.id}</li>
						<li class="writer">${member.name}</li>
						<li class="writer">${member.email}</li>
						<li class="date">${member.reg_date}</li>
						<li><input id="chbox" type="checkbox" name="remove" value="${member.no}"></li>
					</ul>
				</c:forEach>
				<a onclick="del()" style="float: right;">삭제</a>
				<form action="usersearch.do" method="post">
					<div>
						<input type="search" name="search"  placeholder="검색어를 입력하시오">
					</div>
				</form>
				<div>
					<ul class="memo">
					<li><a href="adminPage.jsp">메인으로</a></li>
					</ul>
				</div>
			</div>
		</div>
	</main>
</body>
</html>