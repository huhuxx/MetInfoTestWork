<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
	<title>首页</title>
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
	SELECT * from mainPage;
</sql:query>
	<c:forEach var="row" items="${result.rows}">
		测试项目：${row.projectNumber}
		测试接口：${row.implementNumber}
		测试任务：${row.testNumber}
		测试人数：${row.memberNumber}
	</c:forEach>
</body>
</html>