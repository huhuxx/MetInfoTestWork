<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h5>---添加用户信息---</h5>
		<form action="Yhgladd" method="post">
			<input type="hidden" name="mark" value="add" />

			<table>
				<tr>
					<td>用户id:</td>
					<td><input name="id" value="${id}"/></td>
				</tr>
				<tr>
					<td>用户名:</td>
					<td><input name="name" value="${name}" /></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input name="password" value="${password}" /></td>
				</tr>
				<tr>
					<td>邮箱:</td>
					<td><input name="email" value="${email}" /></td>
				</tr>
				<tr>
					<td>权限:</td>
					<td><input name="tright" value="${tright}" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="增加"></td>

				</tr>
			</table>

		</form>
	</center>

</body>
</html>