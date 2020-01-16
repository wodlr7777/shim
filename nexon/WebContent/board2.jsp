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
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
$("#del").click(function(){
	swal('삭제 되었습니다.');
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
					<li class="subject">제목</li>
					<li class="writer">작성자</li>
					<li class="date">작성일</li>
				</ul>
				<c:forEach items="${board}" var="board">
					<ul>
						<li class="no">${board.no}</li>
						<li class="subject"><a onclick="detail('${board.no}')">${board.subject}</a></li>
						<li class="writer">${board.writer}</li>
						<c:if
							test="${board.reg_date.toLocalDate() eq board.reg_date.toLocalDate().now() }">
							<li class="date">${board.reg_date.toLocalTime()}</li>
						</c:if>
						<c:if
							test="${board.reg_date.toLocalDate() ne board.reg_date.toLocalDate().now() }">
							<li class="date">${board.reg_date.toLocalDate()}</li>
						</c:if>
						<li><input id="chbox" type="checkbox" name="remove"
							value="${board.no}"></li>
					</ul>
				</c:forEach>
				<div>
					<input type="text" name="search"
						placeholder="검색어를 입력하시오" onKeypress="javascript:if(event.keyCode==13){search(value)}">
				</div>
				<div>
					<ul class="memo">
						<c:if test="${page.pageStart > 1 }">
							<li><a onclick="prevpage(${page.pageStart-1 })">이전</a></li>
						</c:if>
						<c:forEach begin="${page.pageStart }" end="${page.pageEnd }"
							varStatus="status">
							<li><a id="page" onclick="paging(${status.index })">${status.index }</a></li>
						</c:forEach>
						<c:if test="${page.pageEnd < page.pageTotal }">
							<li><a onclick="nextpage(${page.pageEnd+1 })">다음</a></li>
						</c:if>
					</ul>
				</div>
				<div class="btn2">
					<a onclick="adwrite()">글쓰기</a> <a
						onclick="boarddel()" style="float: right;">삭제</a>
				</div>
			</div>
		</div>
	</main>
</body>
</html>