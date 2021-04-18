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
		<style type="text/css">
    *{
		margin:0;
		padding:0;
	}
	a{
		text-decoration:none;
		color:#fff;
		opacity:0.7;
		
	}
	a:hover{
		opacity:1;
	}
	#Banner{
		left:0px;
		top:-1px;
		width:1920px;
		height:80px;
		line-height:18px;
		background-color:#23262E;
		font-size:14px;
	}
	#Banner_title{
		font-size:28px;
		font-weight:bold;
		margin-left:50px;
		padding-top:20px;
		color:#fff;
		float:left;
	}
	#Banner_description{
		font-size:14px;
		color:#fff;
		opacity: 0.7;
		float:left;
	}
	#Banner_user{
		margin-top:20px;
		font-size:16px;
		float:right;
	}
	#user{
		padding-bottom:30px;
		color:#fff;
	}
	#left{
		top: 79px;
		width: 252px;
		height:863px;
		font-size:20px;
		background-color: #2B2E34;
		padding-top:20px;
		float:left;
		display:inline-block;
	}
	#left_word,a{
		margin-left:25px;
		color:#fff;
		padding-top:10px;
		vertical-align:middle;
	}
	#left_word>a>img{
		vertical-align:middle;
	}
	ul li{
		list-style: none;
		line-height:50px;
  		height:50px;
	}
	#list li {
		color:#fff;
		opacity:0.7;
	}
	#list>li:hover{
		background:#23262E;
		display:block;
		opacity:1;
	}
	#list_img {
		vertical-align: middle;
	}
	.filter{
		font-size:20px;
		line-height:45px;
	}
	#right_index_img,#right_index_text {
		float:left;
	}
	#right_index_img {
		margin-left:120px;
	}
	#right_index_text {
		margin-left:20px;
	}
	#right_middle{
		float:left;
	}
	#xm,#rw,#jk,#person {
		float:left;
		width:180px;
		height:80px;
		margin:4px 40px 0px 40px;
	}
	#xm {
		background-color:#36cfca;
		margin-left:100px;
	}
	#xm_img,#xm_text,#jk_img,#rw_img,#person_img,#jk_text,#rw_text,#person_text {
		float:left;
		margin:6px 10px 0px 10px;
	}
	#rw_img,#person_img{
		margin-top:10px;
	}
	#xm_text,#jk_text,#rw_text,#person_text{
		margin-top:20px;
		color:white;
		font-size:12px;
	}
	#jk {
		background-color:#ffc439;
	}
	
	#rw {
		background-color:#fd4d4f;
		
	}
	#person {
		background-color:#42a7ff;
	}
	
	#right_report{
		margin-left:100px;
	}
	#right{
		top: 79px;
		font-size:20px;
		padding-top:20px;
		float:left;
		width:1668px;
		height:863px;
	}
	#divXttx{
		margin-left:0px;
		margin-top:0px;
		border-top-color:#FF7F7F;
		margin-top:16px;
		height:67px;
		width:440px;
		margin-left:57px;
	}
	#right_2{
		width:46px;
		height:33px;
	}
	#right_3{
		margin-top:15px;
		margin-left:8px;
		color:#23DF15;
	}
	#right_4{
		width:229px;
		height:46px;
	}
	#right_5{
		width:440px;
		height:4px;
	}
	#right_6{
		width:100%;
		border:0;
		cellspacing:0;
		cellpadding:0;
	}
	#right_7{
		width:430px;
		height:67px;
		align:center;
		valign:middle;
	}
	#right_8{
		width:430px;
		border:0;
		cellspacing:0;
		cellpadding:0;
	}
	#right_9{
		width:43px;
		height:4px;
		margin-left:13px;
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
		width:1649px;
		height:774px;
		border-width:1px;
	}
	#top_2{
		background-color:#ECECEC;
		width:172px;
		height:55px;
		margin-top:58px;
		margin-left:67px;
	}
	#top_3{
		color:#888888;
		background-color:#ECECEC;
		width:867px;
		height:55px;
		margin-top:58px;
		border-width:1px;
	}
	#top_4{
		width:145px;
		height:55px;
		margin-top:48px;
		margin-left:116px;
		border-radius:10px;
		background:#097BED;
		color:#FCFDFF;
	}
	#top_5{
		width:145px;
		height:55px;
		margin-top:48px;
		margin-left:13px;
		border-radius:10px;
		background:#ECECEC;
		color:#101010;
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
		height:10px;
		background-color:#F89E3F;
		margin-top:19px;
	}
	#top_8{
		border:0;
     	outline:none;
     	background-color:rgba(0,0,0,0);
     	color:#E1C50D;
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
		float:left;
		width:28px;
		height:28px;
		margin-right:17px;
		margin-top:10px;
	}
	#top_14{
		width:58px;
		height:42px;
		border:0;
     	outline:none;
     	background-color:rgba(0,0,0,0);
     	font-size:25px;
	}
	#top_15{
		width:28px;
		height:28px;
		margin-top:10px;
		margin-left:47px;
	}
	#top_16{
		width:112px;
		height:42px;
		border:0;
     	outline:none;
     	background-color:rgba(0,0,0,0);
     	font-size:25px;
     	margin-left:14px;
	}
	#top_17{
		width:28px;
		height:28px;
		margin-top:10px;
		margin-left:52px;
	}
	#top_18{
		width:276px;
		height:42px;
		border:0;
     	outline:none;
     	background-color:rgba(0,0,0,0);
     	font-size:25px;
     	margin-left:14px;
	}
	#top_20{
		width:28px;
		height:28px;
		margin-top:10px;
		margin-left:59px;
	}
	#top_21{
		width:42px;
		height:42px;
		border:0;
     	outline:none;
     	background-color:rgba(0,0,0,0);
     	font-size:25px;
     	margin-left:18px;
	}
	#top_22{
		width:28px;
		height:28px;
		margin-top:10px;
		margin-left:42px;
	}
	#top_23{
		width:73px;
		height:42px;
		border:0;
     	outline:none;
     	background-color:rgba(0,0,0,0);
     	font-size:25px;
     	margin-left:18px;
	}
	#top_25{
		width:146px;
		height:42px;
		margin-left:58px;
		border-radius:5px;
		color:#F89F40;
		display:none;
	}
	#top_24{
		width:1457px;
		height:218px;
		border-style:solid;
		border-width:1px;
		margin-left:77px;
		margin-top:140px;
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
	</style>
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
    		document.getElementById('top_26').style.display = 'none';
    		document.getElementById('top_27').style.display = 'none';
    		document.getElementById('top_28').style.display = 'none';
    	}
		function xianshi1(){
			document.getElementById('top_25').style.display = 'none';
    		document.getElementById('top_24').style.display = 'none';
			document.getElementById('top_26').style.display = 'inline-block';
    		document.getElementById('top_27').style.display = 'inline-block';
    		document.getElementById('top_28').style.display = 'inline-block';
		}
    </script>
