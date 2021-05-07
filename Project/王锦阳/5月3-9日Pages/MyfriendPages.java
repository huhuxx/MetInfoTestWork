package com.sport.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class MyfriendPages {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
//	构造方法
	public  MyfriendPages(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		action=new BaseAction(driver);
		
	}
//	页面对象
	//搜索
	public AndroidElement search() {
		return driver.findElementById("com.example.fitnessdemo:id/iv_friend");
	}
	//搜索好友界面名称  com.example.fitnessdemo/.ws.SearchActivity
	//
	
//	页面操作方法
	//跳转到搜索界面
	public SearchfriendPages turn_to_search() {
		action.click(search());
		return new SearchfriendPages(driver);
	}
	
}
