package com.hxy.pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class UpdateTitie{
	WebDriver driver;
	public UpdateTitie(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement get_title() {
		return driver.findElement(By.xpath("//span[@met-id='4']"));	
	}
	public WebElement get_title2() {
		return driver.findElement(By.xpath("//span[text()='产品展示']"));
	}
	public WebElement get_text(String text) {
		return driver.findElement(By.xpath("//span[text()='"+text+"']"));
	}
	public WebElement get_edit() {
		return driver.findElement(By.xpath("//i[@class='icon wb-pencil']"));
	}
	public WebElement get_input() {
		return driver.findElement(By.xpath("//input[@class='form-control input-sm']"));
	}
	public WebElement get_save() {
		return driver.findElement(By.xpath("//i[@class='wb-check']"));
	}
	public void mainPage() throws InterruptedException {
		//回到主页
		driver.get("http://localhost:99/admin/?lang=cn&n=ui_set");
		Thread.sleep(1000);
	}
	public void updateTitle_text() throws InterruptedException {
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);	
		action.moveToElement(get_title()).perform();
		Thread.sleep(1000);
		get_edit().click();
		Thread.sleep(1000);
		get_input().clear();
		Thread.sleep(1000);
		get_input().sendKeys("产品展示");
		get_save().click();
		Thread.sleep(1000);
		assertEquals(get_text("产品展示"), get_text("产品展示"));
	}
	public void updateTitle_symbol() throws InterruptedException {
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);	
		action.moveToElement(get_title()).perform();
		Thread.sleep(1000);
		get_edit().click();
		Thread.sleep(1000);
		get_input().clear();
		Thread.sleep(1000);
		get_input().sendKeys("++--");
		get_save().click();
		Thread.sleep(1000);
		assertEquals(get_text("++--"), get_text("++--"));
	}
	public void updateTitle_number() throws InterruptedException {
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);	
		action.moveToElement(get_title()).perform();
		Thread.sleep(1000);
		get_edit().click();
		Thread.sleep(1000);
		get_input().clear();
		Thread.sleep(1000);
		get_input().sendKeys("2018011681");
		get_save().click();
		Thread.sleep(1000);
		assertEquals(get_text("2018011681"), get_text("2018011681"));
	}
	public void updateTitle_all() throws InterruptedException {
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);	
		action.moveToElement(get_title()).perform();
		Thread.sleep(1000);
		get_edit().click();
		Thread.sleep(1000);
		get_input().clear();
		Thread.sleep(1000);
		get_input().sendKeys("1+产品展示");
		get_save().click();
		Thread.sleep(1000);
		assertEquals(get_text("1+产品展示"), get_text("1+产品展示"));
	}
	public void updateTitle_data(String text) throws InterruptedException {
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);	
		action.moveToElement(get_title()).perform();
		Thread.sleep(1000);
		get_edit().click();
		Thread.sleep(1000);
		get_input().clear();
		Thread.sleep(1000);
		get_input().sendKeys(text);
		get_save().click();
		Thread.sleep(1000);
//		assertEquals(get_text("1+产品展示"), get_text("1+产品展示"));
	}
}
