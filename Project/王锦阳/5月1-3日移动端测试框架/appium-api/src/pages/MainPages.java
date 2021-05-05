package pages;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class MainPages {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
//	构造方法
	public MainPages(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		this.action=new BaseAction(driver);
		}
	
//	页面对象
	public AndroidElement action_new() {
		return driver.findElementById("com.example.todolist:id/action_new");
	}
	public AndroidElement edit_content() {
		return driver.findElementById("com.example.todolist:id/toDoItemDetailET");
		
	}
	
	public AndroidElement btn_save() {
	 return driver.findElementById("com.example.todolist:id/saveBtn");
	
	}
//	页面操作方法
	
	public void inset_item(String message) {
		action.click(action_new());
		action.type(edit_content(), message);
		action.click(btn_save());
	}
	
	
	public MobileElement get_item_first() {
		AndroidElement listView=driver.findElementById("com.example.todolist:id/todoListView");
		List<MobileElement> list_view=listView.findElementsByClassName("android.widget.RelativeLayout");
		int count=list_view.size();
		if(count>0) {
			return list_view.get(0);
		}
		return null;

	}
	
	public AndroidElement menu_delete() {
		return  driver.findElementByXPath("//*[@text='删除']");
		
	}
	
	public AndroidElement btn_ok() {
		return  driver.findElementById("android:id/button1");
		
	}
	
	public void delete_first() {
		action.longPress(get_item_first());
		action.click(menu_delete());
		action.click(btn_ok());
		
	}
	
}
