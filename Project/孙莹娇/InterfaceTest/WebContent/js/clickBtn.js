//通过js动态的给按钮添加一个click事件
$(function(){
	$("submit").click(function(){	
		//得到自定义的custom
		return $(this).attr("value")
	})
})
