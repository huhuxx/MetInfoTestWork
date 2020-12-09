package com.webtest.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class JavaMailTestListener extends TestListenerAdapter{
	private static String detailResult;
	@Override
	public void onFinish(ITestContext testContext) {
		//super.onFinish(testContext);
		//打印出所有的测试用例数目
		ITestNGMethod[] methods = this.getAllTestMethods();
		String TestSum = "一共执行了："+methods.length;
		
		//失败的测试用例名称和数目
		List<ITestResult> failList = this.getFailedTests();
		List<ITestResult> sucessList = this.getPassedTests();
		List<String> detail = new ArrayList<String>();
		int len = failList.size();
		int len1 = sucessList.size();
		String failtest="失败的测试用例："+len;
		String sucesstest="成功的测试用例："+len1;
		detail.add(TestSum);
		detail.add(failtest);
		detail.add(sucesstest);
		for(int i = 0; i < len; i++) {
			ITestResult tr = failList.get(i);
			String detailFailTest = tr.getInstanceName()+":"+tr.getName()+"失败了";
			detail.add(detailFailTest);
		}
		for(int i = 0; i< len1; i++) {
			ITestResult trr = sucessList.get(i);
			String detailSucessTest = trr.getInstanceName()+":"+trr.getName()+"成功了";
			detail.add(detailSucessTest);
		}
		for(int i=0; i<detail.size();i++) {
			String s = detail.get(i);
			detailResult = detailResult+s;
		}
		MailUtil mail = new MailUtil();
		try {
			mail.SendMail(detailResult);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
