package com.sport.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import utils.BaseAction;

public class PlanMakePage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	LoginPage l;
	MainPages m;
//	构造方法
	public  PlanMakePage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		action=new BaseAction(driver);
		l = new LoginPage(driver);
		m = new MainPages(driver);
	}
//	页面对象
	//确定
	public AndroidElement button_confirm() {
		return driver.findElementById("com.example.fitnessdemo:id/btn_yesToAdd");
	}
	//返回
	public AndroidElement button_return() {
		return driver.findElementById("com.example.fitnessdemo:id/btn_finish");
	}
	//肩部环绕计划
	public AndroidElement list_plan1() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout");
	//	return driver.findElementsByClassName("android.widget.RelativeLayout").get(0);
	}	
	//输入框
	public AndroidElement input_planName() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.EditText");
	}
	//Yes
	public AndroidElement button_yes() {
		return driver.findElementById("android:id/button1");
	}
	//BACK
	public AndroidElement button_back() {
		return driver.findElementById("android:id/button2");
	}
//	页面操作方法
	//点击按钮
	public void click(String target) {
		switch (target) {
		case "确定":
			action.click(button_confirm());
			break;
		case "返回":
			action.click(button_return());
			break;
		case "肩部环绕":
			action.click(list_plan1());
			break;
		case "YES":
			action.click(button_yes());
			break;
		case "BACK":
			action.click(button_back());
			break;
		default:
			break;
		}
	}
	//制作个人计划返回
	public void plan_make_return() throws InterruptedException {
		l.login("17732053746","123456");
		Thread.sleep(500);
		m.turn_success("制作计划");
		Thread.sleep(500);
		click("返回");
	}
	//制作个人计划
	public void plan_make() throws InterruptedException {
		m.turn_success("制作计划");
		Thread.sleep(500);
		click("肩部环绕");
	}
	//输入计划返回
	public void plan_input_back(String planName) throws InterruptedException {
		click("确定");
		action.type(input_planName(), planName);
		Thread.sleep(500);
		click("BACK");
		Thread.sleep(500);
	}
	//输入计划返回
	public void plan_input_yes(String planName) throws InterruptedException {
		click("确定");
		action.type(input_planName(), planName);
		Thread.sleep(500);
		click("YES");
	}
}
