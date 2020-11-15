package com.webtest.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.webtest.utils.TestMethods;

public class JavaMailTestListener extends TestListenerAdapter{
	public static String content="失败的测试用例："; 
	public static int caseSize=0;
	public static int successSize=0;
	public static int failSize=0;
	public static int skipSize=0;
	public static List<TestMethods> testMethodsList=new ArrayList<>();
	
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
		failSize=failList.size();
		System.out.println("失败的测试用例个数:"+failSize);
		
		for (int i = 0; i < failSize; i++) {
			ITestResult trFail=failList.get(i);
			
			TestMethods testMethod=new TestMethods();
			testMethod.setIndex(i+1);
			testMethod.setMethodName(trFail.getName());
			testMethod.setMehthodClassName(trFail.getInstanceName());
			testMethod.setStatus("Failed");
			
			testMethodsList.add(testMethod);
			String text="类名："+trFail.getInstanceName()+" 方法名:"+trFail.getName()+";";
			content=content+text+" ";
			System.out.println(text);
		}
		System.out.println("*******");
		System.out.println(content);
		
		//成功的测试用例
		List<ITestResult> successList=this.getPassedTests();
		successSize=successList.size();
		System.out.println("失败的测试用例个数:"+successSize);
		
		for (int i = 0; i < successSize; i++) {
			ITestResult trSuccess=successList.get(i);
				
			TestMethods testMethod=new TestMethods();
			testMethod.setIndex(i+1);
			testMethod.setMethodName(trSuccess.getName());
			testMethod.setMehthodClassName(trSuccess.getInstanceName());
			testMethod.setStatus("Passed");
			testMethodsList.add(testMethod);
		}	
		
		//跳过的测试用例
		List<ITestResult> skipList=this.getSkippedTests();
		skipSize=skipList.size();
		System.out.println("跳过的测试用例的个数："+skipSize);
		
		for (int i = 0; i < skipSize; i++) {
			ITestResult trSkip=skipList.get(i);
				
			TestMethods testMethod=new TestMethods();
			testMethod.setIndex(i+1);
			testMethod.setMethodName(trSkip.getName());
			testMethod.setMehthodClassName(trSkip.getInstanceName());
			testMethod.setStatus("Skipped");
			testMethodsList.add(testMethod);
		}	
	
	

		
		
	}
	
}

