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
<script src="js/myjs.js"></script>
<script src="js/myjs2.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
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
						<li class="subject"><a href="detail.do?no=${board.no}">${board.subject}</a></li>
						<li class="writer">${board.writer}</li>
						<li class="date">${board.reg_date}</li>
					</ul>
				</c:forEach>
				<div>
					<a href="board.do" style="font-weight: bold">메인으로</a>
				</div>
				<div class="btn2">
					<a href="write.jsp">글쓰기</a>
				</div>
			</div>
		</div>
	</main>
	<footer>
		<h1>푸터영역</h1>
		<div class="footer-wrap">
			<section class="event">
				<h1>공지</h1>
				<ul>
					<li><a href="#">[공지] 12/9일 현대카드 결제 서비스 점검 안내</a></li>
					<li><img src=""> <img src=""> <img src=""></li>
				</ul>
			</section>
			<section class="company">
				<div class="company-info">
					<ul>
						<li>회사소개</li>
						<li>채용안내</li>
						<li>윤리경영</li>
						<li>이용약관</li>
						<li>개인정보처리방침</li>
						<li>청소년보호정책</li>
						<li>광고문의</li>
						<li>넥슨PC방</li>
						<li>게임시간선택제</li>
						<li>고객센터</li>
						<li>전체서비스</li>
					</ul>
					<div>
						<a></a>
					</div>
				</div>
				<div class="copyright">
					<h1>회사정보</h1>
					<p>㈜넥슨코리아 대표이사 이정헌 경기도 성남시 분당구 판교로 256번길 7 전화 : 1588-7701 팩스 :
						0502-258-8322</p>
					<p>E-mail : contact-us@nexon.co.kr 사업자등록번호 : 220-87-17483호
						통신판매업 신고번호 : 제2013-경기성남-1659호 사업자정보확인</p>
					<p>© 2004 NEXON Korea Corporation All Rights Reserved.</p>
				</div>
				<div class="footer-logo">
					<a><img></a>
				</div>
			</section>
		</div>
	</footer>
</body>
</html>