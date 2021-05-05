package com.hxy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hxy.util.BaseTest;

public class EditorialColumn extends BaseTest {
	WebDriver driver;
	WebElement webElement;
	public EditorialColumn(WebDriver driver) {
		this.driver = driver;
	}
	
	public ColumnManage c() {
		ColumnManage c = new ColumnManage(driver);
		return c;
	}
	public WebElement get_set() {
		//设置
		return driver.findElements(By.xpath("//button[@class='btn btn-sm btn-primary mr-1']")).get(1);
	}
	public WebElement get_set_productshow() {
		//产品展示
		return driver.findElement(By.xpath("//input[@name='name']"));
	}
	public WebElement get_set_textsize() {
		//设置文字大小框
		return driver.findElement(By.xpath("//input[@class='form-control d-inline-block mr-2']"));
	}
	public WebElement get_set_textcolor() {
		//设置文字颜色框
		return driver.findElement(By.xpath("//input[@name='text_color']"));
	}
	public WebElement get_set_no() {
		//不显示
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio']//input")).get(0);
	}
	public WebElement get_set_head() {
		//头部主导航栏显示
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio']//input")).get(1);
	}
	public WebElement get_set_tail() {
		//尾部导航栏显示
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio']//input")).get(2);
	}
	public WebElement get_set_all() {
		//全显示
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio']//input")).get(3);
	}

	public WebElement get_set_window_yes() {
		//新窗口打开“是”
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']//input")).get(0);
	}
	public WebElement get_set_window_no() {
		//新窗口打开“否”
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']//input")).get(1);
	}
	public WebElement get_set_sortStyle_updateTime() {
		//更新时间
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio']//input")).get(4);
	}
	public WebElement get_set_sortStyle_releaseTime() {
		//发布时间
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio']//input")).get(5);
	}
	public WebElement get_set_sortStyle_clickNumber() {
		//点击时间
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio']//input")).get(6);
	}
	public WebElement get_set_sortStyle_idDaoxu() {
		//id倒序
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio']//input")).get(7);
	}
	public WebElement get_set_sortStyle_idZheng() {
		//id顺序
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio']//input")).get(8);
	}
	public void intoSet() throws InterruptedException {
		//进入“产品展示”设置
		c().intoContent();
		get_set().click();
		Thread.sleep(2000);
	}
	public WebElement get_set_save() {
		//保存
		return driver.findElement(By.xpath("//button[@data-ok='']"));
	}
	public void save() {
		//设置页面保存操作
		get_set_save().click();
	}
	public void set_updateTitle() throws InterruptedException {
		//设置页面修改标题
		intoSet();
		get_set_productshow().clear();
		Thread.sleep(1000);
		get_set_productshow().sendKeys("产品展示");
		Thread.sleep(1000);
		save();
	}
	public void set_text_size() throws InterruptedException {
		//调整字体大小
		intoSet();
		get_set_textsize().sendKeys("12");
		Thread.sleep(2000);
		get_set_textsize().clear();
		Thread.sleep(2000);	
		save();
	}
	public void set_text_color() throws InterruptedException {
		//调整字体颜色
		intoSet();
		get_set_textcolor().clear();
		Thread.sleep(2000);
		get_set_textcolor().sendKeys("#f21818");
		Thread.sleep(2000);	
		get_set_textcolor().clear();
		Thread.sleep(1000);	
		save();
	}
	public void set_setDisplay_no() throws InterruptedException {
		//设置页面设置导航栏显示为不显示
		intoSet();
		get_set_no().click();
		Thread.sleep(1000);
		save();
	}
	public void set_setDisplay_head() throws InterruptedException {
		//设置页面设置导航栏显示为头部导航栏显示
		intoSet();
		get_set_head().click();
		Thread.sleep(1000);
		save();
	}
	public void set_setDisplay_tail() throws InterruptedException {
		//设置页面设置导航栏显示为尾部导航栏显示
		intoSet();
		get_set_tail().click();
		Thread.sleep(1000);
		save();
	}
	public void set_setDisplay_all() throws InterruptedException {
		//设置页面设置导航栏显示为全部显示
		intoSet();
		get_set_all().click();
		Thread.sleep(1000);
		save();
	}
	public void set_newWindow_yes() throws InterruptedException {
		//设置页面设置新窗口打开为是
		intoSet();
		get_set_window_yes().click();
		Thread.sleep(1000);
//		save();
	}
	public void set_newWindow_no() throws InterruptedException {
		//设置页面设置新窗口打开为否
		intoSet();
		get_set_window_no().click();
		Thread.sleep(1000);
		save();
	}
	public void set_sortStyle_updateTime() throws InterruptedException {
		//设置页面设置列表页排序方式为更新时间
		intoSet();
		get_set_sortStyle_updateTime().click();
		Thread.sleep(1000);
		save();
	}
	public void set_sortStyle_releaseTime() throws InterruptedException {
		//设置页面设置列表页排序方式为发布时间
		intoSet();
		get_set_sortStyle_releaseTime().click();
		Thread.sleep(1000);
		save();
	}
	public void set_sortStyle_clickNumber() throws InterruptedException {
		//设置页面设置列表页排序方式为点击次数
		intoSet();
		get_set_sortStyle_clickNumber().click();
		Thread.sleep(1000);
		save();
	}
	public void set_sortStyle_daoxu() throws InterruptedException {
		//设置页面设置列表页排序方式为更新时间
		intoSet();
		get_set_sortStyle_idDaoxu();
		Thread.sleep(1000);
		save();
	}
	public void set_sortStyle_zhengxu() throws InterruptedException {
		//设置页面设置列表页排序方式为更新时间
		intoSet();
		get_set_sortStyle_idZheng();
		Thread.sleep(1000);
		save();
	}
}
