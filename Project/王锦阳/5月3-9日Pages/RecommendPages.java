package com.sport.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class RecommendPages {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
//	构造方法
	public  RecommendPages(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		action=new BaseAction(driver);
		
	}
}
