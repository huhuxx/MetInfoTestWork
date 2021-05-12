package com.sport.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import utils.BaseAction;

public class PlanDPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	LoginPage l;
	MainPages m;
	PlanPage p;
	PlanRPage pr;
	PlanRListPage prl;
//	构造方法
	public  PlanDPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		action=new BaseAction(driver);
		l = new LoginPage(driver);
		m = new MainPages(driver);
		p = new PlanPage(driver);
		pr = new PlanRPage(driver);
		prl = new PlanRListPage(driver);
	}
	public void drag(AndroidElement from, AndroidElement to) {
		// 长按，拖动
		AndroidTouchAction action = new AndroidTouchAction(driver);

		LongPressOptions longOptions = LongPressOptions.longPressOptions();
		longOptions.withElement(ElementOption.element(from));

		action.longPress(longOptions).moveTo(ElementOption.element(to)).release().perform();
	}
//	页面对象
	//开始训练
	public AndroidElement button_start() {
		return driver.findElementById("com.example.fitnessdemo:id/btn_startPlan");
	}
	//添加计划
	public AndroidElement button_add() {
		return driver.findElementById("com.example.fitnessdemo:id/btn_addPlan");
	}
//	页面操作方法
	//点击按钮
	public void click(String target) {
		switch (target) {
		case "开始训练":
			action.click(button_start());
			break;
		case "添加计划":
			action.click(button_add());
			break;
		default:
			break;
		}
	}
	
//	//完整的开始训练
//	public void startTrain() throws InterruptedException {
//		l.login("17732053746", "123456");
//		Thread.sleep(500);
//		m.turn_success("计划");
//		Thread.sleep(500);
//		p.click("一周两练增肌计划");
//		Thread.sleep(500);
//		click("开始训练");
//	}
	//完整的添加计划
	public void addPlan() throws InterruptedException {
		l.login("17732053746", "123456");
		Thread.sleep(500);
		m.turn_success("计划");
		Thread.sleep(500);
		p.click("一周两练增肌计划");
		Thread.sleep(500);
		click("添加计划");
		Thread.sleep(5000);
	}
	//再次添加计划
	public String addPlanAgain() throws InterruptedException {
		click("添加计划");
		Thread.sleep(500);
		return action.getToast();
	}
	//开始训练
	public void startTrain() throws InterruptedException {
		Thread.sleep(2000);
		click("开始训练");
	}
	//进入推荐计划
	public String enterPlanR() throws InterruptedException {
		prl.click("完美肩背塑型计划");
		Thread.sleep(500);
		return action.getToast();
	}
	//添加推荐计划
	public String addPlanR() throws InterruptedException {
		click("添加计划");
		Thread.sleep(5000);
		return action.getToast();
	}
	//完整的添加推荐计划
	public void addPlanR1() throws InterruptedException {
		l.login("17732053746", "123456");
		Thread.sleep(500);
		m.turn_success("推荐计划");
		Thread.sleep(500);
		pr.click("确认");
		Thread.sleep(500);
		prl.click("完美肩背塑性计划");
		Thread.sleep(500);
		click("添加计划");
		Thread.sleep(5000);
	}
}
