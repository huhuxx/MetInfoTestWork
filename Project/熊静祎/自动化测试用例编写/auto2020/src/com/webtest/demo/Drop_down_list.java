package com.webtest.demo;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.utils.ReadProperties;

public class Drop_down_list extends BaseTest{
	@Test(priority = 3)
	public void DropdownList_Show() throws InterruptedException {
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:8070/index.php?lang=cn&pageset=1']");
		webtest.mouseToElement("xpath=//span[text()='新闻动态']");
		Thread.sleep(2000);
		webtest.click("xpath=//span[text()='新闻动态']");
		Thread.sleep(2000);
		System.out.println("测试用例3");
		webtest.leaveFrame();
	}
	
	@Test(priority = 4)
	public void DropdownList_MediaEdit() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit = webtest.findElements("xpath=//input[@class=' form-control']");
		webtest.typeAndClear(elementEdit.get(3), "熊-报道1");
		Thread.sleep(2000);
		System.out.println("测试用例4");
	}
	
	@Test(priority = 5)
	public void DropdownList_IndustryEdit() throws InterruptedException {
		List<WebElement> elementEdit = webtest.findElements("xpath=//input[@class=' form-control']");
		webtest.typeAndClear(elementEdit.get(4), "熊-资讯2");
		Thread.sleep(2000);
		System.out.println("测试用例5");
	}
	
	@Test(priority = 6)
	public void DropdownList_CorporateEdit() throws InterruptedException {
		List<WebElement> elementEdit = webtest.findElements("xpath=//input[@class=' form-control']");
		webtest.typeAndClear(elementEdit.get(5), "熊-企业3");
		Thread.sleep(2000);
		System.out.println("测试用例6");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//滚动条到最下方
		js.executeScript("window.scroll(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		webtest.click("xpath=//button[text()='保存']");
		webtest.click("xpath=//button[text()='关闭']");
		Thread.sleep(2000);
	}
	
	@Test(priority = 7)
	public void DropdownList_MediaNavigation_Head() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_Head = webtest.findElements("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		System.out.println("'设置'的按钮一共有"+elementEdit_Head.size()+'个');
		elementEdit_Head.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementNavigation= webtest.findElements("xpath=//input[@class='custom-control-input']");
		elementNavigation.get(2).click();
		Thread.sleep(2000);
		List<WebElement> elementSave= webtest.findElements("xpath=//button[@class='btn btn-primary']");
		System.out.println("'保存'的按钮一共有"+elementSave.size()+"个");
		elementSave.get(3).click();
		Thread.sleep(2000);
		System.out.println("测试用例7");
		webtest.click("xpath=//button[text()='关闭']");
	}
	
	@Test(priority = 8)
	public void DropdownList_CorporateNavigation_Head() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_Head = webtest.findElements("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		elementEdit_Head.get(4).click();
		Thread.sleep(2000);
		List<WebElement> elementNavigation= webtest.findElements("xpath=//input[@class='custom-control-input']");
		elementNavigation.get(2).click();
		Thread.sleep(2000);
		List<WebElement> elementSave= webtest.findElements("xpath=//button[@class='btn btn-primary']");
		//System.out.println("'保存'的按钮一共有"+elementSave.size()+"个");
		elementSave.get(3).click();
		Thread.sleep(2000);
		System.out.println("测试用例8");
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//滚动条到最下方
		//js.executeScript("window.scroll(0,document.body.scrollHeight)");
		//Thread.sleep(3000);
		//webtest.click("xpath=//button[text()='保存']");
		webtest.click("xpath=//button[text()='关闭']");
	}
	
	@Test(priority = 9)
	public void DropdownList_IndustryNavigation_Head() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_Head = webtest.findElements("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		elementEdit_Head.get(5).click();
		Thread.sleep(2000);
		List<WebElement> elementNavigation= webtest.findElements("xpath=//input[@class='custom-control-input']");
		elementNavigation.get(2).click();
		Thread.sleep(2000);
		List<WebElement> elementSave= webtest.findElements("xpath=//button[@class='btn btn-primary']");
		//System.out.println("'保存'的按钮一共有"+elementSave.size()+"个");
		elementSave.get(3).click();
		Thread.sleep(2000);
		System.out.println("测试用例9");
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//滚动条到最下方
		//js.executeScript("window.scroll(0,document.body.scrollHeight)");
		//Thread.sleep(3000);
		//webtest.click("xpath=//button[text()='保存']");
		webtest.click("xpath=//button[text()='关闭']");
	}
	
	@Test(priority = 10)
	public void DropdownList_MediaNavigation_Bottom() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_Head = webtest.findElements("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		elementEdit_Head.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementNavigation= webtest.findElements("xpath=//input[@class='custom-control-input']");
		elementNavigation.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementSave= webtest.findElements("xpath=//button[@class='btn btn-primary']");
		elementSave.get(3).click();
		Thread.sleep(2000);
		System.out.println("测试用例10");
		webtest.click("xpath=//button[text()='关闭']");
	}
	
	@Test(priority = 11)
	public void DropdownList_CorporateNavigation_Bottom() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_Head = webtest.findElements("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		elementEdit_Head.get(4).click();
		Thread.sleep(2000);
		List<WebElement> elementNavigation= webtest.findElements("xpath=//input[@class='custom-control-input']");
		elementNavigation.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementSave= webtest.findElements("xpath=//button[@class='btn btn-primary']");
		elementSave.get(3).click();
		Thread.sleep(2000);
		System.out.println("测试用例11");
		webtest.click("xpath=//button[text()='关闭']");
	}
	
	@Test(priority = 12)
	public void DropdownList_IndustryNavigation_Bottom() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_Head = webtest.findElements("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		elementEdit_Head.get(5).click();
		Thread.sleep(2000);
		List<WebElement> elementNavigation= webtest.findElements("xpath=//input[@class='custom-control-input']");
		elementNavigation.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementSave= webtest.findElements("xpath=//button[@class='btn btn-primary']");
		elementSave.get(3).click();
		Thread.sleep(2000);
		System.out.println("测试用例12");
		webtest.click("xpath=//button[text()='关闭']");
	}
	
	@Test(priority = 13)
	public void DropdownList_MediaNavigation_All() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_Head = webtest.findElements("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		elementEdit_Head.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementNavigation= webtest.findElements("xpath=//input[@class='custom-control-input']");
		elementNavigation.get(4).click();
		Thread.sleep(2000);
		List<WebElement> elementSave= webtest.findElements("xpath=//button[@class='btn btn-primary']");
		elementSave.get(3).click();
		Thread.sleep(2000);
		System.out.println("测试用例13");
		webtest.click("xpath=//button[text()='关闭']");
	}
	
	@Test(priority = 14)
	public void DropdownList_CorporateNavigation_All() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_Head = webtest.findElements("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		elementEdit_Head.get(4).click();
		Thread.sleep(2000);
		List<WebElement> elementNavigation= webtest.findElements("xpath=//input[@class='custom-control-input']");
		elementNavigation.get(4).click();
		Thread.sleep(2000);
		List<WebElement> elementSave= webtest.findElements("xpath=//button[@class='btn btn-primary']");
		elementSave.get(3).click();
		Thread.sleep(2000);
		System.out.println("测试用例14");
		webtest.click("xpath=//button[text()='关闭']");
	}
	
	@Test(priority = 15)
	public void DropdownList_IndustryNavigation_All() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_Head = webtest.findElements("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		elementEdit_Head.get(5).click();
		Thread.sleep(2000);
		List<WebElement> elementNavigation= webtest.findElements("xpath=//input[@class='custom-control-input']");
		elementNavigation.get(4).click();
		Thread.sleep(2000);
		List<WebElement> elementSave= webtest.findElements("xpath=//button[@class='btn btn-primary']");
		elementSave.get(3).click();
		Thread.sleep(2000);
		System.out.println("测试用例15");
		webtest.click("xpath=//button[text()='关闭']");
	}
	
	@Test(priority = 16)
	public void DropdownList_MediaNewOpen() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_Head = webtest.findElements("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		elementEdit_Head.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementNavigation= webtest.findElements("xpath=//input[@class='custom-control-input']");
		elementNavigation.get(5).click();
		Thread.sleep(2000);
		List<WebElement> elementSave= webtest.findElements("xpath=//button[@class='btn btn-primary']");
		elementSave.get(3).click();
		Thread.sleep(2000);
		System.out.println("测试用例16");
		webtest.click("xpath=//button[text()='关闭']");
		
	}
	
	@Test(priority = 17)
	public void DropdownList_CorporateNewOpen() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_Head = webtest.findElements("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		elementEdit_Head.get(4).click();
		Thread.sleep(2000);
		List<WebElement> elementNavigation= webtest.findElements("xpath=//input[@class='custom-control-input']");
		elementNavigation.get(5).click();
		Thread.sleep(2000);
		List<WebElement> elementSave= webtest.findElements("xpath=//button[@class='btn btn-primary']");
		elementSave.get(3).click();
		Thread.sleep(2000);
		System.out.println("测试用例17");
		webtest.click("xpath=//button[text()='关闭']");
	}
	
	@Test(priority = 18)
	public void DropdownList_IndustryNewOpen() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_Head = webtest.findElements("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		elementEdit_Head.get(5).click();
		Thread.sleep(2000);
		List<WebElement> elementNavigation= webtest.findElements("xpath=//input[@class='custom-control-input']");
		elementNavigation.get(5).click();
		Thread.sleep(2000);
		List<WebElement> elementSave= webtest.findElements("xpath=//button[@class='btn btn-primary']");
		elementSave.get(3).click();
		Thread.sleep(2000);
		System.out.println("测试用例18");
		webtest.click("xpath=//button[text()='关闭']");
	}
	
	@Test(priority = 19)
	public void DropdownList_MediaOrder() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_Head = webtest.findElements("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		elementEdit_Head.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementNavigation= webtest.findElements("xpath=//input[@class='custom-control-input']");
		//System.out.println(elementNavigation.size());
		elementNavigation.get(8).click();
		Thread.sleep(2000);
		List<WebElement> elementSave= webtest.findElements("xpath=//button[@class='btn btn-primary']");
		elementSave.get(3).click();
		Thread.sleep(2000);
		System.out.println("测试用例19");
		webtest.click("xpath=//button[text()='关闭']");
		
	}
	
	@Test(priority = 20)
	public void DropdownList_CorporateOrder() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_Head = webtest.findElements("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		elementEdit_Head.get(4).click();
		Thread.sleep(2000);
		List<WebElement> elementNavigation= webtest.findElements("xpath=//input[@class='custom-control-input']");
		elementNavigation.get(8).click();
		Thread.sleep(2000);
		List<WebElement> elementSave= webtest.findElements("xpath=//button[@class='btn btn-primary']");
		elementSave.get(3).click();
		Thread.sleep(2000);
		System.out.println("测试用例20");
		webtest.click("xpath=//button[text()='关闭']");
	}
	
	@Test(priority = 21)
	public void DropdownList_IndustryOrder() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_Head = webtest.findElements("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		elementEdit_Head.get(5).click();
		Thread.sleep(2000);
		List<WebElement> elementNavigation= webtest.findElements("xpath=//input[@class='custom-control-input']");
		elementNavigation.get(8).click();
		Thread.sleep(2000);
		List<WebElement> elementSave= webtest.findElements("xpath=//button[@class='btn btn-primary']");
		elementSave.get(3).click();
		Thread.sleep(2000);
		System.out.println("测试用例21");
		webtest.click("xpath=//button[text()='关闭']");
	}
	
	@Test(priority = 22)
	public void DropdownList_AddChild() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementEdit_More = webtest.findElements("xpath=//button[@class='btn btn-sm btn-default dropdown-toggle']");
		System.out.println("一共有'更多'按钮"+elementEdit_More.size()+"个");
		elementEdit_More.get(2).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_add = webtest.findElements("xpath=//a[@class='dropdown-item btn-add-subcolumn']");
		System.out.println("一共有'添加子栏目'按钮"+elementEdit_add.size()+"个");
		elementEdit_add.get(2).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_addtext = webtest.findElements("xpath=//input[@class=' form-control']");
		webtest.typeAndClear(elementEdit_addtext.get(6), "熊-添加4");
		Thread.sleep(2000);
		List<WebElement> elementSave= webtest.findElements("xpath=//button[@class='btn btn-primary']");
		elementSave.get(4).click();
		System.out.println("添加子栏目");
		Thread.sleep(2000);
		System.out.println("测试用例22");
		webtest.click("xpath=//button[text()='关闭']");
	}
	
	@Test(priority = 23)
	public void DropdownList_AddChild1() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementEdit_More = webtest.findElements("xpath=//button[@class='btn btn-sm btn-default dropdown-toggle']");
		elementEdit_More.get(2).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_add = webtest.findElements("xpath=//a[@class='dropdown-item btn-add-subcolumn']");
		elementEdit_add.get(2).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_addtext = webtest.findElements("xpath=//input[@class=' form-control']");
		webtest.typeAndClear(elementEdit_addtext.get(6), "熊-添加5");
		Thread.sleep(2000);
		List<WebElement> elementSave= webtest.findElements("xpath=//button[@class='btn btn-primary']");
		elementSave.get(4).click();
		System.out.println("添加子栏目");
		Thread.sleep(2000);
		System.out.println("测试用例23");
		webtest.click("xpath=//button[text()='关闭']");
	}
	
	@Test(priority = 24)
	public void DropdownList_AddChild_child() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_More = webtest.findElements("xpath=//button[@class='btn btn-sm btn-default dropdown-toggle']");
		elementEdit_More.get(4).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_add = webtest.findElements("xpath=//a[@class='dropdown-item btn-add-subcolumn']");
		elementEdit_add.get(4).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_addtext = webtest.findElements("xpath=//input[@class=' form-control']");
		System.out.println(elementEdit_addtext.size());
		webtest.typeAndClear(elementEdit_addtext.get(11), "熊-添加6");
		Thread.sleep(2000);
		List<WebElement> elementSave= webtest.findElements("xpath=//button[@class='btn btn-primary']");
		elementSave.get(4).click();
		System.out.println("添加子栏目");
		Thread.sleep(2000);
		System.out.println("测试用例24");
		webtest.click("xpath=//button[text()='关闭']");
	}
	
	@Test(priority = 25)
	public void DropdownList_up() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_More = webtest.findElements("xpath=//button[@class='btn btn-sm btn-default dropdown-toggle']");
		elementEdit_More.get(4).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_move = webtest.findElements("xpath=//a[@class='dropdown-item dropdown-toggle btn-move-column']");
		//System.out.println("移动按钮共有"+elementEdit_move.size());
		elementEdit_move.get(2).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_moveUp = webtest.findElements("xpath=//a[@class='dropdown-item px-3']");
		//System.out.println("升为一级栏目共有"+elementEdit_moveUp.size()+"个");
		elementEdit_moveUp.get(9).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_addtext = webtest.findElements("xpath=//input[@class='form-control mt-2 mb-0']");
		webtest.typeAndClear(elementEdit_addtext.get(0), "add1");
		Thread.sleep(2000);
		List<WebElement> elementSave= webtest.findElements("xpath=//button[@class='ok btn btn-primary']");
		//System.out.println("确定按钮一共有"+elementSave.size()+"个");
		elementSave.get(0).click();
		System.out.println("栏目升级");
		Thread.sleep(2000);
		System.out.println("测试用例25");
		webtest.click("xpath=//button[text()='关闭']");
	}
	
	//测试对下拉列表框同级间进行“移动”的设置
	@Test(priority = 26)
	public void DropdownList_Move() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		//找到“新闻动态”，并打开下拉列表
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(4).click();
		Thread.sleep(2000);
		//点击“更多”按钮
		List<WebElement> elementEdit_More = webtest.findElements("xpath=//button[@class='btn btn-sm btn-default dropdown-toggle']");
		elementEdit_More.get(4).click();
		Thread.sleep(2000);
		//找到“移动”
		List<WebElement> elementEdit_move = webtest.findElements("xpath=//a[@class='dropdown-item dropdown-toggle btn-move-column']");
		System.out.println("移动按钮共有"+elementEdit_move.size());
		elementEdit_move.get(3).click();
		Thread.sleep(2000);
		//找到“熊-资讯2”
		List<WebElement> elementEdit_moveUp = webtest.findElements("xpath=//a[@class='dropdown-item px-3']");
		System.out.println("移动栏目共有"+elementEdit_moveUp.size()+"个");
		elementEdit_moveUp.get(19).click();
		Thread.sleep(2000);
		System.out.println("测试用例26");
		webtest.click("xpath=//button[text()='关闭']");
	}
	
	//27、测试对下拉列表框进行“删除”的设置
	@Test(priority = 27)
	public void DropdownList_Delete() throws InterruptedException {
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		//找到“熊-添加4”，并打开下拉列表
		List<WebElement> elementDown= webtest.findElements("xpath=//i[@class='fa-angle-down h5 mb-0']");
		elementDown.get(1).click();
		Thread.sleep(2000);
		//点击“更多”按钮
		List<WebElement> elementEdit_More = webtest.findElements("xpath=//button[@class='btn btn-sm btn-default dropdown-toggle']");
		elementEdit_More.get(1).click();
		Thread.sleep(2000);
		//找到“删除”
		List<WebElement> elementEdit_move = webtest.findElements("xpath=//button[@class='dropdown-item btn-del-column']");
		System.out.println("删除按钮共有"+elementEdit_move.size());
		elementEdit_move.get(1).click();
		Thread.sleep(2000);
		//找到“确定”
		webtest.click("xpath=//button[@class='ok btn btn-primary']");
		Thread.sleep(2000);
		System.out.println("测试用例27");
		webtest.click("xpath=//button[text()='关闭']");
	}
	
	//28、测试对子栏目区块“全部”选项进行编辑
	@Test(priority = 28)
	public void DropdownList_EditAll() throws InterruptedException {
		//找到“风格”
		webtest.click("xpath=//button[text()='风格']");
		Thread.sleep(2000);
		//点击“风格设置”
		webtest.click("xpath=//a[text()='风格设置']");
		Thread.sleep(2000);
		//找到页面文字
		List<WebElement> elementEdit_yes = webtest.findElements("xpath=//input[@class=' form-control']");
		System.out.println("输入框共有"+elementEdit_yes.size());
		webtest.typeAndClear(elementEdit_yes.get(9), "熊-全部");
		Thread.sleep(2000);
		webtest.leaveFrame();
		//保存
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//滚动条到最下方
		js.executeScript("window.scroll(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		List<WebElement> elementEdit_Save = webtest.findElements("xpath=//button[@class='btn btn-primary']");
		System.out.println("保存按钮共有"+elementEdit_Save.size());
		elementEdit_Save.get(5).click();
		System.out.println("测试用例28");
		Thread.sleep(2000);
	}
	
	
	// 测试对子栏目区块“媒体报道”选项文字进行编辑
	@Test(priority = 29)
	public void DropdownList_EditMedia() throws InterruptedException {
		// 找到“熊-报道1”并点击
		webtest.refresh();
		Thread.sleep(2000);
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:8070/news/?pageset=1']");
		Thread.sleep(2000);
		webtest.mouseToElement("xpath=//ul[@class='clearfix met-column-nav-ul text-xs-center']/li[2]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='icon wb-pencil']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@class='form-control input-sm']", "熊-媒体报道");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-primary btn-xs editable-submit']");
		Thread.sleep(2000);
		System.out.println("测试用例29");
		Thread.sleep(2000);
	}

	// 测试对子栏目区块“行业资讯”选项文字进行编辑
	@Test(priority = 30)
	public void DropdownList_EditIndustry() throws InterruptedException {
		// 找到“熊-资讯2”并点击
		webtest.refresh();
		Thread.sleep(2000);
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:8070/news/?pageset=1']");
		Thread.sleep(2000);
		webtest.mouseToElement("xpath=//ul[@class='clearfix met-column-nav-ul text-xs-center']/li[3]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='icon wb-pencil']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@class='form-control input-sm']", "熊-行业资讯");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-primary btn-xs editable-submit']");
		Thread.sleep(2000);
		System.out.println("测试用例30");
		Thread.sleep(2000);
	}

	// 测试对子栏目区块“行业资讯”选项文字进行编辑
	@Test(priority = 31)
	public void DropdownList_EditCorporate() throws InterruptedException {
		// 找到“熊-企业3”并点击
		webtest.refresh();
		Thread.sleep(2000);
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:8070/news/?pageset=1']");
		Thread.sleep(2000);
		webtest.mouseToElement("xpath=//ul[@class='clearfix met-column-nav-ul text-xs-center']/li[4]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='icon wb-pencil']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@class='form-control input-sm']", "熊-企业新闻");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-primary btn-xs editable-submit']");
		Thread.sleep(2000);
		System.out.println("测试用例31");
		webtest.leaveFrame();
		Thread.sleep(2000);
	}
		
	//测试对子栏目区块选项文字进行编辑后，头部主导航栏中下拉框的文字内容显示
	@Test(priority = 32)
	public void DropdownList_Show2() throws InterruptedException {
		//webtest.leaveFrame();
		//Thread.sleep(2000);
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:8070/index.php?lang=cn&pageset=1']");
		webtest.refresh();
		webtest.click("xpath=//span[text()='新闻动态']");
		Thread.sleep(2000);
		System.out.println("测试用例32");
		webtest.leaveFrame();
	}

	//测试对子栏目区块搜索栏进行关键字搜索
	@Test(priority = 33)
	public void Search_Engines() throws InterruptedException {
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:8070/news/?pageset=1']");
		//找到搜索框
		webtest.typeAndClear("xpath=//input[@class='form-control input-lg']", "Parallels");
		Thread.sleep(2000);
		//点击搜索
		webtest.click("xpath=//button[@class='input-search-btn']");
		Thread.sleep(2000);
		System.out.println("关键字搜索");
		System.out.println("测试用例33"); 
		webtest.leaveFrame();
	}
	
	// 测试对子栏目区块搜索栏进行搜索方式设置
	@Test(priority = 34)
	public void Search_EnginesSet() throws InterruptedException, IOException {
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:8070/news/?pageset=1']");
		// 找到设置
		webtest.mouseToElement("xpath=//input[@class='form-control input-lg']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@data-index='5']");
		Thread.sleep(2000);
		// 点击"标题"
		webtest.leaveFrame();
		Thread.sleep(2000);
		webtest.click("xpath=//label[text()='标题']");
		Thread.sleep(2000);
		List<WebElement> elementEdit_Save = webtest.findElements("xpath=//button[@class='btn btn-primary']");
		System.out.println("保存按钮共有" + elementEdit_Save.size());
		elementEdit_Save.get(0).click();
		System.out.println("关键字搜索方式设置");
		System.out.println("测试用例34");
	}

	// 测试对内容进行推荐
	@Test(priority = 35)
	public void Search_Recommend() throws InterruptedException {
		webtest.refresh();
		Thread.sleep(2000);
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:8070/news/index.php?lang=cn&stype=1&search=search&class1=3&content=Parallels&pageset=1']");
		// 找到文章模块的“内容”
		webtest.mouseToElement("xpath=//div[@class='met-news-list set']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-xs btn-warning pageset-content']");
		Thread.sleep(2000);
		webtest.leaveFrame();
		webtest.click("xpath=//input[@class='checkall-item custom-control-input']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-default dropdown-toggle']");
		Thread.sleep(2000);
		//推荐
		webtest.click("xpath=//a[text()='推荐']");
		Thread.sleep(2000);
		System.out.println("推荐内容");
		System.out.println("测试用例35");
	}
	
	//测试对内容取消推荐
	@Test(priority = 36)
	public void Search_CancelRecommend() throws InterruptedException {
		webtest.click("xpath=//input[@class='checkall-item custom-control-input']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-default dropdown-toggle']");
		Thread.sleep(2000);
		//取消推荐
		webtest.click("xpath=//a[text()='取消推荐']");
		Thread.sleep(2000);
		System.out.println("推荐内容");
		System.out.println("测试用例36");
	}

	
	//测试对内容置顶
	@Test(priority = 37)
	public void Search_Topping() throws InterruptedException {
		/*
		 * webtest.refresh(); Thread.sleep(2000); webtest.enterFrame1(
		 * "xpath=//iframe[@src='http://localhost:8070/news/index.php?lang=cn&stype=1&search=search&class1=3&content=Parallels&pageset=1']"
		 * ); // 找到文章模块的“内容”
		 * webtest.mouseToElement("xpath=//div[@class='met-news-list set']");
		 * Thread.sleep(2000); webtest.
		 * click("xpath=//button[@class='btn btn-xs btn-warning pageset-content']");
		 * Thread.sleep(2000); // 勾选第二个 webtest.leaveFrame();
		 */
		List<WebElement> elementEdit_article = webtest.findElements("xpath=//input[@class='checkall-item custom-control-input']");
		System.out.println("共有文章" + elementEdit_article.size());
		elementEdit_article.get(1).click();
		Thread.sleep(2000);
		//点击状态修改
		webtest.click("xpath=//button[@class='btn btn-default dropdown-toggle']");
		Thread.sleep(2000);
		//置顶
		webtest.click("xpath=//a[text()='置顶']");
		Thread.sleep(2000);
		//Thread.sleep(2000);
		System.out.println("置顶");
		System.out.println("测试用例37");
	}

	// 测试对内容取消置顶
	@Test(priority = 38)
	public void Search_CancelTopping() throws InterruptedException {
		webtest.click("xpath=//input[@class='checkall-item custom-control-input']");
		Thread.sleep(2000);
		// 点击状态修改
		webtest.click("xpath=//button[@class='btn btn-default dropdown-toggle']");
		Thread.sleep(2000);
		// 置顶
		webtest.click("xpath=//a[text()='取消置顶']");
		Thread.sleep(2000);
		Thread.sleep(2000);
		System.out.println("置顶");
		System.out.println("测试用例38");
	}

	
	//测试对内容前台隐藏
	@Test(priority = 39)
	public void Search_Hide() throws InterruptedException {
		
		webtest.click("xpath=//input[@class='checkall-all custom-control-input']");
		Thread.sleep(2000);
		// 点击状态修改
		webtest.click("xpath=//button[@class='btn btn-default dropdown-toggle']");
		Thread.sleep(2000);
		// 前台隐藏
		webtest.click("xpath=//a[text()='前台隐藏']");
		Thread.sleep(2000);
//		webtest.click("xpath=//button[@class='btn btn-default mr-1']");
		Thread.sleep(2000);
		System.out.println("前台隐藏");
		System.out.println("测试用例39");
	}

	// 测试对内容前台显示
	@Test(priority = 40)
	public void Search_CancelHide() throws InterruptedException {
		/*
		 * //webtest.enterFrame1(
		 * "xpath=//iframe[@src='http://localhost:8070/news/index.php?lang=cn&stype=1&search=search&class1=3&content=Parallels&pageset=1']"
		 * ); // 找到文章模块的“内容”
		 * webtest.mouseToElement("xpath=//div[@class='met-news-list set']");
		 * Thread.sleep(2000); webtest.
		 * click("xpath=//button[@class='btn btn-xs btn-warning pageset-content']");
		 * Thread.sleep(2000); // 勾选所有 webtest.leaveFrame();
		 */
		webtest.click("xpath=//input[@class='checkall-all custom-control-input']");
		Thread.sleep(2000);
		// 点击状态修改
		webtest.click("xpath=//button[@class='btn btn-default dropdown-toggle']");
		Thread.sleep(2000);
		// 前台隐藏
		webtest.click("xpath=//a[text()='前台显示']");
		Thread.sleep(2000);
//		webtest.click("xpath=//button[@class='btn btn-default mr-1']");
		Thread.sleep(2000);
		System.out.println("前台显示");
		System.out.println("测试用例40");
	}
	
	// 测试测试对内容进行“简体中文”复制
	@Test(priority = 41)
	public void Search_Copy() throws InterruptedException {
		/*
		 * //webtest.enterFrame1(
		 * "xpath=//iframe[@src='http://localhost:8070/news/index.php?lang=cn&stype=1&search=search&class1=3&content=Parallels&pageset=1']"
		 * ); // 找到文章模块的“内容”
		 * webtest.mouseToElement("xpath=//div[@class='met-news-list set']");
		 * Thread.sleep(2000); webtest.
		 * click("xpath=//button[@class='btn btn-xs btn-warning pageset-content']");
		 * Thread.sleep(2000); // 勾选第一项 webtest.leaveFrame();
		 */
		webtest.click("xpath=//input[@class='checkall-item custom-control-input']");
		Thread.sleep(2000);
		// 点击复制
		List<WebElement> elementEdit_Copy = webtest.findElements("xpath=//button[@class='btn btn-default dropdown-toggle']");
		elementEdit_Copy.get(2).click();
		Thread.sleep(2000);
		// 点击简体中文
		webtest.click("xpath=//a[text()='简体中文']");
		Thread.sleep(2000);
		//点击新闻动态
		webtest.doubleClick("xpath=//button[text()='复制到指定栏目']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id=\"news-list\"]/tfoot/tr/th[2]/div[5]/div/div/a[text()='新闻动态']");
		Thread.sleep(2000);
		//点击熊-资讯2
		webtest.mouseToElement("xpath=//div[@class='dropdown-menu show']");
		Thread.sleep(2000);
		List<WebElement> elementEdit_Choose = webtest.findElements("xpath=//div[@class='dropdown dropright dropdown-submenu']");
		System.out.println(elementEdit_Choose.size());
		elementEdit_Choose.get(2).click();
		Thread.sleep(2000);
		//点击熊-添加5
		webtest.click("xpath=//*[@id=\"news-list\"]/tfoot/tr/th[2]/div[5]/div/div/div/div/div/a[text()='熊-添加5']");
		Thread.sleep(2000);
//		webtest.click("xpath=//button[@class='btn btn-default mr-1']");
		Thread.sleep(2000);
		System.out.println("“简体中文”复制");
		System.out.println("测试用例41");
	}
	
	
	// 测试测试对内容进行“English”复制
	@Test(priority = 42)
	public void Search_CopyEnglish() throws InterruptedException {
		/*
		 * // 找到文章模块的“内容”
		 * webtest.mouseToElement("xpath=//div[@class='met-news-list set']");
		 * Thread.sleep(2000); webtest.
		 * click("xpath=//button[@class='btn btn-xs btn-warning pageset-content']");
		 * Thread.sleep(2000); // 勾选第一项 webtest.leaveFrame();
		 */
		webtest.click("xpath=//input[@class='checkall-item custom-control-input']");
		Thread.sleep(2000);
		// 点击复制
		List<WebElement> elementEdit_Copy = webtest
				.findElements("xpath=//button[@class='btn btn-default dropdown-toggle']");
		elementEdit_Copy.get(2).click();
		Thread.sleep(2000);
		// 点击English
		webtest.click("xpath=//a[text()='English']");
		Thread.sleep(2000);
		// 点击News
		List<WebElement> elementEdit_Choose = webtest
				.findElements("xpath=//div[@class='dropdown dropright dropdown-submenu']");
		elementEdit_Choose.get(1).click();
		Thread.sleep(2000);
		// 点击熊-添加5
		webtest.click("xpath=//a[text()='Industry information']");
		Thread.sleep(2000);
//		webtest.click("xpath=//button[@class='btn btn-default mr-1']");
		Thread.sleep(2000);
		System.out.println("“English”复制");
		System.out.println("测试用例42");
	}
	
	//测试对内容进行“放入回收站”删除
	@Test(priority = 43)
	public void Search_RecycleBin() throws InterruptedException {
		/*
		 * // 找到文章模块的“内容”
		 * webtest.mouseToElement("xpath=//div[@class='met-news-list set']");
		 * Thread.sleep(2000); webtest.
		 * click("xpath=//button[@class='btn btn-xs btn-warning pageset-content']");
		 * Thread.sleep(2000); // 勾选第一项 webtest.leaveFrame();
		 */
		webtest.click("xpath=//input[@class='checkall-item custom-control-input']");
		Thread.sleep(2000);
		// 点击删除
		List<WebElement> elementEdit_Delete = webtest.findElements("xpath=//button[@class='btn btn-sm btn-default']");
		System.out.println(elementEdit_Delete.size());
		elementEdit_Delete.get(0).click();
		Thread.sleep(2000);
		// 点击放入回收站
		webtest.click("xpath=//button[text()='放入回收站']");
		Thread.sleep(2000);
		System.out.println("“放入回收站”删除");
		System.out.println("测试用例43");
	}

	// BUG 测试对内容进行“放入回收站”还原
	@Test(priority = 44)
	public void Search_RecycleBin_Reduction() throws InterruptedException {
		/*
		 * // 找到文章模块的“内容”
		 * webtest.mouseToElement("xpath=//div[@class='met-news-list set']");
		 * Thread.sleep(2000); webtest.
		 * click("xpath=//button[@class='btn btn-xs btn-warning pageset-content']");
		 * Thread.sleep(2000); // 点击回收站 webtest.leaveFrame();
		 */
		webtest.mouseToElement("xpath=//div[@class='py-2 d-flex align-items-center justify-content-between']");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='btn-content-recycle text-content']");
		Thread.sleep(2000);
		// 点击全部文章
		List<WebElement> elementEdit_all = webtest
				.findElements("xpath=//input[@class='checkall-all custom-control-input']");
		System.out.println(elementEdit_all.size());
		elementEdit_all.get(2).click();
		Thread.sleep(2000);
		// 点击还原
		webtest.click("xpath=//button[text()='还原']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[text()='关闭']");
		System.out.println("“放入回收站”删除");
		System.out.println("测试用例44");
	}
	
	//测试对内容进行彻底删除
	@Test(priority = 45)
	public void Search_Delete_completely() throws InterruptedException {
		webtest.refresh(); 
		Thread.sleep(2000); 
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:8070/news/index.php?lang=cn&stype=1&search=search&class1=3&content=Parallels&pageset=1']");
		Thread.sleep(2000);
		// 找到文章模块的“内容”
		webtest.mouseToElement("xpath=//div[@class='met-news-list set']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-xs btn-warning pageset-content']");
		Thread.sleep(2000); // 勾选第一项 
		webtest.leaveFrame();
		webtest.click("xpath=//input[@class='checkall-item custom-control-input']");
		Thread.sleep(2000);
		// 点击删除
		List<WebElement> elementEdit_Delete = webtest.findElements("xpath=//button[@class='btn btn-sm btn-default']");
		System.out.println(elementEdit_Delete.size());
		elementEdit_Delete.get(0).click();
		Thread.sleep(2000);
		// 点击放入回收站
		webtest.click("xpath=//button[text()='彻底删除']");
		Thread.sleep(2000);
//		webtest.click("xpath=//button[text()='关闭']");
		System.out.println("“放入回收站”删除");
		System.out.println("测试用例45");
	}
	
	//测试对内容进行纯文字添加
	@Test(priority = 46)
	public void Search_AddWord() throws InterruptedException {
		/*
		 * // 找到文章模块的“内容”
		 * webtest.mouseToElement("xpath=//div[@class='met-news-list set']");
		 * Thread.sleep(2000); webtest.
		 * click("xpath=//button[@class='btn btn-xs btn-warning pageset-content']");
		 * Thread.sleep(2000); // 点击添加内容 webtest.leaveFrame();
		 */
		webtest.click("xpath=//button[text()='添加内容']");
		Thread.sleep(2000);
		// 选择所属栏目
		webtest.click("xpath=//select[@class='form-control mr-1 w-a prov']");
		Thread.sleep(2000);
		webtest.click("xpath=//select[@class='form-control mr-1 w-a prov']/option[text()='熊-添加4']");
		Thread.sleep(2000);
		// 输入文章标题
		List<WebElement> elementEdit_add = webtest.findElements("xpath=//input[@class='form-control']");
		System.out.println(elementEdit_add.size());
		webtest.typeAndClear(elementEdit_add.get(1), "这是小熊添加的第一篇文章");
		Thread.sleep(2000);		
		// 输入文章内容
		webtest.enterFrame("ueditor_0");
		webtest.type("xpath=//body[@class='view']", "这是小熊添加的第一篇文章，有着简简单单的内容");
		Thread.sleep(2000);
		webtest.leaveFrame();
		Thread.sleep(2000);
		List<WebElement> elementEdit_Save = webtest.findElements("xpath=//button[@class='btn btn-primary']");
		System.out.println(elementEdit_Save.size());
		elementEdit_Save.get(1).click();
		Thread.sleep(2000);
//		webtest.click("xpath=//button[text()='关闭']");
		System.out.println("纯文字添加内容");
		System.out.println("测试用例46");
	}
	
	//测试对内容进行含封面图片的添加
	@Test(priority = 49)
	public void Search_AddPicture() throws InterruptedException {
		webtest.refresh();
		Thread.sleep(2000);
		// 找到文章模块的“内容”
		webtest.mouseToElement("xpath=//div[@class='met-news-list set']");
		Thread.sleep(2000); webtest.
		click("xpath=//button[@class='btn btn-xs btn-warning pageset-content']");
		Thread.sleep(2000); 
		// 点击添加内容 
		
		webtest.click("xpath=//button[text()='添加内容']"); 
		Thread.sleep(2000);
		webtest.leaveFrame();
		// 选择所属栏目
		webtest.click("xpath=//select[@class='form-control mr-1 w-a prov']");
		Thread.sleep(2000);
		webtest.click("xpath=//select[@class='form-control mr-1 w-a prov']/option[text()='熊-添加4']");
		Thread.sleep(2000);
		// 输入文章标题
		List<WebElement> elementEdit_add = webtest.findElements("xpath=//input[@class='form-control']");
		System.out.println(elementEdit_add.size());
		webtest.typeAndClear(elementEdit_add.get(1), "这是小熊添加的第一篇有图片的文章");
		webtest.leaveFrame();
		Thread.sleep(2000);
		// 输入文章内容
		
		webtest.enterFrame("ueditor_0]");
		webtest.type("xpath=//body[@class='view']", "这是小熊添加的第一篇带图片的文章，有着简简单单的内容");
		Thread.sleep(2000);
		webtest.leaveFrame();
		Thread.sleep(2000);
		//添加文章封面
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//滚动条到最下方
		js.executeScript("window.scroll(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		//点击从图片库选择
		webtest.click("xpath=//button[text()='从图片库选择']");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//a[@data-path='/upload/201801']");
		Thread.sleep(2000);
		webtest.click("xpath=//img[@class='vertical-align-middle img-fluid']");
		Thread.sleep(2000);
		List<WebElement> elementEdit_Save0 = webtest.findElements("xpath=//button[@class='btn btn-primary']");
		System.out.println(elementEdit_Save0.size());
		elementEdit_Save0.get(2).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_Save = webtest.findElements("xpath=//button[@class='btn btn-primary']");
		System.out.println(elementEdit_Save.size());
		elementEdit_Save.get(1).click();
		Thread.sleep(2000);
		webtest.click("xpath=//button[text()='关闭']");
		System.out.println("含封面图片添加内容");
		System.out.println("测试用例49");
	}
	
	// 测试对内容进行含封面图片文章进行编辑
	@Test(priority = 47)
	public void Search_EditPicture() throws InterruptedException {
		/*
		 * // 找到文章模块的“内容”
		 * webtest.mouseToElement("xpath=//div[@class='met-news-list set']");
		 * Thread.sleep(2000); webtest.
		 * click("xpath=//button[@class='btn btn-xs btn-warning pageset-content']");
		 * Thread.sleep(2000); // 点击新闻动态 webtest.leaveFrame();
		 */
		webtest.click("xpath=//span[text()='新闻动态']");
		Thread.sleep(2000);
		// 勾选第一项
		webtest.click("xpath=//input[@class='checkall-item custom-control-input']");
		Thread.sleep(2000);
		// 点击编辑
		List<WebElement> elementEdit_Delete = webtest.findElements("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		elementEdit_Delete.get(0).click();
		Thread.sleep(2000);
		// 添加文章封面
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// 滚动条到最下方
		js.executeScript("window.scroll(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		// 点击文件上传
		webtest.type("xpath=//input[@data-plugin='fileinput']", "E:\\workspace\\img\\01.png");
		Thread.sleep(2000);
		//保存
		List<WebElement> elementEdit_Save0 = webtest.findElements("xpath=//button[@class='btn btn-primary']");
		System.out.println("保存"+elementEdit_Save0.size());
		elementEdit_Save0.get(2).click();
		Thread.sleep(2000);
//		webtest.click("xpath=//button[text()='关闭']");
		System.out.println("含封面图片文章进行图片编辑");
		System.out.println("测试用例47");
	}
	
	// 测试对含封面图片的内容进行封面的删除
	@Test(priority = 48)
	public void Search_EditPicture_Delete() throws InterruptedException {
		/*
		 * // 找到文章模块的“内容”
		 * webtest.mouseToElement("xpath=//div[@class='met-news-list set']");
		 * Thread.sleep(2000); webtest.
		 * click("xpath=//button[@class='btn btn-xs btn-warning pageset-content']");
		 * Thread.sleep(2000); // 点击新闻动态 webtest.leaveFrame();
		 */
		// 勾选第一项
		webtest.click("xpath=//input[@class='checkall-item custom-control-input']");
		Thread.sleep(2000);
		// 点击编辑
		List<WebElement> elementEdit_Delete = webtest
				.findElements("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		elementEdit_Delete.get(0).click();
		Thread.sleep(2000);
		// 添加文章封面
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// 滚动条到最下方
		js.executeScript("window.scroll(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		// 点击文件上传
		webtest.click("xpath=//i[@class='glyphicon glyphicon-trash text-grey']");
		Thread.sleep(2000);
		// 保存
		List<WebElement> elementEdit_Save0 = webtest.findElements("xpath=//button[@class='btn btn-primary']");
		System.out.println("保存" + elementEdit_Save0.size());
		elementEdit_Save0.get(2).click();
		Thread.sleep(2000);
		//webtest.click("xpath=//button[text()='关闭']");
		System.out.println("含封面图片文章进行图片编辑");
		System.out.println("测试用例48");
	}

	//测试对下拉列表框进行“添加英文子栏目”的设置
	@Test(priority = 50)
	public void DropdownList_English() throws InterruptedException {
		webtest.refresh();
		Thread.sleep(2000);
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:8070/news/index.php?lang=cn&stype=1&search=search&class1=3&content=Parallels&pageset=1']");
		webtest.click("xpath=//span[text()='English']");
		Thread.sleep(2000);
		webtest.leaveFrame();
		Thread.sleep(2000);
		webtest.click("xpath=//a[text()='栏目']");
		Thread.sleep(2000);
		List<WebElement> elementEdit_More = webtest
				.findElements("xpath=//button[@class='btn btn-sm btn-default dropdown-toggle']");
		elementEdit_More.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_add = webtest.findElements("xpath=//a[@class='dropdown-item btn-add-subcolumn']");
		System.out.println(elementEdit_add.size());
		elementEdit_add.get(3).click();
		Thread.sleep(2000);
		List<WebElement> elementEdit_addtext = webtest.findElements("xpath=//input[@class=' form-control']");
		webtest.typeAndClear(elementEdit_addtext.get(7), "Xiong-Add7");
		Thread.sleep(2000);
		List<WebElement> elementSave = webtest.findElements("xpath=//button[@class='btn btn-primary']");
		elementSave.get(3).click();
		System.out.println("添加子栏目");
		Thread.sleep(2000);
		System.out.println("测试用例50");
		webtest.click("xpath=//button[text()='关闭']");
		Thread.sleep(2000);
	}
	

}
