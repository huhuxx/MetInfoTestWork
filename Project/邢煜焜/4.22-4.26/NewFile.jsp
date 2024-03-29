<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="org.jfree.chart.*" %>
<%@ page import="org.jfree.data.general.*" %>
<%@ page import="org.jfree.chart.servlet.ServletUtilities" %>
<%@ page import="org.jfree.chart.plot.PiePlot" %>
<%@ page import="java.awt.Color" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <style>
#table {
	
}

.th {
	font-size: 20
}

.td {
	font-size: 16
}
#top{
	
	height: 50px;
}

#top1 {
	width: 150px;
	height: 40px;
	line-height: 20px;
	border-radius: 4px 4px 4px 4px;
	background-color: rgba(54, 207, 202, 100);
	color: rgba(16, 16, 16, 100);
	font-size: 14px;
	text-align: center;
	font-family: Roboto;
	border: 1px solid rgba(255, 255, 255, 100);
	float:left;
	margin-left:30px;
}

#top2 {
	
	width: 150px;
	height: 40px;
	line-height: 20px;
	border-radius: 4px 4px 4px 4px;
	background-color: rgba(255, 196, 57, 100);
	color: rgba(16, 16, 16, 100);
	font-size: 14px;
	text-align: center;
	font-family: Roboto;
	border: 1px solid rgba(255, 255, 255, 100);
	float:left;
	margin-left:30px;
}

#top3 {
	width: 150px;
	height: 40px;
	line-height: 20px;
	border-radius: 4px 4px 4px 4px;
	background-color: rgba(253, 77, 79, 100);
	color: rgba(16, 16, 16, 100);
	font-size: 14px;
	text-align: center;
	font-family: Roboto;
	border: 1px solid rgba(255, 255, 255, 100);
	float:left;
	margin-left:30px;
}

#top4 {
	width: 150px;
	height: 40px;
	line-height: 20px;
	border-radius: 4px 4px 4px 4px;
	background-color: rgba(66, 167, 255, 100);
	color: rgba(16, 16, 16, 100);
	font-size: 14px;
	text-align: center;
	font-family: Roboto;
	border: 1px solid rgba(255, 255, 255, 100);
	float:left;
	margin-left:30px;
}
.images{
    width: 60px;
    height: 40px;
	display: table-cell;
    vertical-align: middle;
    text-align: center;
    float:left;
}
.text{
	line-height:40px;
}
#title{
	color: rgba(16, 16, 16, 100);
	font-size: 20px;
	text-align: left;
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
}
#world1{
	background:#2998EA;
	border-radius: 4px 4px 4px 4px;
}
#world2{
	background:#F11D1D;
	border-radius: 4px 4px 4px 4px;
}
#world3{
	background:#F1A21D;
	border-radius: 4px 4px 4px 4px;
}
</style>
</head>
<body>
<div id="top">
		<div id="top1">
			<div class="image"><img src="images/menu.png" class="images"></div>
			<div class="text">
				
					测试项目：
			
			</div>
		</div>
		<div id="top2">
			<div class="image"><img src="images/computer.png" class="images"></div>
			<div class="text">
				
					测试接口：
				
			</div>
			<div></div>
		</div>
		<div id="top3">
			<div class="image"><img src="images/line.png" class="images"></div>
			<div class="text">
					测试任务：
			</div>
		</div>
		<div id="top4">
			<div class="image"><img src="images/Team.png" class="images"></div>
			<div class="text">
					测试人数
			</div>
		</div>
	</div>
	<div id="middle">
		<div id="title">用例执行统计</div>
	</div>
	<div id="bottom">
		<div id="world">
			<span id="world1">成功用例</span>
			<span id="world2">失败用例</span>
			<span id="world3">跳过用例</span>
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
    <img src="<%=graphURL %>" >
</body>
</html>