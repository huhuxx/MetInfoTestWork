package com.sport.pages;

import java.util.List;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class NotesListPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	public NotesListPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		this.action=new BaseAction(driver);
	}
//	页面对象
	
	//添加按钮
	public AndroidElement action_add() {
		return driver.findElementById("com.example.android.notepad:id/menu_add");
	}
	//文本框
	public AndroidElement action_edittext() {
		return driver.findElementById("com.example.android.notepad:id/note");
	}
	//保存按钮
	public AndroidElement action_save() {
		return driver.findElementById("com.example.android.notepad:id/menu_save");
	}
	//text
	public AndroidElement action_text() {
		return driver.findElementById("android:id/text1");
	}
	//delete
	public AndroidElement action_delete() {
		return driver.findElementByXPath("//*[@text='Delete']");
	}
	//copy
	public AndroidElement action_copy() {
		return driver.findElementByXPath("//*[@text='Copy']");
	}
	//更多选项
	public AndroidElement action_more() {
		return driver.findElementByAccessibilityId("更多选项");
	}
	//paste
	public AndroidElement action_paste() {
		return driver.findElementByXPath("//*[@text='Paste']");
	}
	//edit
	public AndroidElement action_edit() {
		return driver.findElementByXPath("//*[@text='Edit title']");
	}
	//title
	public AndroidElement action_title() {
		return driver.findElementById("com.example.android.notepad:id/title");
	}
	//ok
	public AndroidElement action_ok() {
		return driver.findElementById("com.example.android.notepad:id/ok");
	}
	
	
//	页面操作方法
	//添加一条记录
	public void add_note(String message) throws InterruptedException{
		Thread.sleep(2000);
		action.click(action_add());
		Thread.sleep(1000);
		action.type(action_edittext(), message);
		Thread.sleep(1000);
		action.click(action_save());
		Thread.sleep(1000);
	}
	
	//删除所有记录
	public void delete_note() throws InterruptedException{
		Thread.sleep(1000);
		AndroidElement listView=driver.findElementById("android:id/list");
		List<MobileElement> list_view=listView.findElementsByClassName("android.widget.TextView");
		int count=list_view.size();
		while(count>0) {
			count--;
			action.longPress(action_text());
			Thread.sleep(1000);
			action.click(action_delete());
			Thread.sleep(1000);
		}
	}
	
	//复制粘贴
	public void copy_note() throws InterruptedException {
		Thread.sleep(1000);
		action.longPress(action_text());
		action.click(action_copy());
		Thread.sleep(1000);
		action.click(action_more());
		Thread.sleep(1000);
		action.click(action_paste());
		Thread.sleep(1000);
		action.click(action_save());
		Thread.sleep(1000);
	}
	//更新
	public void update_note(String message) throws InterruptedException {
		Thread.sleep(1000);
		action.longPress(action_text());
		action.click(action_edit());
		Thread.sleep(1000);
		action.type(action_title(), message);
		Thread.sleep(1000);
		action.click(action_ok());
	}
	
	
	
}
