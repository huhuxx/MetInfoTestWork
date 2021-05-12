package com.sport.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class PlanRPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	LoginPage l;
	MainPages m;
//	构造方法
	public  PlanRPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		action=new BaseAction(driver);
		l = new LoginPage(driver);
		m = new MainPages(driver);
	}
//	页面对象
	//性别
	public AndroidElement button_sex() {
		return driver.findElementById("com.example.fitnessdemo:id/btn_register_info_sex");
	}
	//身高
	public AndroidElement silde_height() {
		return driver.findElementById("com.example.fitnessdemo:id/ruler_height");
	}	
	//体重
	public AndroidElement silde_weight() {
		return driver.findElementById("com.example.fitnessdemo:id/ruler_weight");
	}
	//确认
	public AndroidElement button_confirm() {
		return driver.findElementById("com.example.fitnessdemo:id/zft_btn_check");
	}
	//推荐计划1
	public AndroidElement list_planR1() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView");
	}
	//推荐计划2
	public AndroidElement list_planR2() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView");
	}
	//
//	页面操作方法
	//点击按钮
	public void click(String target) {
		switch (target) {
		case "性别":
			action.click(button_sex());
			break;
		case "确认":
			action.click(button_confirm());
			break;
		default:
			break;
		}
	}
	//核对信息
	public String information(String sex) throws InterruptedException {
		l.login("17732053746", "123456");
		Thread.sleep(500);
		m.turn_success("推荐计划");
		Thread.sleep(500);
		if(sex.equals("girl")) {
			click("性别");
			Thread.sleep(500);
		}
		click("确认");
		return action.getToast();
	}
	//信息核对男
	public String information_boy() throws InterruptedException {
		l.login("17732053746", "123456");
		Thread.sleep(500);
		m.turn_success("推荐计划");
		Thread.sleep(500);
		click("确认");
		return action.getToast();
	}
	//信息核对
	public String information_girl() throws InterruptedException {
		l.login("17732053746", "123456");
		Thread.sleep(500);
		m.turn_success("推荐计划");
		Thread.sleep(500);
		click("性别");
		Thread.sleep(500);
		click("确认");
		return action.getToast();
	}
}
