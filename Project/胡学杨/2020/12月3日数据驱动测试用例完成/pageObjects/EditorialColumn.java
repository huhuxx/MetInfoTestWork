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
		//����
		return driver.findElements(By.xpath("//button[@class='btn btn-sm btn-primary mr-1']")).get(1);
	}
	public WebElement get_set_productshow() {
		//��Ʒչʾ
		return driver.findElement(By.xpath("//input[@name='name']"));
	}
	public WebElement get_set_textsize() {
		//�������ִ�С��
		return driver.findElement(By.xpath("//input[@class='form-control d-inline-block mr-2']"));
	}
	public WebElement get_set_textcolor() {
		//����������ɫ��
		return driver.findElement(By.xpath("//input[@name='text_color']"));
	}
	public WebElement get_set_no() {
		//����ʾ
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio']//input")).get(0);
	}
	public WebElement get_set_head() {
		//ͷ������������ʾ
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio']//input")).get(1);
	}
	public WebElement get_set_tail() {
		//β����������ʾ
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio']//input")).get(2);
	}
	public WebElement get_set_all() {
		//ȫ��ʾ
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio']//input")).get(3);
	}

	public WebElement get_set_window_yes() {
		//�´��ڴ򿪡��ǡ�
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']//input")).get(0);
	}
	public WebElement get_set_window_no() {
		//�´��ڴ򿪡���
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']//input")).get(1);
	}
	public WebElement get_set_sortStyle_updateTime() {
		//����ʱ��
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio']//input")).get(4);
	}
	public WebElement get_set_sortStyle_releaseTime() {
		//����ʱ��
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio']//input")).get(5);
	}
	public WebElement get_set_sortStyle_clickNumber() {
		//���ʱ��
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio']//input")).get(6);
	}
	public WebElement get_set_sortStyle_idDaoxu() {
		//id����
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio']//input")).get(7);
	}
	public WebElement get_set_sortStyle_idZheng() {
		//id˳��
		return driver.findElements(By.xpath("//div[@class='custom-control custom-radio']//input")).get(8);
	}
	public void intoSet() throws InterruptedException {
		//���롰��Ʒչʾ������
		c().intoContent();
		get_set().click();
		Thread.sleep(2000);
	}
	public WebElement get_set_save() {
		//����
		return driver.findElement(By.xpath("//button[@data-ok='']"));
	}
	public void save() {
		//����ҳ�汣�����
		get_set_save().click();
	}
	public void mainPage() throws InterruptedException {
		//�ص���ҳ
		driver.get("http://localhost:99/admin/?lang=cn&n=ui_set");
		Thread.sleep(1000);
	}
	public void set_updateTitle() throws InterruptedException {
		//����ҳ���޸ı���
		intoSet();
		get_set_productshow().clear();
		Thread.sleep(1000);
		get_set_productshow().sendKeys("��Ʒչʾ");
		Thread.sleep(1000);
		save();
//		mainPage();
	}
	public void set_text_size() throws InterruptedException {
		//���������С
		intoSet();
		get_set_textsize().sendKeys("12");
		Thread.sleep(2000);
		get_set_textsize().clear();
		Thread.sleep(2000);	
		save();
//		mainPage();
	}
	public void set_text_color() throws InterruptedException {
		//����������ɫ
		intoSet();
		get_set_textcolor().clear();
		Thread.sleep(2000);
		get_set_textcolor().sendKeys("#f21818");
		Thread.sleep(2000);	
		get_set_textcolor().clear();
		Thread.sleep(1000);	
		save();
//		mainPage();
	}
	public void set_setDisplay_no() throws InterruptedException {
		//����ҳ�����õ�������ʾΪ����ʾ
		intoSet();
		get_set_no().click();
		Thread.sleep(1000);
		save();
//		mainPage();
	}
	public void set_setDisplay_head() throws InterruptedException {
		//����ҳ�����õ�������ʾΪͷ����������ʾ
		intoSet();
		get_set_head().click();
		Thread.sleep(1000);
		save();
//		mainPage();
	}
	public void set_setDisplay_tail() throws InterruptedException {
		//����ҳ�����õ�������ʾΪβ����������ʾ
		intoSet();
		get_set_tail().click();
		Thread.sleep(1000);
		save();
//		mainPage();
	}
	public void set_setDisplay_all() throws InterruptedException {
		//����ҳ�����õ�������ʾΪȫ����ʾ
		intoSet();
		get_set_all().click();
		Thread.sleep(1000);
		save();
//		mainPage();
	}
	public void set_newWindow_yes() throws InterruptedException {
		//����ҳ�������´��ڴ�Ϊ��
		intoSet();
		get_set_window_yes().click();
		Thread.sleep(1000);
		save();
//		mainPage();
	}
	public void set_newWindow_no() throws InterruptedException {
		//����ҳ�������´��ڴ�Ϊ��
		intoSet();
		get_set_window_no().click();
		Thread.sleep(1000);
		save();
//		mainPage();
	}
	public void set_sortStyle_updateTime() throws InterruptedException {
		//����ҳ�������б�ҳ����ʽΪ����ʱ��
		intoSet();
		get_set_sortStyle_updateTime().click();
		Thread.sleep(1000);
		save();
//		mainPage();
	}
	public void set_sortStyle_releaseTime() throws InterruptedException {
		//����ҳ�������б�ҳ����ʽΪ����ʱ��
		intoSet();
		get_set_sortStyle_releaseTime().click();
		Thread.sleep(1000);
		save();
//		mainPage();
	}
	public void set_sortStyle_clickNumber() throws InterruptedException {
		//����ҳ�������б�ҳ����ʽΪ�������
		intoSet();
		get_set_sortStyle_clickNumber().click();
		Thread.sleep(1000);
		save();
//		mainPage();
	}
	public void set_sortStyle_daoxu() throws InterruptedException {
		//����ҳ�������б�ҳ����ʽΪ����ʱ��
		intoSet();
		get_set_sortStyle_idDaoxu();
		Thread.sleep(1000);
		save();
//		mainPage();
	}
	public void set_sortStyle_zhengxu() throws InterruptedException {
		//����ҳ�������б�ҳ����ʽΪ����ʱ��
		intoSet();
		get_set_sortStyle_idZheng();
		Thread.sleep(1000);
		save();
//		mainPage();
	}
}
