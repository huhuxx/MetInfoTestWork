<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
	<title>测试环境</title>
	<link rel="stylesheet" type="text/css" href="css/Interface.css" />
	<style>
		body{
			background-color: rgba(136, 136, 136, 0.07);
		}
		#right{
		height:100%;
		width:1344px;
		}
		#top{
		margin-left:113px;
			margin-top:20px;
		width:185px;
		height:61px;
		background:rgba(29,197,163,100);
		border-radius:18px;
		display: flex;
	justify-content: center;
	align-items: center;
		}
		#top_1{
		padding:0px;
			width:110px;
			height:61px;
			background:rgba(29,197,163,100);
			font-size:24px;
			text-align:center;
			font-family:Roboto;
			border-radius:18px;
			border:0px;
			color:rgba(255,255,255,100);
		}
		#top_2{
		align-items: center
		}
		#top_3{
		width:140px;
		height:61px;
		display: flex;
		align-items: center;
		}
		#table{
			margin-left:93px;
			margin-top:25px;
			border:1px;
			border-collapse: collapse;
			background:white;
		}
		.th{
		border-width: 1px;
		border-style: solid; 
		font-size:20;
		text-align: center;
		font-family: Microsoft Yahei;
		font-weight: normal;
		height:59px;
		}
		.td{
		border-width: 1px;
		border-style: solid; 
		font-size:16;
		}
		#top_up{
		width:60px;
		height:30px;
			border-radius:5px;
			background:#1DC5A3;
			margin-top:14px;
		}
		#top_del{
		width:60px;
		height:30px;
			border-radius:5px;
			background:#DC4747;
			margin-top:14px;
		}
	</style>
</head>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/implementTest?useUnicode=true&characterEncoding=utf-8"
     user="root"  password="123456"/>
<sql:query dataSource="${snapshot}" var="result">
	SELECT * from environmentManage order by environmentId ASC;
</sql:query>
<div id="all">
<div id="Banner">
	<div id="Banner_title">
		<h4>接口测试平台</h4>
		<br>
		<p id="Banner_description">8组学好测试过大年小组</p>
	</div>
	<div id="Banner_user">
		<a href="#" id="user" style="margin-left:15px">用户名</a>
		<a href="#" style="margin-left:15px"><img src="images/b_user1.png"></a>
		<a href="#" style="margin-left:15px"><img src="images/b_tc.png"></a>
	</div>
</div>
<div id="left">
	<div id="left_word">
		<ul id="list">
			<li class="filter"><a href ="Index.jsp" target ="_self"><img id="list_img" src="images/X_1.jpg" />首页</a></li>
			<li class="filter"><a href ="projectManage.jsp" target ="_self"><img id="list_img" src="images/X_2.jpg" />项目管理</a></li>
			<li class="filter"><a href ="environmentManage.jsp" target ="_self"><img id="list_img" src="images/X_3.jpg" />测试环境</a></li>
			<li class="filter"><a href ="implementManage.jsp" target ="_self"><img id="list_img" src="images/X_4.jpg" />接口测试</a></li>
			<li class="filter"><a href ="Ylgl.jsp" target ="_self"><img id="list_img" src="images/X_5.jpg" />用例管理</a></li>
			<li class="filter"><a href ="Jkgl.jsp" target ="_self"><img id="list_img" src="images/X_6.jpg" />接口管理</a></li>
			<li class="filter"><a href ="Dsrw.jsp" target ="_self"><img id="list_img" src="images/X_7.jpg" />定时任务</a></li>
			<li class="filter"><a href ="Yxbg.jsp" target ="_self"><img id="list_img" src="images/X_8.jpg" />运行报告</a></li>
			<li class="filter"><a href ="Xncs.jsp" target ="_self"><img id="list_img" src="images/X_9.jpg" />性能测试</a></li>
			<li class="filter"><a href ="Yhgl.jsp" target ="_self"><img id="list_img" src="images/X_10.jpg" />用户管理</a></li>
			<li class="filter"><a href ="About.jsp" target ="_self"><img id="list_img" src="images/X_11.jpg" />关于我们</a></li>
		</ul>
	</div>
</div>
<div id=right>
<div id=top>
<div id=top_3>
	<img id=top_2 alt="jiahao" src="images/jiahao.png">
	<input id=top_1 type="button" onclick="openwindow()" value="增加环境" />
</div>
</div>
	<table id="table" border="3">
		<tr>
		   <th class="th" width="102px">ID</th>
		   <th class="th" width="263px">环境名称</th>
		   <th class="th" width="254px">swagger导入</th>
		   <th class="th" width="262px">url</th>
		   <th class="th" width="224px">所属项目</th>
		   <th class="th" width="306px">更新时间</th>
		   <th class="th" width="337px">更新用户</th>
		   <th class="th" width="161px">编辑操作</th>
		   <th class="th" width="161px">删除操作</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
		<tr>
		   <td class="td" align="center">${row.environmentId}</td>
		   <td class="td" align="center">${row.environmentName}</td>
		   <td class="td" align="center">${row.swaggerNumber}</td>
		   <td class="td" align="center">${row.url}</td>
		   <td class="td" align="center">${row.project}</td>
		   <td class="td" align="center">${row.updateTime}</td>
		   <td class="td" align="center">${row.username}</td>
		   <td class="td" align="center"> 	
		   	   	<input id=top_up type="button" onclick="deletewindow(${row.environmentId})" value="删除"/>   			
		   	</td>
		   	<td class="td" align="center">
		   		<input id=top_del type="button" onclick="editwindow(${row.environmentId})" value="编辑"/>	 	
		   	</td>	
				
		</tr>
		</c:forEach>
		
	</table>
	</div>
	</div>
	
</body>
</html>

<script type="text/javascript">
function openwindow(){ 
	document.body.style.background="rgba(20,20,20,0.2)";
    window.showModalDialog("addEnvironment.jsp",window,"resizable:no;center:yes;status:no;scroll:no;dialogWidth:844px;dialogHeight:376px;edge:sunken;status:no;titlebar:no;menubar:no;toolbar:no");
    window.location.reload();  
  }  
  
function editwindow(a){ 
	var TenvironmentId = a;
	document.body.style.background="rgba(20,20,20,0.2)";
    window.showModalDialog("changeEnvironment.jsp?TenvironmentId="+TenvironmentId,window,"resizable:no;center:yes;status:no;scroll:no;dialogWidth:500px;dialogHeight:200px");
    window.location.reload();  
  }   
function deletewindow(a){ 
	var TenvironmentId = a;
	document.body.style.background="rgba(20,20,20,0.2)";
    window.showModalDialog("deleteEnvironment.jsp?TenvironmentId="+TenvironmentId,window,"resizable:no;center:yes;status:no;scroll:no;dialogWidth:500px;dialogHeight:200px");
    window.location.reload();  
  }
</script>
