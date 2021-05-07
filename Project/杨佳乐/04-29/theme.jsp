<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="org.jfree.chart.*" %>
<%@ page import="org.jfree.data.general.*" %>
<%@ page import="org.jfree.chart.servlet.ServletUtilities" %>
<%@ page import="org.jfree.chart.plot.PiePlot" %>
<%@ page import="java.awt.Color" %>
<html>
<head>
	<title>首页</title>
	<link rel="stylesheet" type="text/css" href="css/Interface.css" />
	<style>
		#table{
		}
		.th{
		font-size:20
		}
		.td{
		font-size:16
		}
		#right{
		margin-top:27px;
		margin-left:93px;
		}
		
		#right_right{
			float:left;
			margin-top:50px;
      		}
		
		#top{
			height:500px;
			width:300px;
			float:left;
			margin-top:50px;
		}
		
		#top1 {
			width: 185px;
			height: 61px;
			display:flex;
			align-items: center;
			border-radius: 5px;
			background-color: rgba(54, 207, 202, 100);
			color: rgba(16, 16, 16, 100);
			font-size: 20px;
			text-align: center;
			font-family: Roboto;
			border: 1px solid rgba(255, 255, 255, 100);
			float:left;
			margin-top:70px;
		}
		
		#top2 {
			margin-top:50px;
			width: 185px;
			height: 61px;
			display:flex;
			align-items: center;
			border-radius: 5px;
			background-color: rgba(255, 196, 57, 100);
			color: rgba(16, 16, 16, 100);
			font-size: 20px;
			text-align: center;
			font-family: Roboto;
			border: 1px solid rgba(255, 255, 255, 100);
			float:left;
		}
		
		#top3 {
			width: 185px;
			height: 61px;
			display:flex;
			align-items: center;
			border-radius:5;
			background-color: rgba(253, 77, 79, 100);
			color: rgba(16, 16, 16, 100);
			font-size: 20px;
			text-align: center;
			font-family: Roboto;
			border: 1px solid rgba(255, 255, 255, 100);
			float:left;
			margin-top:50px;
		}
		
		#top4 {
			width: 185px;
			height: 61px;
			display:flex;
			align-items: center;
			border-radius: 5px;
			background-color: rgba(66, 167, 255, 100);
			color: rgba(16, 16, 16, 100);
			font-size: 20px;
			text-align: center;
			font-family: Roboto;
			border: 1px solid rgba(255, 255, 255, 100);
			float:left;
			margin-top:50px;
		}
		.images{
		    width: 50px;
		    height: 50px;
			display: table-cell;
		    vertical-align: middle;
		    text-align: center;
		    float:left;
		    margin-right:5px;
		}
		.text{
			line-height:40px;
		}
		#title{
			color: rgba(16, 16, 16, 100);
			font-size: 25px;
			text-align: center;
			font-family: SourceHanSansSC-bold;
		}
		#middle{
			margin-top:20px;
			border-bottom:2px solid #F0F8FF;
		}
		#world{
			height: 50px;
			color:white;
			font-size: 15px;
			text-align:center;
			margin-top:10px;
		}
		#world1{
			width:90px;
			height:40px;
			background:#2998EA;
			border-radius: 5px;
			float:left;
			margin-left:500px;
		}
		#world2{
			width:90px;
			height:40px;
			background:#F11D1D;
			border-radius:5px;
			float:left;
			margin-left:20px;
		}
		#world3{
			width:90px;
			height:40px;
			background:#F1A21D;
			border-radius: 5px;
			float:left;
			margin-left:20px;
		}
		
		#img_1{
			margin-left:150px;
		}
	</style>
</head>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/implementTest?useUnicode=true&characterEncoding=utf-8"
     user="root"  password="123456"/>
<sql:query dataSource="${snapshot}" var="result">
	SELECT * from mainPage;
</sql:query>



<div id="all">
<div id="Banner">
	<div id="Banner_title">
		<h4>接口测试平台</h4>
		<br>
		<p id="Banner_description">8组学好测试过大年小组</p>
	</div>
	<div id="Banner_user">
		<a href="#" id="user" style="margin-left:15px">用户名：<span><%=session.getAttribute("name")%></span></a>
		<!-- <a href="#" style="margin-left:15px"><img src="images/b_user1.png"></a>-->
		<a href="user.jsp" style="margin-left:15px"><img src="images/b_tc.png"></a>
	</div>
