<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base target="_self" />
<title>增加接口</title>
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
	<form action="AddImplementServlet" method="post" id="form1">
		<div id="li_title">
			<ul id="ul_title">
				<li id="li_name">接口名称</li>
				<li id="li_env">所属环境</li>
				<li id="li_req">请求方式</li>
				<li id="li_dat">传输方式</li>
				<li id="li_addr">请求地址</li>    
			</ul>
		</div>
		<div id="li_text">
			<ul id="ul_text">
				<li><input type="text" name="implementName"  value="请输入"/></li>
				<li>
					<div id="select_env">
						<select id="environment" name="environment">
							<c:forEach var="row" items="${result.rows}">
								 <option><c:out value="${row.environmentName}"/></option>
							</c:forEach>
					   </select>
				   </div>
				</li>
				<li id="req">
					<select id="requestStyle" name="requestStyle">
						<option value="GET">GET</option>
						<option value="POST">POST</option>
				   </select>
				</li>
				<li>
					<select id="dataStyle" name="dataStyle">
				       <option value="Params">Params</option>
		   	    	   <option value="JSON">JSON</option>
		  	       </select>
		 	   </li>
				<li><input type="text" name="url" value="请输入"/></li>
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
		//window.opener.location.href=window.opener.location.href; 
		window.close();
	  }
	  function bcancel(){
	     window.close();
	  }
</script>

<style>
	#title{
		background-color: #2B2E34;
		color:#fff;
		border-radius:6px 6px 6px 6px;
		height:50px;
	}
	#title_text{
		position:relative;
		width: 240px;
		height: 39px;
		left:10px;
		top:10px;
		font-size:28px;
		font_family:SourceHanSansSC-regular;
	}
	ul{
		list-style:none;
		width:844px;
	}
	ul li{
		float:left;
		font-size: 20px;
		width:160px;
	}
	#form1{
		width:820px;
	}
	#li_title{
		float:left;
		position:relative;
		top:10px;
		border-top:1px solid rgba(187, 187, 187, 100);
		border-bottom:1px solid rgba(187, 187, 187, 100);
		border-radius:6px 6px 6px 6px;
	}
	#ul_title{
		position:relative;
		top:-7px;
	}
	#li_text{
		float:left;
		position:relative;
		left:-15px;
		top:10px;
		border-bottom:1px solid rgba(187, 187, 187, 100);
		border-radius:6px 6px 6px 6px;
	}
	#ul_text{
		position:relative;
		top:-7px;
	}
	#submit{
		clear:both;
		position:relative;
		top:70px;
		left:550px;
	}
	input[name="implementName"]{
		border-radius:10px 10px 10px 10px;
		height:51px;
		width:150px;
		color:#888888;
	}
	input[name="url"]{
		border-radius:10px 10px 10px 10px;
		height:51px;
		width:150px;
		color:#888888;
	}
	input[name="inputbox"]{
   		background-color:#1194FE;
   		border:1px solid #888888;
   		border-radius:10px 10px 10px 10px;
   		height:41px;
   		width:120px;
	}
	input[name="inputboxbs"]{
   		background-color:transparent;
   		border:1px solid #888888;
   		border-radius:10px 10px 10px 10px;
   		height:41px;
   		width:120px;
	}
	#environment{
		appearance: none;
        height:51px;
        width:120px;
        border:1px solid #888888;
        border-radius:10px 10px 10px 10px;
	}
	#requestStyle{
		appearance: none;
        height:51px;
        width:120px;
        border:1px solid #888888;
        border-radius:10px 10px 10px 10px;
	}
	#dataStyle{
		appearance: none;
        height:51px;
        width:120px;
        border:1px solid #888888;
        border-radius:10px 10px 10px 10px;
	}
	#req{
		left:-20px;
	}
</style>
