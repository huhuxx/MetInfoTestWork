package com.bxx.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JoinuspageTest extends BaseTest {

	@BeforeMethod
	public void beforeall() throws InterruptedException {
		webtest.enterFrame1("xpath=//*[@class='page-iframe flex-fill']");
		webtest.click("xpath=//*[@id='met-nav-collapse']/ul/li[7]/a/span[@class='editable-click']");
	}
	
	@Test
	public void text1() throws InterruptedException {
		//选择岗位输入简历并进行提交
		webtest.runJs("window.scrollBy(0, 400)");
		webtest.click("xpath=//a[text()='在线应聘']");
		Thread.sleep(5000);
		webtest.type("xpath=//*[@id='met-job-cv0']/div/div/div[2]/form/div[1]/input", "张三");
		webtest.click("xpath=//*[@id='para166_2']");
		webtest.type("xpath=//*[@id='met-job-cv0']/div/div/div[2]/form/div[3]/input", "135682634");
		webtest.type("xpath=//*[@id='met-job-cv0']/div/div/div[2]/form/div[4]/input", "13113893039@163.com");
		webtest.type("xpath=//*[@id='met-job-cv0']/div/div/div[2]/form/div[13]/div/input", "1");
		webtest.click("xpath=//*[@id=\"met-job-cv0\"]/div/div/div[2]/form/div[14]/button[1]");
		String alert  = webtest.switchtoalert();
		Assert.assertEquals(alert,"操作成功!");
	}
	
	@Test
	public void test2() throws InterruptedException {
		//填写简历信息并选择点击【取消】
		webtest.runJs("window.scrollBy(0, 500)");
		webtest.click("xpath=//a[text()='在线应聘']");
		Thread.sleep(5000);
		webtest.type("xpath=//*[@id='met-job-cv0']/div/div/div[2]/form/div[1]/input", "Lili");
		webtest.click("xpath=//*[@id='para166_2']");
		webtest.type("xpath=//*[@id='met-job-cv0']/div/div/div[2]/form/div[3]/input", "135682634");
		webtest.type("xpath=//*[@id='met-job-cv0']/div/div/div[2]/form/div[4]/input", "13113893039@163.com");
		webtest.type("xpath=//*[@id='met-job-cv0']/div/div/div[2]/form/div[13]/div/input", "1");
		webtest.click("xpath=//*[@id='met-job-cv0']/div/div/div[2]/form/div[14]/button[2]");
	}
	
	@Test
	public void test3() throws InterruptedException {
		//搜索岗位信息，并且在其中一个岗位投递简历信息
		webtest.type("xpath=//input[@name='content']", "测试后台人员");
		webtest.click("xpath=/html/body/section[1]/div/div/div/form/div/button/i");
		webtest.click("xpath=//div[@class='card card-shadow']/div[2]/a");
		
		webtest.type("xpath=//*[@id='met-job-cv0']/div/div/div[2]/form/div[1]/input","赵六");
		webtest.click("xpath=//*[@id='para166_2']");
		webtest.type("xpath=//*[@id='met-job-cv0']/div/div/div[2]/form/div[3]/input", "135682634");
		webtest.type("xpath=//*[@id='met-job-cv0']/div/div/div[2]/form/div[4]/input", "13113893039@163.com");
		webtest.type("xpath=//*[@placeholder='验证码']", "1");
		webtest.click("xpath=//*[@id='met-job-cv0']/div/div/div[2]/form/div[14]/button[text()='提交信息']");
		String alert  = webtest.switchtoalert();
		Assert.assertEquals(alert,"操作成功!");
	}
	
	@Test
	public void test4() throws InterruptedException {
		//下滑至底部 ，切换至第二个页面，并返回第一个页面
		String jString = "window.scrollTo(0,document.body.scrollHeight)";
		webtest.runJs(jString);
		webtest.click("xpath=/html/body/section[2]/div/div/div[2]/div/a[text()='2']");
		Thread.sleep(5000);
		webtest.runJs(jString);
		webtest.click("xpath=/html/body/section[2]/div/div/div[2]/div/a[text()='上一页']");
	}
	

}
