<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
	<title>项目管理</title>
	<link rel="stylesheet" type="text/css" href="css/Interface.css" />
	<style>
	body{
			background-color: rgba(136, 136, 136, 0.07);
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
			margin-top:25px;
			margin-left:93px;
			border:1px;
			width:1107pd;
			border-collapse: collapse;
			background:white;
		}
		.th{
		font-size:20;
		border-width: 1px;
		border-style: solid; 
		font-weight: normal;
		height:59px;
		}
		.td{
		border-width: 1px;
		border-style: solid; 
		font-size:16
		}
		#top_2{
			align:center;
		}
		#top_up{
			border-radius:5px;
			background:#1DC5A3;
			margin-top:14px;
			width:60px;
			height:30px;
		}
		#top_del{
			border-radius:5px;
			background:#DC4747;
			margin-top:14px;
			width:60px;
			height:30px;
		}
	</style>
</head>
<body>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/implementTest?useUnicode=true&characterEncoding=utf-8"
     user="root"  password="123456"/>
<sql:query dataSource="${snapshot}" var="result">
	SELECT * from projectManage  order by projectId ASC;
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
    <input id=top_1 type="button" onclick="openwindow()" value="创建项目" /> 
	</div>
    </div>
	<table id="table">
		<tr>
		   <th class="th" width="53pd" text-align:enter>ID</th>
		   <th class="th" width="160pd">项目名称</th>
		   <th class="th" width="250pd">项目描述</th>
		   <th class="th" width="189pd">更新时间</th>
		   <th class="th" width="249pd">更新用户</th>
		   <th class="th" width="150pd">编辑操作</th>
		   <th class="th" width="150pd">删除操作</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
		<tr>
		   <td class="td" align="center"><c:out value="${row.projectId}"/></td>
		   <td class="td" align="center"><c:out value="${row.projectName}"/></td>
		   <td class="td" align="center"><c:out value="${row.projectDescription}"/></td>
		   <td class="td" align="center"><c:out value="${row.updateTime}"/></td>
		   <td class="td" align="center"><c:out value="${row.username}"/></td>
		   	<td class="td" id=top_2 align="center">  			
				<input id=top_up type="submit" onclick="editwindow(${row.projectId})" value="编辑" />		   
		   </td>
		   <td class="td" align="center">
				<input  id=top_del type="button" onclick="deletewindow(${row.projectId})" value="删除" />
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
    window.showModalDialog("addProject.jsp",window,"resizable:no;center:yes;status:no;scroll:no;dialogWidth:844px;dialogHeight:376px;edge:sunken;status:no;titlebar:no;menubar:no;toolbar:no");
    window.location.reload();  
  }    
function editwindow(a){ 
	var TprojectId = a;
	document.body.style.background="rgba(20,20,20,0.2)";
    window.showModalDialog("changeProject.jsp?TprojectId="+TprojectId,window,"resizable:no;center:yes;status:no;scroll:no;dialogWidth:500px;dialogHeight:200px");
    window.location.reload();  
  }  
function deletewindow(a){ 
	var TprojectId = a;
	document.body.style.background="rgba(20,20,20,0.2)";
    window.showModalDialog("deleteProject.jsp?TprojectId="+TprojectId,window,"resizable:no;center:yes;status:no;scroll:no;dialogWidth:500px;dialogHeight:200px");
    window.location.reload();  
  }
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
	<title>项目管理</title>
	<link rel="stylesheet" type="text/css" href="css/Interface.css" />
	<style>
	body{
			background-color: rgba(136, 136, 136, 0.07);
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
			margin-top:25px;
			margin-left:93px;
			border:1px;
			width:1107pd;
			border-collapse: collapse;
			background:white;
		}
		.th{
		font-size:20;
		border-width: 1px;
		border-style: solid; 
		font-weight: normal;
		height:59px;
		}
		.td{
		border-width: 1px;
		border-style: solid; 
		font-size:16
		}
		#top_2{
			align:center;
		}
		#top_up{
			border-radius:5px;
			background:#1DC5A3;
			margin-top:14px;
			width:60px;
			height:30px;
		}
		#top_del{
			border-radius:5px;
			background:#DC4747;
			margin-top:14px;
			width:60px;
			height:30px;
		}
	</style>
</head>
<body>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/implementTest?useUnicode=true&characterEncoding=utf-8"
     user="root"  password="123456"/>
<sql:query dataSource="${snapshot}" var="result">
	SELECT * from projectManage  order by projectId ASC;
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
    <input id=top_1 type="button" onclick="openwindow()" value="创建项目" /> 
	</div>
    </div>
	<table id="table">
		<tr>
		   <th class="th" width="53pd" text-align:enter>ID</th>
		   <th class="th" width="160pd">项目名称</th>
		   <th class="th" width="250pd">项目描述</th>
		   <th class="th" width="189pd">更新时间</th>
		   <th class="th" width="249pd">更新用户</th>
		   <th class="th" width="150pd">编辑操作</th>
		   <th class="th" width="150pd">删除操作</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
		<tr>
		   <td class="td" align="center"><c:out value="${row.projectId}"/></td>
		   <td class="td" align="center"><c:out value="${row.projectName}"/></td>
		   <td class="td" align="center"><c:out value="${row.projectDescription}"/></td>
		   <td class="td" align="center"><c:out value="${row.updateTime}"/></td>
		   <td class="td" align="center"><c:out value="${row.username}"/></td>
		   	<td class="td" id=top_2 align="center">  			
				<input id=top_up type="submit" onclick="editwindow(${row.projectId})" value="编辑" />		   
		   </td>
		   <td class="td" align="center">
				<input  id=top_del type="button" onclick="deletewindow(${row.projectId})" value="删除" />
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
    window.showModalDialog("addProject.jsp",window,"resizable:no;center:yes;status:no;scroll:no;dialogWidth:844px;dialogHeight:376px;edge:sunken;status:no;titlebar:no;menubar:no;toolbar:no");
    window.location.reload();  
  }    
function editwindow(a){ 
	var TprojectId = a;
	document.body.style.background="rgba(20,20,20,0.2)";
    window.showModalDialog("changeProject.jsp?TprojectId="+TprojectId,window,"resizable:no;center:yes;status:no;scroll:no;dialogWidth:500px;dialogHeight:200px");
    window.location.reload();  
  }  
function deletewindow(a){ 
	var TprojectId = a;
	document.body.style.background="rgba(20,20,20,0.2)";
    window.showModalDialog("deleteProject.jsp?TprojectId="+TprojectId,window,"resizable:no;center:yes;status:no;scroll:no;dialogWidth:500px;dialogHeight:200px");
    window.location.reload();  
  }
>>>>>>> a2c0e3927d752efa07af5968f56a8cb4f02dcca6
</script>