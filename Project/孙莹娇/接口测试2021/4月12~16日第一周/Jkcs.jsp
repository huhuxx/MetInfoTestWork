<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
    <title>学好测试过大年接口测试平台</title>
    <link rel="stylesheet" type="text/css" href="css/Interface.css" />
    <style type="text/css">
	#right{
		font-size:20px;
		padding-top:0;
		float:left;
		height:100%;
	}
	#right_9{
		width:1380px;
		height:1px;
		margin-left:13px;
		margin-top:20px;
		background-color:#DDDDDD;
	}
	#right_10{
		width:1px;
		height:750px;
		margin-left:13px;
		background-color:#DDDDDD;
		float:left;
	}
	#top_1{
		float:left;
		width: 1349px;
		height:774px;
		border-width:1px;
	}
	#top_2{
		background-color:#ECECEC;
		width:133px;
		height:71px;
		margin-left:67px;
		border-radius:10px;
		border-width:1px;
		padding-top:4px;
		font-size:20px;
	}
	#top_3{
		color:#888888;
		background-color:#ECECEC;
		width:673px;
		height:69px;
		border-width:1px;
		border-radius:10px;
		padding:0px;
		margin-left: 30px;
	}
	#top_4{
		width:135px;
		height:70px;
		margin-top:48px;
		margin-left:56px;
		border-radius:10px;
		background:#097BED;
		color:#FCFDFF;
		border-width:1px;
		padding-bottom:5px;
	}
	#top_5{
		width:135px;
		height:70px;
		margin-top:48px;
		margin-left:30px;
		border-radius:10px;
		background:#ECECEC;
		color:#101010;
		border-width:1px;
		padding-bottom:5px;
	}
	#top_6{
		width:1380px;
		height:238px;
		border-width:1px;
		margin-top:75px;
		border-style:solid none none none;
		border-color:#BBBBBB;
		float:left;
	}
	#top_9{
		width:93px;
		margin-left:70px;
		margin-top:32px;
		float:left;
	}
	#top_10{
		width:93px;
		height:5px;
		background-color:#F89E3F;
		margin-top:19px;
	}
	#top_8{
		border:0;
     	outline:none;
     	background-color:rgba(0,0,0,0);
     	color:#E1C50D;
     	font-size:20px;
	}
	#top_11{
		width:93px;
		height:56px;
		margin-left:12px;
		margin-top:32px;
		float:left;
	}
	#top_12{
		width:166px;
		height:40px;
		margin-top:14px;
		margin-left:71px;
		color:#888888;
	}
	#top_13{
		width:1475px;
		height:145px;
		margin-top:49px;
		margin-left:70px;
		float:left;
	}
	#top_14{
		width:100%;
		border:1;
		cellspacing:0;
		cellpadding:2;
		border-collapse: collapse
	}
	.top{
		border:1px solid gray;
	}
	.top_15{
		border:0;
		color:#888888;
	}
	#top_16{
		width:93px;
		height:72px;
	}
	#top_17{
		width:129px;
		height:43px;
		margin-top:22px;
		margin-left:74px;
		color:#9B8989;
	}
	#top_18{
		font-size:20px;
		width:1475px;
		height:145px;
		margin-top:15px;
		margin-left:67px;
	}
	#top_19{
		width:52px;
		height:22px;
		margin-top:35px;
		margin-left:1248px;
		float:left;
	}
	</style>
	<script type="text/javascript">
    	function showXttx(){
        	document.getElementById("divXttx").style.display="";
         	parent.showXttx();
      	}
    	function jump(){
    		window.location.replace("/Demo2020/Jkcs_1.jsp");
    	}
    	function send(){
   		 	document.form1.action="/Demo2020/req/SendServlet";
            document.form1.submit();
   		}
   		function add(){
   		 	document.form1.action="/Demo2020/req/add";
            document.form1.submit();
   		}
   		<%
		ServletContext context = this.getServletContext();
		String reqMehthod =(String)context.getAttribute("reqMethod");
		String result =(String)context.getAttribute("result");
		String url=(String)context.getAttribute("url");
		String json=(String)context.getAttribute("json");
		System.out.println("返回jsp的reqMehthod："+reqMehthod);
		%>
		<%if(reqMehthod!=null){%>
			$("#top_2").find("option[text='"+reqMehthod+"']").attr("selected",true);
		<%}%>
    </script>
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
			<li class="filter"><a href ="Index.jsp" target ="_self"><img id="list_img" src="images/X_1.jpg" />首页</a></li>
			<li class="filter"><a href ="Xmgl.jsp" target ="_self"><img id="list_img" src="images/X_2.jpg" />项目管理</a></li>
			<li class="filter"><a href ="Cshj.jsp" target ="_self"><img id="list_img" src="images/X_3.jpg" />测试环境</a></li>
			<li class="filter"><a href ="Jkcs.jsp" target ="_self"><img id="list_img" src="images/X_4.jpg" />接口测试</a></li>
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
<div id="right">
	<div id="right_9"></div>
	<div id="right_10"></div>
	<div id="top_1">
			<form  method="post" name="form1">
				<select id="top_2" name="selectReqMehthod">
					<option value="get">GET</option>
					<option value="post">POST</option>
					<option value="put">PUT</option>
					<option value="delete">DELETE</option>
				</select>
				<input style="font-size:20px" type="text" name="url" value=<%=url%> value="URL" id="top_3"/>
				<input style="font-size:25px" type="submit" value="send" id="top_4" onClick="send()"/>
				<input style="font-size:25px" type="submit" value="save" id="top_5" onClick="add()"/>
			</form>	
			<div id="top_9">
				<input type="button" name="reqBodyType" value="Param" id="top_8"/>
				<div id="top_10"></div>
			</div>
			<div id="top_11">
				<input type="button" onClick="jump()" value="Body" id="top_8"/>
			</div>
			<div id="top_19">
				<input type="button" value="Cookies" id="top_8"/>
			</div>
			<div id="top_12">
				Query Params
			</div>
			<div id="top_13">
				<table id="top_14">
					<tr class="top">
						<td class="top" id="top_16"></td>
						<td class="top">KEY</td>
						<td class="top">VALUE</td>
						<td class="top">DESCRIPTION</td>
					</tr>
					<tr class="top">
						<td class="top" id="top_16"></td>
						<td class="top"><input type="text" value="KEY" class="top_15"/></td>
						<td class="top"><input type="text" value="VALUE" class="top_15"/></td>
						<td class="top"><input type="text" value="DESCRIPTION" class="top_15"/></td>
					</tr>
				</table>
			</div>
			<div id="top_6">
				<div id="top_17">
					Response
				</div>
				<div id="top_18">
					<p style="font-size:25px"><%=result %></p>
				</div>
			</div>
	</div>
</div>
</div>
</body>

 
</html>