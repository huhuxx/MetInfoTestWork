测试结果:
<#list maps as m>
	${m.testName} : ${m.testResult}
</#list>


<!DOCTYPE html>
<html>
<head>s
	<meta charset="utf=8"/>
	<title>MetInfo</title>
	<style>
		
	</style>
</head>
	<body>
		<h1>MetInfo Test Reports</h1>
		<table border='1' cellSpacing="1"  width='960px' align="center">
				<tr>
					<td>TestName</td>
					<td>TestReslut</td>
				</tr>
			<#list maps as m>
			    <tr>  
				    <td  bgcolor=green>${m.testName}</td>
				    <td bgcolor=green>${m.testResult}</td>
			    </tr>
			</#list>
		</table>
	</body>
</html>


		<h3>Fail Test</h3>
		<table border='1' cellSpacing="1"  width='960px' align="center">
				<tr>
					<td>TestName</td>
					<td>TestReslut</td>
				</tr>
			<#list mapsF as mf>
			    <tr>  
				    <td bgcolor=red>${mf.testName}</td>
				    <td bgcolor=red>${mf.testResult}</td>
			    </tr>
			</#list>
		</table>