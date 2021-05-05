package com.hxy.mail;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class JavaMailTestListener implements ITestListener{
	String error = "";
	@Override
	public void onTestFailure(ITestResult tr) {
        ITestListener.super.onTestFailure(tr);
        error = error + tr.getName() + ",";
	}
	@Override
	public void onFinish(ITestContext testContext) {
		try {
			String mymail = ReadProperties.getPropertyValue("mymail");
			//给自己发
			MailUtil.sendMail(error,mymail);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
