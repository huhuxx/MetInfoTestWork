<!DOCTYPE html>
<html>
<head>
	<meta charset="utf=8"/>
	<title>MetInfo</title>
	<style>
		
	</style>
</head>
	<body>
		<h1>MetInfo Test Reports</h1>
		<h3>Test Success</h3>
		<table border='1' cellSpacing="4"  width='960px' align="center">
				<tr>
					<td bgcolor=blue>TestName</td>
					<td bgcolor=blue>TestReslut</td>
				</tr>
			<#list maps1 as m>
			    <tr>  
				    <td bgcolor=green>${m.testName}</td>
				    <td bgcolor=green>${m.testResult}</td>
			    </tr>
			</#list>
		</table>
		<h3>Test Fail</h3>
		<table border='1' cellSpacing="4"  width='960px' align="center">
				<tr>
					<td bgcolor=blue>TestName</td>
					<td bgcolor=blue>TestReslut</td>
				</tr>
			<#list maps2 as m2>
			    <tr>  
				    <td bgcolor=red>${m2.testName}</td>
				    <td bgcolor=red>${m2.testResult}</td>
			    </tr>
			</#list>
		</table>
	</body>
</html>