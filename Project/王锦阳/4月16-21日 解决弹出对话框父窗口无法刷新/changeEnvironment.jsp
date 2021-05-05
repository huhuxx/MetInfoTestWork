<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
	<title>更新环境</title>
	 <base target="_self"  />
	<style>
		#table{
		}
		.th{
		font-size:20
		}
		.td{
		font-size:16
		}
	</style>
</head>
<body>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
	     url="jdbc:mysql://localhost:3306/implementTest?useUnicode=true&characterEncoding=utf-8"
	     user="root"  password="123456"/>
	<sql:query dataSource="${snapshot}" var="result">
		SELECT projectName from projectManage;
	</sql:query>
	<form action="ChangeEnvironmentServlet" method="post">
		环境名称：<input type="text" name="environmentName"/><br>
		URL：<input type="text" name="url"/><br>
		所属工程：<select id="project" name="project">
					<c:forEach var="row" items="${result.rows}">
					   <option><c:out value="${row.projectName}"/></option>
					</c:forEach>
			   </select><br> 
		<%String btnname = request.getParameter("TenvironmentId"); %>
		<input type="hidden" value=<%=btnname %> name="TenvironmentId"/> 	
		<br/>
		<input type="submit" name="inputbox" value="确定" onclick="bconfirm();">
	    <input type="button" name="inputboxbs" value=取消 onclick="bcancel();">
	</form>
</body>
</html>
<script type="text/javascript">
	function bconfirm(){
		alert("编辑成功！");
		window.close();
	  }
	  function bcancel(){
	     window.close();
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
	<title>更新环境</title>
	 <base target="_self"  />
	<style>
		#table{
		}
		.th{
		font-size:20
		}
		.td{
		font-size:16
		}
	</style>
</head>
<body>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
	     url="jdbc:mysql://localhost:3306/implementTest?useUnicode=true&characterEncoding=utf-8"
	     user="root"  password="123456"/>
	<sql:query dataSource="${snapshot}" var="result">
		SELECT projectName from projectManage;
	</sql:query>
	<form action="ChangeEnvironmentServlet" method="post">
		环境名称：<input type="text" name="environmentName"/><br>
		URL：<input type="text" name="url"/><br>
		所属工程：<select id="project" name="project">
					<c:forEach var="row" items="${result.rows}">
					   <option><c:out value="${row.projectName}"/></option>
					</c:forEach>
			   </select><br> 
		<%String btnname = request.getParameter("TenvironmentId"); %>
		<input type="hidden" value=<%=btnname %> name="TenvironmentId"/> 	
		<br/>
		<input type="submit" name="inputbox" value="确定" onclick="bconfirm();">
	    <input type="button" name="inputboxbs" value=取消 onclick="bcancel();">
	</form>
</body>
</html>
<script type="text/javascript">
	function bconfirm(){
		alert("编辑成功！");
		window.close();
	  }
	  function bcancel(){
	     window.close();
	  }
>>>>>>> a2c0e3927d752efa07af5968f56a8cb4f02dcca6
</script>