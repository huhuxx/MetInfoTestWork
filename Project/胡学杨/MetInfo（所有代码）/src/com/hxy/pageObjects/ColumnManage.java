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
		//���ݮ�
		return driver.findElement(By.xpath("//button[@class='btn btn-xs btn-warning pageset-content']"));
	}
	public WebElement get_productshow() {
		//��Ʒչʾ
		return driver.findElement(By.xpath("//input[@value='��Ʒչʾ']"));
	}
	public Select get_setdisplay() {
		//��Ʒչʾ��������ʾ
		webElement = driver.findElement(By.xpath("//select[@name='nav-4']"));
		Select select = new Select(webElement);
		return select;
	}
	public String get_setdisplay_no() {
		//����ʾ
		return "0";
	}
	public String get_setdisplay_head() {
		//ͷ������������ʾ
		return "1";
	}
	public String get_setdisplay_tail() {
		//β����������ʾ
		return "2";
	}
	public String get_setdisplay_all() {
		//����ʾ
		return "3";
	}
	public WebElement get_more() {
		//"��Ʒչʾ"����
		return driver.findElements(By.xpath("//button[@class='btn btn-sm btn-default dropdown-toggle']")).get(1);
	}
	public WebElement get_add() {
		//"��Ʒչʾ"����-�������Ŀ
		return driver.findElement(By.xpath("//div[@class='dropdown-menu dropdown-menu-right show']//a"));
	}
	public WebElement get_add_num() {
		//"��Ʒչʾ"����-�������Ŀ-�����
		return driver.findElements(By.xpath("//div[@class='form-group']//input")).get(8);
	}
	public WebElement get_add_name() {
		//"��Ʒչʾ"����-�������Ŀ-���ƿ�
		return driver.findElements(By.xpath("//div[@class='form-group']//input")).get(9);
	}
	public WebElement get_add_save() {
		//���ҳ�汣��
		return driver.findElement(By.xpath("//button[@data-ok='']"));
	}
	public WebElement get_save() {	
		//����
		return driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
	}
	public void save() {
		//����
		get_save().click();
	}
	public void mainPage() throws InterruptedException {
		//�ص���ҳ
		driver.get("http://localhost:99/admin/?lang=cn&n=ui_set");
		Thread.sleep(1000);
	}
	public void intoContent() throws InterruptedException {
		//��������
		driver.switchTo().frame(0);
//		Actions action = new Actions(driver);	
//		action.moveToElement(get_row()).perform();
		Thread.sleep(1000);
		get_content().click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}
	
	public void updateTitle() throws InterruptedException {
		//����ҳ���޸ı���
		intoContent();
		get_productshow().clear();
		Thread.sleep(1000);
		get_productshow().sendKeys("��Ʒչʾ");
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
//		mainPage();
	}
	
	public void setDisplay_no() throws InterruptedException {
		//����ҳ�桰��Ʒչʾ����������ʾ����Ϊ����ʾ
		intoContent();
		get_setdisplay().selectByValue("0");
		Thread.sleep(2000);
		save();
		Thread.sleep(1000);
//		mainPage();
	}
	public void setDisplay_head() throws InterruptedException {
		//����ҳ�桰��Ʒչʾ����������ʾ����Ϊͷ����������ʾ
		intoContent();
		get_setdisplay().selectByValue("1");
		Thread.sleep(2000);
		save();
		Thread.sleep(1000);
//		mainPage();
	}
	public void setDisplay_tail() throws InterruptedException {
		//����ҳ�桰��Ʒչʾ����������ʾ����Ϊβ����������ʾ
		intoContent();
		get_setdisplay().selectByValue("2");
		Thread.sleep(2000);
		save();
		Thread.sleep(1000);
//		mainPage();
	}
	public void setDisplay_all() throws InterruptedException {
		//����ҳ�桰��Ʒչʾ����������ʾ����Ϊȫ��ʾ
		intoContent();
		get_setdisplay().selectByValue("3");
		Thread.sleep(2000);
		save();
		Thread.sleep(1000);
//		mainPage();
	}
	public void addColumn() throws InterruptedException {
		//"��Ʒչʾ"�������Ŀ
		intoContent();
		get_more().click();
		Thread.sleep(1000);
		get_add().click();
		Thread.sleep(1000);
		get_add_name().sendKeys("dell�ʼǱ�����");
		Thread.sleep(1000);
		get_add_save().click();
		Thread.sleep(1000);
//		mainPage();
	}
}