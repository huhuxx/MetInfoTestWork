<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
	<title>项目管理</title>
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
	SELECT * from projectManage  order by projectId ASC;
</sql:query>
    <input type="button" onclick="javascript:window.location.href='addProject.jsp';"value="创建项目" /> 
	<table id="table" border="3" width="1107pd">
		<tr>
		   <th class="th" width="53pd" text-align:enter>ID</th>
		   <th class="th" width="187pd">项目名称</th>
		   <th class="th" width="334pd">项目描述</th>
		   <th class="th" width="189pd">更新时间</th>
		   <th class="th" width="249pd">更新用户</th>
		   <th class="th" width="95pd">操作</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
		<tr>
		   <td class="td" align="center"><c:out value="${row.projectId}"/></td>
		   <td class="td" align="center"><c:out value="${row.projectName}"/></td>
		   <td class="td"><c:out value="${row.projectDescription}"/></td>
		   <td class="td" align="center"><c:out value="${row.updateTime}"/></td>
		   <td class="td" align="center"><c:out value="${row.username}"/></td>
		   	<td>
		   	   <form action="ToDeleteProjectServlet" method="post"> 
		   			<input type="hidden" value=${row.projectId} name="projectId"/>  
		   			<input type="submit" value="删除" />			
		   	   </form>
		   	   <form action="ToChangeProjectServlet" method="post"> 
		   			<input type="hidden" value=${row.projectId} name="projectId"/>  	
		   			<input type="submit" value="编辑" />		
		   	   </form> 
		   	</td>
		</tr>
		</c:forEach>
		<div class="pageNum">
				总共有${page.totalPageNum }页，总共有${page.totalCount }个数据；
				<a href="projectList?page=1">首页</a>
				<a href="projectList?page=${page.prePageNum }">上一页</a>
			
				第${page.currentPageNum }页
				
				<a href="projectList?page=${page.nextPageNum }">下一页</a>
				<a href="projectList?page=${page.totalPageNum }">末页</a>
		</div>
	</table>
</body>

</html>