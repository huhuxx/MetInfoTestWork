<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
	<title>测试环境</title>
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
<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/implementTest?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8"
     user="root"  password="123456"/>
<sql:query dataSource="${snapshot}" var="result">
	SELECT * from environmentManage order by environmentId ASC;
</sql:query>

	<input type="button" onclick="javascript:window.location.href='addEnvironment.jsp';" value="增加环境" /> 
	<table id="table" border="3" width="1127pd">
		<tr>
		   <th class="th" width="47pd">ID</th>
		   <th class="th" width="166pd">环境名称</th>
		   <th class="th" width="137pd">swagger导入</th>
		   <th class="th" width="221pd">url</th>
		   <th class="th" width="137pd">所属项目</th>
		   <th class="th" width="168pd">更新时间</th>
		   <th class="th" width="165pd">更新用户</th>
		   <th class="th" width="86pd">操作</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
		<tr>
		   <td class="td" align="center">${row.environmentId}</td>
		   <td class="td">${row.environmentName}</td>
		   <td class="td" align="center">${row.swaggerNumber}</td>
		   <td class="td">${row.url}</td>
		   <td class="td" align="center">${row.project}</td>
		   <td class="td" align="center">${row.updateTime}</td>
		   <td class="td" align="center">${row.username}</td>
		   <td class="td" align="center">
		       <form action="ToDeleteEnvironmentServlet" method="post"> 
		   			<input type="hidden" value=${row.environmentId} name="TenvironmentId"/>  	
		   			<input type="submit" value="删除" />		
		   	   </form> 	
		   	   <form action="ToChangeEnvironmentServlet" method="post"> 
		   			<input type="hidden" value=${row.environmentId} name="environmentId"/>  	
		   			<input type="submit" value="编辑" />		
		   	   </form> 			
		   	</td>
		</tr>
		</c:forEach>
		<div class="pageNum">
				总共有${page.totalPageNum }页，总共有${page.totalCount }个数据；
				<a href="environmentList?page=1">首页</a>
				<a href="environmentList?page=${page.prePageNum }">上一页</a>
			
				第${page.currentPageNum }页
				
				<a href="environmentList?page=${page.nextPageNum }">下一页</a>
				<a href="environmentList?page=${page.totalPageNum }">末页</a>
		</div>
	</table>
</body>
</html>

