<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
	<title>接口管理</title>
	<link rel="stylesheet" type="text/css" href="css/Interface.css" />
	<style>
	body{
			background-color: rgba(136, 136, 136, 0.07);
		}
		#top{
		margin-left:113px;
			margin-top:20px;
		width:235px;
		height:61px;
		background:#1DC5A3;
		border-radius:18px;
		display: flex;
	justify-content: center;
	align-items: center;
	
	
		}
		#top_1{
		width:130px;
			height:61px;
			background:url("images.jiahao.png") no-repeat;
			border-radius:10px;
			color:white;
			font-size:20px;
			padding:0px;
			border:1px;
			
		}
		#top_2{
		align-items: center
		}
		#top_3{
		width:160px;
		height:61px;
		display: flex;
		align-items: center;
		}
		#table{
		margin-top:39px;
		margin-left:93px;
			border:1px;
			border-collapse: collapse;
			background:white;
		}
		.th{
		border-width: 1px;
		border-style: solid; 
		font-size:20;
		font-weight: normal;
		height:59px;
		}
		.td{
		border-width: 1px;
		border-style: solid; 
		font-size:14
		}
		#top_up{
			border-radius:5px;
			background:#1DC5A3;
			width:60px;
		height:30px;
		}
		#top_del{
			border-radius:5px;
			background:#DC4747;
			width:60px;
		height:30px;
		}
		.pageNum{
		width:550px;
		height:50px;
		margin-left:400px;
		font-size:18px;
		}
		.page:link{
		color:black;
		text-decoration:none;
		}
		.page:visited{
		color:black;
		text-decoration:none;
		}
		.page:hover{
		color:#0065CC;
		text-decoration:underline;
		}
	</style>
</head>
<body>

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
			<li class="filter"><a href ="theme.jsp" target ="_self"><img id="list_img" src="images/X_1.jpg" />首页</a></li>
			<li class="filter"><a href ="projectList" target ="_self"><img id="list_img" src="images/X_2.jpg" />项目管理</a></li>
			<li class="filter"><a href ="environmentList" target ="_self"><img id="list_img" src="images/X_3.jpg" />测试环境</a></li>
			<li class="filter"><a href ="implementList" target ="_self"><img id="list_img" src="images/X_4.jpg" />接口测试</a></li>
			<li class="filter"><a href ="interfaceList" target ="_self"><img id="list_img" src="images/X_5.jpg" />用例管理</a></li>
			<li class="filter"><a href ="Jkgl.jsp" target ="_self"><img id="list_img" src="images/X_6.jpg" />接口管理</a></li>
			<li class="filter"><a href ="Dsrw.jsp" target ="_self"><img id="list_img" src="images/X_7.jpg" />定时任务</a></li>
			<li class="filter"><a href ="Yxbg.jsp" target ="_self"><img id="list_img" src="images/X_8.jpg" />运行报告</a></li>
			<li class="filter"><a href ="bin.jsp" target ="_self"><img id="list_img" src="images/X_9.jpg" />接口回收</a></li>
			<li class="filter"><a href ="Yhgl.jsp" target ="_self"><img id="list_img" src="images/X_10.jpg" />用户管理</a></li>
			<li class="filter"><a href ="About.jsp" target ="_self"><img id="list_img" src="images/X_11.jpg" />关于我们</a></li>
		</ul>
	</div>
</div>
<div id=right>
<div id=top>
<div id=top_3>
<img id=top_2 alt="jiahao" src="images/jiahao.png">
	 <input id=top_1 type="button" onclick="openwindow()" value="导入swagger" /> 
	</div>
	</div>
	<table id="table" border="3" width="1129pd">
		<tr>
		   <th class="th" width="36pd">ID</th>
		   <th class="th" width="311pd">接口名称</th>
		   <th class="th" width="136pd">所属环境</th>
		   <th class="th" width="111pd">请求方式</th>
		   <th class="th" width="158pd">数据传输方式</th>
		   <th class="th" width="246pd">请求地址</th>
		   <th class="th" width="131pd">编辑</th>
		   <th class="th" width="131pd">删除</th>
		</tr>
		
		<div class="content">
			<c:forEach items="${page.list}" var="record">
				<tr>
				   <td class="td" align="center"><c:out value="${record.impId}"/></td>
				   <td class="td"><c:out value="${record.impName}"/></td>
				   <td class="td"><c:out value="${record.environment}"/></td>
				   <td class="td" align="center"><c:out value="${record.requestStyle}"/></td>
				   <td class="td" align="center"><c:out value="${record.dataStyle}"/></td>
				   <td class="td"><c:out value="${record.requestURL}"/></td>
			   	   <td class="td" align="center">  
			   	   	<input id=top_up type="button" onclick="editwindow(${record.impId})" value="编辑"/>	 						
			   	   </td>
			   	   <td class="td" align="center">
					<input id=top_del type="button" onclick="deletewindow(${record.impId})" value="删除"/> 					
				   </td>
				</tr>
			</c:forEach>
		</div>
	</table>
	<div class="pageNum">
				总共有${page.totalPageNum }页，总共有${page.totalCount }个数据；
				<a class="page" href="interfaceList?page=1">首页</a>
				<a class="page" href="interfaceList?page=${page.prePageNum }">上一页</a>
			
				第${page.currentPageNum }页
				
				<a class="page" href="interfaceList?page=${page.nextPageNum }">下一页</a>
				<a class="page" href="interfaceList?page=${page.totalPageNum }">末页</a>
			</div>
	</div>
	</div>
</body>
</html>
<script type="text/javascript">
function openwindow(){ 
	document.body.style.background="rgba(20,20,20,0.2)";
    window.showModalDialog("addImplement.jsp",window,"resizable:no;center:yes;status:no;scroll:no;dialogWidth:844px;dialogHeight:300px;edge:sunken;status:no;titlebar:no;menubar:no;toolbar:no");
    window.location.reload();  
  }  
function editwindow(a){ 
	var TimplementId = a;
	document.body.style.background="rgba(20,20,20,0.2)";
    window.showModalDialog("changeImplement.jsp?TimplementId="+TimplementId,window,"resizable:no;center:yes;status:no;scroll:no;dialogWidth:500px;dialogHeight:200px");
    window.location.reload();  
  }  
function deletewindow(a){ 
	var TimplementId = a;
	document.body.style.background="rgba(20,20,20,0.2)";
    window.showModalDialog("deleteImplement.jsp?TimplementId="+TimplementId,window,"resizable:no;center:yes;status:no;scroll:no;dialogWidth:500px;dialogHeight:200px");
    window.location.reload();  
  }
</script>