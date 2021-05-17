package com.sport.pages;

import java.util.List;

import org.openqa.selenium.interactions.ClickAction;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class AllCoursePage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
//	构造方法
	public AllCoursePage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		this.action=new BaseAction(driver);
		}
/*
 * 搜索+全部课程
 * 页面对象
 * 
 * */
	//所有放大镜的id
	public AndroidElement action_courseSearch() {
		return driver.findElementById("com.example.fitnessdemo:id/sousuo");
	}
	//全部课程
	public AndroidElement action_allCourse() {
		return driver.findElementById("com.example.fitnessdemo:id/quanbu");
	}
	//全部课程_全部
	public AndroidElement action_allcourseAll() {
		return driver.findElementById("com.example.fitnessdemo:id/quanbu");
	}
	//全部课程_健身
	public AndroidElement action_bodybuilding() {
		return driver.findElementByXPath("//*[@text='健身']");
	}
	//全部课程_搏击
	public AndroidElement action_fight() {
		return driver.findElementByXPath("//*[@text='搏击']");
	}
	//全部课程_跑步
	public AndroidElement action_run() {
		return driver.findElementByXPath("//*[@text='跑步']");
	}
	//全部课程_瑜伽
	public AndroidElement action_yoga() {
		return driver.findElementByXPath("//*[@text='瑜伽']");
	}
	//全部课程_拉伸
	public AndroidElement action_stretch() {
		return driver.findElementByXPath("//*[@text='拉伸']");
	}
	//全部课程_操课
		public AndroidElement action_exerciseClass() {
			return driver.findElementByXPath("//*[@text='拉伸']");
		}
	//“返回”id
	public AndroidElement action_collectReturn() { 
		return driver.findElementById("com.example.fitnessdemo:id/fanhui"); 
	}
	
	
	
	
//	页面操作方法
	
	//点击“课程”，点击”全部课程” 
	public void allCourse() {
		action.click(action_allCourse()); 
	}
	//点击放大镜
	public void allCourse_search(){
		action.click(action_courseSearch());
	}
	//点击“返回”
	public void back(){
		action.click(action_collectReturn());
	}
	
	
	public void turn_success(String target) {
		
		switch (target) {
		case "全部":
			action.click(action_allcourseAll());
			break;
		case "健身":
			action.click(action_bodybuilding());
			break;
		case "搏击":
			action.click(action_fight());
			break;
		case "跑步":
			action.click(action_run());
			break;
		case "瑜伽":
			action.click(action_yoga());
			break;
		case "拉伸":
			action.click(action_stretch());
			break;	
		case "操课":
			action.click(action_exerciseClass());
			break;	
		default:
			break;
		}
	}
	
}
