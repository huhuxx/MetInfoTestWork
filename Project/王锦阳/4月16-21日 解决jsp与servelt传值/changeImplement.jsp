<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>改变接口</title>
<base target="_self" />
</head>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/implementTest?useUnicode=true&characterEncoding=utf-8"
     user="root"  password="123456"/>
<sql:query dataSource="${snapshot}" var="result">
	SELECT environmentName from environmentManage;
</sql:query>
	<form action="ChangeImplementServlet" method="post">
		接口名称：<input type="text" name="implementName" /><br>
		所属环境：<select id="environment" name="environment">
					<c:forEach var="row" items="${result.rows}">
						 <option><c:out value="${row.environmentName}"/></option>
					</c:forEach>
			   </select><br>
		请求方式：<select id="requestStyle" name="requestStyle">
				<option value="GET">GET</option>
				<option value="POST">POST</option>
			   </select><br>
		数据传输方式：<select id="dataStyle" name="dataStyle">
			       <option value="Params">Params</optionS>
		       	   <option value="JSON">JSON</option>
		         </select>
		请求地址：<input type="text" name="url" />
		<%String btnname = request.getParameter("TimplementId"); %>
		<input type="hidden" value=<%=btnname %> name="TimplementId"/> 	
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
</script>