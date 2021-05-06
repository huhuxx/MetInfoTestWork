package com.bxx.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JoinuszhaopinTest extends BaseTest {

	@BeforeMethod
	public void before() throws InterruptedException {
		webtest.click("xpath=//a[text()='内容']");
		List<WebElement> list = webtest.backlist("xpath=//*[@class='py-2 d-block']");
		webtest.click(list.get(5));
		
		webtest.click("xpath=//div[@class='content-show-item']/nav/a[text()='招聘系统配置']");
	}
	@Test
	public void test1() throws InterruptedException {
		//填写第一栏，点击【保存】
		webtest.typeAndClear("xpath=//*[@id='job-set-form']/div/dl[1]/dd/input[@name='met_cv_time']","180");
		webtest.click("xpath=//*[@id=\"job-set-form\"]/div/dl[2]/dd/select[@name='met_cv_image']");
		webtest.click("xpath=//*[@id=\"job-set-form\"]/div/dl[2]/dd/select/option[text()='请选择']");
		List<WebElement> selectlist = webtest.backlist("xpath=//*[@class='custom-control-input']");
		System.out.println("共有选项的数量"+selectlist.size());
		webtest.click(selectlist.get(3));
		webtest.click(selectlist.get(4));
		webtest.click("xpath=//input[@name='met_cv_type']");
		webtest.click("xpath=//*[@name='met_cv_emtype']");
		
		webtest.type("xpath=//*[@name='met_cv_to']","1336124020@qq.com|13113893039@126.com");
		webtest.type("xpath=//*[@name='met_cv_job_tel']", "13113893039");
		
		webtest.click("xpath=//*[@id='job-set-form']/div/dl[15]/dd/button[text()='保存']");
	}
	@Test
	public void test2() throws InterruptedException {
		//填写邮件回复设置，点击【保存】
		webtest.click("xpath=//*[@class='custom-control-input']");
		webtest.typeAndClear("xpath=//*[@name='met_cv_title']", "欢迎到我们公司");
		
		webtest.typeAndClear("xpath=//div[@class='tab-pane fade active show']/form/div/dl[11]/dd/textarea[@class='form-control']", "我们已经收到你的简历信息，接下来三天内将会通知你参加面试的时间");
		webtest.click("xpath=//*[@id='job-set-form']/div/dl[15]/dd/button[text()='保存']");
	}
	@Test
	public void test3() throws InterruptedException {
		//填写短信回复设置，点击【保存】
		webtest.click("xpath=//*[@name='met_cv_sms_back']");
		webtest.type("xpath=//*[@name='met_cv_sms_content']", "回复短信内容需要在短信功能提供平台提交内容模板审核，审核通过后才能发送成功。");
		
		webtest.click("xpath=//*[@id='job-set-form']/div/dl[15]/dd/button[text()='保存']");
	}
}
