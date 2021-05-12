package com.sport.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import utils.BaseAction;

public class PlanPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
//	构造方法
	public  PlanPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		action=new BaseAction(driver);
	}
	public void drag(AndroidElement from, AndroidElement to) {
		// 长按，拖动
		AndroidTouchAction action = new AndroidTouchAction(driver);

		LongPressOptions longOptions = LongPressOptions.longPressOptions();
		longOptions.withElement(ElementOption.element(from));

		action.longPress(longOptions).moveTo(ElementOption.element(to)).release().perform();
	}
//	页面对象
	//增肌
	public AndroidElement list_add() {
		return driver.findElementById("增肌");
	}
	//减脂
	public AndroidElement list_reduce() {
		return driver.findElementById("减脂");
	}
	//塑身
	public AndroidElement list_body() {
		return driver.findElementById("塑身");
	}	
	//健康
	public AndroidElement list_healthy() {
		return driver.findElementById("健康");
	}
	//计划
	public AndroidElement list_plan1() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.ImageView");
	}
//	页面操作方法
	//点击按钮
	public void click(String target) {
		switch (target) {
		case "增肌":
			action.click(list_add());
			break;
		case "减脂":
			action.click(list_reduce());
			break;
		case "塑身":
			action.click(list_body());
			break;
		case "健康":
			action.click(list_healthy());
			break;
		case "一周两练增肌计划":
			action.click(list_plan1());
			break;
		default:
			break;
		}
	}
}
