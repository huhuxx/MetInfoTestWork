<div style="font-size:12px">�Զ������Ա���-----${date?string("yyyy-MM-dd HH:mm:ss")}
<br/>���ι������Զ���case:${casesize}��������ʧ��:${failcasesize}�����ɹ�:${successcasesize}������${skipsize}
<br/>
${message}
<br/>
</div>

<body>
	<table border="2" align="center" cellspacing="0" bgcolor="#F0F8FF">
		<tr>
			<th class="spec">���</th>
			<th>������</th>
			<th>���Է���</th>
			<th>���Խ��</th>
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