package com.webtest.demo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.JavaMailTestListener;
import com.webtest.utils.FreeMarker;
import com.webtest.utils.MailUtil;
import com.webtest.utils.ReadProperties;

import freemarker.template.TemplateException;
public class TopSetting extends BaseTest {

	@BeforeMethod
	public void refreshPage() {
		webtest.refresh();
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
		//下拉方式修改为“鼠标经过”
		this.openTopSetting();
		webtest.click("xpath=//label[text()='鼠标经过']/preceding-sibling::input[1]");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		//点击预览进行验证
		webtest.click("xpath=//a[text()='预览']");
		webtest.switchWidow(1);
		
		webtest.mouseToElement("xpath=//a[@title='关于我们']/..");
		Thread.sleep(2000);           
		String mouseMove_li=webtest.getValue("xpath=//a[@title='关于我们']/..", "class");
		System.out.println("下拉方式修改为“鼠标经过”后，li的class值为："+mouseMove_li);
		webtest.switchWidow(0);
		
		//下拉方式修改为“点击展开”
		this.openTopSetting();
		webtest.click("xpath=//label[text()='点击展开']/preceding-sibling::input[1]");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		//点击预览进行验证
		webtest.click("xpath=//a[text()='预览']");
		webtest.switchWidow(1);
		webtest.mouseToElement("xpath=//a[@title='关于我们']/..");
		Thread.sleep(2000); 
		String mouseClick_li=webtest.getValue("xpath=//a[@title='关于我们']/..", "class");
		System.out.println("下拉方式修改为“点击展开”后，li的class值为："+mouseClick_li);
		if (mouseMove_li.equals(mouseClick_li)) {
			System.out.println("ID84 顶部设置的下拉方式修改为“点击展开”失败！");
		}else {
			System.out.println("ID84 顶部设置的下拉方式修改为“点击展开”成功！");
		}
		webtest.switchWidow(0);
		Assert.assertEquals(mouseMove_li.equals(mouseClick_li), false);
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
	
//12、	ID86 顶部设置的语言国旗开关修改为“关闭” 
	@Test(priority = 3)
	public void nationalFlagSetting() throws InterruptedException {
		Thread.sleep(2000);
		this.openTopSetting();
//		顶部设置的语言国旗开关修改为“关闭” 
		webtest.click("xpath=//label[text()='语言国旗开关']/../following-sibling::dd[1]//label[text()='关闭']");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		System.out.println("ID86 顶部设置的语言国旗开关修改为“关闭” 成功！");
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
		//恢复“网站首页”
		webtest.mouseToElement("xpath=//a[text()='首页syj']");
		webtest.click("xpath=//button[@data-index='3']");
		webtest.typeAndClear("xpath=//input[@class='form-control input-sm']", "网站首页");
		webtest.click("xpath=//i[@class='wb-check']");
		webtest.leaveFrame();
	}
	
}
