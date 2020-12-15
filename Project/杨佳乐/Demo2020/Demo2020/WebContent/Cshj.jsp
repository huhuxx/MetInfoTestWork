<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>学好测试过大年接口测试平台</title>
    <style type="text/css">
    *{
		margin:0;
		padding:0;
	}
	a{
		text-decoration:none;
		color:#fff;
		opacity:0.7;
		
	}
	a:hover{
		opacity:1;
	}
	#Banner{
		left:0px;
		top:-1px;
		height:80px;
		line-height:18px;
		background-color:#23262E;
		font-size:14px;
	}
	#Banner_title{
		font-size:28px;
		font-weight:bold;
		margin-left:50px;
		padding-top:20px;
		color:#fff;
		float:left;
	}
	#Banner_description{
		font-size:14px;
		color:#fff;
		opacity: 0.7;
		float:left;
	}
	#Banner_user{
		margin-top:20px;
		font-size:16px;
		float:right;
	}
	#user{
		padding-bottom:30px;
		color:#fff;
	}
	#left{
		top: 79px;
		width: 253px;
		height:628px;
		font-size:20px;
		background-color: #2B2E34;
		padding-top:20px;
		float:left;
		display:inline-block;
	}
	#left_word,a{
		margin-left:25px;
		color:#fff;
		padding-top:10px;
		vertical-align:middle;
	}
	#left_word>a>img{
		vertical-align:middle;
	}
	ul li{
		list-style: none;
		line-height:50px;
  		height:50px;
	}
	#list li {
		color:#fff;
		opacity:0.7;
	}
	#list>li:hover{
		background:#23262E;
		display:block;
		opacity:1;
	}
	#list_img {
		vertical-align: middle;
	}
	.filter{
		font-size:20px;
		line-height:45px;
	}
	#right{
		top: 79px;
		height:600px;
		font-size:20px;
		padding-top:20px;
		float:left;
	}
	#right_index_img,#right_index_text {
		float:left;
	}
	#right_index_img {
		margin-left:120px;
	}
	#right_index_text {
		margin-left:20px;
	}
	#right_middle{
		float:left;
	}
	#xm,#rw,#jk,#person {
		float:left;
		width:180px;
		height:80px;
		margin:4px 40px 0px 40px;
	}
	#xm {
		background-color:#36cfca;
		margin-left:100px;
	}
	#xm_img,#xm_text,#jk_img,#rw_img,#person_img,#jk_text,#rw_text,#person_text {
		float:left;
		margin:6px 10px 0px 10px;
	}
	#rw_img,#person_img{
		margin-top:10px;
	}
	#xm_text,#jk_text,#rw_text,#person_text{
		margin-top:20px;
		color:white;
		font-size:12px;
	}
	#jk {
		background-color:#ffc439;
	}
	
	#rw {
		background-color:#fd4d4f;
		
	}
	#person {
		background-color:#42a7ff;
	}
	
	#right_report{
		margin-left:100px;
	}
	</style>

</head>
<body>
<div id="Banner">
	<div id="Banner_title">
		<h4>接口测试平台</h4>
		<br>
		<p id="Banner_description">8组学好测试过大年小组</p>
	</div>
	<div id="Banner_user">
		<a href="#" id="user" style="margin-left:15px">用户名</a>
		<a href="#" style="margin-left:15px"><img src="images/b_user1.png"></a>
		<a href="#" style="margin-left:15px"><img src="images/b_tc.png"></a>
	</div>
</div>
<div id="left">
	<div id="left_word">
		<ul id="list">
			<li class="filter"><a href ="Index.jsp" target ="_self"><img id="list_img" src="images/X_1.jpg" />首页</a></li>
			<li class="filter"><a href ="Xmgl.jsp" target ="_self"><img id="list_img" src="images/X_2.jpg" />项目管理</a></li>
			<li class="filter"><a href ="Cshj.jsp" target ="_self"><img id="list_img" src="images/X_3.jpg" />测试环境</a></li>
			<li class="filter"><a href ="Jkcs.jsp" target ="_self"><img id="list_img" src="images/X_4.jpg" />接口测试</a></li>
			<li class="filter"><a href ="Ylgl.jsp" target ="_self"><img id="list_img" src="images/X_5.jpg" />用例管理</a></li>
			<li class="filter"><a href ="Jkgl.jsp" target ="_self"><img id="list_img" src="images/X_6.jpg" />接口管理</a></li>
			<li class="filter"><a href ="Dsrw.jsp" target ="_self"><img id="list_img" src="images/X_7.jpg" />定时任务</a></li>
			<li class="filter"><a href ="Yxbg.jsp" target ="_self"><img id="list_img" src="images/X_8.jpg" />运行报告</a></li>
			<li class="filter"><a href ="Xncs.jsp" target ="_self"><img id="list_img" src="images/X_9.jpg" />性能测试</a></li>
			<li class="filter"><a href ="Yhgl.jsp" target ="_self"><img id="list_img" src="images/X_10.jpg" />用户管理</a></li>
			<li class="filter"><a href ="About.jsp" target ="_self"><img id="list_img" src="images/X_11.jpg" />关于我们</a></li>
		</ul>
	</div>
</div>
<div id="right">
	这是测试环境的内容
</div>
</body>

 
</html>