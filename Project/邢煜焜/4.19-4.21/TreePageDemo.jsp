<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.awt.Font"%>
<%@ page import="java.io.File"%>
<%@ page import="javax.imageio.ImageIO"%>
<%@ page import="org.jfree.chart.ChartFactory"%>
<%@ page import="org.jfree.chart.ChartUtilities"%>
<%@ page import="org.jfree.chart.JFreeChart"%>
<%@ page import="org.jfree.chart.plot.CategoryPlot"%>
<%@ page import="org.jfree.chart.plot.PlotOrientation"%>
<%@ page import="org.jfree.data.category.DefaultCategoryDataset"%>
<%@ page import="org.jfree.chart.servlet.ServletUtilities"%>
<%@ page import="org.jfree.chart.*"%>
<%@ page import="org.jfree.data.general.*"%>
<%@ page import="org.jfree.chart.servlet.ServletUtilities"%>
<%@ page import="java.awt.Color"%>
<%@ page import="org.jfree.chart.renderer.category.BarRenderer"%>
<%@ page import="org.jfree.chart.renderer.category.BarRenderer"%>

<!DOCTYPE html>
<html>
<body>
	<%
		//种类数据集
		DefaultCategoryDataset ds = new DefaultCategoryDataset();

		ds.setValue(600, "跳过", "第一次");
		ds.setValue(300, "跳过", "第二次");
		ds.setValue(100, "跳过", "第三次");

		ds.setValue(400, "失败", "第一次");
		ds.setValue(340, "失败", "第二次");
		ds.setValue(180, "失败", "第三次");

		ds.setValue(800, "成功", "第一次");
		ds.setValue(900, "成功", "第二次");
		ds.setValue(1000, "成功", "第三次");
		
		Font font = new Font("宋体", Font.BOLD, 20);
		//创建柱状图,柱状图分水平显示和垂直显示两种
		JFreeChart chart = ChartFactory.createBarChart("测试用例执行结果", "执行次数", "次数(次)", ds, PlotOrientation.VERTICAL,
				true, true, true);
		//设置整 个图片的标题字体
		chart.getTitle().setFont(font);
		//设置提示条字体
		font = new Font("宋体", Font.BOLD, 15);
		chart.getLegend().setItemFont(font);
		//得到绘图区
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		//得到绘图区的域轴(横轴),设置标签的字体
		plot.getDomainAxis().setLabelFont(font);
		//设置横轴标签项字体
		plot.getDomainAxis().setTickLabelFont(font);
		//删除边框
		plot.setOutlinePaint(Color.WHITE);
		//设置背景颜色
		plot.setBackgroundPaint(ChartColor.WHITE);
		//设置范围轴(纵轴)字体
		plot.getRangeAxis().setLabelFont(font);
   
		//绘图
		String filename = ServletUtilities.saveChartAsPNG(chart, 500, 400, session);
		String graphURL = request.getContextPath() + "/DisplayChart?filename=" + filename;
	%>
	<img src="<%=graphURL%>">

</body>


</html>