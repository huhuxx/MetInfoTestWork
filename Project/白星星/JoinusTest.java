package com.bxx.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JoinusTest extends BaseTest{
	
	@BeforeTest
	public void basictest() throws InterruptedException {
		webtest.click("xpath=//a[text()='内容']");
		List<WebElement> list = webtest.backlist("xpath=//*[@class='py-2 d-block']");
		webtest.click(list.get(5));
	}

	@Test
	public void test1() throws InterruptedException {
		//将第三个置顶
		
		List<WebElement> gangweiList = webtest.backlist("xpath=//*[@name='id']");
		System.out.println("岗位个数"+gangweiList.size());
		webtest.click(gangweiList.get(2));
		webtest.click("xpath=//*[@class='btn btn-default dropdown-toggle']");
		webtest.click("xpath=//*[text()='置顶']");
	}
	
	@Test
	public void test2() throws InterruptedException {
		//将第一个取消置顶
		List<WebElement> gangweiList = webtest.backlist("xpath=//*[@name='id']");
		System.out.println("岗位个数"+gangweiList.size());
		webtest.click(gangweiList.get(0));
		webtest.click("xpath=//*[@class='btn btn-default dropdown-toggle']");
		webtest.click("xpath=//*[text()='取消置顶']");
	}
	
	@Test
	public void test3() throws InterruptedException {
		//搜索框进行搜索，并打印出搜索结果有几个
		webtest.type("name=keyword","前端工程师");
		webtest.click("xpath=//*[@class='input-group-text bg-none btn']");
		List<WebElement> gangweiList = webtest.backlist("xpath=//*[@name='id']");
		System.out.println("前端工程师的个数："+gangweiList.size());
	}
	@Test
	public void test4() throws InterruptedException {
		//删除第三个工作岗位
		List<WebElement> gangweiList = webtest.backlist("xpath=//*[@name='id']");
		System.out.println("岗位个数"+gangweiList.size());
		webtest.click(gangweiList.get(2));	
		List<WebElement> deleteList = webtest.backlist("xpath=//button[text()='删除']");
		webtest.click(deleteList.get(2));
		webtest.click("xpath=//*[@class='ok btn btn-primary']");
	}
	@Test
	public void test5() throws InterruptedException {
		//添加一个工作岗位
		webtest.click("xpath=//*[text()='添加内容']");
		webtest.type("xpath=//*[@name='position']", "前端工程师");
		webtest.type("xpath=//*[@name='place']", "天津");
		webtest.type("xpath=//*[@name='deal']", "8k+");
		webtest.type("xpath=//*[@name='count']", "10");
		webtest.type("xpath=//*[@name='useful_life']","30");
		webtest.type("xpath=//*[@name='addtime']", "2020-11-28");
		webtest.type("xpath=//*[@name='updatetime']", "2020-11-30");
		
		webtest.enterFrame("ueditor_0");
		webtest.type("tag=body", "岗位要求：\r\n" + 
				"本科及以上学历，环境或法律相关专业\r\n" + 
				"5年以上电子或机械产品环境推进经验，五百强企业工作经验优先\r\n" + 
				"了解RoHS、WEEE相关知识，并熟悉环境标识及能效标识等环境法规标准\r\n" + 
				"流利日文以及英文沟通及书写能力\r\n" + 
				"良好的人际沟通能力及团队合作学习能力");
		webtest.leaveFrame();

		webtest.click("xpath=//div[@class='float-right']//button[text()='保存']");
	}
	@Test
	public void test6() throws InterruptedException {
		//对第五个岗位的编辑
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
	@Test
	public void test7() throws InterruptedException {
		//将第五个设置为前台隐藏
		List<WebElement> gangweiList = webtest.backlist("xpath=//*[@name='id']");
		System.out.println("岗位个数"+gangweiList.size());
		webtest.click(gangweiList.get(4));
		
		//点击设置
		webtest.click("xpath=//*[@class='btn btn-default dropdown-toggle']");
		webtest.click("xpath=//a[text()='前台隐藏']");
	}
	@Test
	public void test8() throws InterruptedException {
		//将第五个设置为前台显示
		List<WebElement> gangweiList = webtest.backlist("xpath=//*[@name='id']");
		System.out.println("岗位个数"+gangweiList.size());
		webtest.click(gangweiList.get(4));
		
		//点击设置
		webtest.click("xpath=//*[@class='btn btn-default dropdown-toggle']");
		webtest.click("xpath=//a[text()='前台显示']");
	}
	@Test
	public void test9() throws InterruptedException {
		//查看所有状态为置顶的岗位信息
		webtest.click("name=search_type");
		webtest.click("xpath=//*[text()='置顶']");
		List<WebElement> gangweiList = webtest.backlist("xpath=//*[@name='id']");
		System.out.println("置顶状态的岗位个数："+gangweiList.size());
	}
	@Test
	public void test10() throws InterruptedException {
		//查看所有状态为前台隐藏的岗位信息
		webtest.click("name=search_type");
		webtest.click("xpath=//*[text()='前台隐藏']");
		List<WebElement> gangweiList = webtest.backlist("xpath=//*[@name='id']");
		System.out.println("前台隐藏的岗位个数："+gangweiList.size());
	}
	@Test
	public void test11() throws InterruptedException {
		//简历信息管理-查看第二个简历
		webtest.click("xpath=//*[text()='简历信息管理']");
		Thread.sleep(5000);
//		****************************************
		List<WebElement> list1 = webtest.backlist("xpath=//input[@name='id']");
		System.out.println(list1.size());
		webtest.click(list1.get(1));
	}
	@Test
	public void test12() throws InterruptedException {
		//简历信息管理-导出第二个简历
		webtest.click("xpath=//*[text()='简历信息管理']");
//**********************************		
		List<WebElement> list1 = webtest.backlist("xpath=//*[@class='btn btn-sm btn-primary mr-1']");
		System.out.println(list1.size());
		
		webtest.click(list1.get(1));
	}
	@Test
	public void test13() {
		//简历信息管理-导出所有简历的Excel表格
	}
}
