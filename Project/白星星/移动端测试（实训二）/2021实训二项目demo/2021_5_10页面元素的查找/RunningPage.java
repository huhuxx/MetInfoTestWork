package com.sport.pages;

import java.sql.Time;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class RunningPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;

	public RunningPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		action = new BaseAction(driver);

	}

	// 计时暂停按钮
	public AndroidElement btn_pause() {
		return driver.findElementById("com.example.fitnessdemo:id/clb_iv_zanting");
	}

	// 计时继续按钮
	public AndroidElement btn_restart() {
		return driver.findElementById("com.example.fitnessdemo:id/pop_iv_begin");
	}

	// 计时停止按钮
	public AndroidElement btn_stop() {
		return driver.findElementById("com.example.fitnessdemo:id/pop_iv_stop");
	}

	// 计时时间获取
	public String action_text() {
		return driver.findElementById("com.example.fitnessdemo:id/timeText1").getText();
	}

	/**
	 * 方法
	 */

	// 打开、暂停、然后停止计时
	public void openAndPauseAndStop() throws InterruptedException {
		Thread.sleep(3000);
		action.click(btn_pause());
		Thread.sleep(5000);
		action.click(btn_stop());
	}

	// 打开、暂停、然后停止计时
	public String getTime() throws InterruptedException {
		Thread.sleep(6000);
		action.click(btn_pause());
		String time = action_text();
		System.out.println("time--------------------" + time);
		Thread.sleep(5000);
		action.click(btn_stop());
		return time;
	}

	// 打开、暂停、继续然后停止计时
	public void openAndPauseAndRestartAndStop() throws InterruptedException {
		Thread.sleep(3000);
		action.click(btn_pause());
		Thread.sleep(5000);
		action.click(btn_restart());
		Thread.sleep(5000);
		action.click(btn_stop());
	}

}
