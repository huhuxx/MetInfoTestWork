package com.sport.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class RemenCoursePage {
	AndroidDriver<AndroidElement> driver;
	BaseAction baseAction;
	public RemenCoursePage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		baseAction=new BaseAction(driver);
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
	public void clickMoreRemen() {
		baseAction.click(driver.findElementById("com.example.fitnessdemo:id/remenquanbu"));
	}
}
