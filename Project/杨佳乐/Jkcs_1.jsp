<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学好测试过大年接口测试平台</title>
<link rel="stylesheet" type="text/css" href="css/Interface.css" />
<style type="text/css">
	#right{
		font-size:20px;
		padding-top:0px;
		float:left;
		height:100%;
	}
	#right_9{
		width:1660px;
		height:1px;
		margin-left:13px;
		margin-top:20px;
		background-color:#DDDDDD;
	}
	#right_10{
		height:760px;
		width:1px;
		margin-left:13px;
		background-color:#DDDDDD;
		float:left;
	}
	#top_1{
		float:left;
		width:1649px;
		height:774px;
		border-width:1px;
	}
	#top_2{
		background-color:#ECECEC;
		width:172px;
		height:57px;
		margin-left:67px;
		border-radius:10px;
		padding-top:5px;
		font-size:15px;
	}
	#top_3{
		color:#888888;
		background-color:#ECECEC;
		width:867px;
		height:55px;
		border-width:1px;
		border-radius:10px;
		padding:0px;
	}
	#top_4{
		width:145px;
		height:57px;
		margin-top:48px;
		margin-left:116px;
		border-radius:10px;
		background:#097BED;
		color:#FCFDFF;
		padding-bottom:5px;
		border-widtn:1px;
	}
	#top_5{
	border-width:1px;
		width:145px;
		height:57px;
		margin-top:48px;
		margin-left:13px;
		border-radius:10px;
		background:#ECECEC;
		color:#101010;
		padding-bottom:5px;
	}
	#top_6{
		width:1649px;
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
	#top_19{
		width:74px;
		height:22px;
		margin-top:39px;
		float:right;
		margin-right:121px;
	}
	#top_12{
		margin-left:68px;
		margin-top:90px;
		width:1300px;
		height:42px;
	}
	#top_13{
		width:28px;
		height:28px;
		margin-top:10px;
		float:left;
	}
	#top_14{
		width:58px;
		height:42px;
		border:0;
     	outline:none;
     	background-color:rgba(0,0,0,0);
     	font-size:20px;
     	text-align:center;
     	float:left;
     	padding:0px;
	}
	#top_15{
		width:28px;
		height:28px;
		margin-top:10px;
		margin-left:47px;
		float:left;
	}
	#top_16{
		width:112px;
		height:42px;
		border:0;
     	outline:none;
     	background-color:rgba(0,0,0,0);
     	font-size:20px;
     	float:left;
     	padding:0px;
	}
	#top_17{
		width:28px;
		height:28px;
		margin-top:10px;
		margin-left:52px;
		float:left;
	}
	#top_18{
		width:276px;
		height:42px;
		border:0;
     	outline:none;
     	background-color:rgba(0,0,0,0);
     	font-size:20px;
     	float:left;
     	padding:0px;
	}
	#top_20{
		width:28px;
		height:28px;
		margin-top:10px;
		margin-left:59px;
		float:left;
	}
	#top_21{
		width:42px;
		height:42px;
		border:0;
     	outline:none;
     	background-color:rgba(0,0,0,0);
     	font-size:20px;
     	float:left;
     	padding:0px;
	}
	#top_22{
		width:28px;
		height:28px;
		margin-top:10px;
		margin-left:42px;
		float:left;
	}
	#top_23{
		width:73px;
		height:42px;
		border:0;
     	outline:none;
     	background-color:rgba(0,0,0,0);
     	font-size:20px;
     	float:left;
     	padding:0px;
	}
	#top_25{
		width:146px;
		height:42px;
		margin-left:58px;
		border-radius:5px;
		color:#F89F40;
		display:none;
		font-size:15px;
	}
	#top_24{
		width:1457px;
		height:218px;
		border-style:solid;
		border-width:1px;
		margin-left:77px;
		margin-top:80px;
		border-color:#BBBBBB;
		display:none;
	}
	#top_26{
		width:376px;
		height:40px;
		margin-left:72px;
		margin-top:22px;
		display:none;
	}
	#top_27{
		width:1622px;
		height:290px;
		border-style:solid none none none;
		border-width:1px;
		border-color:#BBBBBB;
		margin-top:141px;
		display:none;
	}
	#top_28{
		width:128px;
		height:30px;
		margin-top:5px;
		margin-left:39px;
		color:#998888;
		display:none;
	}
	#top_29{
		width:1475px;
		height:145px;
		margin-top:15px;
		margin-left:67px;
	}
	#top_30{
		width:1457px;
		height:218px;
		border-style:solid;
		border-width:1px;
		margin-left:77px;
		margin-top:10px;
		border-color:#BBBBBB;
		display:none;
	}
	#top_31{
		width:1420px;
		height:180px;
		border-style:none;
		margin-left:15px;
		margin-top:10px;
		border-color:#BBBBBB;
	}
	</style>
	<script type="text/javascript" src="jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		
		
    	function showXttx(){
        	document.getElementById("divXttx").style.display="";
         	parent.showXttx();
      	}
    	function jump(){
    		window.location.replace("/Demo2020/Jkcs.jsp");
    	}
    	function xianshi(){
    		document.getElementById('top_25').style.display = 'inline-block';
    		document.getElementById('top_24').style.display = 'inline-block';
    		document.getElementById('top_30').style.display = 'inline-block';
    		document.getElementById('top_26').style.display = 'none';
    		document.getElementById('top_27').style.display = 'none';
    		document.getElementById('top_28').style.display = 'none';
    	}
		function xianshi1(){
			document.getElementById('top_25').style.display = 'none';
    		document.getElementById('top_24').style.display = 'none';
    		document.getElementById('top_30').style.display = 'none';
			document.getElementById('top_26').style.display = 'inline-block';
    		document.getElementById('top_27').style.display = 'inline-block';
    		document.getElementById('top_28').style.display = 'inline-block';
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
		<%if(reqMehthod==null){%>
			
		<%}else if(reqMehthod.equals("post")){%>
			$(document).ready(function(){
				$(".selector").val("post");
			});
		<%}else if(reqMehthod.equals("delete")){%>
			$(document).ready(function(){
				$(".selector").val("delete");
			});
		<%}else if(reqMehthod.equals("put")){%>
			$(document).ready(function(){
				$(".selector").val("put");
			});
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
				<select class="selector" id="top_2" name="selectReqMehthod">
					<option value="get">GET</option>
					<option value="post">POST</option>
					<option value="put">PUT</option>
					<option value="delete">DELETE</option>
				</select>
				<input style="font-size:20px" type="text" name="url" value=<%=url%> value="URL" id="top_3"/>
				<input style="font-size:25px" type="submit" value="Send" id="top_4" onClick="send()"/>
				<input style="font-size:25px" type="submit" value="Save" id="top_5" onClick="add()"/>
			
			<div id="top_9">
				<input type="button" onClick="jump()" value="Param" id="top_8"/>
			</div>
			<div id="top_11">
				<input type="button" name="reqBodyType" value="Body" id="top_8"/>
				<div id="top_10"></div>
			</div>
			<div id="top_19">
				<input type="button" value="Cookies" id="top_8"/>
			</div>
			<div id="top_12">
				<input type="radio" name="one_1" value="none" id="top_13" onClick="xianshi1()"/>
				<input type="button" name="raw" value="none" id="top_14" onClick="xianshi1()"/>
				<input type="radio" name="one_1" value="form-data" id="top_15"/>
				<input type="button" value="form-data" id="top_16"/>
				<input type="radio" name="one_1" value="x-www-form-urlencoded" id="top_17"/>
				<input type="button" value="x-www-form-urlencoded" id="top_18"/>
				<input type="radio" name="one_1" value="raw" id="top_20" onClick="xianshi()"/>
				<input type="button" value="raw" id="top_21" onClick="xianshi()"/>
				<input type="radio" name="one_1" value="binary" id="top_22"/>
				<input type="button" value="binary" id="top_23"/>
				<select id="top_25">
					<option value="JSON">JSON</option>
					<option value="Text">Text</option>
					<option value="XML">XML</option>
					<option value="HTML">HTML</option>
					<option value="JavaScript">JavaScript</option>
				</select>
			</div>
			
			<textarea id="top_24" name="json" style="font-size:25px" ><%=json%></textarea>
			<div id="top_30">Response:
				<textarea id="top_31" style="font-size:25px"  name="response"><%=result %></textarea>
			</div>
			
			</form>	
			<div id="top_26">This request does not have a body</div>
			<div id="top_27">
				<div id="top_28">Response</div>
				<div id="top_29">
					<p></p>
				</div>
			</div>
		</div>
</div>
</div>
</body>
</html>