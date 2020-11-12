package com.freemarker;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.webtest.utils.Log;
import com.webtest.utils.ReadProperties;
/**
 * author:xiongjingyi
 * 
 */
public class JavaMailTestListener extends TestListenerAdapter{
	
	FreemarkerTemplateEngine ft=new FreemarkerTemplateEngine();
	
	public JavaMailTestListener() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	private String writeResultToMailTemplate()
	{
		ITestNGMethod method[]=this.getAllTestMethods();
		List<?> failedList=this.getFailedTests();
		List<?> passedList=this.getPassedTests();
		List<ITestResult> failedList1=new ArrayList<ITestResult>();
		List<ITestResult> passedList1=new ArrayList<ITestResult>();
		for(int j=0;j<failedList.size();j++)
		{
			ITestResult tr=(ITestResult) failedList.get(j);
			for(int i=0;i<method.length;i++)
			{
				if(tr.getMethod().getMethodName().equals(method[i].getMethodName()))
				{
					if(method[i].getDescription()!=null)
					{
						tr.setAttribute("name", method[i].getDescription());
					}
					else
					{
						tr.setAttribute("name", "");
					}
					break;
				}
			}
			failedList1.add(tr);
		}
		for(int j=0;j<passedList.size();j++)
		{
			ITestResult tr=(ITestResult) passedList.get(j);
			for(int i=0;i<method.length;i++)
			{
				if(tr.getMethod().getMethodName().equals(method[i].getMethodName()))
				{
					if(method[i].getDescription()!=null)
					{
						tr.setAttribute("name", method[i].getDescription());
					}
					else
					{
						tr.setAttribute("name", "");
					}
					break;
				}
			}
			passedList1.add(tr);
		}
		@SuppressWarnings("rawtypes")
		Map context=new HashMap();
    	context.put("date", new Date());
        context.put("failedList",failedList);   
        context.put("passedList",passedList1); 
        context.put("casesize",passedList.size()+failedList.size()); 
        context.put("failcasesize",failedList.size());
        try {
			String content=ft.run(context);
			return content;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public void onFinish(ITestContext testContext){
		// TODO Auto-generated method stub
		super.onFinish(testContext);
		if(System.getProperty("os.name").contains("dow"))
		{
			//return;
		}
		try {
			if(ReadProperties.getPropertyValue("enable_email").equals("true"))
			{
				String emailContent=this.writeResultToMailTemplate();
				String emailTitle=ReadProperties.getPropertyValue("mail_title")+"----"+this.getTime();
				String toMail=ReadProperties.getPropertyValue("to_mail");
				try {
					if(this.getFailedTests()!=null&&this.getFailedTests().size()>0)
					{
						MailUtil.SendMail(toMail,emailTitle, emailContent);
						Log.info("email send to "+toMail+" success");
					}else
					{
						MailUtil.SendMail(ReadProperties.getPropertyValue("success_to_mail"),emailTitle, emailContent);
						Log.info("email send to "+ReadProperties.getPropertyValue("success_to_mail")+" success");
					}
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					Log.fatal("email send fail :"+e.getMessage());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
  public String getTime()
    {
    	java.util.Calendar c=java.util.Calendar.getInstance();    
        java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");    
       	return  f.format(c.getTime());    
    }
	
}
