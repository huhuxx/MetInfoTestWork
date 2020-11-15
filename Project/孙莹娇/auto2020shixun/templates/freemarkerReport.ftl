<div style="font-size:12px">自动化测试报告-----${date?string("yyyy-MM-dd HH:mm:ss")}
<br/>本次共运行自动化case:${casesize}个，其中失败:${failcasesize}个，成功:${successcasesize}，跳过${skipsize}
<br/>
${message}
<br/>
</div>

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