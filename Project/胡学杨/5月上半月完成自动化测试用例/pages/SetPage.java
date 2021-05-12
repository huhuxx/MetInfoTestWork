package com.sport.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class SetPage {
	AndroidDriver<AndroidElement> driver;
	LoginPage l;
	MainPages m;
	MyInformationPages my;
	BaseAction action;
	public SetPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		action=new BaseAction(driver);
		l=new LoginPage(driver);
		m=new MainPages(driver);
		my = new MyInformationPages(driver);
	}
	//退出按钮
	public AndroidElement button_exit() {
		return driver.findElementById("com.example.fitnessdemo:id/tuichu");
	}
	//注销按钮
	public AndroidElement button_logout() {
		return driver.findElementById("com.example.fitnessdemo:id/tuichuzhuxiao");
	}
	//返回按钮
	public AndroidElement button_back() {
		return driver.findElementById("com.example.fitnessdemo:id/iv_backtuichu");
	}
	//点击方法
	public void click(String target) {
		switch (target) {
		case "退出":
			action.click(button_exit());
			break;
		case "注销":
			action.click(button_logout());
			break;
		case "返回":
			action.click(button_back());
			break;
		default:
			break;
		}
	}	
	//进入设置
	public void enter_set(String username,String password) throws InterruptedException {
		l.login_sucess(username, password);		
		Thread.sleep(500);
		m.turn_success("我的");		
		Thread.sleep(500);
		my.turn_to_target("设置");		
		Thread.sleep(500);
	}
	//完整的退出
	public void exit(String username,String password) throws InterruptedException {
		enter_set(username, password);
		click("退出");
	}
	//完整的注销
	public void layout(String username,String password) throws InterruptedException {
		enter_set(username, password);
		click("注销");
		Thread.sleep(2000);
	}
	//返回
	public void back() throws InterruptedException {
		m.turn_success("我的");		
		Thread.sleep(500);
		my.turn_to_target("设置");		
		Thread.sleep(500);
		click("返回");
	}
}
