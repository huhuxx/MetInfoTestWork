<div style="font-size:12px">自动化测试报告-----${date?string("yyyy-MM-dd HH:mm:ss")}
<br/>本次共运行自动化case:${casesize}个，其中失败:${failcasesize}个，成功:${successcasesize}，跳过${skipsize}
<br/>
${message}
<br/>
</div>
<head>
<style type="text/css">
		.table
		{
			width: 100%;
			padding: 0;
			margin: 0;
		}
		th {
			font: bold 12px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
			color: #4f6b72;
			border-right: 1px solid #C1DAD7;
			border-bottom: 1px solid #C1DAD7;
			border-top: 1px solid #C1DAD7;
			letter-spacing: 2px;
			text-transform: uppercase;
			text-align: left;
			padding: 6px 6px 6px 12px;
			background: #CAE8EA no-repeat;
		}
		td {
			border-right: 1px solid #C1DAD7;
			border-bottom: 1px solid #C1DAD7;
			background: #fff;
			font-size:14px;
			padding: 6px 6px 6px 12px;
			color: #4f6b72;
		}
		td.alt {
			background: #F5FAFA;
			color: #797268;
		}
		th.spec,td.spec {
			border-left: 1px solid #C1DAD7;
		}
		/*---------for IE 5.x bug*/
		html>body td{ font-size:14px;}
		tr.select th,tr.select td
		{
			background-color:#CAE8EA;
			color: #797268;
		}
	</style>
</head>
<body>
	<table border="2" align="center" cellspacing="0" bgcolor="#F0F8FF">
		<tr>
			<th class="spec">序号</th>
			<th>测试类</th>
			<th>测试方法</th>
			<th>测试结果</th>
		</tr>
		<#list testMethodsList as testMethods>
		<tr>
			<td>${testMethods.index}</td>
			<td>${testMethods.methodName}</td>
			<td>${testMethods.mehthodClassName}</td>
			<td>${testMethods.status}</td>
		</tr>
			
		</#list>
	
	</table>
</body>