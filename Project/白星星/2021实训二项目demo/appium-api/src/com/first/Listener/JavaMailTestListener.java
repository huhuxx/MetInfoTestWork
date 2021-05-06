package com.first.Listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.first.freemarker.testFreemarker;
import com.first.readproperties.ReadProperties;
import com.mail.send.MailUtilFile;
import com.mail.send.MailUtilHtml;

import freemarker.template.TemplateException;
/*
 *  * 1组
 */
public class JavaMailTestListener implements ITestListener{
	testFreemarker testFreemarker = new testFreemarker();
	int testsum,ssum,fsum=0;
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub		
        String testName = result.getName();
        System.out.println(testName+"-----------------------------------------测试用例通过");
        testsum++;
        ssum++;
        testFreemarker.createSuccessData(testName,"True");
        testFreemarker.createData(testName,"True");
	}
	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
        
        String testName = tr.getName();
        System.out.println(testName+"-----------------------------------------测试用例失败");
        testsum++;
        fsum++;
        testFreemarker.createFailData(testName, "False");
        testFreemarker.createData(testName,"False");
	}
	@Override
	public void onFinish(ITestContext testContext) {
		testFreemarker.testSum(testsum, ssum, fsum);
		System.out.println(testsum);
		try {	
			String mymail = ReadProperties.getPropertyValue("mymail");
			testFreemarker.createHtml();
			Thread.sleep(1000);
			MailUtilHtml.sendMail(mymail);
		} catch (IOException | TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String testName = result.getName();
        System.out.println(testName+"-----------------------------------------onTestStart");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String testName = result.getName();
		System.out.println(testName+"-----------------------------------------onTestSkipped");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		String testName = result.getName();
        System.out.println(testName+"-----------------------------------------onTestFailedButWithinSuccessPercentage");
	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}
}
