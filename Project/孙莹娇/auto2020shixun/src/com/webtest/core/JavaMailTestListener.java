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
	public static String content="ʧ�ܵĲ���������"; 
	public static int caseSize=0;
	public static int successSize=0;
	public static int failSize=0;
	public static int skipSize=0;
	public static List<TestMethods> testMethodsList=new ArrayList<>();
	
	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
//		super.onFinish(testContext);
		//��ӡ���ܵĲ���������Ŀ
		ITestNGMethod[] methods= this.getAllTestMethods();
		System.out.println("һ��ִ���ˣ�"+methods.length);
		caseSize=methods.length;
		
		//ʧ�ܵĲ������������ͷ���
		List<ITestResult> failList=this.getFailedTests();
		failSize=failList.size();
		System.out.println("ʧ�ܵĲ�����������:"+failSize);
		
		for (int i = 0; i < failSize; i++) {
			ITestResult trFail=failList.get(i);
			
			TestMethods testMethod=new TestMethods();
			testMethod.setIndex(i+1);
			testMethod.setMethodName(trFail.getName());
			testMethod.setMehthodClassName(trFail.getInstanceName());
			testMethod.setStatus("Failed");
			
			testMethodsList.add(testMethod);
			String text="������"+trFail.getInstanceName()+" ������:"+trFail.getName()+";";
			content=content+text+" ";
			System.out.println(text);
		}
		System.out.println("*******");
		System.out.println(content);
		
		//�ɹ��Ĳ�������
		List<ITestResult> successList=this.getPassedTests();
		successSize=successList.size();
		System.out.println("�ɹ��Ĳ�����������:"+successSize);
		
		for (int i = 0; i < successSize; i++) {
			ITestResult trSuccess=successList.get(i);
				
			TestMethods testMethod=new TestMethods();
			testMethod.setIndex(i+1);
			testMethod.setMethodName(trSuccess.getName());
			testMethod.setMehthodClassName(trSuccess.getInstanceName());
			testMethod.setStatus("Passed");
			testMethodsList.add(testMethod);
		}	
		
		//�����Ĳ�������
		List<ITestResult> skipList=this.getSkippedTests();
		skipSize=skipList.size();
		System.out.println("�����Ĳ��������ĸ�����"+skipSize);
		
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

