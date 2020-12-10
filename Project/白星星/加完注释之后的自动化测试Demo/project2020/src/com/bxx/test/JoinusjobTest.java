package com.bxx.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bxx.dataprovider.NSDataProvider;
/**
 * 加入我们后台的招聘职位管理和简历信息管理模块
 * 岗位的增删改查、显示状态的修改、简历的查看
 * 搜索框的搜索
 * 数据驱动的实现
 * 
 * @author 白星星
 *
 */
public class JoinusjobTest extends BaseTest{
	
	@BeforeMethod(description = "进入加入我们后天的招聘职位管理模块")
	public void basictest() throws InterruptedException {
		webtest.click("xpath=//a[text()='内容']");
		List<WebElement> list = webtest.backlist("xpath=//*[@class='py-2 d-block']");
		webtest.click(list.get(5));
	}
	

	@Test(description = "将第三个置顶")
	public void test1() throws InterruptedException {
		List<WebElement> gangweiList = webtest.backlist("xpath=//*[@name='id']");
		System.out.println("岗位个数"+gangweiList.size());
		webtest.click(gangweiList.get(2));
		webtest.click("xpath=//*[@class='btn btn-default dropdown-toggle']");
		webtest.click("xpath=//*[text()='置顶']");
	}
	
	@Test(description = "将第一个取消置顶")
	public void test2() throws InterruptedException {
		List<WebElement> gangweiList = webtest.backlist("xpath=//*[@name='id']");
		System.out.println("岗位个数"+gangweiList.size());
		webtest.click(gangweiList.get(0));
		webtest.click("xpath=//*[@class='btn btn-default dropdown-toggle']");
		webtest.click("xpath=//*[text()='取消置顶']");
	}
	
