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
		width:174px;
		height:79px;
		margin-top:58px;
		margin-left:67px;
	}
	#top_3{
		color:#888888;
		background-color:#ECECEC;
		width:873px;
		height:79px;
		margin-top:58px;
		border-width:1px;
	}
	#top_4{
		width:147px;
		height:79px;
		margin-top:48px;
		margin-left:116px;
		border-radius:10px;
		background:#097BED;
		color:#FCFDFF;
	}
	#top_5{
		width:147px;
		height:79px;
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
				<option value="put">PUT</option>
			</select>
			<input type="text" name="url" value="URL" id="top_3"/>
			<input type="submit" value="send" id="top_4" onClick="add()"/>
			<input type="submit" value="save" id="top_5" onClick="send()"/>
			<div id="top_9">
				<input type="button" value="Param" id="top_8"/>
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
					<p></p>
				</div>
			</div>
	</div>
</div>
</body>

 
</html>