<div style="font-size:12px">�Զ������Ա���-----${date?string("yyyy-MM-dd HH:mm:ss")}
<br/>���ι������Զ���case:${casesize}��������ʧ��:${failcasesize}�����ɹ�:${successcasesize}������${skipsize}
<br/>

<br/>
</div>

<body>
	<table border="2" align="center" width="100%" cellspacing="0" bgcolor="#F0F8FF">
		<tr style="text-align: center;">
			<th class="spec">���</th>
			<th>���Է���</th>
			<th>������</th>
			<th>���Խ��</th>
		</tr>
		<#list testMethodsList as testMethods>
		<tr style="text-align: center;">
			<td>${testMethods.index}</td>
			<td>${testMethods.methodName}</td>
			<td>${testMethods.mehthodClassName}</td>
			
			<#if testMethods.status=="Failed">
        	<td bgcolor="#FF4000">${testMethods.status}</td>
        	<#elseif testMethods.status=="Passed">
        	<td bgcolor="#64FE2E">${testMethods.status}</td>
        	<#else>
        	<td bgcolor="#FFFF00">${testMethods.status}</td>
        	</#if>
		</tr>
			
		</#list>
	
	</table>
</body>