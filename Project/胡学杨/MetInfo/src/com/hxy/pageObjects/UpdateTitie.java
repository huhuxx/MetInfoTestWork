package com.hxy.pageObjects;

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
		return driver.findElement(By.xpath("//span[text()='产品展示']"));
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
	}
}
