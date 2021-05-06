package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class LoginPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	public  LoginPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		action=new BaseAction(driver);
		
	}
	public AndroidElement edit_username() {
		return driver.findElementById("com.example.todolist:id/nameET");
	}
	public AndroidElement edit_password() {
		return driver.findElementById("com.example.todolist:id/passwordET");
	}
	public AndroidElement btn_login() {
		return driver.findElementById("com.example.todolist:id/loginBtn");
	}
	public MainPages login_sucess(String username,String password) {
		action.type(edit_username(), username);
		action.type(edit_password(), password);
		action.click(btn_login());
		return new MainPages(driver);
	
	}
	
	public String login_fail(String username,String password) {
		action.type(edit_username(), username);
		action.type(edit_password(), password);
		action.click(btn_login());
		return action.getToast();
	
	}
}
