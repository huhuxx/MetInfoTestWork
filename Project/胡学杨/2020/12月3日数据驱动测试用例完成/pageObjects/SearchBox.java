package com.hxy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hxy.util.BaseTest;

public class SearchBox extends BaseTest {
	WebDriver driver;
	WebElement webElement;
	
	public SearchBox(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement get_title() {
		//产品展示导航栏
		return driver.findElement(By.xpath("//span[@met-id='4']"));	
	}
	public WebElement get_set() {
		//搜索框设置
		return driver.findElements(By.xpath("//button[@class='btn btn-xs btn-primary pageset-block-config']")).get(5);
	}
	public WebElement get_range_1() {
		//搜索范围为当前栏目
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']")).get(0);
	}
	public WebElement get_range_2() {
		//搜索范围为当前所属一级栏目
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']")).get(1);
	}
	public WebElement get_style_all() {
		//搜索方式为全部
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']")).get(2);
	}
	public WebElement get_style_title() {
		//搜索方式为标题
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']")).get(3);
	}
	public WebElement get_style_content() {
		//搜索方式为内容
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']")).get(4);
	}
	public WebElement get_style_tc() {
		//搜索方式为标题和内容
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']")).get(5);
	}
	public WebElement get_input_text() {
		//修改默认输入框
		return driver.findElement(By.xpath("//input[@name='search_placeholder']"));
//		return driver.findElement(By.xpath("//input[@value='请输入你感兴趣的关键词；']"));
	}
	public WebElement get_save() {
		//保存按钮
		return driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
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
	public void save() {
		//保存操作
		get_save().click();
	}
	public void set_range_1() throws InterruptedException {
		//设置搜索范围为当前栏目
		intoProductShow();
		get_range_1().click();
		Thread.sleep(1000);;
	}
	public void set_range_2() throws InterruptedException {
		//设置搜索范围为当前所属一级栏目
		intoProductShow();
		get_range_2().click();
		Thread.sleep(1000);
	}
	public void set_style_all() throws InterruptedException {
		//设置搜索方式为全部
		intoProductShow();
		get_style_all().click();
		Thread.sleep(1000);
	}
	public void set_style_title() throws InterruptedException {
		//设置搜索方式为标题
		intoProductShow();
		get_style_title().click();
		Thread.sleep(1000);
	}
	public void set_style_content() throws InterruptedException {
		//设置搜索方式为内容
		intoProductShow();
		get_style_content().click();
		Thread.sleep(1000);
	}
	public void set_style_tc() throws InterruptedException {
		//设置搜索方式为标题和内容
		intoProductShow();
		get_style_tc().click();
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
	}
	public void set_content_text() throws InterruptedException {
		//设置搜索框默认内容为文字
		intoProductShow();
		get_input_text().clear();
		Thread.sleep(1000);
		get_input_text().sendKeys("请输入");
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
	}
	public void set_content_number() throws InterruptedException {
		//设置搜索框默认内容为数字
		intoProductShow();
		get_input_text().clear();
		Thread.sleep(1000);
		get_input_text().sendKeys("123");
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
	}
	public void set_content_symbol() throws InterruptedException {
		//设置搜索框默认内容为符号
		intoProductShow();
		get_input_text().clear();
		Thread.sleep(1000);
		get_input_text().sendKeys("；；；；；；；");
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
	}
	public void set_content_all() throws InterruptedException {
		//设置搜索框默认内容为复杂字符串
		intoProductShow();
		get_input_text().clear();
		Thread.sleep(1000);
		get_input_text().sendKeys("请输入1个关键词；");
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
	}
	public void set_content_data(String text) throws InterruptedException {
		//设置搜索框默认内容为文字
		intoProductShow();
		get_input_text().clear();
		Thread.sleep(1000);
		get_input_text().sendKeys(text);
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
	}
}
