<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>删除环境</title>
	<base target="_self" />
	<link rel="stylesheet" type="text/css" href="css/Bullet.css" />
</head>
<body>
	<div id = "form">
		<div id = "title"><p id="title_text">删除环境</p></div>
			<form action="DeleteEnvironmentServlet" method="post" id="form1">
				<div id="li_title">
					<ul id="ul_title">
						<li id="li_name">请确认需要删除的环境id</li>
					</ul>
				</div>
				
				<div id="li_text">
					<ul id="ul_text">
						<li><input type="text" name="IenvironmentId" value="请输入" id="inputid"/></li>
						<li><%String btnname = request.getParameter("TenvironmentId"); %></li>
					</ul>
				</div>
			  	<div id="submit">
			  		<input type="hidden" value=<%=btnname %> name="TenvironmentId"/>
					<input type="submit" name="inputbox" value="确定" onclick="bconfirm();">
	    			<input type="button" name="inputboxbs" value=取消 onclick="bcancel();">
	    		</div>
			</form>
	</div>
</body>
</html>
<script type="text/javascript">
	function bconfirm(){
		var inputid=document.getElementById("inputid").value;
		var trueid=document.getElementById("trueid").value;
		if(inputid==trueid){
			alert("删除成功！");
		}else{
			alert("输入id不符！");
		}
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
		width:280px;
	}
</style>