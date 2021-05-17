<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
	<title>用例管理</title>
	<style>
		#table{
		}
		.th{
		font-size:20
		}
		.td{
		font-size:14
		}
	</style>
</head>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/implementTest?useUnicode=true&characterEncoding=utf-8"
     user="root"  password="123456"/>
<sql:query dataSource="${snapshot}" var="result">
	SELECT * from caseManage;
</sql:query>
	<input type="button" onclick="javascript:window.location.href='addCase.jsp';" value="增加用例" />
	<table id="table" border="3" width="1129pd">
		<tr>
		   <th class="th" width="36pd">ID</th>
		   <th class="th" width="311pd">用例名称</th>
		   <th class="th" width="111pd">所属环境</th>
		   <th class="th" width="158pd">所属接口</th>
		   <th class="th" width="131pd">编辑</th>
		   <th class="th" width="131pd">删除</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
		<tr>
		   <td class="td" align="center"><c:out value="${row.caseId}"/></td>
		   <td class="td"><c:out value="${row.caseName}"/></td>
		   <td class="td"><c:out value="${row.environment}"/></td>
		   <td class="td" align="center"><c:out value="${row.implement}"/></td>   
		   <td>
		   	   <form action="ToChangeCaseServlet" method="post"> 
		   			<input type="hidden" value=${row.caseId} name="caseId"/>  	
		   			<input type="submit" value="编辑" />		
		   	   </form> 
		   </td>
		   <td class="td">
		   	   <form action="ToDeleteCaseServlet" method="post"> 
		   			<input type="hidden" value=${row.caseId} name="TcaseId"/>  	
		   			<input type="submit" value="删除" />		
		   	   </form>
		   	</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>