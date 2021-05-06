<!DOCTYPE html>
<html>
<head>
	<meta charset="utf=8"/>
	<title>MetInfo</title>
	<style>
		
	</style>
</head>
	<body>
		<h2>MetInfo Test Reports</h2>
		<table border='1' width='960px' align="center">
				<tr>
					<td bgcolor=#DCDCDC>TestName</td>
					<td bgcolor=#DCDCDC>TestReslut</td>
				</tr>
			<#list maps as m>
				<#if m.testResult == "False">
			   		<tr>  
					    <td bgcolor=#FF4500>${m.testName}</td>
					    <td bgcolor=#FF4500>${m.testResult}</td>
				    </tr>
				</#if>
				<#if m.testResult == "True">
			   		<tr>  
					    <td bgcolor=#00FA9A>${m.testName}</td>
					    <td bgcolor=#00FA9A>${m.testResult}</td>
				    </tr>
				</#if>
			</#list>
		</table>
	</body>
</html>