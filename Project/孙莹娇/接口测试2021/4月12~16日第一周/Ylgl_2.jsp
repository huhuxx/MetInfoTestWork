<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
<head>
    <title>学好测试过大年接口测试平台</title>
    <script type="text/javascript">
    (function (doc, win) {
        var docEl = doc.documentElement,
          resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
          recalc = function () {
            var clientWidth = docEl.clientWidth;
            if (!clientWidth) return;
            // 根据设备的比例调整初始font-size大小
            if(clientWidth>640) clientWidth = 640;
            docEl.style.fontSize = 50 * (clientWidth / 320) + 'px';
          };
        if (!doc.addEventListener) return;
        win.addEventListener(resizeEvt, recalc, false);
        doc.addEventListener('DOMContentLoaded', recalc, false);
      })(document, window);
    </script>
    <style type="text/css">
    *{
		margin:0;
		padding:0;
	}
	html,body{
    	height: 100%;
    	padding: 0; 
    	margin: 0;
	}
	a{
		text-decoration:none;
		color:#fff;
		opacity:0.8;
		
	}
	a:hover{
		opacity:1;
	}
	#all{
		height: 100%; 
		padding: 100px 0 0; 
		box-sizing: border-box ; 
		position: relative;
	}
	#Banner{
		height:100px;
		position:absolute;
		top:0;
		left:0;
		float:left;
		width:100%;
		line-height:18%;
		background-color:#23262E;
		font-size:1.4rem;
	}
	#Banner_title{
		font-size:0.3rem;
		float:left;
		position:relative;
		top:10px;
		left:10px;
		font-weight:bold;
		color:#fff;
	}
	#Banner_description{
		font-size:0.15rem;
		color:#fff;
		opacity: 0.7;
		float:left;
		position:relative;
		top:-10px;
	}
	#Banner_user{
		font-size:0.16rem;
		float:right;
		position:relative;
		top:15px;
	}
	#user{
		float:right;
		position:relative;
		right:200px;
		color:#fff;
	}
	#left{
	    width:15%;
	    height:100%;
    	position:relative;
		font-size:1.6rem;
		background-color: #2B2E34;
		float:left;
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
	table {
		max-width: 90%;
		margin-left: 100px;
		margin-top: 30px;
		background: #FFFFFF;
		padding: 30px 30px 20px 30px;
		font: 26px Arial, Helvetica, sans-serif;
		color: #666;
		border-radius: 5px;
		-webkit-border-radius: 5px;
		-moz-border-radius: 5px;
	}
	</style>

</head>
<body>

<div id="all">
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
			<li class="filter"><a href ="Yhgl_2.jsp" target ="_self"><img id="list_img" src="images/X_10.jpg" />用户管理</a></li>
			<li class="filter"><a href ="About.jsp" target ="_self"><img id="list_img" src="images/X_11.jpg" />关于我们</a></li>
		</ul>
	</div>
</div>
<div id="right">
	这是用例管理的内容~
	<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
	     url="jdbc:mysql://localhost:3306/request?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8"
	     user="root"  password="87654321"/>
	
	<sql:query dataSource="${snapshot}" var="result">
		SELECT * from requests;
	</sql:query>
	<table border="1" width="70%">
		<tr>
			<th>ID</th>
			<th>请求方式</th>
			<th>src</th>
			<th>删除</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
		<tr>
			<td><c:out value="${row.requestId}"/></td>
			<td><c:out value="${row.requestMethod}"/></td>
			<td><c:out value="${row.url}"/></td>
		    <td><a href='delete?id=${row.requestId}'>delete</a></td>
		</tr>
		</c:forEach>
	</table>
</div>
</div>
</body>

 
</html>