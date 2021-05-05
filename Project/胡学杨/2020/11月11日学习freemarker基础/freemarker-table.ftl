<table border='1' cellSpacing="1" align="center">
		<tr>
			<td>TestName</td>
			<td>TestReslut</td>
		</tr>
	<#list maps as m>
	    <tr>  
		    <td>                           
		       ${m.testName}
		    </td>
		    <td>                           
		       ${m.testResult}
		    </td>
	    </tr>
	</#list>
</table>
