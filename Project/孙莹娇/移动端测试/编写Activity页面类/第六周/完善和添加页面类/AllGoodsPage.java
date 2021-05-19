package com.sport.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class AllGoodsPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	//	构造方法
	public AllGoodsPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		this.action=new BaseAction(driver);
		}
	/**
	 * 
	 * @param index
	 * @return 第index个商品
	 */
	public AndroidElement oneGood(int index) {
		return driver.findElementsById("com.example.fitnessdemo:id/iv_show").get(index);
	}
	/**
	 * 
	 * @param index
	 * 点击 第index个课程view
	 */
	public void clickOneGood(int index) {
		action.click(oneGood(index));
	}
}