</head>
<body>
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
	<div id="divXttx">
		<table>
			<tr>
				<td id="right_5" bgcolor="#FF7F7F"></td>
			</tr>
		</table>
		<table id="right_6">
  			<tr>
  				<td width="1" bgcolor="#E8E8E8"></td>
  				<td id="right_7">
       				<table id="right_8">
              			<tr>
              				<td id="right_2">
                				<span id="right_3">GET</span>
                			</td>
                			<td id="right_4">
                				<span>Untitled Request</span>
                			</td>
              			</tr>
            		</table>
           		</td>
            	<td width="1" bgcolor="#E8E8E8"></td>
            </tr>
        </table>
	</div>
	<div id="right_9"></div>
	<div id="right_10"></div>
	<div id="top_1">
			<select id="top_2">
				<option value="get">GET</option>
				<option value="poat">POST</option>
			</select>
			<input type="text" name="url" value="URL" id="top_3"/>
			<input type="submit" value="send" id="top_4" onClick="add()"/>
			<input type="submit" value="save" id="top_5" onClick="send()"/>
			<div id="top_9">
				<input type="button" onClick="jump()" value="Param" id="top_8"/>
			</div>
			<div id="top_11">
				<input type="button" value="Body" id="top_8"/>
				<div id="top_10"></div>
			</div>
			<div id="top_19">
				<input type="button" value="Cookies" id="top_8"/>
			</div>
			<div id="top_12">
				<input type="radio" name="one_1" value="none" id="top_13" onClick="xianshi1()"/>
				<input type="button" value="none" id="top_14" onClick="xianshi1()"/>
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
			<div id="top_24">
			</div>
			<div id="top_26">This request does not have a body</div>
			<div id="top_27">
				<div id="top_28">Response</div>
				<div id="top_29">
					<p></p>
				</div>
			</div>
		</div>
</div>
</body>
</html>