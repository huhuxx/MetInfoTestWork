package com.webtest.demo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.utils.ReadProperties;

public class CustomerServiceSetting extends BaseTest{
	@BeforeClass
	public void loginTest() throws InterruptedException {
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.type("name=login_name",ReadProperties.getPropertyValue("username"));
		webtest.type("name=login_pass", ReadProperties.getPropertyValue("password"));
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
	}
	//CustomerService以CS代称
	public void openCSList() throws InterruptedException {
		Thread.sleep(3000);
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		webtest.mouseToElement("xpath=//div[@class='onlinebox_one_list']");
		Thread.sleep(3000);
		webtest.click("xpath=//div[@data-index='13']//button[text()='内容']");
		webtest.leaveFrame();
	}
//35、ID196 客服设置-客服列表-客服名称修改  
	@Test(priority = 1)
	public void editCSName() throws InterruptedException {
		//打开“客服设置-客服列表”界面
		this.openCSList();
		//修改第一个列表的客服名称“售前客服”为“售前客服1”
		webtest.typeAndClear("xpath=//tbody/tr[1]/td[2]/div//input", "售前客服1");
		//保存
		webtest.click("xpath=//button[text()='保存']");
		webtest.click("xpath=//button[text()='关闭']");
		//进入前台页面验证修改
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		List<WebElement> serviceNames=webtest.getElementsList("xpath=//div[@class='onlinebox_one_list']//p");
		System.out.println(serviceNames.get(0).getText());
		Assert.assertEquals(serviceNames.get(0).getText(), "售前客服1");
		webtest.leaveFrame();
		System.out.println("ID196 客服设置-客服列表-客服名称修改 成功！");
	}
//36、ID197 客服设置-客服列表-类型修改
	@Test(priority = 2)
	public void editeCSType() throws InterruptedException {
		//打开“客服设置-客服列表”界面
		this.openCSList();
		//修改修改“售后支持”的类型为“电话”
		webtest.selectByValue("xpath=//input[@value='售后支持']/../../following-sibling::td[1]/select", "3");
		webtest.typeAndClear("xpath=//input[@value='售后支持']/../../following-sibling::td[2]/div/input", "10087");
		//保存
		webtest.click("xpath=//button[text()='保存']");
		webtest.click("xpath=//button[text()='关闭']");
		//进入前台页面验证修改
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		webtest.click("xpath=//p[text()='售后支持']");
		webtest.switchWidow(0);
		webtest.leaveFrame();
		System.out.println("ID197 客服设置-客服列表-类型修改 成功！");
	}
//37、ID198 客服设置-客服列表-号码/链接/图片修改 	
	@Test(priority = 3)
	public void editCSPhoneNum() throws InterruptedException {
		//打开“客服设置-客服列表”界面
		this.openCSList();
		//修改“售前客服1”的“号码/链接/图片修改”的QQ为123456
		webtest.typeAndClear("xpath=//input[@value='售前客服1']/../../following-sibling::td[2]/div/input", "123456");
		//保存
		webtest.click("xpath=//button[text()='保存']");
		webtest.click("xpath=//button[text()='关闭']");
		//进入前台页面验证修改
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		webtest.click("xpath=//p[text()='售前客服1']");
		webtest.switchWidow(0);
		webtest.leaveFrame();
		System.out.println("ID198 客服设置-客服列表-号码/链接/图片修改 成功！");
	}
//38、ID200 客服设置-客服列表-图标删除
	@Test(priority = 4)
	public void deleteCSImg() throws InterruptedException {
		//打开“客服设置-客服列表”界面
		this.openCSList();
		//删除“售后支持”的图标
		webtest.click("xpath=//input[@value='售后支持']/../../following-sibling::td[3]/div[2]/button[1]");
		//保存
		webtest.click("xpath=//button[text()='保存']");
		webtest.click("xpath=//button[text()='关闭']");
		//进入前台页面验证修改
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		String nowImg=webtest.getValue("xpath=//p[text()='售后支持']//preceding-sibling::i[1]","class");
		Assert.assertEquals(nowImg, "");
		webtest.leaveFrame();
		System.out.println("ID200 客服设置-客服列表-图标删除成功！");
	}
//39、 ID199 客服设置-客服列表-图标修改
	@Test(priority = 5)
	public void editCSImg() throws InterruptedException {
		//打开“客服设置-客服列表”界面
		this.openCSList();
		//修改“售后支持”的图标为phone
		webtest.click("xpath=//input[@value='售后支持']/../../following-sibling::td[3]/div[2]//button[text()='选择图标']");
		//选择font-awesome图标库的phone图标
		webtest.click("xpath=//h2[text()='font-awesome']/following-sibling::button[1]");
		webtest.click("xpath=//div[text()='phone']");
		//图标保存
		List<WebElement> submitBtns=webtest.getElementsList("xpath=//button[text()='保存']");
		webtest.click(submitBtns.get(1));
		//保存
		webtest.click("xpath=//button[text()='保存']");
		webtest.click("xpath=//button[text()='关闭']");
		//进入前台页面验证修改
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		String nowImg=webtest.getValue("xpath=//p[text()='售后支持']//preceding-sibling::i[1]","class");
		System.out.println(nowImg);
		Assert.assertEquals(nowImg, "icon fa-phone");
		webtest.leaveFrame();
		System.out.println("ID199 客服设置-客服列表-图标修改 成功！");
	}
//40、ID201 客服设置-客服列表-添加客服 
	@Test(priority = 6)
	public void addCS() throws InterruptedException {
		//打开“客服设置-客服列表”界面
		this.openCSList();
		//添加客服
		webtest.click("xpath=//i[@class='fa fa-plus-circle']");
		webtest.type("xpath=//input[@data-fv-field='name-new-0']", "脸书");
		webtest.selectByValue("xpath=//select[@name='type-new-0']", "6");
		webtest.type("xpath=//input[@data-fv-field='value-new-0']", "987654321");
		webtest.click("xpath=//input[@data-fv-field='value-new-0']/../../following-sibling::td[1]//button[text()='选择图标']");
		//选择font-awesome图标库的facebook图标
		webtest.click("xpath=//h2[text()='font-awesome']/following-sibling::button[1]");
		webtest.click("xpath=//div[text()='facebook']");
		//图标保存
		List<WebElement> submitBtns=webtest.getElementsList("xpath=//button[text()='保存']");
		webtest.click(submitBtns.get(1));
		//保存
		webtest.click("xpath=//button[text()='保存']");
		webtest.click("xpath=//button[text()='关闭']");
		//进入前台页面验证修改
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		String facebookImg=webtest.getValue("xpath=//p[text()='脸书']//preceding-sibling::i[1]","class");
		System.out.println(facebookImg);
		webtest.leaveFrame();
		System.out.println("ID199 客服设置-客服列表-图标修改 成功！");
	}
//41、ID202 客服设置-客服列表-删除客服	
	@Test(priority = 7)
	public void deleteCS() throws InterruptedException {
		//删除“脸书”前
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		System.out.println("删除前，脸书客服是否存在："+webtest.isElementPresent("xpath=//p[text()='脸书']"));
		webtest.leaveFrame();
		//打开“客服设置-客服列表”界面
		this.openCSList();
		//删除“脸书”客服
		webtest.click("xpath=//input[@value='脸书']/../../following-sibling::td[4]/button");
		webtest.click("xpath=//div[@class='dialog']/div/nav/button[text()='确定']");
		webtest.click("xpath=//button[text()='关闭']");
		//删除后，进入前台页面验证修改
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		System.out.println("删除后，脸书客服是否存在："+webtest.isElementPresent("xpath=//p[text()='脸书']"));
		webtest.leaveFrame();
		System.out.println("ID202 客服设置-客服列表-删除客服成功！");
	}
//42、ID203 客服设置-客服设置-功能设置
	@Test(priority = 8)
	public void editFixedStyle() throws InterruptedException {
		//进入 客服设置-客服设置 界面
		Thread.sleep(3000);
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		webtest.mouseToElement("xpath=//div[@class='onlinebox_one_list']");
		Thread.sleep(3000);
		webtest.click("xpath=//div[@data-index='13']/button");
		webtest.leaveFrame();
		//修改在线交流方式为“固定于页面左边”
		webtest.click("xpath=//label[text()='固定于页面左边']");
		//设置距离浏览器侧边0像素，距离浏览器顶部150像素
		webtest.typeAndClear("xpath=//span[text()='距离浏览器侧边']/following-sibling::input[1]", "0");
		webtest.typeAndClear("xpath=//span[text()='距离浏览器顶部']/following-sibling::input[1]", "150");
		//保存
		webtest.click("xpath=//button[text()='保存']");
		//关闭界面
		webtest.click("xpath=//button[text()='关闭']");
		System.out.println("ID203 客服设置-客服设置-功能设置-修改在线交流方式为“固定于页面左边” 成功！");
	}
//43、ID204 客服设置-客服设置-样式设置 	
	@Test(priority = 9)
	public void CSstyleSetting() throws InterruptedException {
		//进入 客服设置-客服设置 界面
		Thread.sleep(3000);
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		String beforeEdit_CScolor=webtest.getValue("xpath=//div[@class='onlinebox_one_list']/a[last()]", "style");
		System.out.println("修改前客服列表的颜色风格为："+beforeEdit_CScolor);
		webtest.mouseToElement("xpath=//div[@class='onlinebox_one_list']");
		Thread.sleep(3000);
		webtest.click("xpath=//div[@data-index='13']/button");
		webtest.leaveFrame();
		//修改颜色风格为#71f086，风格选择为“风格2”
		webtest.typeAndClear("xpath=//input[@name='met_online_color']", "#71f086");
		webtest.selectByValue("tag=select", "2");
		//保存
		webtest.click("xpath=//button[text()='保存']");
		//关闭界面
		webtest.click("xpath=//button[text()='关闭']");
		//进入前台页面验证修改
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		Thread.sleep(2000);
		String afterEdit_CScolor=webtest.getValue("xpath=//div[@class='onlinebox_two_list']/div[1]/a[last()]", "style");
		System.out.println("修改后客服列表的颜色风格为："+afterEdit_CScolor);
		Assert.assertEquals(afterEdit_CScolor, "background-color: rgb(113, 240, 134);");
		webtest.leaveFrame();
		System.out.println("ID204 客服设置-客服设置-样式设置 成功！");
	}
//44、ID205 客服设置-客服设置-其它设置
	@Test(priority = 10)
	public void otherSetting() throws InterruptedException {
		//进入 客服设置-客服设置 界面
		Thread.sleep(3000);
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		webtest.mouseToElement("xpath=//div[@id='onlinebox']");
		Thread.sleep(3000);
		webtest.click("xpath=//div[@data-index='13']/button");
		webtest.leaveFrame();
		//设置界面风格为“风格3”(因为“其他信息”仅在风格3中生效)
		webtest.down(5);
		webtest.selectByValue("tag=select", "3");
		//在其他设置的输入框中输入一行日期文字“2020/11/30/20/50”
		webtest.down(9);
		webtest.enterFrame("ueditor_0");
		webtest.typeAndClear("tag=body","联系热线：");
		webtest.type("tag=body","0311-8300-7262");
		webtest.leaveFrame();
		//保存
		webtest.click("xpath=//button[text()='保存']");
		//关闭界面
		webtest.click("xpath=//button[text()='关闭']");
		//进入前台页面验证修改
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		Thread.sleep(2000);
		String otherInfo=webtest.getElement("xpath=//div[@class='onlinebox-box']/div[last()]").getText();
		System.out.println("其他设置信息为："+otherInfo);
		webtest.leaveFrame();
		System.out.println("ID205 客服设置-客服设置-其它设置 成功！");
	}
//45、ID	241 栏目管理-添加一级栏目
	@Test(priority = 11)
	public void addColumn() {
		//点击顶部的“栏目”，进入栏目管理
		webtest.click("xpath=//a[text()='栏目']");
		//点击最上方的“添加“按钮
		webtest.click("xpath=//button[text()='添加']");
		//设置排序为8，栏目名称为“新一级栏目”，导航栏显示为“头部主导航栏”，所属模块为“简介模块”，目录名称“new”
		webtest.type("xpath=//input[@name='no_order-new-0']", "8");
		webtest.type("xpath=//input[@name='name-new-0']", "新一级栏目");
		webtest.selectByValue("xpath=//select[@name='nav-new-0']", "1");
		webtest.selectByValue("xpath=//select[@name='module-new-0']", "1");
		webtest.type("xpath=//input[@name='foldername-new-0']", "new");
		//保存、关闭
		List<WebElement> submitBtns=webtest.getElementsList("xpath=//button[text()='保存']");
		webtest.click(submitBtns.get(1));
		webtest.click("xpath=//span[text()='×']");
		//进入前台页面验证修改
		boolean newExist=webtest.isElementPresent("xpath=//span[text()='新一级栏目']");
		System.out.println("新添加'新一级栏目'是否存在："+newExist);
		Assert.assertEquals(newExist, true);
		System.out.println("ID	241 栏目管理-添加一级栏目 成功！");
	}
	
}
