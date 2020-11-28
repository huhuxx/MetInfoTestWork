package com.hxy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ColumnManage {
	WebDriver driver;
	WebElement webElement;
	public ColumnManage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver driver() {
		return driver;
	}
	public WebElement get_row() {
		//
		return driver.findElement(By.className("row"));
	}
	public WebElement get_content() {
		//内容
		return driver.findElement(By.xpath("//button[@class='btn btn-xs btn-warning pageset-content']"));
	}
	public WebElement get_productshow() {
		//产品展示
		return driver.findElement(By.xpath("//input[@value='产品展示']"));
	}
	public Select get_setdisplay() {
		//产品展示导航栏显示
		webElement = driver.findElement(By.xpath("//select[@name='nav-4']"));
		Select select = new Select(webElement);
		return select;
	}
	public String get_setdisplay_no() {
		//不显示
		return "0";
	}
	public String get_setdisplay_head() {
		//头部主导航栏显示
		return "1";
	}
	public String get_setdisplay_tail() {
		//尾部导航栏显示
		return "2";
	}
	public String get_setdisplay_all() {
		//都显示
		return "3";
	}
	public WebElement get_more() {
		//"产品展示"更多
		return driver.findElements(By.xpath("//button[@class='btn btn-sm btn-default dropdown-toggle']")).get(1);
	}
	public WebElement get_add() {
		//"产品展示"更多-添加子栏目
		return driver.findElement(By.xpath("//div[@class='dropdown-menu dropdown-menu-right show']//a"));
	}
	public WebElement get_add_num() {
		//"产品展示"更多-添加子栏目-排序框
		return driver.findElements(By.xpath("//div[@class='form-group']//input")).get(8);
	}
	public WebElement get_add_name() {
		//"产品展示"更多-添加子栏目-名称框
		return driver.findElements(By.xpath("//div[@class='form-group']//input")).get(9);
	}
	public WebElement get_add_save() {
		//添加页面保存
		return driver.findElement(By.xpath("//div[@class='modal-footer clearfix d-block']"));
	}
	public WebElement get_save() {	
		//保存
		return driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
	}
	public void save() {
		//保存
		get_save().click();
	}
	
	public void intoContent() throws InterruptedException {
		//进入内容
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);	
		action.moveToElement(get_row()).perform();
		Thread.sleep(1000);
		get_content().click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
	}
	
	public void updateTitle() throws InterruptedException {
		//内容页面修改标题
		intoContent();
		get_productshow().clear();
		Thread.sleep(1000);
		get_productshow().sendKeys("产品展示");
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
	}
	
	public void setDisplay_no() throws InterruptedException {
		//内容页面“产品展示”导航栏显示设置为不显示
		intoContent();
		get_setdisplay().selectByValue("0");
		save();
		Thread.sleep(1000);
	}
	public void setDisplay_head() throws InterruptedException {
		//内容页面“产品展示”导航栏显示设置为头部导航栏显示
		intoContent();
		get_setdisplay().selectByValue("1");
		save();
		Thread.sleep(1000);
	}
	public void setDisplay_tail() throws InterruptedException {
		//内容页面“产品展示”导航栏显示设置为尾部导航栏显示
		intoContent();
		get_setdisplay().selectByValue("2");
		save();
		Thread.sleep(1000);
	}
	public void setDisplay_all() throws InterruptedException {
		//内容页面“产品展示”导航栏显示设置为全显示
		intoContent();
		get_setdisplay().selectByValue("3");
		save();
		Thread.sleep(1000);
	}
	public void addColumn() throws InterruptedException {
		//"产品展示"添加子栏目
		intoContent();
		get_more().click();
		Thread.sleep(1000);
		get_add().click();
		Thread.sleep(1000);
		get_add_name().sendKeys("dell笔记本电脑");
		Thread.sleep(1000);
		get_add_save().click();
		Thread.sleep(1000);
	}
}