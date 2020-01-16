<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nexon</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>
<body>
				<section class="pc-game">
				<c:forEach items="${game }" var="game" >
				<section class="pc-game1">
						<div class="pc-game-img">
							<a href="#"><img src="images/game${game.no}.jpg"></a>
						</div>
						<h2>${game.name}</h2>
						<div class="box">
						<div class="pc-game-name">
								<span>EVENT</span>
								<p>${game.gameinfo }
							</div>
							<div class="pc-game-subject">
								<p>${game.kind }
								<div class="pc-game-subject1">
								</div>
							</div>
						</div>
					</section>
					</c:forEach>
					</section>
</body>
</html>