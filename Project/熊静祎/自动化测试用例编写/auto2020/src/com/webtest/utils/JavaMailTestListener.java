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
		//��ӡ�����еĲ���������Ŀ
		ITestNGMethod[] methods = this.getAllTestMethods();
		String TestSum = "һ��ִ���ˣ�"+methods.length;
		
		//ʧ�ܵĲ����������ƺ���Ŀ
		List<ITestResult> failList = this.getFailedTests();
		List<ITestResult> sucessList = this.getPassedTests();
		List<String> detail = new ArrayList<String>();
		int len = failList.size();
		int len1 = sucessList.size();
		String failtest="ʧ�ܵĲ���������"+len;
		String sucesstest="�ɹ��Ĳ���������"+len1;
		detail.add(TestSum);
		detail.add(failtest);
		detail.add(sucesstest);
		for(int i = 0; i < len; i++) {
			ITestResult tr = failList.get(i);
			String detailFailTest = tr.getInstanceName()+":"+tr.getName()+"ʧ����";
			detail.add(detailFailTest);
		}
		for(int i = 0; i< len1; i++) {
			ITestResult trr = sucessList.get(i);
			String detailSucessTest = trr.getInstanceName()+":"+trr.getName()+"�ɹ���";
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
