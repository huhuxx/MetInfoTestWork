package com.webtest.core;

import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class JavaMailTestListener extends TestListenerAdapter{
	public static String content="ʧ�ܵĲ���������"; 
	public static int caseSize=0;
	public static int successSize=0;
	public static int failSize=0;
	

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
		int failLen=failList.size();
		System.out.println("ʧ�ܵĲ�����������:"+failLen);
		failSize=failLen;
		
		//�ɹ��Ĳ������������ͷ�����
		List<ITestResult> successList=this.getPassedTests();
		int successLen=successList.size();
		System.out.println("ʧ�ܵĲ�����������:"+successLen);
		successSize=successLen;

		for (int i = 0; i < failLen; i++) {
			ITestResult tr=failList.get(i);
			String text="������"+tr.getInstanceName()+" ������:"+tr.getName()+";";
			content=content+text+" ";
			System.out.println(text);
		}
		System.out.println("*******");
		System.out.println(content);
	}
	
}

