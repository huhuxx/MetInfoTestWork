package com.sport.pages;

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
		return driver.findElementByXPath("//*[@text='我的']");
	}
	//推荐
	public AndroidElement recommend_button() {
		return driver.findElementByXPath("//*[@text='推荐']");
	}
	//课程
	public AndroidElement course_button() {
		return driver.findElementByXPath("//*[@text='课程']");
	}
	//首页
	public AndroidElement home_button() {
		return driver.findElementByXPath("//*[@text='首页']");
	}
	//设置闹钟
	public AndroidElement clock_setting() {
		return driver.findElementById("com.example.fitnessdemo:id/btn_setClock");
	}
	//闹钟开关
	public AndroidElement clock_switch() {
		return driver.findElementById("com.example.fitnessdemo:id/btn_enClk");
	}
	//秒表（Running）
	public AndroidElement running() {
		return driver.findElementById("com.example.fitnessdemo:id/clb_tv_begin_run");
	}
	//健身百科
	public AndroidElement encyclopedia() {
		return driver.findElementById("com.example.fitnessdemo:id/ll_clock_1");
	}
	//计划
	public AndroidElement plan() {
		return driver.findElementById("com.example.fitnessdemo:id/ll_clock_3");
	}
	//推荐计划
	public AndroidElement recommend_plan() {
		return driver.findElementById("com.example.fitnessdemo:id/ll_clock_2");
	}
	//制作计划
	public AndroidElement make_myplan() {
		return driver.findElementById("com.example.fitnessdemo:id/btn_action");
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
		case "闹钟":
			action.click(clock_setting());
			break;
		case "开关":
			action.click(clock_switch());
			break;
		case "健身百科":
			action.click(encyclopedia());
			break;
		case "计划":
			action.click(plan());
			break;
		case "推荐计划":
			action.click(recommend_plan());
			break;
		case "制作计划":
			action.click(make_myplan());
			break;
		case "秒表":
			action.click(running());
			break;
		default:
			break;
		}
	}
	
}
