package com.sport.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class PlanStartPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	LoginPage l;
	MainPages m;
	PlanPage p;
	PlanRPage pr;
	PlanRListPage prl;
	PlanDPage pd;
//	构造方法
	public  PlanStartPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		action=new BaseAction(driver);
		l = new LoginPage(driver);
		m = new MainPages(driver);
		p = new PlanPage(driver);
		pr = new PlanRPage(driver);
		prl = new PlanRListPage(driver);
	}
//	页面对象
	//
	public AndroidElement button_start1() {
		return driver.findElementById("com.example.fitnessdemo:id/btn_startPlan");
	}
	//播放按钮
	public AndroidElement button_start() {
		return driver.findElementById("com.example.fitnessdemo:id/btn_startMotion");
	}
	//暂停按钮
	public AndroidElement button_stop() {
		return driver.findElementById("com.example.fitnessdemo:id/zft_start_stop");
	}
	//向右
	public AndroidElement button_right() {
		return driver.findElementById("com.example.fitnessdemo:id/iv_next");
	}
	//向左
	public AndroidElement button_left() {
		return driver.findElementById("com.example.fitnessdemo:id/iv_pre");
	}
	//训练名称
	public AndroidElement strain_name() {
		return driver.findElementById("com.example.fitnessdemo:id/tv_motionInfoName");
	}
	//
	public String strain_string_name() {
		return strain_name().getText();
		
	}
//	页面操作方法
	//点击按钮
	public void click(String target) {
		switch (target) {
		case "播放":
			action.click(button_start());
			break;
		case "暂停":
			action.click(button_stop());
			break;
		case "继续播放":
			action.click(button_stop());
			break;
		case "向右":
			action.click(button_right());
			break;
		case "向左":
			action.click(button_left());
			break;
		case "开始":
			action.click(button_start1());
			break;
		default:
			break;
		}
	}
	
	//完整的开始训练
	public void startTrain() throws InterruptedException {
		l.login("17732053746", "123456");
		Thread.sleep(500);
		m.turn_success("计划");
		Thread.sleep(500);
		p.click("减脂");
		Thread.sleep(500);
		p.click("初级燃脂");
		Thread.sleep(2000);
		click("开始");
		Thread.sleep(500);
		click("播放");
	}
	//下一个
	public String nextTrain() throws InterruptedException {
		Thread.sleep(2000);
		click("向右");
		Thread.sleep(500);
		click("向右");
		return strain_string_name();
	}
}
