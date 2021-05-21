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
	public AndroidElement addCollecting() {
		return driver.findElementById("com.example.fitnessdemo:id/tianjia");
	}
	public AndroidElement courseBtn() {
		return driver.findElementById("//*[@text='¿Î³Ì']");
	}
}
