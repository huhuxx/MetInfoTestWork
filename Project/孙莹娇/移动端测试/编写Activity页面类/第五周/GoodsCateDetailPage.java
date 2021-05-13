package com.sport.pages;

import com.sport.base.BaseTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class GoodsCateDetailPage extends BaseTest{
	AndroidDriver<AndroidElement> driver;
	BaseAction baseAction;
	
	public GoodsCateDetailPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		baseAction = new BaseAction(driver);
	}
	/**
	 * 
	 * @param index
	 * @return 返回第index个列表类别的元素
	 */
	public AndroidElement oneCategory(int index) {
		return driver.findElementsById("com.example.fitnessdemo:id/txt_category_list").get(index);
	}
	/**
	 * 
	 * @param index
	 * @return 返回第index个商品元素
	 */
	public AndroidElement oneGoods(int index) {
		return driver.findElementsById("com.example.fitnessdemo:id/img_category_gridview").get(index);
	}
	
	
	/**
	 * 点击第index个列表类别
	 * @param index
	 */
	public void clickOneCategory(int index) {
		baseAction.click(oneCategory(index));
	}
	/**
	 * 点击第index个商品
	 * @param index
	 */
	public void clickOneGoods(int index) {
		baseAction.click(oneGoods(index));
	}
}
