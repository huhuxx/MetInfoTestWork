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
		//��Ʒչʾ������
		return driver.findElement(By.xpath("//span[@met-id='4']"));	
	}
	public WebElement get_set() {
		//����������
		return driver.findElements(By.xpath("//button[@class='btn btn-xs btn-primary pageset-block-config']")).get(5);
	}
	public WebElement get_range_1() {
		//������ΧΪ��ǰ��Ŀ
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']")).get(0);
	}
	public WebElement get_range_2() {
		//������ΧΪ��ǰ����һ����Ŀ
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']")).get(1);
	}
	public WebElement get_style_all() {
		//������ʽΪȫ��
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']")).get(2);
	}
	public WebElement get_style_title() {
		//������ʽΪ����
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']")).get(3);
	}
	public WebElement get_style_content() {
		//������ʽΪ����
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']")).get(4);
	}
	public WebElement get_style_tc() {
		//������ʽΪ���������
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']")).get(5);
	}
	public WebElement get_input_text() {
		//�޸�Ĭ�������
		return driver.findElement(By.xpath("//input[@value='�����������Ȥ�Ĺؼ��ʣ�']"));
	}
	public WebElement get_input_text2() {
		return driver.findElement(By.xpath("//input[@name='search_placeholder']"));
		
	}
	public WebElement get_save() {
		//���水ť
		return driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
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
	public void save() {
		//�������
		get_save().click();
	}
	public void set_range_1() throws InterruptedException {
		//����������ΧΪ��ǰ��Ŀ
		intoProductShow();
		get_range_1().click();
		Thread.sleep(1000);
//		mainPage();
	}
	public void set_range_2() throws InterruptedException {
		//����������ΧΪ��ǰ����һ����Ŀ
		intoProductShow();
		get_range_2().click();
		Thread.sleep(1000);
//		mainPage();
	}
	public void set_style_all() throws InterruptedException {
		//����������ʽΪȫ��
		intoProductShow();
		get_style_all().click();
		Thread.sleep(1000);
//		mainPage();
	}
	public void set_style_title() throws InterruptedException {
		//����������ʽΪ����
		intoProductShow();
		get_style_title().click();
		Thread.sleep(1000);
//		mainPage();
	}
	public void set_style_content() throws InterruptedException {
		//����������ʽΪ����
		intoProductShow();
		get_style_content().click();
		Thread.sleep(1000);
//		mainPage();
	}
	public void set_style_tc() throws InterruptedException {
		//����������ʽΪ���������
		intoProductShow();
		get_style_tc().click();
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
//		mainPage();
	}
	public void set_content_text() throws InterruptedException {
		//����������Ĭ������Ϊ����
		intoProductShow();
		get_input_text().clear();
		Thread.sleep(1000);
		get_input_text2().sendKeys("������");
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
//		mainPage();
	}
	public void set_content_number() throws InterruptedException {
		//����������Ĭ������Ϊ����
		intoProductShow();
		get_input_text().clear();
		Thread.sleep(1000);
		get_input_text2().sendKeys("123");
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
//		mainPage();
	}
	public void set_content_symbol() throws InterruptedException {
		//����������Ĭ������Ϊ����
		intoProductShow();
		get_input_text().clear();
		Thread.sleep(1000);
		get_input_text2().sendKeys("��������������");
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
//		mainPage();
	}
	public void set_content_all() throws InterruptedException {
		//����������Ĭ������Ϊ�����ַ���
		intoProductShow();
		get_input_text().clear();
		Thread.sleep(1000);
		get_input_text2().sendKeys("������1���ؼ��ʣ�");
		Thread.sleep(1000);
		save();
		
		Thread.sleep(1000);
//		mainPage();
	}
}
