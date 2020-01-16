<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nexon</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="js/myjs.js"></script>
<script src="js/myjs2.js"></script>
<script src="js/myajax.js"></script>
<script>
$(document).ready(function(){
		$.ajax({
			type : "GET",
			url : "gamesearch.do",
			data : {"game" : ""},
			success : function(result) {
				$(".pc-game").html(result);
			}
		});
	  $(".dropdown").click(function(){
	    $(".dropdown-content").css("transform","translate3d(0,0,0)").css("transition","0.5s");
	    $("body").css("filter","grayscale(30%)");
	  });
	  $(".dropdown-content").mouseleave(function(){
		    $(".dropdown-content").css("transform","translate3d(-100%,0,0)").css("transition","0.5s");
		    $("body").css("filter","grayscale(0)");
		  });
	  $("#reg").click(function(){
		  $(".dropdown-content2").css("transform","translate3d(0,0,0)").css("transition","0.5s");
		  $("body").css("filter","grayscale(30%)");
	  });
	  $(".dropdown-content2").mouseleave(function(){
		    $(".dropdown-content2").css("transform","translate3d(100%,0,0)").css("transition","0.5s");
		    $("body").css("filter","grayscale(0)");
		  });
	});
</script>
</head>
<body>
	<h1>바디영역</h1>
	<jsp:include page="header.jsp"></jsp:include>
	<main>
		<section class="main-wrap">
				<h1>메인영역</h1>
			<section class=visual>
				<h1>메인이미지</h1>
				<div>
					<ul class="visual-img">
						<li><div></div></li>
						<li><div></div></li>
						<li><div></div></li>
						<li><div></div></li>
						<li><div></div></li>
					</ul>
				</div>
				<a href="#"></a>
			</section>
			<section class="main">
				<h1>추천게임,로그인영역</h1>
				<c:if test="${empty member }">
				<div class="game">
					<div class="title">
						<h2>
							추천게임
						</h2>
					</div>
					<section class="rec-game">
						<h1>게임</h1>
						<div class="recomend">
							<div class="img-size">
								<a href="#" class="detail"> <img
									src="https://rs.nxfs.nexon.com/gameusr/19/7/fvmA29180044074.png">
								</a>
							</div>
							<div>
								<a href="#" class="detail"><span>추천</span> <i>메이플스토리2</i></a>
							</div>
						</div>
						<div class="recomend">
							<div class="img-size">
								<a href="#" class="detail"> <img
									src="https://rs.nxfs.nexon.com/gameusr/19/10/Bl1w24162553758.png">
								</a>
							</div>
							<div>
								<a href="#" class="detail"><span>추천</span> <i>EA SPORTS<br>FIFA
										ONLINE 4
								</i></a>
							</div>
						</div>
						<div class="recomend">
							<div class="img-size">
								<a href="#" class="detail"> <img
									src="https://rs.nxfs.nexon.com/gameusr/19/7/SH0J29212201541.png">
								</a>
							</div>
							<div>
								<a href="#" class="detail"><span>추천</span> <i>카트라이더</i></a>
							</div>
						</div>
						<div class="recomend">
							<div class="img-size">
								<a href="#" class="detail"> <img
									src="https://rs.nxfs.nexon.com/gameusr/19/7/3SkR29180016094.png">
								</a>
							</div>
							<div>
								<a href="#" class="detail"><span>추천</span> <i>메이플스토리</i></a>
							</div>
						</div>
						<div class="recomend">
							<div class="img-size">
								<a href="#" class="detail"> <img
									src="https://rs.nxfs.nexon.com/gameusr/19/7/3CRJ29175605990.png">
								</a>
							</div>
							<div>
								<a href="#" class="detail"><span>추천</span> <i>던전앤파이터</i></a>
							</div>
						</div>
					</section>
				</div>
				<section class="log-title title">
					<h1>고객센터</h1>
					<h2>
						<a href="#">고객센터</a>
					</h2>
					<div class="log">
						<section class="login1">
							<h1>로그인1</h1>
							<a href="login.jsp">NEXON ID 로그인</a>
						</section>
						<section class="login2">
							<h1>로그인2</h1>
							<section class="log1">
								<h1>일회용 로그인</h1>
								<a href="#">일회용 로그인</a>
							</section>
							<section class="log2">
								<h1>QR 로그인</h1>
								<a href="#">QR 로그인</a>
							</section>
						</section>
						<section class="a-login">
							<h1>로그인3</h1>
							<p>다른 계정 간편 로그인
							<p>
								<!-- <img src=""><img src=""><img src=""> -->
						</section>
						<section class="f-login">
							<h1>개인정보 수정</h1>
							<ul>
								<li><a href="#">넥슨 ID찾기</a></li>
								<li><a href="#">비밀번호 찾기</a></li>
								<li><a href="#">회원가입</a></li>
							</ul>
						</section>
					</div>
				</section>
				</c:if>
				<c:if test="${not empty member }">
					<div class="game">
					<div class="title">
						<h2 style="font-size: 25px;">
							<span style="color:#07f;">${member.id }</span>님,어서오세요
						</h2>
					</div>
					<section class="rec-game">
						<h1>게임</h1>
						<div class="recomend">
							<div class="img-size">
								<a href="#" class="detail"> <img
									src="https://rs.nxfs.nexon.com/gameusr/19/7/fvmA29180044074.png">
								</a>
							</div>
							<div>
								<a href="#" class="detail"><span>추천</span> <i>메이플스토리2</i></a>
							</div>
						</div>
						<div class="recomend">
							<div class="img-size">
								<a href="#" class="detail"> <img
									src="https://rs.nxfs.nexon.com/gameusr/19/10/Bl1w24162553758.png">
								</a>
							</div>
							<div>
								<a href="#" class="detail"><span>추천</span> <i>EA SPORTS<br>FIFA
										ONLINE 4
								</i></a>
							</div>
						</div>
						<div class="recomend">
							<div class="img-size">
								<a href="#" class="detail"> <img
									src="https://rs.nxfs.nexon.com/gameusr/19/7/SH0J29212201541.png">
								</a>
							</div>
							<div>
								<a href="#" class="detail"><span>추천</span> <i>카트라이더</i></a>
							</div>
						</div>
						<div class="recomend">
							<div class="img-size">
								<a href="#" class="detail"> <img
									src="https://rs.nxfs.nexon.com/gameusr/19/7/3SkR29180016094.png">
								</a>
							</div>
							<div>
								<a href="#" class="detail"><span>추천</span> <i>메이플스토리</i></a>
							</div>
						</div>
						<div class="recomend">
							<div class="img-size">
								<a href="#" class="detail"> <img
									src="https://rs.nxfs.nexon.com/gameusr/19/7/3CRJ29175605990.png">
								</a>
							</div>
							<div>
								<a href="#" class="detail"><span>추천</span> <i>던전앤파이터</i></a>
							</div>
						</div>
					</section>
				</div>
				<section class="log-title title">
					<h1>고객센터</h1>
					<div class="user-menu">
					<h2>
						<a href="#">고객센터</a>
						<a href="account.jsp">내정보</a>
						<a href="logout.do">로그아웃</a>
					</h2>
					</div>
					<div class="log-ok">
						<div class="log-left">
						<ul class="log-top">
						<li><a href="#">캐시/보안</a></li>
						<li><a href="#">맞춤소식</a></li>
						</ul>
						<ul class="log-mid">
						<li><a href="#">넥슨캐시</a></li>
						<li>플레이포인트</li>
						</ul>
						<ul class="log-bot">
						<li class="bot-left"><a href="#">충전</a></li>
						<li class="bot-right"><a href="#">자동충전</a></li>
						</ul>
						</div>
						<div class="log-right">
						<ul>
						<li><a href="#">해외 로그인 차단</a></li>
						<li><a href="#">아이디 생성잠금</a></li>
						<li><a href="#">넥슨캐시 보안설정</a></li>
						<li><a href="#">U-OTP</a></li>
						<li><a href="#">넥슨 OTP</a></li>
						</ul>
						</div>
					</div>
				</section>
				</c:if>
			</section>
			<section class="main2">
				<h1>전체게임</h1>
				<section class="search">
					<ul>
						<li><h2>전체게임</h2></li>
						<li class="btn-search"><input style="font-weight: bold;" id="gamesearch" type="text"
							placeholder="게임명 검색" name="game" onkeyup="gamesearch(value)">
							</li>
					</ul>
				</section>
				<section class="all-game">
				<h1>카테고리</h1>
					<ul class="all-game2">
						<li><a class="all" onclick="allgame()">#전체</a></li>
						<li><a class="RPG" onclick="kind('RPG')">#RPG</a></li>
						<li><a class="ActionRPG" onclick="kind('ActionRPG')">#액션 RPG</a></li>
						<li><a class="AOSMOBA" onclick="kind('AOSMOBA')">#AOS/MOBA</a></li>
						<li><a class="FPS" onclick="kind('FPS')">#FPS</a></li>
						<li><a class="캐주얼" onclick="kind('캐주얼')">#캐주얼</a></li>
						<li><a class="스포츠" onclick="kind('스포츠')">#스포츠</a></li>
						<li><a class="Event" onclick="kind('Event')">#이벤트</a></li>
						<li><a class="update" onclick="kind('update')">#업데이트</a></li>
						<li><a class="new" onclick="kind('new')">#신규게임</a></li>
					</ul>
				</section>
					<section class="pcmob">
					<h1>pc and mobile</h1>
							<a class="pc" onclick="pc()" style="margin-right:30px;">pc게임</a>
						<a class="mobile" onclick="mobile()" >모바일 게임</a>
					</section>
				<section class="pc-game">
					</section>
			</section>
		</section>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>