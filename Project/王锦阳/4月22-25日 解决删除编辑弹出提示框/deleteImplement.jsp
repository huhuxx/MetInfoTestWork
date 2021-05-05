<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除接口</title>
<base target="_self" />
</head>
<body>
<form action="DeleteImplementServlet" method="post">
	请确认需要删除的接口id：<input id="inputid" type="text" name="IimplementId"/><br>
	
	<%String btnname = request.getParameter("TimplementId"); %>
	<input type="hidden" value=<%=btnname %> name="TimplementId" id="trueid"/> 	
	<input type="submit" name="inputbox" value="确定" onclick="bconfirm();">
	<input type="button" name="inputboxbs" value=取消 onclick="bcancel();">
</form>
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