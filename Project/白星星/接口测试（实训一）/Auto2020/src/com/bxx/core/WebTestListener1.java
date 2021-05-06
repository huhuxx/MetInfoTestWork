package com.bxx.core;


import java.io.IOException;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;

import com.bxx.utils.MailUtil;

public class WebTestListener1 extends TestListenerAdapter {
	public static int all;
	public static List<ITestResult> passList;
	public static List<ITestResult> failList;
	public static List<ITestResult> skipList;
	@Override
	public void onFinish(ITestContext testContext) {
//		super.onFinish(testContext);
//		打印出总的测试用例的数目	
		ITestNGMethod[] methods = this.getAllTestMethods();
		all = methods.length;
		System.out.println("一共执行了："+methods.length);
		this.getFailedTests();
		
//		成功的、失败的测试用例名称和数目
		passList = this.getPassedTests();
		failList = this.getFailedTests();
		skipList = this.getSkippedTests();
		//passed
		int lenpass = passList.size();
		for (int i = 0; i < lenpass; i++) {
			ITestResult result = passList.get(i);
			System.out.println(result.getInstanceName()+":"+result.getName()+"通过了");
		}
		//failed
		int len = failList.size();
		System.out.println("失败的测试用例："+len);
		for (int i = 0; i < len; i++) {
			ITestResult tr = failList.get(i);
			System.out.println(tr.getInstanceName()+":"+tr.getName()+"失败了");
		}
		
//		this.getPassedTests();//成功的
		
		
	}

}
