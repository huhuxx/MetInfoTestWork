package com.bxx.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class LoginPage {

	private String name = "name";
	private String pwd = "pwd";
	private String forLogin = "inputbutton";

	public void login(WebDriver driver, String username, String password) throws Exception {
		driver.findElement(By.name(name)).sendKeys(username);
		driver.findElement(By.name(pwd)).sendKeys(password);
// 点击登录
		driver.findElement(By.id(forLogin)).click();
		Thread.sleep(2000);
// System.out.println(driver.getCurrentUrl());
	}
	public boolean isLoginSuccess(WebDriver driver) throws Exception {
		boolean flag = false;
		try {
			if (driver.findElement(By.id("asset")).isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
// e.printStackTrace();
// System.out.println(e);
		}
		return flag;
	}

	public boolean loginStatus(WebDriver driver) throws Exception {
		if (isAlertPresent(driver)) {
			Reporter.log(driver.switchTo().alert().getText());
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			driver.navigate().refresh();
			return false;
		}
		else if (!(isLoginSuccess(driver))) {
			Reporter.log("用户名错误！");
			System.out.println("用户名错误！");
			driver.navigate().refresh();
			Thread.sleep(2000);
			return false;
		}
		else {
			Reporter.log("登录成功！");
			System.out.println("登录成功！");
			return true;
		}
	}

	public boolean isAlertPresent(WebDriver driver) throws Exception {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
// e.printStackTrace();
			return false;
		}
	}
	public boolean isLoginPage(WebDriver driver) throws Exception {
		boolean flag = false;
		try {
			if (driver.findElement(By.id(forLogin)).getAttribute("value").equals("登录")) {
				flag = true;
				return flag;
			}

		} catch (Exception e) {
//     System.out.println(e);
			return flag;
		}
		return flag;
	}
}