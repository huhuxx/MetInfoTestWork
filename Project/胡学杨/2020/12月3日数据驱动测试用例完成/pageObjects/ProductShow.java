package com.hxy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hxy.util.BaseTest;

public class ProductShow extends BaseTest{
	WebDriver driver;
	WebElement webElement;
	public ProductShow(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver driver() {
		return driver;
	}
	public WebElement get_title() {
		//产品展示导航栏
		return driver.findElement(By.xpath("//span[@met-id='4']"));	
	}
	public WebElement get_set() {
		//大标题设置
		return driver.findElements(By.xpath("//button[@class='btn btn-xs btn-primary pageset-block-config']")).get(3);
	}
	public WebElement get_content() {
		//大标题内容
		return driver.findElements(By.xpath("//button[@class='btn btn-xs btn-warning pageset-content']")).get(3);
	}
	public WebElement get_setbackrground_color() {
		//设置标题背景色	
		return driver.findElement(By.xpath("//input[@name='36_metinfo']"));
//		return driver.findElement(By.xpath("//input[@value='#1baadb']"));
	}
	public WebElement get_settext_color() {
		//设置标题颜色
		return driver.findElement(By.xpath("//input[@name='37_metinfo']"));
//		return driver.findElement(By.xpath("//input[@value='#ffffff']"));
	}
	public WebElement get_settext_distance() {
		//设置标题电脑端按钮之间的边距
		return driver.findElement(By.xpath("//input[@name='38_metinfo']"));
	}
	public WebElement get_save() {
		//保存按钮
		return driver.findElement(By.xpath("//button[@data-ok='']"));
	}
	public void save() {
		//保存操作
		get_save().click();
	}
	public void mainPage() throws InterruptedException {
		//回到主页
		driver.get("http://localhost:99/admin/?lang=cn&n=ui_set");
		Thread.sleep(1000);
	}
	public void intoProductShow() throws InterruptedException {
		//进入设置
		driver.switchTo().frame(0);
		get_title().click();
		Thread.sleep(2000);
		get_set().click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
	}
	public void set_background_color() throws InterruptedException {
		//背景色设置
		intoProductShow();
		get_setbackrground_color().clear();
		Thread.sleep(1000);
		get_setbackrground_color().sendKeys("#1baadb");
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
	}
	public void set_background_color_data(String color) throws InterruptedException {
		//背景色设置-数据驱动
		intoProductShow();
		get_setbackrground_color().clear();
		Thread.sleep(1000);
		get_setbackrground_color().sendKeys(color);
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
	}
	public void set_text_color() throws InterruptedException {
		//标题颜色设置
		intoProductShow();
		get_settext_color().clear();
		Thread.sleep(1000);
		get_settext_color().sendKeys("#ffffff");
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
	}
	public void set_text_color_data(String color) throws InterruptedException {
		//标题颜色设置-数据驱动
		intoProductShow();
		get_settext_color().clear();
		Thread.sleep(1000);
		get_settext_color().sendKeys(color);
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
	}
	public void set_text_distance() throws InterruptedException {
		//边距设置
		intoProductShow();
		Thread.sleep(1000);
		get_settext_distance().clear();
		Thread.sleep(1000);
		get_settext_distance().sendKeys("5");
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
//		mainPage();
	}
}
