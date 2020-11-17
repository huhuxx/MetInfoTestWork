<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>自动化测试</title>
</head>
<body>
<table border="1">
	<#list maps as m>
		<tr>
			<td>${m.id1}</td>
			<td>${m.id2}</td>
		</tr>
	</#list>
	${cur_time?date}
</table>
</body>
</html>