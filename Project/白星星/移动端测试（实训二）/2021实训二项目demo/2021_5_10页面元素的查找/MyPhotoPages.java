package com.sport.pages;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class MyPhotoPages {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;

	public MyPhotoPages(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.action = new BaseAction(driver);
	}

	// 相册按钮
	public AndroidElement btn_photo() {
		return driver.findElementById("com.example.fitnessdemo:id/tv_photo");

	}
	// 拍照按钮
	public AndroidElement btn_photograph() {
		return driver.findElementById("com.example.fitnessdemo:id/tv_photograph");
	}
	// 取消按钮
	public AndroidElement btn_cancle() {
		return driver.findElementById("com.example.fitnessdemo:id/tv_cancle");
	}
	// 选择头像图片
	public AndroidElement btn_selectPhoto() {
		return driver.findElementById("com.android.gallery3d:id/gl_root_view");
	}
	// 保存图片
	public AndroidElement btn_selectandsave() {
		return driver.findElementById("android:id/home");
	}
	// 取消选择图片
	public AndroidElement btn_selectandcancel() {
		return driver.findElementById("com.android.gallery3d:id/action_cancel");
	}
	
//	测试方法
	//更换头像（从相册）
	public void updatePortrait() {
		action.click(btn_photo());
		action.click(btn_selectPhoto());
	}

}
