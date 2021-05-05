<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
	<title>添加环境</title>
	<base target="_self"  /> 
	<link rel="stylesheet" type="text/css" href="css/Bullet.css" />
</head>
<body>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
	     url="jdbc:mysql://localhost:3306/implementTest?useUnicode=true&characterEncoding=utf-8"
	     user="root"  password="123456"/>
	<sql:query dataSource="${snapshot}" var="result">
		SELECT projectName from projectManage;
	</sql:query>
	
	<div id = "form">
		<div id = "title"><p id="title_text">添加环境</p></div>
			<form action="AddEnvironmentServlet" method="post" id="form1">
				<div id="li_title">
					<ul id="ul_title">
						<li id="li_name">环境名称</li>
						<li id="li_link">URL</li>
						<li id="li_project">所属项目</li> 
					</ul>
				</div>
				
				<div id="li_text">
					<ul id="ul_text">
						<li><input type="text" name="environmentName" value="请输入"/></li>
						<li><input type="text" name="url" value="请输入"/></li>
						<li>
							<div id="select_env">
								<select id="project" name="project">
									<c:forEach var="row" items="${result.rows}">
							   		<option><c:out value="${row.projectName}"/></option>
									</c:forEach>
			   					</select>
				   			</div>
						</li>
					</ul>
				</div>
			  	<div id="submit">
					<input type="submit" name="inputbox" value="确定" onclick="bconfirm();">
	    			<input type="button" name="inputboxbs" value=取消 onclick="bcancel();">
	    		</div>
			</form>
	</div>
	
</body>
</html>
<script type="text/javascript">
	function bconfirm(){
		window.close();
	  }
	  function bcancel(){
	     window.close();
	  }
</script>

<style>
	ul li{
		float:left;
		font-size: 20px;
		width:269px;
	}
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
	<title>添加环境</title>
	<base target="_self"  /> 
	<link rel="stylesheet" type="text/css" href="css/Bullet.css" />
</head>
<body>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
	     url="jdbc:mysql://localhost:3306/implementTest?useUnicode=true&characterEncoding=utf-8"
	     user="root"  password="123456"/>
	<sql:query dataSource="${snapshot}" var="result">
		SELECT projectName from projectManage;
	</sql:query>
	
	<div id = "form">
		<div id = "title"><p id="title_text">添加环境</p></div>
			<form action="AddEnvironmentServlet" method="post" id="form1">
				<div id="li_title">
					<ul id="ul_title">
						<li id="li_name">环境名称</li>
						<li id="li_link">URL</li>
						<li id="li_project">所属项目</li> 
					</ul>
				</div>
				
				<div id="li_text">
					<ul id="ul_text">
						<li><input type="text" name="environmentName" value="请输入"/></li>
						<li><input type="text" name="url" value="请输入"/></li>
						<li>
							<div id="select_env">
								<select id="project" name="project">
									<c:forEach var="row" items="${result.rows}">
							   		<option><c:out value="${row.projectName}"/></option>
									</c:forEach>
			   					</select>
				   			</div>
						</li>
					</ul>
				</div>
			  	<div id="submit">
					<input type="submit" name="inputbox" value="确定" onclick="bconfirm();">
	    			<input type="button" name="inputboxbs" value=取消 onclick="bcancel();">
	    		</div>
			</form>
	</div>
	
</body>
</html>
<script type="text/javascript">
	function bconfirm(){
		window.close();
	  }
	  function bcancel(){
	     window.close();
	  }
</script>

<style>
	ul li{
		float:left;
		font-size: 20px;
		width:269px;
	}
>>>>>>> a2c0e3927d752efa07af5968f56a8cb4f02dcca6
</style>