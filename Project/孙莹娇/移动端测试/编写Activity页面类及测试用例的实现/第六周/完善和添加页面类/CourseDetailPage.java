package com.sport.pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class CourseDetailPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction baseAction;
	
	public CourseDetailPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		baseAction = new BaseAction(driver);
	}
	/**
	 * 
	 * @return 返回按钮
	 */
	public AndroidElement backBtn() {
		return driver.findElementById("com.example.fitnessdemo:id/fanhui");
	}

	/**
	 * 
	 * @return: “加入我的收藏”按钮
	 */
	public AndroidElement addCollect_btn() {
		return driver.findElementById("com.example.fitnessdemo:id/btn_collect");
	}
	/**
	 * 
	 * @return “课程简介”按钮
	 */
	public AndroidElement courseBriefIntrodoction_btn() {
		return driver.findElementByXPath("//*[@text='课程简介']");
	}
	/**
	 * 
	 * @return “视频列表”按钮
	 */
	public AndroidElement videoList_btn() {
		return driver.findElementByXPath("//*[@text='视频列表']");
	}
	/**
	 * 
	 * @return “相关计划”按钮
	 */
	public AndroidElement relatedPlans_btn() {
		return driver.findElementByXPath("//*[@text='相关计划']");
	}
	/**
	 * 
	 * @return “相关计划”按钮
	 */
	public boolean cancelCollect_btn() {
		if(driver.findElementByXPath("//*[@text='取消收藏']")!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void clickOneMenu(String target) {
		switch (target) {
		case "课程简介":
			baseAction.click(courseBriefIntrodoction_btn());
			break;
		case "视频列表":
			baseAction.click(videoList_btn());
			break;
		case "相关计划":
			baseAction.click(relatedPlans_btn());
			break;
		default:
			break;
		}
	}
	
	/**
	 * 在课程详情页中 点击返回键
	 */
	public void clickBackBtn() {
		baseAction.click(backBtn());
	}
	/**
	 * 点击“加入我的收藏按钮”
	 */
	public void clickAdd_btn() {
		baseAction.click(addCollect_btn());
	}
}
