package com.webtest.demo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.JavaMailTestListener;
import com.webtest.utils.FreeMarker;
import com.webtest.utils.MailUtil;
import com.webtest.utils.ReadProperties;

import freemarker.template.TemplateException;
@Listeners(JavaMailTestListener.class)
public class TopSetting extends BaseTest {
	@BeforeClass
	public void loginTest() throws InterruptedException {
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.type("name=login_name",ReadProperties.getPropertyValue("username"));
		webtest.type("name=login_pass", ReadProperties.getPropertyValue("password"));
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
	}
	public void openTopSetting() throws InterruptedException {
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
//		List<WebElement> setElements=webtest.getElementsList("xpath=//button[@data-mid='met-head']");
		webtest.mouseToElement("xpath=//ul[@class='nav navbar-nav navlist']");
		webtest.click("xpath=//button[@data-mid='met_head']");
		webtest.leaveFrame();
	}
//10、	ID84 顶部设置的下拉方式修改为“点击展开”
	@Test(priority = 1)
	public void setPutDown() throws InterruptedException {
		this.openTopSetting();
//		下拉方式修改为“点击展开”
		webtest.click("xpath=//label[text()='点击展开']/preceding-sibling::input[1]");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		System.out.println("ID84 顶部设置的下拉方式修改为“点击展开”失败！");
		Thread.sleep(2000);
	}
	
//11、	85 顶部设置的多语言位置设置修改为“底部” 
	@Test(priority = 2)
	public void languagePosition() throws InterruptedException {
//		this.openTopSetting();
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
//		List<WebElement> setElements=webtest.getElementsList("xpath=//button[@data-mid='met-head']");
		webtest.mouseToElement("xpath=//ul[@class='nav navbar-nav navlist']");
		webtest.click("xpath=//button[@data-mid='met_head']");
		webtest.leaveFrame();
//		顶部设置的多语言位置设置修改为“底部” 
		webtest.click("xpath=//label[text()='底部']/preceding-sibling::input[1]");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		System.out.println("ID85 顶部设置的多语言位置设置修改为“底部” 成功！");
		Thread.sleep(2000);
	}
	
//12、	86 顶部设置的语言国旗开关修改为“关闭” 
	@Test(priority = 3)
	public void nationalFlagSetting() throws InterruptedException {
		Thread.sleep(2000);
		this.openTopSetting();
//		顶部设置的语言国旗开关修改为“关闭” 
		webtest.click("xpath=//label[text()='关闭']/preceding-sibling::input[1]");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		System.out.println("86 顶部设置的语言国旗开关修改为“关闭” 成功！");
	}
//13、	ID103 修改“网站首页”内容
	@Test(priority = 4)
	public void editHomePageName() throws InterruptedException {
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		webtest.mouseToElement("xpath=//a[text()='网站首页']");
		webtest.click("xpath=//button[@data-index='3']");
		webtest.typeAndClear("xpath=//input[@class='form-control input-sm']", "首页syj");
		webtest.click("xpath=//i[@class='wb-check']");
		//验证修改
		String nowName=webtest.getText("xpath=//a[@met-id='3']");
		System.out.println("修改后为："+nowName);
		Assert.assertEquals(nowName, "首页syj");
	}
	@AfterSuite
	public void mailUtil() throws IOException, TemplateException {
		FreeMarker freeMarker=new FreeMarker();
		freeMarker.makeReport();
		
		MailUtil m=new MailUtil();
		m.sendMail();
		
	}
}
