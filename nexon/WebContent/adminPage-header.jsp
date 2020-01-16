<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<header>
		<section class="header-wrap">
			<h1>헤더 영역</h1>
			<section class="left">
				<h1>왼쪽</h1>
				<div class="dropdown">
				</div>
			</section>
			<section class="center">
				<h1>가운데 로고</h1>
				<div>
					<a href="adminPage.jsp"><img
						src="https://rs.nxfs.nexon.com/gnb/images/logo_nexon.png"></a>
				</div>
			</section>
			<section class="right">
				<h1>유저 메뉴</h1>
				<div>
					<ul>
						<li class="reg"><a onclick="board()" style="cursor: pointer;">게시글 관리</a></li>
						<li class="reg"><a onclick="userinfo()" style="cursor: pointer;">회원관리</a></li>
						<li class="reg"><a href="logout.do">로그아웃</a></li>
						<li id="reg" class="reg">${member.id }</li>
					</ul>
					<div class="dropdown-content2">
						<div>
							<a href="board.do">게시판</a>
						</div>
					</div>
				</div>
			</section>
		</section>
	</header>