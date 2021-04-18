<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>接口测试</title>

<body style="background: #ffffff;">
	<!--
	JDBC 驱动名及数据库 URL 
	数据库的用户名与密码，需要根据自己的设置
	useUnicode=true&characterEncoding=utf-8 防止中文乱码
	 -->
	<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
	     url="jdbc:mysql://localhost:3306/request?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8"
	     user="root"  password="87654321"/>
	
	<sql:query dataSource="${snapshot}" var="result">
	SELECT * from requests;
	</sql:query>
	<h1>接口测试</h1>
	<table border="1" width="23%" style="float:left;">
	<tr>
	   <th>请求方式</th>
	   <th>src</th>
	</tr>
	<c:forEach var="row" items="${result.rows}">
	<tr>
	  <td><c:out value="${row.requestMethod}"/></td>
	  <td><c:out value="${row.url}"/></td>
	</tr>
	</c:forEach>
	</table>
	<%/* String result = (String)request.getAttribute("result");  */
		ServletContext context = this.getServletContext();
		String reqMehthod =(String)context.getAttribute("reqMethod");
		String result =(String)context.getAttribute("result");
		String url=(String)context.getAttribute("url");
		String json=(String)context.getAttribute("json");
		System.out.println("返回jsp的reqMehthod："+reqMehthod);
	%>
	<div id=top_1, width="75%" style="height:702px;border-width:1px;border-style:solid;float:left;">
		<form  method="post" name="form1">
			<select id="select_1" name="selectReqMehthod" style="width:80px;height:40px;margin-top:35px;margin-left:35px">
				<option value="get">GET</option>
				<option value="post">POST</option>
				<option value="put">PUT</option>
				<option value="delete">DELETE</option>
			</select>
			<input type="text" name="url" value=<%=url%> id="top_3" style="width:500px;height:35px;margin-top:35px;border-width:1px"/>
			<input type="submit" value="save" id="top_4" onClick="add()" style="width:100px;height:40px;margin-top:35px;margin-left:30px"/>
			<input type="submit" value="send" id="top_5" onClick="send()" style="width:100px;height:40px;margin-top:35px;margin-left:10px"/>
			<br>
			<textarea name="json" style="width:500px;height:200px;margin-top:35px;border-width:1px"><%=json%></textarea>
			<div id="top_6" style="width:958px;height:300px;border-width:1px;margin-top:300px;border-style:solid none none none">
				<p><%=result%></p>
			</div>
		</form>		
	</div>
</body>
<script type="text/javascript">
	function send(){
		 document.form1.action="/InterfaceTest/req/DoGetDemo";
         document.form1.submit();
	}
	function add(){
		 document.form1.action="/InterfaceTest/req/add";
         document.form1.submit();
	}
	
	<%-- window.onload=function(){
		var select = document.getElementById("select_1");  
		for(var i=0; i<select.options.length; i++){  
	        if(select.options[i].value == <%=reqMehthod%>){  
	            select.options[i].selected = true; 
	            alert(<%=reqMehthod%>+select.options[i].value);
	            break;  
	        }  
	    }  
	} --%>
  	
</script>
</html>