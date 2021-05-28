<!DOCTYPE html>
<html>
<head>
	<meta charset="utf=8"/>
	<title>ImplementTestReport</title>
	<style>
		#i{
			background:url('http://a1.qpic.cn/psc?/V128S3LO4Aqidm/ruAMsa53pVQWN7FLK88i5hgMcYmcs9Sm.ysR2poct8SqIjZrOcjVHCQdWjtFwXdQC3.7QAvMF2XWvGdJKKYi4fGFf7MbTnr8G9iZ.rtgE1A!/c&ek=1&kp=1&pt=0&bo=gAewBIAHsAQRECc!&t=5&tl=3&vuin=1647524030&tm=1621854000&sce=60-2-2&rf=0-0') no-repeat center top;
			background-size: 100% 100%;
		}
		table{ 
			border-collapse:collapse;
			border:solid 1px #ccc;
			width:600px;
		}
		td{ 
			border:solid 1px #ccc; 
			padding-left:10px;
			opacity:0.8;
		}
	</style>
</head>
		<body>
		<div id="i">
			<h1>JSZS Test Reports</h1>
			<h3><font color=blue>testNumber:<#list maps3 as m>${m.testsum}</#list></font></h3>	
			<h3><font color=#00FF00>testSuccessNumber:<#list maps3 as m>${m.ssum}</#list></font></h3>	
			<h3><font color=#FF4500>testFailNumber:<#list maps3 as m>${m.fsum}</#list></font></h3>	
			<table align="center">
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
			<table align="center">
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
			<table align="center">
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
	</div>
	</body>
</html>