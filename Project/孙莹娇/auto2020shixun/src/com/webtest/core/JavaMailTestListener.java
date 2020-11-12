package com.webtest.core;

import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class JavaMailTestListener extends TestListenerAdapter{
	public static String content="失败的测试用例："; 
	public static int caseSize=0;
	public static int successSize=0;
	public static int failSize=0;
	

	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
//		super.onFinish(testContext);
		//打印出总的测试用例数目
		ITestNGMethod[] methods= this.getAllTestMethods();
		System.out.println("一共执行了："+methods.length);
		caseSize=methods.length;
		
		//失败的测试用例类名和方法
		List<ITestResult> failList=this.getFailedTests();
		int failLen=failList.size();
		System.out.println("失败的测试用例个数:"+failLen);
		failSize=failLen;
		
		//成功的测试用例类名和方法名
		List<ITestResult> successList=this.getPassedTests();
		int successLen=successList.size();
		System.out.println("失败的测试用例个数:"+successLen);
		successSize=successLen;

		for (int i = 0; i < failLen; i++) {
			ITestResult tr=failList.get(i);
			String text="类名："+tr.getInstanceName()+" 方法名:"+tr.getName()+";";
			content=content+text+" ";
			System.out.println(text);
		}
		System.out.println("*******");
		System.out.println(content);
	}
	
}

