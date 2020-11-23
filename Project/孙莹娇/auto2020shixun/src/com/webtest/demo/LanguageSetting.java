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
public class LanguageSetting extends BaseTest{
	public String style;
	public String nowStyle;
	public String result;
	public void switchLanguage(String string) {
		//兄弟节点定位xpath=//span[text()='管理员在登录前可以选择后台语言']/preceding-sibling::span[1]
		webtest.click("xpath=//span[text()='"+string+"']/preceding-sibling::span[1]");
		//多语言-语言设置界面-保存、关闭
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.click("xpath=//span[text()='×']");
	}
	public void openLanguageSetting() {
		webtest.click("xpath=//a[@data-url='language']");
		webtest.click("xpath=//a[@data-url='language/setting']");
	}
	@BeforeClass
	public void loginTest() throws InterruptedException {
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.type("name=login_name",ReadProperties.getPropertyValue("username"));
		webtest.type("name=login_pass", ReadProperties.getPropertyValue("password"));
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
	}
//	ID24 语言设置-开启”后台语言切换“ 
	@Test(priority = 1)
	public void openBackLanguageSwitch() throws InterruptedException {
		//打开语言设置界面
		this.openLanguageSetting();
		style="left: 21px; transition: background-color 0.4s ease 0s, left 0.2s ease 0s; background-color: rgb(255, 255, 255);";
		nowStyle=webtest.getValue("xpath=//span[text()='管理员在登录前可以选择后台语言']/preceding-sibling::span[1]/small","style");
		
		if (nowStyle.equals(style)) {
			result="ID24:后台语言切换已是开启状态,无需再次开启。";
			webtest.click("xpath=//span[text()='×']");
		}else {
			this.switchLanguage("管理员在登录前可以选择后台语言");
			Thread.sleep(2000);
			webtest.click("xpath=//iframe[@class='page-iframe flex-fill']");
			//退出登录
			webtest.click("xpath=//span[text()='syj']");
			webtest.click("xpath=//a[text()='退出']");
			Thread.sleep(2000);
			boolean result2=webtest.isElementPresent("xpath=//label[text()='后台语言']");
			Assert.assertEquals(result2, true);
			result="ID24:后台语言切换的开启操作成功！";
			//登录
			webtest.type("name=login_name",ReadProperties.getPropertyValue("username"));
			webtest.type("name=login_pass", ReadProperties.getPropertyValue("password"));
			webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		}
		System.out.println(result);
	}
//	ID25 语言设置-关闭”语言切换“
	@Test(priority = 2)
	public void closeLanguageSwitch() throws InterruptedException {
		//打开语言设置界面
		this.openLanguageSetting();
		style="left: 0px; transition: background-color 0.4s ease 0s, left 0.2s ease 0s;";
		nowStyle=webtest.getValue("xpath=//span[text()='一般以链接形式显示在前台右上角']/preceding-sibling::span[1]/small", "style");
		
		if (style.equals(nowStyle)) {
			result="ID25:语言切换已是关闭状态,无需再次关闭。";
			webtest.click("xpath=//span[text()='×']");
		}else {
			//关闭”语言切换“
			this.switchLanguage("一般以链接形式显示在前台右上角");
			Thread.sleep(2000);
			//再次获取元素
			webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
			boolean result2=webtest.isElementPresent("xpath=//a[@class='met-lang-other']");
			Assert.assertEquals(result2, false);
			result="ID25:语言切换的关闭操作成功！";
			webtest.leaveFrame();
		}
		System.out.println(result);
	}
	
//	ID26 语言设置-关闭”繁简体自动切换“ 
	@Test(priority = 3)
	public void closeCSLanguageSwtich() throws InterruptedException {
		//打开语言设置界面
		this.openLanguageSetting();
		style="left: 0px; transition: background-color 0.4s ease 0s, left 0.2s ease 0s;";
		nowStyle=webtest.getValue("xpath=//span[text()='仅适用用于中文前台语言（语言标识为cn或zh时生效），浏览者可以在简繁体之间切换。']/preceding-sibling::span[1]/small", "style");
		
		if (style.equals(nowStyle)) {
			result="ID26:繁简体自动切换已是关闭状态，无需再次关闭";
			webtest.click("xpath=//span[text()='×']");
		}else {
			this.switchLanguage("仅适用用于中文前台语言（语言标识为cn或zh时生效），浏览者可以在简繁体之间切换。");
			Thread.sleep(2000);
			//再次获取元素
			webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
			boolean result2=webtest.isElementPresent("xpath=//div[text()='繁體']");
			Assert.assertEquals(result2, false);
			result="ID26:繁简体自动切换的关闭操作成功！";
			webtest.leaveFrame();
		}
		System.out.println(result);
	}
	
//	ID27 网站语言-添加新语言
	@Test(priority = 4)
	public void addNewLanguage() throws InterruptedException {
		webtest.click("xpath=//a[@data-url='language']");
		webtest.click("xpath=//button[@data-modal-title='添加新语言']");
		//选择韩语
		webtest.selectByValue("xpath=//select[@id='met-lang']", "ko");
		webtest.down(8);
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='modal-footer clearfix d-block']/div//button[@class='btn btn-primary']");
		//再次获取元素
		webtest.click("xpath=//a[@data-url='language']");
		Thread.sleep(2000);
		Assert.assertEquals(webtest.isElementPresent("xpath=//td[text()='韩语']"), true);
		webtest.click("xpath=//span[text()='×']");
		System.out.println("ID27:添加韩语成功！");
	}
