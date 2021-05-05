<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加项目</title>
	<base target="_self"  />  
 	<link rel="stylesheet" type="text/css" href="css/Bullet.css" />
</head>
<body>
	<div id = "form">
		<div id = "title"><p id="title_text">添加环境</p></div>
			<form action="AddProjectServlet" method="post" id="form1">
				<div id="li_title">
					<ul id="ul_title">
						<li id="li_name">项目名称</li>
						<li id="li_describe">描述</li>
					</ul>
				</div>
				
				<div id="li_text">
					<ul id="ul_text">
						<li><input type="text" name="projectName" value="请输入"/></li>
						<li><input type="text" name="projectDescription" value="请输入"/></li>
					</ul>
				</div>
			  	<div id="submit">
					<input type="submit" name="inputbox" value="确定" onclick="bconfirm();">
	    			<input type="button" name="inputboxbs" value=取消 onclick="bcancel();">
	    		</div>
			</form>
	</div>
</body>
</html>
<script type="text/javascript">
	function bconfirm(){
		window.close();
	  }
	  function bcancel(){
	     window.close();
	  }
</script>
<style>
	ul li{
		float:left;
		font-size: 20px;
		width:290px;
	}
</style>