package com.hxy.assertion;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateTitle_Assert {
	WebDriver driver;
	public UpdateTitle_Assert(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement get_title_text() {
		return driver.findElement(By.xpath("//span[text()='产品展示']"));
	}
	public WebElement get_title_number() {
		return driver.findElement(By.xpath("//span[text()='2018011681']"));
	}
	public WebElement get_title_symbol() {
		return driver.findElement(By.xpath("//span[text()='++--']"));
	}
	public WebElement get_title_all() {
		return driver.findElement(By.xpath("//span[text()='1+产品展示']"));
	}
	public void UpdateTitle_text_Assert() {
		assertEquals(get_title_text(), get_title_text());
	}
	public void UpdateTitle_number_Assert() {
		assertEquals(get_title_number(), get_title_number());
	}
	public void UpdateTitle_symbol_Assert() {
		assertEquals(get_title_symbol(), get_title_symbol());
	}
	public void UpdateTitle_all_Assert() {
		assertEquals(get_title_all(), get_title_all());
	}
}
