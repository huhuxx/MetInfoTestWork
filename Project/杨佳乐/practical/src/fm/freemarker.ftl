<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>自动化测试</title>
</head>
<body>
	<div style="font-size:12px;" >
		<h1 align="center">MetInfo建站系统自动化测试报告 </h1>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h3>1 引言部分</h3>
 				</div>
 				<div class="ibox-title">
					<h5>1.1 项目背景</h5>
 				</div>
 				<div class="ibox-title">
					<p style="text-indent: 2em;">本测试报告为MetInfo建站系统测试报告；本报告目的在于总结测试阶段的测试及测试结果分析，描述系统是否达到需求的目的。</p>
 				</div>
 				<div class="ibox-title">
					<h3>2 测试基本信息</h3>
 				</div>
 				<div class="ibox-title">
					<h5>2.1 测试范围</h5>
 				</div>
 				<div class="ibox-title">
					<p style="text-indent: 2em;">目前为基本的发送freemarker的html邮件的完成阶段，测试内容只是简单的正确错误的内容，不具体到系统的范围和内容。</p>
 				</div>
 				<div class="ibox-title">
					<h5>2.2 测试案例设计思路</h5>
 				</div>
 				<div class="ibox-title">
					<p style="text-indent: 2em;">根据测试用例进行自动化测试。</p>
 				</div>
				<div class="ibox-title">
					<h3>3 测试结果</h3>
 				</div>
 				<div class="ibox-title">
					<h5>3.1 测试详细数据</h5>
 				</div>
            	<div class="ibox-content" style="width: 100%;" >
					<div class="input-group panel-heading" style="width: 100%; background-color: #1ab394; margin-bottom: 10px; text-align: left; font-family: Consolas;">
                    	<label style="color: snow;width: 10%;">执行测试总数:${num1}</label>
                    	<label style="color: snow;width: 10%;">&nbsp;&nbsp;&nbsp;&nbsp;正确的数量：${len1}</label>
                    	<label style="color: snow;width: 10%;">&nbsp;&nbsp;&nbsp;&nbsp;错误的数量：${len}</label>
                	</div>
                	<table border="1" cellspacing="0">
                    	<thead>
                        	<tr style="width:100%;">
                            	<th style="width:6%;">Name</th>
                            	<th style="width:10%;">Result</th>
                            	<th style="width:5%;">Time</th>
                            	<th style="width:5%;">测试人员</th>                        
                        	</tr>
   							<#list maps as m>
   								<#if m.result == "true"> 
   									<tr style="width:100%;">
                            			<td style="width:6%;">${m.name}</td>
                            			<td style="width:10%;">${m.result}</td>   	
                            			<td style="width:5%;">${cur_time}</td>
                            			<td style="width:5%;">${ceshi}</td>                      
                        			</tr>
                        		<#else>
                        			<tr style="width:100%; color:#ff2121;">
                            			<td style="width:6%;">${m.name}</td>
                            			<td style="width:10%;">${m.result}</td>   	
                            			<td style="width:5%;">${cur_time}</td>
                            			<td style="width:5%;">${ceshi}</td>                      
                        			</tr>
                        		</#if>
   							</#list>
                    	</thead>
                    	<tbody id="detailBody">
                    	</tbody>
                	</table>
            	</div>
        	</div>
   	 	</div>
	</div>
</body>
</html>


