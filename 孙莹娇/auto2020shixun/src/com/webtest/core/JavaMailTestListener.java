package com.webtest.core;

import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class JavaMailTestListener extends TestListenerAdapter{
	public static String content="ʧ�ܵĲ���������"; 
	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
//		super.onFinish(testContext);
		//��ӡ���ܵĲ���������Ŀ
		ITestNGMethod[] methods= this.getAllTestMethods();
		System.out.println("һ��ִ���ˣ�"+methods.length);
		
		//ʧ�ܵĲ������������ͷ���
		List<ITestResult> faiList=this.getFailedTests();
		int failLen=faiList.size();
		System.out.println("ʧ�ܵĲ�����������:"+failLen);
		

		for (int i = 0; i < failLen; i++) {
			ITestResult tr=faiList.get(i);
			String text="������"+tr.getInstanceName()+" ������:"+tr.getName()+";";
			content=content+text+" ";
			System.out.println(text);
		}
		System.out.println("*******");
		System.out.println(content);
	}
	
}

