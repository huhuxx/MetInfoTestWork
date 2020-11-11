package com.hxy.mail;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hxy.freemarker.testFreemarker;

import freemarker.template.TemplateException;

public class JavaCreateHtml implements ITestListener{
	String error = "";
	testFreemarker testFreemarker = new testFreemarker();
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		ITestListener.super.onTestFailure(result);
        String testName = result.getName();
        System.out.println(testName+"-----------------------------------------测试完成，通过");
        testFreemarker.createData(testName, "True");
	}
	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
        ITestListener.super.onTestFailure(tr);
        String testName = tr.getName();
        System.out.println(testName+"-----------------------------------------测试完成，失败");
        testFreemarker.createData(testName, "False");
	}
	@Override
	public void onFinish(ITestContext testContext) {
			try {
				testFreemarker.createHtml();
			} catch (IOException | TemplateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
