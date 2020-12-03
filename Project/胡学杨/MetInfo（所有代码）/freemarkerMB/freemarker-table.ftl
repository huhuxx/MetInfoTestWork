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
		<h3><font color=blue>testNumber:<#list maps3 as m>${m.testsum}</#list></font></h3>	
		<h3><font color=green>testSuccessNumber:<#list maps3 as m>${m.ssum}</#list></font></h3>	
		<h3><font color=#FF4500>testFailNumber:<#list maps3 as m>${m.fsum}</#list></font></h3>	
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
		<h3>Test Success</h3>
		<table border='1' width='960px' align="center">
				<tr>
					<td bgcolor=#DCDCDC>TestName</td>
					<td bgcolor=#DCDCDC>TestReslut</td>
				</tr>
			<#list maps1 as m>
			    <tr>  
				    <td bgcolor=#00FA9A>${m.testName}</td>
				    <td bgcolor=#00FA9A>${m.testResult}</td>
			    </tr>
			</#list>
		</table>
		<h3>Test Fail</h3>
		<table border='1' width='960px' align="center">
				<tr>
					<td bgcolor=#DCDCDC>TestName</td>
					<td bgcolor=#DCDCDC>TestReslut</td>
				</tr>
			<#list maps2 as m2>
			    <tr>  
				    <td bgcolor=#FF4500>${m2.testName}</td>
				    <td bgcolor=#FF4500>${m2.testResult}</td>
			    </tr>
			</#list>
		</table>
	</body>
</html>