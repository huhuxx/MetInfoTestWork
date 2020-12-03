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
		//��Ʒչʾ������
		return driver.findElement(By.xpath("//span[@met-id='4']"));	
	}
	public WebElement get_set() {
		//���������
		return driver.findElements(By.xpath("//button[@class='btn btn-xs btn-primary pageset-block-config']")).get(3);
	}
	public WebElement get_content() {
		//���������
		return driver.findElements(By.xpath("//button[@class='btn btn-xs btn-warning pageset-content']")).get(3);
	}
	public WebElement get_setbackrground_color() {
		//���ñ��ⱳ��ɫ
		return driver.findElement(By.xpath("//input[@value='#1baadb']"));
	}
	public WebElement get_settext_color() {
		//���ñ�����ɫ
		return driver.findElement(By.xpath("//input[@value='#ffffff']"));
	}
	public WebElement get_settext_distance() {
		//���ñ�����Զ˰�ť֮��ı߾�
		return driver.findElement(By.xpath("//input[@name='38_metinfo']"));
	}
	public WebElement get_save() {
		//���水ť
		return driver.findElement(By.xpath("//button[@data-ok='']"));
	}
	public void save() {
		//�������
		get_save().click();
	}
	public void mainPage() throws InterruptedException {
		//�ص���ҳ
		driver.get("http://localhost:99/admin/?lang=cn&n=ui_set");
		Thread.sleep(1000);
	}
	public void intoProductShow() throws InterruptedException {
		//��������
		driver.switchTo().frame(0);
		get_title().click();
		Thread.sleep(2000);
		get_set().click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
	}
	public void set_background_color() throws InterruptedException {
		//����ɫ����
		intoProductShow();
		get_setbackrground_color().clear();
		Thread.sleep(1000);
		get_setbackrground_color().sendKeys("#1baadb");
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
//		mainPage();
	}
	public void set_text_color() throws InterruptedException {
		//������ɫ����
		intoProductShow();
		get_settext_color().clear();
		Thread.sleep(1000);
		get_settext_color().sendKeys("#ffffff");
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
//		mainPage();
	}
	public void set_text_distance() throws InterruptedException {
		//�߾�����
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
