package com.hxy.Listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hxy.freemarker.testFreemarker;
import com.hxy.mail.MailUtilHtml;
import com.hxy.readproperties.ReadProperties;

import freemarker.template.TemplateException;

public class JavaMailTestListener implements ITestListener{
	testFreemarker testFreemarker = new testFreemarker();
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSuccess(result);
        String testName = result.getName();
        System.out.println(testName+"-----------------------------------------测试用例通过");
        testFreemarker.createSuccessData(testName,"True");
        testFreemarker.createData(testName,"True");
	}
	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
//        ITestListener.super.onTestFailure(tr);
        String testName = tr.getName();
        System.out.println(testName+"-----------------------------------------测试用例失败");
        testFreemarker.createFailData(testName, "False");
        testFreemarker.createData(testName,"False");
	}
	@Override
	public void onFinish(ITestContext testContext) {
		try {
			String mymail = ReadProperties.getPropertyValue("mymail");
			//
			testFreemarker.createHtml();
			Thread.sleep(1000);
			MailUtilHtml.sendMail(mymail);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
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
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String testName = result.getName();
		System.out.println(testName+"-----------------------------------------测试用例失败");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}	
}