</div>
<div id="left">
	<div id="left_word">
		<ul id="list">
			<li class="filter"><a href ="theme.jsp" target ="_self"><img id="list_img" src="images/X_1.jpg" />首页</a></li>
			<li class="filter"><a href ="projectList" target ="_self"><img id="list_img" src="images/X_2.jpg" />项目管理</a></li>
			<li class="filter"><a href ="environmentList" target ="_self"><img id="list_img" src="images/X_3.jpg" />测试环境</a></li>
			<li class="filter"><a href ="Jkcs_1.jsp" target ="_self"><img id="list_img" src="images/X_4.jpg" />接口测试</a></li>
			<li class="filter"><a href ="implementList" target ="_self"><img id="list_img" src="images/X_5.jpg" />用例管理</a></li>
			<li class="filter"><a href ="implementList" target ="_self"><img id="list_img" src="images/X_6.jpg" />接口管理</a></li>
			<li class="filter"><a href ="Dsrw.jsp" target ="_self"><img id="list_img" src="images/X_7.jpg" />定时任务</a></li>
			<li class="filter"><a href ="Yxbg.jsp" target ="_self"><img id="list_img" src="images/X_8.jpg" />运行报告</a></li>
			<li class="filter"><a href ="bin.jsp" target ="_self"><img id="list_img" src="images/X_9.jpg" />接口回收</a></li>
			<li class="filter"><a href ="Yhgl.jsp" target ="_self"><img id="list_img" src="images/X_10.jpg" />用户管理</a></li>
			<li class="filter"><a href ="About.jsp" target ="_self"><img id="list_img" src="images/X_11.jpg" />关于我们</a></li>
		</ul>
	</div>
</div>

<div id=right>
   <div id="top">
   <c:forEach var="row" items="${result.rows}">
		<div id="top1">
			<div class="image"><img src="images/menu.png" class="images"></div>
			<div class="text">
					测试项目：${row.projectNumber}
			</div>
		</div>
		<div id="top2">
			<div class="image"><img src="images/computer.png" class="images"></div>
			<div class="text">
					测试接口：${row.implementNumber}
			</div>
			<div></div>
		</div>
		<div id="top3">
			<div class="image"><img src="images/line.png" class="images"></div>
			<div class="text">
					测试任务：${row.testNumber}
			</div>
		</div>
		<div id="top4">
			<div class="image"><img src="images/Team.png" class="images"></div>
			<div class="text">
					测试人数：${row.memberNumber}
			</div>
		</div>
		</c:forEach>
	</div>
<div id=right_right>
	<div id="middle">
		<div id="title">用例执行统计</div>
	</div>
	<div id="bottom">
		<div id="world">
		<div  id="world1">
			<p>成功用例</p>
			</div>
			<div id="world2">
			<p >失败用例</p>
			</div>
			<div id="world3">
			<p>跳过用例</p>
			</div>
		</div>
<%
	 	//实例化颜色对象
	 	Color buled = new Color(41,152,234);
        //实例化核心类对象
        DefaultPieDataset dataset=new DefaultPieDataset();
        //设置图表值，可为多个
        dataset.setValue("Success",50);
        dataset.setValue("Fail",30);
        dataset.setValue("Skip",20);
        //根据JFreeChart提供的工厂类org.jfree.chart.ChartFactory创建饼状图
        //3D饼图
        //JFreeChart chart=ChartFactory.createPieChart3D("Test Case",dataset,true,false,false);
        //非3D饼图
        JFreeChart chart=ChartFactory.createPieChart("Test Case",dataset,true,false,false);
        PiePlot plot = (PiePlot) chart.getPlot();
        //删除饼图边框
        plot.setOutlinePaint(Color.WHITE);
        plot.setShadowPaint(Color.WHITE); 
        //设置背景颜色
		plot.setBackgroundPaint(ChartColor.WHITE);
        //设置饼图各部分颜色
		plot.setSectionPaint("Fail", new Color(232,19,19));
		plot.setSectionPaint("Success", new Color(41,152,234));
		plot.setSectionPaint("Skip", new Color(241,162,29));
		
        String filename=ServletUtilities.saveChartAsPNG(chart,500,400,session);
        String graphURL=request.getContextPath()+"/DisplayChart?filename="+filename;
     %>
    <img src="<%=graphURL %>" id=img_1>
    </div>
    </div>
</div>
</div>
</body>
</html>