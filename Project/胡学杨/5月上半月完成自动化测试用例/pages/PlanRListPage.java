package com.sport.pages;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import utils.BaseAction;

public class PlanRListPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	LoginPage l;
	MainPages m;
	PlanRPage pr;
//	构造方法
	public  PlanRListPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		action=new BaseAction(driver);
		l = new LoginPage(driver);
		m = new MainPages(driver);
		pr = new PlanRPage(driver);
	}
//	页面对象
	//推荐计划1
	public AndroidElement list_planR1() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView");
	}
	//添加到我的计划
	public AndroidElement button_add() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.TextView");
	}
	//推荐计划2
	public AndroidElement list_planR2() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView");
	}
	//OK
	public AndroidElement button_OK() {
		return driver.findElementById("com.example.fitnessdemo:id/btn_ok");
	}
	//整体
	public AndroidElement body() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout");
	}
	
	//
//	页面操作方法
	//点击按钮
	public void click(String target) {
		switch (target) {
		case "OK":
			action.click(button_OK());
			break;
		case "AddToMyPlan":
			action.click(button_add());
			break;
		case "完美肩背塑型计划":
			action.click(list_planR1());
			break;
		default:
			break;
		}
	}
	//OK按钮
	public void OK() throws InterruptedException {
//		l.login("17732053746", "123456");
//		Thread.sleep(500);
//		m.turn_success("推荐计划");
//		Thread.sleep(500);
//		pr.click("确认");
//		Thread.sleep(500);
		VerticalSwip(0.1);
		Thread.sleep(500);
		click("OK");
		Thread.sleep(500);
	}
	//进入推荐计划
	public String plan_enter() throws InterruptedException {
		l.login("17732053746", "123456");
		Thread.sleep(500);
		m.turn_success("推荐计划");
		Thread.sleep(500);
		pr.click("确认");
		Thread.sleep(500);
		return action.getToast();
	}
	//添加计划
	public String plan_add() throws InterruptedException {
		click("AddToMyPlan");
		return action.getToast();
	}
	//添加计划
	public String plan_addAgain() throws InterruptedException {
		Thread.sleep(2000);
		click("AddToMyPlan");
		return action.getToast();
	}
	
	
	public void VerticalSwip(double i) {
		// 获取屏幕的宽度和高度
		Dimension dimension = driver.manage().window().getSize();
		int height = dimension.getHeight();
		int width = dimension.getWidth();
		int fromx = width / 2;
		int fromy = height / 2;

		int tox = fromx;
		int toy = (int) (height * (i));

		AndroidTouchAction action = new AndroidTouchAction(driver);

		action.press(PointOption.point(fromx, fromy)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(tox, toy)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.release().perform();
	}
}
