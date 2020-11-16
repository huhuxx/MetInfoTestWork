<!DOCTYPE html>

<html>
  <head>
  <meta charset='utf-8'>
  <title>测试报告</title>    
  </head>

  <body>
  <h1>白星星的测试报告</h1>
  <h2>Start Time:${dateTime?string("yyyy-MM-dd-mm-ss")}</h2>
  <h2>测试结果：共${alltest},通过${passedtest},失败${failedtest}</h2>
  <hr>
  <table  align="center" border="1px" border="10" width="50%" cellpadding="10" cellspacing="10">
    <caption>用例执行情况</caption>
    <tr bgcolor="blue">
        <th align="center" valign="middle">Test Case</th>
        <th align="center" valign="middle">Pass</th>
        <th align="center" valign="middle">Fail</th>
        <th align="center" valign="middle">Skip</th>
        <th align="center" valign="middle">测试人</th>
    </tr>
    
    <#list maps as m>
    <tr>
    	<td align="center">${m.group}</td>
    	<td align="center"><font color="green">${m.pass}</td>
    	<td align="center"><font color="red">${m.fail}</td>
    	<td align="center"><font color="yellow">${m.skip}</td>
    	<td align="center">${m.user}</td>
    </tr>
    </#list>
  </table>
  <br>
  <br>
  <table align="center" border="1px" border="10" width="50%" cellpadding="10" cellspacing="10">
  	<caption>成功的测试用例</caption>
  	<tr bgcolor="green">
        <th align="center" valign="middle">测试用例所在位置</th>
        <th align="center" valign="middle">测试用例</th>
    </tr>
    <#list passes as pass>
    <tr>
    	<td>${pass.InstanceName1}</td>
    	<td>${pass.Name1}</td>
    </tr>
    </#list>>
  </table>
  <br>
  <br>
  <table align="center" border="1px" border="10" width="50%" cellpadding="10" cellspacing="10">
  	<caption>失败的测试用例</caption>
  	<tr bgcolor="red">
        <th align="center" valign="middle">测试用例所在位置</th>
        <th align="center" valign="middle">测试用例</th>
    </tr>
    <#list failed as fail>
    <tr>
    	<td>${fail.InstanceName2}</td>
    	<td>${fail.Name2}</td>
    </tr>
    </#list>
  </table>
  <br>
  <br>
  <table align="center" border="1px" border="10" width="50%" cellpadding="10" cellspacing="10">
  	<caption>跳过的测试用例</caption>
  	<tr bgcolor="yellow">
        <th align="center" valign="middle">测试用例所在位置</th>
        <th align="center" valign="middle">测试用例</th>
    </tr>
    <#list skipped as skip>
    <tr>
    	<td>${skip.InstanceName3}</td>
    	<td>${skip.Name3}</td>
    </tr>
    </#list>
  </table>
  </body>
</html>



