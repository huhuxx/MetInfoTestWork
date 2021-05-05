<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<title>用例</title>
<link rel="stylesheet" type="text/css" href="css/Interface.css" />
<style>
body {
	background-color: rgba(136, 136, 136, 0.07);
}

#top {
	margin-left: 863px;
	margin-top: 50px;
	width: 350px;
	height: 42px;
}

#top_1 {
	width: 90px;
	height: 40px;
	background: #1DC5A3;
	border-radius: 5px;
	color: white;
	font-size: 15px;
	padding: 0px;
	border: 1px;
	float:left;
}

#top_02{
	width: 90px;
	height: 40px;
	background: #1DC5A3;
	border-radius: 5px;
	color: white;
	font-size: 15px;
	padding: 0px;
	border: 1px;
	float:left;
	margin-left:30px;
}

#top_03{
	width: 90px;
	height: 40px;
	background: #1DC5A3;
	border-radius: 5px;
	color: white;
	font-size: 15px;
	padding: 0px;
	border: 1px;
	float:left;
	margin-left:30px;
}

#top_2 {
	align-items: center
}

#top_3 {
	width: 160px;
	height: 61px;
	display: flex;
	align-items: center;
}

#table {
	margin-top: 20px;
	margin-left: 93px;
	border: 1px;
	border-collapse: collapse;
	background: white;
}

.th {
	border-width: 1px;
	border-style: solid;
	font-size: 20;
	font-weight: normal;
	height: 59px;
}

.td {
	border-width: 1px;
	border-style: solid;
	font-size: 14
}

#top_up {
	border-radius: 5px;
	background: #1DC5A3;
	width: 60px;
	height: 30px;
	margin-left: 35px;
}

#top_del {
	border-radius: 5px;
	background: #DC4747;
	width: 60px;
	height: 30px;
}
</style>
</head>
<body>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/implementTest?useUnicode=true&characterEncoding=utf-8"
		user="root" password="123456" />
	<sql:query dataSource="${snapshot}" var="result">
	SELECT * from caseManage order by caseId;
</sql:query>
	<div id="all">
		<div id="Banner">
			<div id="Banner_title">
				<h4>接口测试平台</h4>
				<br>
				<p id="Banner_description">8组学好测试过大年小组</p>
			</div>
			<div id="Banner_user">
				<a href="#" id="user" style="margin-left: 15px">用户名：<span><%=session.getAttribute("name")%></span></a>
				<!-- <a href="#" style="margin-left:15px"><img src="images/b_user1.png"></a>-->
				<a href="user.jsp" style="margin-left: 15px"><img
					src="images/b_tc.png"></a>
			</div>
		</div>
		<div id="left">
			<div id="left_word">
				<ul id="list">
					<li class="filter"><a href="theme.jsp" target="_self"><img
							id="list_img" src="images/X_1.jpg" />首页</a></li>
					<li class="filter"><a href="projectList" target="_self"><img
							id="list_img" src="images/X_2.jpg" />项目管理</a></li>
					<li class="filter"><a href="environmentList" target="_self"><img
							id="list_img" src="images/X_3.jpg" />测试环境</a></li>
					<li class="filter"><a href="interfaceTest.jsp" target="_self"><img
							id="list_img" src="images/X_4.jpg" />接口测试</a></li>
					<li class="filter"><a href="interfaceList" target="_self"><img
							id="list_img" src="images/X_5.jpg" />用例管理</a></li>
					<li class="filter"><a href="interfaceList" target="_self"><img
							id="list_img" src="images/X_6.jpg" />接口管理</a></li>
					<li class="filter"><a href="Dsrw.jsp" target="_self"><img
							id="list_img" src="images/X_7.jpg" />定时任务</a></li>
					<li class="filter"><a href="Yxbg.jsp" target="_self"><img
							id="list_img" src="images/X_8.jpg" />运行报告</a></li>
					<li class="filter"><a href="bin.jsp" target="_self"><img
							id="list_img" src="images/X_9.jpg" />接口回收</a></li>
					<li class="filter"><a href="Yhgl.jsp" target="_self"><img
							id="list_img" src="images/X_10.jpg" />用户管理</a></li>
					<li class="filter"><a href="About.jsp" target="_self"><img
							id="list_img" src="images/X_11.jpg" />关于我们</a></li>
				</ul>
			</div>
		</div>
		<div id=right>
		<div id=top>
			<input id=top_1 type="button" onclick="openwindow()" value="导入用例" />

			<form action="DeleteCaseServlet" method="post">
				<input id=top_02 type="submit" value="全部删除" />
			</form>

			<form action=RunCaseServlet " method="post">
				<input id=top_03 type="submit" value="全部运行" />
			</form>

</div>
			<table id="table" border="3" width="1129pd">
				<tr>
					<th class="th" width="36pd">ID</th>
					<th class="th" width="311pd">用例名称</th>
					<th class="th" width="136pd">所属环境</th>
					<th class="th" width="136pd">所属接口</th>
					<th class="th" width="131pd">执行</th>
				</tr>

				<div class="content">
					<c:forEach var="row" items="${result.rows}">
						<tr>
							<td class="td" align="center"><c:out value="${row.caseId}" /></td>
							<td class="td"><c:out value="${row.caseName}" /></td>
							<td class="td"><c:out value="${row.environment}" /></td>
							<td class="td" align="center"><c:out
									value="${row.implement}" /></td>
							<td><input id=top_up type="submit" value="还原" /></td>
						</tr>
					</c:forEach>
				</div>
			</table>
		</div>
	</div>
</body>
</html>

<script type="text/javascript">
	function openwindow() {
		document.body.style.background = "rgba(20,20,20,0.2)";
		window
				.showModalDialog(
						"addCase.jsp",
						window,
						"resizable:no;center:yes;status:no;scroll:no;dialogWidth:844px;dialogHeight:376px;edge:sunken;status:no;titlebar:no;menubar:no;toolbar:no");
		window.location.reload();
	}
</script>