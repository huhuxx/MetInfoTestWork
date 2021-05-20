package com.sport.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class MoreCoursePage {
	AndroidDriver<AndroidElement> driver;
	BaseAction baseAction;
	public MoreCoursePage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		baseAction=new BaseAction(driver);
	}
	/**
	 * 点击“更多热门课程”
	 */
	public void clickMoreRemen() {
		baseAction.click(driver.findElementById("com.example.fitnessdemo:id/remenquanbu"));
	}
	/**
	 * 点击“更多最新课程”
	 */
	public void clickMoreNewest() {
		baseAction.click(driver.findElementById("com.example.fitnessdemo:id/zuixinquanbu"));
	}
	/**
	 * 
	 * @param index
	 * @return 第index个课程的view
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
	
}
