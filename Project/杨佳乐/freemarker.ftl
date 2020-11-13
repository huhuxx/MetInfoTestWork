<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>自动化测试</title>
</head>
<body>
	<div style="font-size:12px" >
		<h1>自动化测试报告 </h1>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h3>详细数据</h3>
 				</div>
            	<div class="ibox-content" style="width: 100%;" >
					<div class="input-group panel-heading" style="width: 100%; background-color: #1ab394; margin-bottom: 10px; text-align: left; font-family: Consolas;">
                    	<label style="color: snow;width: 10%;">执行测试总数:${num1}</label>
                    	<label style="color: snow;width: 10%;">&nbsp;&nbsp;&nbsp;&nbsp;正确的数量：${len1}</label>
                    	<label style="color: snow;width: 10%;">&nbsp;&nbsp;&nbsp;&nbsp;错误的数量：${len}</label>
                	</div>
                	<table border="1" class="table table-bordered">
                    	<thead>
                        	<tr style="width:100%;">
                            	<th style="width:6%;">Name</th>
                            	<th style="width:10%;">Result</th>
                            	<th style="width:5%;">Time</th>
                            	<th style="width:5%;">测试人员</th>                        
                        	</tr>
   							<#list maps as m>
   								<tr style="width:100%;">
                            		<td style="width:6%;">${m.name}</td>
                            		<td style="width:10%;">${m.result}</td> 	
                            		<td style="width:5%;">${cur_time}</td>
                            		<td style="width:5%;">${ceshi}</td>                      
                        		</tr>
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


