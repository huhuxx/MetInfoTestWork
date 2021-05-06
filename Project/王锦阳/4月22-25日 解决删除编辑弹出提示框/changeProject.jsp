<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新项目</title>
<base target="_self" />
</head>
<body>
<form action="ChangeProjectServlet" method="post">
	项目名称：<input type="text" name="projectName"/><br>
	项目描述：<input type="text" name="projectDescription"/><br>
			<%String btnname = request.getParameter("TprojectId"); %>
		<input type="hidden" value=<%=btnname %> name="TprojectId"/> 		
		<input type="submit" name="inputbox" value="确定" onclick="bconfirm();">
		<input type="button" name="inputboxbs" value=取消 onclick="bcancel();">
</form>
</body>
</html>
<script type="text/javascript">
	function bconfirm(){
		alert("编辑成功！");
		window.close();
	  }
	  function bcancel(){
	     window.close();
	  }
</script>