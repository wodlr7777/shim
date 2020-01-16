<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<section class="header-wrap">
		<h1>헤더 영역</h1>
		<section class="left">
			<h1>왼쪽</h1>
			<div class="dropdown">
				<div class="btn">
					<a href="#"><span> <i></i> <i></i> <i></i>
					</span></a>
				</div>
				<div>
					<a href="#">메뉴</a>
					<div class="dropdown-content">
						<div>
							<a href="board.do">게시판</a>
						</div>
					</div>
				</div>
			</div>
		</section>
		<section class="center">
			<h1>가운데 로고</h1>
			<div>
				<a href="index.jsp"><img
					src="https://rs.nxfs.nexon.com/gnb/images/logo_nexon.png"></a>
			</div>
		</section>
		<section class="right">
			<h1>유저 메뉴</h1>
			<div>
				<c:if test="${empty member }">
					<ul>
						<li>PC방 <span>OFF</span></li>
						<li class="reg"><a href="register.jsp">회원가입</a></li>
						<li class="login"><a href="login.jsp">로그인</a></li>
					</ul>
				</c:if>
				<c:if test="${not empty member }">
					<ul>
						<li>PC방 <span>OFF</span></li>
						<li class="reg"><a href="#">쪽지</a></li>
						<li class="reg"><a href="logout.do">로그아웃</a></li>
						<li id="reg" class="reg"><a href="#">${member.id }</a></li>
					</ul>
					<div class="dropdown-content2">
						<div>
							<a href="board.do">게시판</a>
						</div>
					</div>
				</c:if>
			</div>
		</section>
	</section>
</header>