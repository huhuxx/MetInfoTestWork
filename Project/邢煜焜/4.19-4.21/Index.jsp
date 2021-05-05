<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="org.jfree.chart.*" %>
<%@ page import="org.jfree.data.general.*" %>
<%@ page import="org.jfree.chart.servlet.ServletUtilities" %>
<%@ page import="org.jfree.chart.plot.PiePlot" %>
<%@ page import="java.awt.Color" %>



<!DOCTYPE html>
<html>
<head>
    <title>ѧ�ò��Թ�����ӿڲ���ƽ̨</title>
    <link rel="stylesheet" type="text/css" href="css/Interface.css" />
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
img{
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
<div id="all">
<div id="Banner">
	<div id="Banner_title">
		<h4>�ӿڲ���ƽ̨</h4>
		<br>
		<p id="Banner_description">8��ѧ�ò��Թ�����С��</p>
	</div>
	<div id="Banner_user">
		<a href="#" id="user_name">�û���</a>
		<a href="#" id="user_quit"><img src="images/b_tc.png"></a>
		<a href="#" id="user_photo"><img src="images/b_user1.png"></a>
	</div>
</div>
<div id="left">
	<div id="left_word">
		<ul id="list">
			<li class="filter"><a href ="Index.jsp" target ="_self"><img id="list_img" src="images/X_1.jpg" />��ҳ</a></li>
			<li class="filter"><a href ="project_Manage.jsp" target ="_self"><img id="list_img" src="images/X_2.jpg" />��Ŀ����</a></li>
			<li class="filter"><a href ="test_Environment.jsp" target ="_self"><img id="list_img" src="images/X_3.jpg" />���Ի���</a></li>
			<li class="filter"><a href ="interface_Test.jsp" target ="_self"><img id="list_img" src="images/X_4.jpg" />�ӿڲ���</a></li>
			<li class="filter"><a href ="usecase_Manage.jsp" target ="_self"><img id="list_img" src="images/X_5.jpg" />��������</a></li>
			<li class="filter"><a href ="interface_Manage.jsp" target ="_self"><img id="list_img" src="images/X_6.jpg" />�ӿڹ���</a></li>
			<li class="filter"><a href ="timed_Task.jsp" target ="_self"><img id="list_img" src="images/X_7.jpg" />��ʱ����</a></li>
			<li class="filter"><a href ="operation_Report.jsp" target ="_self"><img id="list_img" src="images/X_8.jpg" />���б���</a></li>
			<li class="filter"><a href ="performance_Test.jsp" target ="_self"><img id="list_img" src="images/X_9.jpg" />���ܲ���</a></li>
			<li class="filter"><a href ="user_Manage.jsp" target ="_self"><img id="list_img" src="images/X_10.jpg" />�û�����</a></li>
			<li class="filter"><a href ="About_us.jsp" target ="_self"><img id="list_img" src="images/X_11.jpg" />��������</a></li>
		</ul>
	</div>
</div>
<div id="right">
	<div id="top">
		<div id="top1">
			<div class="image"><img src="images/menu.png"></div>
			<div class="text">
				
					������Ŀ��
			
			</div>
		</div>
		<div id="top2">
			<div class="image"><img src="images/computer.png"></div>
			<div class="text">
				
					���Խӿڣ�
				
			</div>
			<div></div>
		</div>
		<div id="top3">
			<div class="image"><img src="images/line.png"></div>
			<div class="text">
				
					��������
				
			</div>
		</div>
		<div id="top4">
			<div class="image"><img src="images/Team.png"></div>
			<div class="text">
				
					��������
				
			</div>
		</div>
	</div>
	<div id="middle">
		<div id="title">����ִ��ͳ��</div>
	</div>
	<div id="bottom">
		<div id="world">
			<span id="world1">�ɹ�����</span>
			<span id="world2">ʧ������</span>
			<span id="world3">��������</span>
		</div>
	</div>
	 <%
	 	//ʵ������ɫ����
	 	Color buled = new Color(41,152,234);
        //ʵ�������������
        DefaultPieDataset dataset=new DefaultPieDataset();
        //����ͼ��ֵ����Ϊ���
        dataset.setValue("Success",50);
        dataset.setValue("Fail",30);
        dataset.setValue("Skip",20);
        //����JFreeChart�ṩ�Ĺ�����org.jfree.chart.ChartFactory������״ͼ
        //3D��ͼ
        //JFreeChart chart=ChartFactory.createPieChart3D("Test Case",dataset,true,false,false);
        //��3D��ͼ
        JFreeChart chart=ChartFactory.createPieChart("Test Case",dataset,true,false,false);
        PiePlot plot = (PiePlot) chart.getPlot();
        //ɾ����ͼ�߿�
        plot.setOutlinePaint(Color.WHITE);
        plot.setShadowPaint(Color.WHITE); 
        //���ñ�����ɫ
		plot.setBackgroundPaint(ChartColor.WHITE);
        //���ñ�ͼ��������ɫ
		plot.setSectionPaint("Fail", new Color(232,19,19));
		plot.setSectionPaint("Success", new Color(41,152,234));
		plot.setSectionPaint("Skip", new Color(241,162,29));
		
        String filename=ServletUtilities.saveChartAsPNG(chart,500,400,session);
        String graphURL=request.getContextPath()+"/DisplayChart?filename="+filename;
     %>
    <img src="<%=graphURL %>" >

</div>
</div>
</body>

 
</html>