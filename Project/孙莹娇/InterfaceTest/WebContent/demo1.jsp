<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="postDemo.jsp" method="POST">
	请求方法<select>
		<option value='get'>get</option>
		<option value='post'>post</option>
	</select>
	<br />
	网址: <input type="text" name="url" />
	<input type="submit" value="提交" />
</form>
</body>
</html>