<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
	<title>接口管理</title>
	<style>
		a{
			text-decoration:none;
			color:#000;
			opacity:0.8;
		}
		#table{
		}
		.th{
			font-size:20
		}
		.td{
			font-size:14
		}
		.content{
		}
		.pageNum{
		}
		
	</style>
</head>
<body>
<%

%>
<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/implementTest?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8"
     user="root"  password="123456"/>
	<input type="button" onclick="javascript:window.location.href='addImplement.jsp';" value="增加接口" />
	<table id="table" border="3" width="1129pd">
		<tr>
		   <th class="th" width="36pd">ID</th>
		   <th class="th" width="311pd">接口名称</th>
		   <th class="th" width="136pd">所属环境</th>
		   <th class="th" width="111pd">请求方式</th>
		   <th class="th" width="158pd">数据传输方式</th>
		   <th class="th" width="246pd">请求地址</th>
		   <th class="th" width="131pd">操作</th>
		</tr>
		
		<div class="content">
			<c:forEach items="${page.list}" var="inter">
				<tr>
				   <td class="td" align="center"><c:out value="${inter.impId}"/></td>
				   <td class="td"><c:out value="${inter.impName}"/></td>
				   <td class="td"><c:out value="${inter.environment}"/></td>
				   <td class="td" align="center"><c:out value="${inter.requestStyle}"/></td>
				   <td class="td" align="center"><c:out value="${inter.dataStyle}"/></td>
				   <td class="td"><c:out value="${inter.requestURL}"/></td>
				   <td class="td">
				   	   <form action="ToDeleteImplementServlet" method="post"> 
				   			<input type="hidden" value=${row.implementId} name="TimplementId"/>  	
				   			<input type="submit" value="删除" />		
				   	   </form>
				   	   <form action="ToChangeImplementServlet" method="post"> 
				   			<input type="hidden" value=${row.implementId} name="implementId"/>  	
				   			<input type="submit" value="编辑" />		
				   	   </form> 
			   		</td>
				</tr>
			</c:forEach>
			
			<div class="pageNum">
				总共有${page.totalPageNum }页，总共有${page.totalCount }个数据；
				<a href="interfaceList?page=1">首页</a>
				<a href="interfaceList?page=${page.prePageNum }">上一页</a>
			
				第${page.currentPageNum }页
				
				<a href="interfaceList?page=${page.nextPageNum }">下一页</a>
				<a href="interfaceList?page=${page.totalPageNum }">末页</a>
			</div>
		</div>
	</table>
</body>
</html>