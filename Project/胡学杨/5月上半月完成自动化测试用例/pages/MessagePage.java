package com.sport.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class MessagePage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	LoginPage login;
//	构造方法
	public MessagePage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		this.action=new BaseAction(driver);
		login = new LoginPage(driver);
		}
	
//	页面对象
	//手机号输入框
	public AndroidElement phone_input() {
		return driver.findElementById("com.example.fitnessdemo:id/phone");
	}
	//验证码输入框
	public AndroidElement code_input() {	
		return driver.findElementById("com.example.fitnessdemo:id/cord");
	}
	//获取验证码按钮
	public AndroidElement getCode_button() {
		return driver.findElementById("com.example.fitnessdemo:id/getcord");
	}
	//验证按钮
	public AndroidElement verification_button() {
		return driver.findElementById("com.example.fitnessdemo:id/savecord");
	}
	
//	页面操作方法
	//点击
	public void click(String target) {
		switch (target) {
		case "获取验证码":
			action.click(getCode_button());
			break;
		case "验证":
			action.click(verification_button());
			break;
		default:
			break;
		}
	}
	//完整验证
	public void check(String phone,String code) throws InterruptedException {
		login.click("忘记密码");
		action.type(phone_input(), phone);
		action.type(code_input(), code);
		click("验证");
	}
}