	@Test(description = "搜索框进行搜索，并打印出搜索结果有几个，返回")
	public void test3() throws InterruptedException {
		webtest.typeAndClear("name=keyword","前端工程师");
		webtest.click("xpath=//*[@class='input-group-text bg-none btn']");
		List<WebElement> gangweiList = webtest.backlist("xpath=//*[@name='id']");
		System.out.println("前端工程师的个数："+gangweiList.size());
//		Assert.assertEquals(gangweiList.size(), 2);
		webtest.runJs("window.history.back(-1)");
	}
	@Test(description = "删除第三个工作岗位，并选择取消")
	public void test4() throws InterruptedException {
		List<WebElement> gangweiList = webtest.backlist("xpath=//*[@name='id']");
		System.out.println("岗位个数"+gangweiList.size());
		webtest.click(gangweiList.get(2));	
		List<WebElement> deleteList = webtest.backlist("xpath=//button[text()='删除']");
		webtest.click(deleteList.get(2));
		webtest.click("xpath=//*[@class='cancel btn btn-default']");
		
	}
	@Test(dataProvider = "gangwei",
			dataProviderClass = NSDataProvider.class,
			description = "添加一个工作岗位")
	public void test5(String text1) throws InterruptedException {
		webtest.click("xpath=//*[text()='添加内容']");
		webtest.typeAndClear("xpath=//*[@name='position']", "Java工程师");
		webtest.typeAndClear("xpath=//*[@name='place']", "上海");
		webtest.typeAndClear("xpath=//*[@name='deal']", "8k+");
		webtest.typeAndClear("xpath=//*[@name='count']", "10");
		webtest.typeAndClear("xpath=//*[@name='useful_life']","30");
		webtest.typeAndClear("xpath=//*[@name='addtime']", "2020-11-28");
		webtest.typeAndClear("xpath=//*[@name='updatetime']", "2020-11-30");
		
		webtest.enterFrame("ueditor_0");
		webtest.typeAndClear("tag=body", text1);
		webtest.leaveFrame();

		webtest.click("xpath=//div[@class='float-right']//button[text()='保存']");
	}
	@Test(description = "对第五个岗位的编辑")
	public void test6() throws InterruptedException {
		List<WebElement> gangweiList = webtest.backlist("xpath=//*[@name='id']");
		System.out.println("岗位个数"+gangweiList.size());
		webtest.click(gangweiList.get(4));	
		List<WebElement> deleteList = webtest.backlist("xpath=//button[text()='编辑']");
		webtest.click(deleteList.get(4));
		webtest.typeAndClear("xpath=//*[@name='position']", "这是更新后的招聘信息");
		webtest.typeAndClear("xpath=//*[@name='place']", "地点更改为天津");
		webtest.typeAndClear("xpath=//*[@name='deal']", "薪资涨到8k+");
		webtest.typeAndClear("xpath=//*[@name='count']", "多招聘10");
		webtest.typeAndClear("xpath=//*[@name='useful_life']","延长30");
		webtest.type("xpath=//*[@name='addtime']", "2020-11-29");
		webtest.type("xpath=//*[@name='updatetime']", "2020-11-30");
		webtest.click("xpath=//div[@class='float-right']//button[text()='保存']");
	}
	@Test(description = "将第五个设置为前台隐藏")
	public void test7() throws InterruptedException {
		List<WebElement> gangweiList = webtest.backlist("xpath=//*[@name='id']");
		System.out.println("岗位个数"+gangweiList.size());
		webtest.click(gangweiList.get(4));
		
		//点击设置
		webtest.click("xpath=//*[@class='btn btn-default dropdown-toggle']");
		webtest.click("xpath=//a[text()='前台隐藏']");
	}
	@Test(description = "将第五个设置为前台显示")
	public void test8() throws InterruptedException {
		List<WebElement> gangweiList = webtest.backlist("xpath=//*[@name='id']");
		System.out.println("岗位个数"+gangweiList.size());
		webtest.click(gangweiList.get(4));
		
		//点击设置
		webtest.click("xpath=//*[@class='btn btn-default dropdown-toggle']");
		webtest.click("xpath=//a[text()='前台显示']");
	}
	@Test(description = "查看所有状态为置顶的岗位信息")
	public void test9() throws InterruptedException {
		webtest.click("name=search_type");
		webtest.click("xpath=//*[text()='置顶']");
		List<WebElement> gangweiList = webtest.backlist("xpath=//*[@name='id']");
		System.out.println("置顶状态的岗位个数："+gangweiList.size());
	}
	@Test(description = "查看所有状态为前台隐藏的岗位信息")
	public void test10() throws InterruptedException {
		webtest.click("name=search_type");
		webtest.click("xpath=//*[text()='前台隐藏']");
		List<WebElement> gangweiList = webtest.backlist("xpath=//*[@name='id']");
		System.out.println("前台隐藏的岗位个数："+gangweiList.size());
	}
	@Test(description = "简历信息管理-查看简历并点击关闭")
	public void test11() throws InterruptedException {
		webtest.click("xpath=//*[text()='简历信息管理']");
		webtest.click("xpath=//*[text()='查看']");
		
		List<WebElement> list = webtest.backlist("xpath=//button[text()='关闭']");
		webtest.click(list.get(1));
	}
	@Test(description = "简历信息管理-导出简历")
	public void test12() throws InterruptedException {
		webtest.click("xpath=//*[text()='简历信息管理']");
		webtest.click("xpath=//a[text()='导出简历']");
		Thread.sleep(5000);
	}
	
	@Test(description = "简历信息的删除")
	public void test13() throws InterruptedException {
		webtest.click("xpath=//*[text()='简历信息管理']");
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='job-list-43--']/tbody/tr[2]/td[7]/button[text()='删除']");
		webtest.click("xpath=//*[@class='ok btn btn-primary']");
	}
	@Test(description = "所有简历的删除，并取消删除")
	public void test14() throws InterruptedException {
		webtest.click("xpath=//*[text()='简历信息管理']");
		webtest.click("xpath=//*[@id='job-list-43--']/thead/tr/th[1]/div/input");
		webtest.click("xpath=//*[@id='job-list-43--']/tfoot/tr/th[2]/button");
		webtest.click("xpath=//*[@class='cancel btn btn-default']");
	}
	@Test(description = "搜索张三的简历信息")
	public void test15() throws InterruptedException {
		webtest.click("xpath=//*[text()='简历信息管理']");
		webtest.typeAndClear("xpath=//*[@data-table-search='#job-list-43--']","张三");
		webtest.click("xpath=//*[@class='input-search-icon wb-search']");
		webtest.getWindow(0);
		Thread.sleep(3000);
	}
	@Test(description = "查看李四的简历详情")
	public void test16() throws InterruptedException {
		webtest.click("xpath=//*[text()='简历信息管理']");
		webtest.typeAndClear("xpath=//*[@data-table-search='#job-list-43--']","李四");
		webtest.click("xpath=//*[@class='input-search-icon wb-search']");
		webtest.click("xpath=//*[@id='job-list-43--']/tbody/tr/td[7]/button[1]");
	}
}
