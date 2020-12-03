package com.hxy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.hxy.util.BaseTest;

public class ContentManage extends BaseTest {
	WebDriver driver;
	WebElement webElement;
	public ContentManage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement get_title() {
		//��Ʒչʾ������
		return driver.findElement(By.xpath("//span[@met-id='4']"));	
	}
	public WebElement get_content() {
		//����
		return driver.findElements(By.xpath("//button[@class='btn btn-xs btn-warning pageset-content']")).get(4);
	}
	public WebElement get_add() {
		//������ݰ�ť
		return driver.findElement(By.xpath("//button[@class='btn btn-primary btn-content-list-add']"));
	}
	public WebElement get_add_title() {
		//�������,�����
		return driver.findElement(By.xpath("//input[@name='title']"));
	}
	public WebElement get_edit() {
		//�༭��ť
		return driver.findElement(By.xpath("//button[@data-modal-url='product/edit/?c=product_admin&a=doeditor&id=8']"));
	}
	public Select get_select() {
		//��ѡ��
		WebElement selectSingle = driver.findElement(By.xpath("//select[@required='']"));	
//		WebElement selectSingle = driver.findElement(By.xpath("//select[@data-checked='4-5-0']"));
		Select f1=new Select(selectSingle);
		return f1;
	}

	public WebElement get_edit_textsize() {
		//���ִ�С
		return driver.findElement(By.xpath("//input[@name='text_size']"));
	}
	public WebElement get_edit_textcolor() {
		//������ɫ
		return driver.findElement(By.xpath("//input[@name='text_color']"));
	}
	public WebElement get_a() {
		//��������Ѱ��Ԫ��
		return driver.findElement(By.xpath("//h3[@class='example-title']"));
	}
	public WebElement get_edit_model() {
		//�ͺ�
		return driver.findElement(By.xpath("//input[@name='para-117']"));
	}
	public WebElement get_edit_JingDong() {
		//����������ַ�޸�
		return driver.findElement(By.xpath("//input[@name='para-188']"));
	}
	public WebElement get_edit_TaoBao() {
		//�Ա�������ַ�޸�
		return driver.findElement(By.xpath("//input[@name='para-189']"));
	}
	public WebElement get_save() {
		//���ݹ����水ť
		return driver.findElement(By.xpath("//button[@data-ok='']"));
	}
	public void save() {
		get_save().click();
	}
	public void mainPage() throws InterruptedException {
		//�ص���ҳ
		driver.get("http://localhost:99/admin/?lang=cn&n=ui_set");
		Thread.sleep(1000);
	}
	public void editContent_column(String value) throws InterruptedException {
		//������ĿѡΪ��Ʒչʾ
		intoProductShow();
		get_edit().click();
		Thread.sleep(1000);
		get_select().deselectAll();
		Thread.sleep(1000);
		get_select().selectByVisibleText(value);
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
	}
	public void intoProductShow() throws InterruptedException {
		//�������ݹ���
		driver.switchTo().frame(0);
		get_title().click();
		Thread.sleep(2000);
		get_content().click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
	}
	public void addContent() throws InterruptedException {
		//�������
		intoProductShow();
		get_add().click();
		Thread.sleep(1000);
		get_add_title().sendKeys("dell�ʼǱ�����");
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
//		mainPage();
	}
	public void editColumn_productshow() throws InterruptedException {
		//ѡ���Ʒչʾ
		editContent_column("��Ʒչʾ");
//		mainPage();
	}
	public void editColumn_cAndp() throws InterruptedException {
		//ѡ�����&ƽ��
		editContent_column("���� ����&ƽ��");
//		mainPage();
	}
	public void editColumn_notePC() throws InterruptedException {
		//ѡ��ʼǱ�����
		editContent_column("�������� �ʼǱ�����");
//		mainPage();
	}
	public void editColumn_tabletPC() throws InterruptedException {
		//ѡ��ƽ�����
		editContent_column("�������� ƽ�����");
//		mainPage();
	}
	public void editColumn_computerOne() throws InterruptedException {
		//ѡ��һ�������
		editContent_column("�������� һ�������");
//		mainPage();
	}
	public void editColumn_computer() throws InterruptedException {
		//ѡ��̨ʽ������
		editContent_column("�������� ̨ʽ������");
//		mainPage();
	}
	public void editColumn_phone() throws InterruptedException {
		//ѡ���ֻ�
		editContent_column("���� �ֻ�");
//		mainPage();
	}
	public void editColumn_phone_first() throws InterruptedException {
		//ѡ�������ֻ�
		editContent_column("�������� �����ֻ�");
//		mainPage();
	}
	public void editColumn_phone_second() throws InterruptedException {
		//ѡ����ϵ��
		editContent_column("�������� ����ϵ��");
//		mainPage();
	}
	public void editColumn_phone_third() throws InterruptedException {
		//ѡ����ϵ��
		editContent_column("�������� ����ϵ��");
//		mainPage();
	}
	public void editContent_text_size() throws InterruptedException {
		//�༭���ݣ����������С
		intoProductShow();
		get_edit().click();
		Thread.sleep(1000);
		get_edit_textsize().clear();
		Thread.sleep(1000);
		get_edit_textsize().sendKeys("5");
		Thread.sleep(1000);
	    save();
	    Thread.sleep(1000);
//	    mainPage();
	}
	public void editContent_text_color() throws InterruptedException {
		//�༭���ݣ�����������ɫ
		intoProductShow();
		get_edit().click();
		Thread.sleep(1000);
		get_edit_textcolor().clear();
		Thread.sleep(1000);
		get_edit_textcolor().sendKeys("#1baadb");
		Thread.sleep(1000);
	    save();
	    Thread.sleep(1000);
//	    mainPage();
	}
	public void editContent_model() throws InterruptedException {
		//�޸��ͺ�
		intoProductShow();
		get_edit().click();
		Thread.sleep(1000);
		get_a().click();
		Actions actions = new Actions(driver);
		while(true) {
		    actions.sendKeys(Keys.DOWN).perform();
		    Thread.sleep(1000);
		    try {
		        get_edit_model().clear();
		        Thread.sleep(1000);
		        get_edit_model().sendKeys("AKG&HUAWEI");
		        Thread.sleep(1000);
		        break;
		    } catch (Exception e) {
		    }
		}
	    save();
	    Thread.sleep(1000);
//	    mainPage();
	}
	public void editContent_JingDong() throws InterruptedException {
		//�޸��ͺ�
		intoProductShow();
		get_edit().click();
		Thread.sleep(1000);
		get_a().click();
		Actions actions = new Actions(driver);
		while(true) {
		    actions.sendKeys(Keys.DOWN).perform();
		    Thread.sleep(1000);
		    try {
		        get_edit_JingDong().clear();
		        Thread.sleep(1000);
		        get_edit_JingDong().sendKeys("https://www.jd.com/");
		        Thread.sleep(1000);
		        break;
		    } catch (Exception e) {
		    }
		}
	    save();
	    Thread.sleep(1000);
//	    mainPage();
	}
	public void editContent_Taobao() throws InterruptedException {
		//�޸��ͺ�
		intoProductShow();
		get_edit().click();
		Thread.sleep(1000);
		get_a().click();
		Actions actions = new Actions(driver);
		while(true) {
		    actions.sendKeys(Keys.DOWN).perform();
		    Thread.sleep(1000);
		    try {
		        get_edit_TaoBao().clear();
		        Thread.sleep(10000);
		        get_edit_TaoBao().sendKeys("https://www.taobao.com/");
		        Thread.sleep(1000);
		        break;
		    } catch (Exception e) {
		    }
		}
		save();
	    Thread.sleep(1000);
//	    mainPage();
	}
	
}
