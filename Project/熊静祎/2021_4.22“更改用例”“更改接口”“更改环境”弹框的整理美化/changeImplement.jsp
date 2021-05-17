<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加接口</title>
	<base target="_self" />
	<link rel="stylesheet" type="text/css" href="css/Bullet.css" />
</head>
<body>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
    	url="jdbc:mysql://localhost:3306/implementTest?useUnicode=true&characterEncoding=utf-8"
    	user="root"  password="123456"/>
	<sql:query dataSource="${snapshot}" var="result">
		SELECT environmentName from environmentManage;
	</sql:query>

	<div id = "form">
		<div id = "title"><p id="title_text">添加接口</p></div>
			<form action="ChangeImplementServlet" method="post" id="form1">
				<div id="li_title">
					<ul id="ul_title">
						<li id="li_name">接口名称</li>
						<li id="li_environment">所属环境</li>
						<li id="li_address">请求地址</li> 
						<li id="li_method">请求方式</li> 
						<li id="li_transport">传输方式</li> 
					</ul>
				</div>
				
				<div id="li_text">
					<ul id="ul_text">
						<li><input type="text" name="implementName" value="请输入"/></li>
						<li>
							<div id="select_env">
								<select id="environment" name="environment">
									<c:forEach var="row" items="${result.rows}">
						 				<option><c:out value="${row.environmentName}"/></option>
									</c:forEach>
			   					</select>
				   			</div>
						</li>
						<li><input type="text" name="url" value="请输入"/></li>
						<li>
							<div id="select_req" style="position:relative;left:10px;">
								<select id="requestStyle" name="requestStyle">
									<option value="GET">GET</option>
									<option value="POST">POST</option>
			   					</select>
				   			</div>
						</li>
						<li>
							<div id="select_req">
								<select id="dataStyle" name="dataStyle">
			       					<option value="Params">Params</optionS>
		       	   					<option value="JSON">JSON</option>
		         				</select>
								<%String btnname = request.getParameter("TimplementId"); %>
				   			</div>
						</li>						
					</ul>
				</div>
			  	<div id="submit">
			  		<input type="hidden" value=<%=btnname %> name="TenvironmentId"/>
					<input type="submit" name="inputbox" value="确定" onclick="bconfirm();">
	    			<input type="button" name="inputboxbs" value=取消 onclick="bcancel();">
	    		</div>
			</form>
		</div>
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
<style>
	#environment{
		appearance: none;
        height:51px;
        width:140px;
        border:1px solid #888888;
        border-radius:10px 10px 10px 10px;
	}
</style>