//	ID28 对新添加的语言进行“语言操作”
	@Test(priority = 5)
	public void editLanguage() throws InterruptedException {
		webtest.click("xpath=//a[@data-url='language']");
//		对新建的序号为3的语言进行编辑操作
		List<WebElement> editBtn=webtest.getElementsList("xpath=//button[text()='编辑']");
		webtest.click(editBtn.get(2));
		Thread.sleep(2000);
		webtest.down(2);
		//将语言名称改为“韩语-syj”
		webtest.typeAndClear("xpath=//input[@name='name']", "韩语-syj");
		webtest.click("xpath=//div[@class='modal-footer clearfix d-block']/div//button[@class='btn btn-primary']");
		Assert.assertEquals(webtest.isElementPresent("xpath=//td[text()='韩语-syj']"), true);
		System.out.println("ID28:编辑成功！");
//		删除操作
		List<WebElement> deleteBtn=webtest.getElementsList("xpath=//button[text()='删除']");
		webtest.click(deleteBtn.get(2));
		webtest.click("xpath=//button[text()='确定']");
		//再次获取元素
		webtest.click("xpath=//a[@data-url='language']");
		Assert.assertEquals(webtest.isElementPresent("xpath=//td[text()='韩语-syj']"), false);
		webtest.click("xpath=//span[text()='×']");
		System.out.println("ID28:删除成功！");
	}
	
//	ID29 对序号为1 的语言进行“插件语言”操作
	@Test(priority = 6)
	public void plugInsEdit() throws InterruptedException {
		webtest.click("xpath=//a[@data-url='language']");
		Thread.sleep(2000);
		List<WebElement> plugInsBtn=webtest.getElementsList("xpath=//button[@data-modal-title='编辑插件语言']");
		System.out.println(plugInsBtn.size());
		webtest.click(plugInsBtn.get(0));
		webtest.click("xpath=//a[text()='导出语言包']");
		System.out.println("ID29:导出语言包成功！");
	}
	@AfterSuite
	public void mailUtil() throws IOException, TemplateException {
		FreeMarker freeMarker=new FreeMarker();
		freeMarker.makeReport();
		
		MailUtil m=new MailUtil();
		m.sendMail();
		
	}
	
}
