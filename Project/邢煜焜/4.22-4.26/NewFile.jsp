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
				
					²âÊÔÏîÄ¿£º
			
			</div>
		</div>
		<div id="top2">
			<div class="image"><img src="images/computer.png" class="images"></div>
			<div class="text">
				
					²âÊÔ½Ó¿Ú£º
				
			</div>
			<div></div>
		</div>
		<div id="top3">
			<div class="image"><img src="images/line.png" class="images"></div>
			<div class="text">
					²âÊÔÈÎÎñ£º
			</div>
		</div>
		<div id="top4">
			<div class="image"><img src="images/Team.png" class="images"></div>
			<div class="text">
					²âÊÔÈËÊý
			</div>
		</div>
	</div>
	<div id="middle">
		<div id="title">ÓÃÀýÖ´ÐÐÍ³¼Æ</div>
	</div>
	<div id="bottom">
		<div id="world">
			<span id="world1">³É¹¦ÓÃÀý</span>
			<span id="world2">Ê§°ÜÓÃÀý</span>
			<span id="world3">Ìø¹ýÓÃÀý</span>
		</div>
	</div>
<%
	 	//ÊµÀý»¯ÑÕÉ«¶ÔÏó
	 	Color buled = new Color(41,152,234);
        //ÊµÀý»¯ºËÐÄÀà¶ÔÏó
        DefaultPieDataset dataset=new DefaultPieDataset();
        //ÉèÖÃÍ¼±íÖµ£¬¿ÉÎª¶à¸ö
        dataset.setValue("Success",50);
        dataset.setValue("Fail",30);
        dataset.setValue("Skip",20);
        //¸ù¾ÝJFreeChartÌá¹©µÄ¹¤³§Ààorg.jfree.chart.ChartFactory´´½¨±ý×´Í¼
        //3D±ýÍ¼
        //JFreeChart chart=ChartFactory.createPieChart3D("Test Case",dataset,true,false,false);
        //·Ç3D±ýÍ¼
        JFreeChart chart=ChartFactory.createPieChart("Test Case",dataset,true,false,false);
        PiePlot plot = (PiePlot) chart.getPlot();
        //É¾³ý±ýÍ¼±ß¿ò
        plot.setOutlinePaint(Color.WHITE);
        plot.setShadowPaint(Color.WHITE); 
        //ÉèÖÃ±³¾°ÑÕÉ«
		plot.setBackgroundPaint(ChartColor.WHITE);
        //ÉèÖÃ±ýÍ¼¸÷²¿·ÖÑÕÉ«
		plot.setSectionPaint("Fail", new Color(232,19,19));
		plot.setSectionPaint("Success", new Color(41,152,234));
		plot.setSectionPaint("Skip", new Color(241,162,29));
		
        String filename=ServletUtilities.saveChartAsPNG(chart,500,400,session);
        String graphURL=request.getContextPath()+"/DisplayChart?filename="+filename;
     %>
    <img src="<%=graphURL %>" >
</body>
</html>