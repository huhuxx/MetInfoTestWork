package com.sport.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class GoodsDetailPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction baseAction;
	
	public GoodsDetailPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		baseAction = new BaseAction(driver);
	}
	/**
	 * 获取收藏按钮
	 * @return
	 */
	public AndroidElement btnCollect() {
		return driver.findElementById("com.example.fitnessdemo:id/product_shoucang");
	}
	/**
	 * 点击收藏按钮
	 */
	public void click_btnCollect() {
		baseAction.click(btnCollect());
	}
}
