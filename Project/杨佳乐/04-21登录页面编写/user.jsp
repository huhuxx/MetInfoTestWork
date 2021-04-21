<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<style>
		body{
			background:url('images/asd1.png') no-repeat center top;
		}
		*{
			padding: 0;
			margin: 0;
		}
		#top{
		width:800px;
		height:833px;
		margin:0px auto;
		display: table;
		}
		#box1{
			padding: 0 20px;
			border: 0px;
			margin: 0px auto;
			display: table-cell;
		vertical-align: middle;
		}
		#top_1{
		width:500px;
			algin:center;
			margin: 0px auto;
		}
		#top_2{
		width:500px;
		margin:0px auto;
		margin-top:40px;
		}
		.inp{
			width: 300px;
			height: 50px;
			text-indent: 8px;
		}
		#top_3{
		margin:0px auto;
		margin-top:60px;
		width:500px;
		height:50px;
		}
		#btn{
			background: #1DC5A3;
			width: 410px;
			height: 50px;
			border: none;
			border-color: #666;
			color: white;
			border-radius: 5px;
			font-size:25px;
		}
		.up1{
		font-size:25px;
		}

	</style>
	<script>
	function jump(){
		window.location.replace("/MyFristServlet/theme.jsp");
	}
	</script>
</head>
<body>
<form action="AdminServlet"  method="post">
	<div id=one>
		<div id=top>
			<div id=box1>
				<div id=top_1>
					<span class=up1>用户名：</span>
					<input class="inp" type="password" name="name" placeholder="请输入用户名">
				</div>
				<div id=top_2>
					<span class=up1>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
					<input class="inp" type="password" name="password" placeholder="请输入密码">
				</div>
				<div id=top_3>
					<input id=btn type="submit" onClick="jump()" value="登录">
				</div>
			</div>
		</div>
	</div>
</form>
</body>
</html>