package com.sport.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class SearchfriendPages {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
//	构造方法
	public  SearchfriendPages(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		action=new BaseAction(driver);
		
	}
	
//	页面对象
	//搜索框
	public AndroidElement search_edit() {
		return driver.findElementById("com.example.fitnessdemo:id/edit_search");
	}	
	//搜索按钮
	public AndroidElement search_button() {
		return driver.findElementById("com.example.fitnessdemo:id/layout_search");
	}
	
//	页面操作方法
	//搜索好友
	public void searchfriend(String name) {
		action.type(search_edit(), name);
		action.click(search_button());
	}
}
