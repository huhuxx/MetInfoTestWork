package com.bxx.test;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bxx.core.ElementFinder;
/**
 * 客户案例页面
 * 更改Banner信息、搜索框、页面的切换、展示案例内容的查看、图片的删除
 * 
 * @author 白星星
 *
 */
public class kehuanliPageTest extends BaseTest {

	@BeforeMethod(description = "进入客户案例页面")
	public void testEnter() throws InterruptedException {
		webtest.enterFrame1("xpath=//*[@class='page-iframe flex-fill']");
		webtest.click("xpath=//*[@id='met-nav-collapse']/ul/li[6]/a");
	}
	
	@Test(description = "更改Banner名字")
	public void testBanner1() throws InterruptedException {
		webtest.mouseToElementandClick("xpath=//*/ul/li[6]/a/span");
		Thread.sleep(3000);
		webtest.typeAndClear("xpath=//input[@class='form-control input-sm']", "客户案例(1)");
		webtest.click("xpath=//button[1]/i[@class='wb-check']");
		Thread.sleep(3000);
		assertEquals(webtest.getText("xpath=/html/body/div[1]/h3"), "客户案例(1)");
	}

	@Test(description = "搜索")
	public void testSearch2() throws InterruptedException {
		webtest.type("xpath=//input[@name='content']","品牌案例展示");
		webtest.click("xpath=//*[@class='icon wb-search']");
	}
	
	@Test(description = "页面切换")
	public void testSwitch3() throws InterruptedException {
		String jString = "window.scrollTo(0,document.body.scrollHeight)";
		webtest.runJs(jString);
		webtest.click("xpath=//*[@class='NextA editable-click']");
		Thread.sleep(3000);
		webtest.runJs(jString);
		webtest.click("xpath=//*[@class='PreA editable-click']");
	}
	
	@Test(priority = 1,description = "查看第五个展示图片的详细内容，并返回上一页	")
	public void test4() throws InterruptedException {
		List<WebElement> list1 = webtest.backlist("xpath=//*[@class='cover-image overlay-scale']");
		System.out.println("该页面一共有图片的数量："+list1.size());
		webtest.runJs("window.scrollTo(0,600)");
		webtest.click(list1.get(4));
		
		String jString = "window.scrollTo(0,document.body.scrollHeight)";
		webtest.runJs(jString);
		webtest.runJs("window.history.back(-1)");
	}
	
	@Test(description = "搜索“新添加”的内容，并打开第一个查看详细信息，然后返回搜索页面")
	public void test5() throws InterruptedException {
		//搜索
		webtest.type("xpath=//input[@name='content']","新添加");
		webtest.click("xpath=//*[@class='icon wb-search']");
		//结果列表
		List<WebElement> resultList = webtest.backlist("xpath=//*[@class='cover-image overlay-scale']");
		System.out.println("本页新添加的有"+resultList.size());
		//点击第一个查看详情
		webtest.click(resultList.get(0));
		Thread.sleep(5000);
		//返回搜索列表
		webtest.runJs("window.history.back(-1)");
		
	}
	
	@Test(description = "展示部分的图片删除")
	public void testEditDelete6() throws InterruptedException {
		webtest.click("xpath=//div[@class='cover overlay overlay-hover']/a[@class='btn btn-outline btn-inverse met-img-showbtn']");
		Thread.sleep(5000);
		webtest.mouseToElement("xpath=//div[@class='met-showimg']");
		List<WebElement> list = webtest.backlist("xpath=/html/div[2]/div/button[2][@class='btn btn-xs btn-warning pageset-content']");
		webtest.click(list.get(0));
		Thread.sleep(5000);		
		webtest.leaveFrame();
		//Delete
		webtest.typeAndClear("xpath=//input[@name='title']", "这是删除部分图片后的名字");
		

		webtest.leaveFrame();
		webtest.click("xpath=//*[@class='btn btn-primary']");
		Thread.sleep(50000);
	}
}
