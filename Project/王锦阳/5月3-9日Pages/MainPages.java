package com.sport.pages;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class MainPages {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
//	构造方法
	public MainPages(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		this.action=new BaseAction(driver);
		}
	
//	页面对象
	//我的
	public AndroidElement my_button() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.TabHost/android.widget.RelativeLayout/android.widget.TabWidget/android.widget.LinearLayout[4]");
	}
	//推荐
	public AndroidElement recommend_button() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.TabHost/android.widget.RelativeLayout/android.widget.TabWidget/android.widget.LinearLayout[3]");
	}
	//课程
	public AndroidElement course_button() {
		return driver.findElementByXPath("	\r\n" + 
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.TabHost/android.widget.RelativeLayout/android.widget.TabWidget/android.widget.LinearLayout[2]");
	}
	//首页
	public AndroidElement home_button() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.TabHost/android.widget.RelativeLayout/android.widget.TabWidget/android.widget.LinearLayout[1]");
	}
//	页面操作方法
	
	public void turn_success(String target) {
		
		switch (target) {
		case "我的":
			action.click(my_button());
			break;
		case "推荐":
			action.click(recommend_button());
			break;
		case "课程":
			action.click(course_button());
			break;
		case "首页":
			action.click(home_button());
			break;
		default:
			break;
		}
	}
	
}
