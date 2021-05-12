package com.sport.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class LoginPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
//	构造方法
	public  LoginPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		action=new BaseAction(driver);
		
	}
//	页面对象
	//账号
	public AndroidElement edit_username() {
		return driver.findElementById("com.example.fitnessdemo:id/edit_loginusernum");
	}
	//密码
	public AndroidElement edit_password() {
		return driver.findElementById("com.example.fitnessdemo:id/edit_loginuserpwd");
	}
	//登录
	public AndroidElement btn_login() {
		return driver.findElementById("com.example.fitnessdemo:id/btn_login");
	}	
	//忘记密码
	public AndroidElement btn_fpassword() {
		return driver.findElementById("com.example.fitnessdemo:id/tv_findpwd");
	}
//	页面操作方法
	//点击按钮
	public void click(String target) {
		switch (target) {
		case "登录":
			action.click(btn_login());
			break;
		case "忘记密码":
			action.click(btn_fpassword());
			break;
		default:
			break;
		}
	}
	//不返回信息的登录
	public void login(String username,String password) throws InterruptedException {
		action.type(edit_username(), username);
		action.type(edit_password(), password);
		action.click(btn_login());
		Thread.sleep(500);
	}
	
	//验证登录成功
	public MainPages login_sucess(String username,String password) {
		action.type(edit_username(), username);
		action.type(edit_password(), password);
		action.click(btn_login());
		return new MainPages(driver);
	}
	
	//登录失败
	public String login_fail(String username,String password) {
		action.type(edit_username(), username);
		action.type(edit_password(), password);
		action.click(btn_login());
		return action.getToast();
	}
}
