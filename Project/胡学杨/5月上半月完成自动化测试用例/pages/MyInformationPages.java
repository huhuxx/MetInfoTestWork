package com.sport.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class MyInformationPages {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
//	构造方法
	public  MyInformationPages(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		action=new BaseAction(driver);
	}
	
//	页面对象
	//我的收藏
	public AndroidElement mycollect() {
		return driver.findElementById("com.example.fitnessdemo:id/user_shoucang");
	}
	//我的好友
	public AndroidElement myfrind() {
		return driver.findElementById("com.example.fitnessdemo:id/user_friend");
	}
	//我的计划
	public AndroidElement myplan() {
		return driver.findElementById("com.example.fitnessdemo:id/user_plan");
	}
	//我的商品
	public AndroidElement mycommodity() {
		return driver.findElementById("com.example.fitnessdemo:id/user_help");
	}
	//设置
	public AndroidElement setting() {
		return driver.findElementById("com.example.fitnessdemo:id/myinfo_setting");
	}
	//头像
	public AndroidElement head_portrait() {
		return driver.findElementById("com.example.fitnessdemo:id/myinfo_touxiang");
	}
	//身体数据
	public AndroidElement body_data() {
		return driver.findElementById("com.example.fitnessdemo:id/layout_userinfo");
	}

	
//	页面操作方法
//	我的好友
//	cmp=com.example.fitnessdemo/.ws.FriendActivity
//	我的收藏
//	cmp=com.example.fitnessdemo/.MR.MyLikeCoursesActivity
//	我的计划
//	cmp=com.example.fitnessdemo/.ZFT.UserPlanActivity
//	我的商品
//	cmp=com.example.fitnessdemo/.LZYZYH.activity.AddTuijianActivity
	//跳转界面方法
public void turn_to_target(String target) {
		switch (target) {
		case "我的收藏":
			action.click(mycollect());
			break;
		case "我的好友":
			action.click(myfrind());
			break;
		case "我的计划":
			action.click(myplan());
			break;
		case "我的商品":
			action.click(mycommodity());
			break;
		case "设置":
			action.click(setting());
			break;
		case "身体数据":
			action.click(body_data());
			break;
		case "头像":
			action.click(head_portrait());
			break;
		default:
			break;
		}
	}

}
