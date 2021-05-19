package com.sport.pages;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import utils.BaseAction;

public class CoursePages {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;

	public CoursePages(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.action = new BaseAction(driver);
	}

	// 最下侧课程按钮
	public AndroidElement btn_course() {
		return driver.findElementByXPath("//*[@text='课程']");
	}

	// 搜索框
	public AndroidElement btn_find() {
		return driver.findElementById("com.example.fitnessdemo:id/sousuo");
	}

	// 全部课程按钮
	public AndroidElement btn_allCourse() {
		return driver.findElementByXPath("//*[@text='全部课程']");
	}

	// 热门课程更多
	public AndroidElement btn_MoreHotCourse() {
		return driver.findElementById("com.example.fitnessdemo:id/remenquanbu");
	}

	// 最新课程更多
	public AndroidElement btn_MoreNewCourse() {
		return driver.findElementById("com.example.fitnessdemo:id/remenquanbu");
	}

	// 热门课程第一个视频
	public AndroidElement btn_hotCourseVideo() {
		return driver.findElementById("com.example.fitnessdemo:id/picture");
	}

	// 最新课程第一个视频
	public AndroidElement btn_newCourseVideo() {
		return driver.findElementById("com.example.fitnessdemo:id/course_list");
	}
	
	/**
	 * 下面是测试方法
	 * 测试方法中的拖拽函数有问题，待解决
	 */

	
	//拖拽热门课程下的轮播图
	public void dragAndDrop_hotCourse() {
		action.click(btn_course());
		action.click(btn_course());
		//action.VerticalSwip(1, btn_course());
		
	}
	
	//向下滑动，并且拖拽最新课程下的轮播图
	public void dragAndDrop_newCourse() {
		
		action.click(btn_course());
		action.click(btn_course());
		
		//action.dragAndSlide(btn_course());
	}
	/**
	 * 点击任意地方，以代替点击“知道了”
	 */
	public void clickKnow() {
		action.click(driver.findElementByXPath("//*[@text='热门课程']"));
	}
	/**
	 * 点击更多热门课程，进入“热门课程”
	 */
	public void clickRemenCourse() {
		action.click(btn_MoreHotCourse());
	}
	/**
	 * 点击更多最新课程，进入“最新课程”
	 */
	public void clickNewestCourse() {
		action.click(btn_MoreNewCourse());
	}
	/**
	 * 
	 * @param index
	 * @return 第index个课程
	 */
	public AndroidElement oneCourse(int index) {
		return driver.findElementsById("com.example.fitnessdemo:id/picture").get(index);
	}
	/**
	 * 
	 * @param index
	 * 点击 第index个课程view
	 */
	public void clickOneCourse(int index) {
		action.click(oneCourse(index));
	}
}
