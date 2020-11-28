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
		//产品展示导航栏
		return driver.findElement(By.xpath("//span[text()='产品展示']"));
	}
	public WebElement get_content() {
		//内容
		return driver.findElements(By.xpath("//button[@class='btn btn-xs btn-warning pageset-content']")).get(4);
	}
	public WebElement get_add() {
		//添加内容按钮
		return driver.findElement(By.xpath("//button[@class='btn btn-primary btn-content-list-add']"));
	}
	public WebElement get_add_title() {
		//添加内容,标题框
		return driver.findElement(By.xpath("//input[@name='title']"));
	}
	public WebElement get_edit() {
		//编辑按钮
		return driver.findElement(By.xpath("//button[@data-modal-url='product/edit/?c=product_admin&a=doeditor&id=8']"));
	}
	public Select get_select() {
		//多选框
		WebElement selectSingle = driver.findElement(By.xpath("//select[@data-checked='4-5-0']"));
		Select f1=new Select(selectSingle);
		return f1;
	}

	public WebElement get_edit_textsize() {
		//文字大小
		return driver.findElement(By.xpath("//input[@name='text_size']"));
	}
	public WebElement get_edit_textcolor() {
		//文字颜色
		return driver.findElement(By.xpath("//input[@name='text_color']"));
	}
	public WebElement get_a() {
		//辅助向下寻找元素
		return driver.findElement(By.xpath("//h3[@class='example-title']"));
	}
	public WebElement get_edit_model() {
		//型号
		return driver.findElement(By.xpath("//input[@name='para-117']"));
	}
	public WebElement get_edit_JingDong() {
		//京东购买网址修改
		return driver.findElement(By.xpath("//input[@name='para-188']"));
	}
	public WebElement get_edit_TaoBao() {
		//淘宝购买网址修改
		return driver.findElement(By.xpath("//input[@name='para-189']"));
	}
	public WebElement get_save() {
		//内容管理保存按钮
		return driver.findElement(By.xpath("//button[@data-ok='']"));
	}
	public void save() {
		get_save().click();
	}
	public void editContent_column(String value) throws InterruptedException {
		//所属栏目选为产品展示
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
		//进入内容管理
		driver.switchTo().frame(0);
		get_title().click();
		Thread.sleep(2000);
		get_content().click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
	}
	public void addContent() throws InterruptedException {
		//添加内容
		intoProductShow();
		get_add().click();
		Thread.sleep(1000);
		get_add_title().sendKeys("dell笔记本电脑");
		Thread.sleep(1000);
		save();
		Thread.sleep(1000);
	}
	public void editColumn_productshow() throws InterruptedException {
		//选择产品展示
		editContent_column("产品展示");
	}
	public void editColumn_cAndp() throws InterruptedException {
		//选择电脑&平板
		editContent_column("电脑&平板");
	}
	public void editColumn_notePC() throws InterruptedException {
		//选择笔记本电脑
		editContent_column("笔记本电脑");
	}
	public void editColumn_tabletPC() throws InterruptedException {
		//选择平板电脑
		editContent_column("平板电脑");
	}
	public void editColumn_computerOne() throws InterruptedException {
		//选择一体机电脑
		editContent_column("一体机电脑");
	}
	public void editColumn_computer() throws InterruptedException {
		//选择台式机电脑
		editContent_column("台式机电脑");
	}
	public void editColumn_phone() throws InterruptedException {
		//选择手机
		editContent_column("手机");
	}
	public void editColumn_phone_first() throws InterruptedException {
		//选择智能手机
		editContent_column("智能手机");
	}
	public void editColumn_phone_second() throws InterruptedException {
		//选择畅玩系列
		editContent_column("畅玩系列");
	}
	public void editColumn_phone_third() throws InterruptedException {
		//选择畅想系列
		editContent_column("畅想系列");
	}
	public void editContent_text_size() throws InterruptedException {
		//编辑内容，设置字体大小
		intoProductShow();
		get_edit().click();
		Thread.sleep(1000);
		get_edit_textsize().sendKeys("5");
		Thread.sleep(1000);
	    save();
	    Thread.sleep(1000);
	}
	public void editContent_text_color() throws InterruptedException {
		//编辑内容，设置字体颜色
		intoProductShow();
		get_edit().click();
		Thread.sleep(1000);
		get_edit_textcolor().clear();
		Thread.sleep(1000);
		get_edit_textcolor().sendKeys("#1baadb");
		Thread.sleep(1000);
	    save();
	    Thread.sleep(1000);
	}
	public void editContent_model() throws InterruptedException {
		//修改型号
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
		        Thread.sleep(10000);
		        break;
		    } catch (Exception e) {
		    }
		}
	    save();
	    Thread.sleep(1000);
	}
	public void editContent_JingDong() throws InterruptedException {
		//修改型号
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
		        Thread.sleep(10000);
		        break;
		    } catch (Exception e) {
		    }
		}
	    save();
	    Thread.sleep(1000);
	}
	public void editContent_Taobao() throws InterruptedException {
		//修改型号
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
		        Thread.sleep(10000);
		        break;
		    } catch (Exception e) {
		    }
		}
		save();
	    Thread.sleep(1000);
	}
	
}
