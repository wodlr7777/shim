/**
 * 
 */

$(function(){
	/*var vewW=$(window).width();
	alert(vewW);
	$(".visual").css({width:vewW});
	$(".images li img").css({width:vewW});*/
	var timer=setInterval(slide, 3000);
	$(".visual").hover(function(){
		clearInterval(timer);
		$(".visual").css("cursor","pointer");
	},function(){
		timer=setInterval(slide,3000);
	});

});

function slide(){
	$(".visual-img").animate({left: '-1900px'},1500,function(){
		/*$(".images li:first").appendTo(".images");*/
		$(".visual-img li:first").insertAfter(".visual-img li:last");
		$(".visual-img").css("left","0");
	});
}
function next(){
	$(".visual-img li:last").insertBefore(".visual-img li:first");
	$(".visual-img").css({left:'-1900px'});
	$(".visual-img").animate({left: 0},1500);
}