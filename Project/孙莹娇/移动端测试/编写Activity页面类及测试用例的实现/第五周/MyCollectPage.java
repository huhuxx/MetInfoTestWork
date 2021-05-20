package com.sport.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class MyCollectPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction baseAction;
	public MyCollectPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		baseAction=new BaseAction(driver);
	}
	public AndroidElement addCollect_btn() {
		return driver.findElementById("com.example.fitnessdemo:id/tianjia");
	}
	/**
	 * 
	 * @param index
	 * @return 第index个课程
	 */
	public AndroidElement oneCourse(int index) {
		return driver.findElementByXPath("//android.widget.ImageView["+index+"]");
	}
	/**
	 * 
	 * @param index
	 * 点击 第index个课程view
	 */
	public void clickOneCourse(int index) {
		baseAction.click(oneCourse(index));
	}
	/**
	 * 点击+
	 */
	public void clickAdd_btn() {
		baseAction.click(addCollect_btn());
	}
}
