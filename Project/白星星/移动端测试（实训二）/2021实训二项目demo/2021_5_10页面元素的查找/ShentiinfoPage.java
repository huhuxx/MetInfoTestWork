package com.sport.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class ShentiinfoPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;

	public ShentiinfoPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		action = new BaseAction(driver);
	}

	// 更改体重按钮
	public AndroidElement btn_updateWeight() {
		return driver.findElementById("com.example.fitnessdemo:id/shenti_img2");
	}

	// 更改身高按钮
	public AndroidElement btn_updateHeight() {
		return driver.findElementById("com.example.fitnessdemo:id/shenti_img4");
	}

	// 填写数据
	public AndroidElement action_inputData() {
		return driver.findElementById("com.example.fitnessdemo:id/wsdialog_num");
	}

	// 保存按钮
	public AndroidElement btn_save() {
		return driver.findElementById("com.example.fitnessdemo:id/btn_wsdialog");
	}

	// 取消按钮
	public AndroidElement btn_cancel() {
		return driver.findElementById("com.example.fitnessdemo:id/wsdialog_cancel");
	}


}
