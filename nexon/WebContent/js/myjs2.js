/**
 * author: cho 
 * version: 1.0
 * contact: nick2615@naver.com
 */
$(function(){
	var images = [
		"images/img1.jpg", 
		"images/img2.jpg",
		"images/img3.jpg",
		"images/img4.jpg",
		"images/img5.jpg"];
	
	$(".visual-img li>div").css("width","100%").css("height","560px");
	for (i = 0; i < images.length ; i++) {
		  $(".visual-img li>div").eq(i).css("background-image","url("+images[i]+")");
	}

});

