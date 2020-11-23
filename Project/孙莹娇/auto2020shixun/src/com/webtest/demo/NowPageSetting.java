package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.WebElement;
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
public class NowPageSetting extends BaseTest {
	@BeforeClass
	public void loginTest() throws InterruptedException {
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.type("name=login_name",ReadProperties.getPropertyValue("username"));
		webtest.type("name=login_pass", ReadProperties.getPropertyValue("password"));
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
	}
	public void chooseLocalImg(String fileName,String imgTitle) throws InterruptedException {
		webtest.doubleClick("xpath=//a[@data-path='/upload/"+fileName+"']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@title='"+imgTitle+"']");
		webtest.click("xpath=//div[@class='modal-dialog modal-dialog- modal-xl my-0 mx-auto h-100']/div//button[@class='btn btn-primary']");
	}
//	ID20 当前页设置网站基本信息设置
	@Test(priority = 1)
	public void siteInfoSetting1() throws InterruptedException {
		//点击顶部“当前页设置”
		webtest.click("xpath=//a[@title='当前页面系统参数设置']");
//		修改网站名称为 ‘SYJ的网站’
		webtest.typeAndClear("name=met_webname","SYJ的网站" );
		
//		修改网站LOGO为从图片库中任选一张图片
		List<WebElement> chooseImgBtnList=webtest.getElementsList("xpath=//button[text()='从图片库选择']");
		webtest.click(chooseImgBtnList.get(0));
		Thread.sleep(2000);
		this.chooseLocalImg("201807", "1532139830.png");
		
//		修改手机LOGO为从图片库中任选一张图片
		webtest.click("xpath=//label[text()='手机站LOGO']");
		webtest.down(6);
		Thread.sleep(2000);
		webtest.click(chooseImgBtnList.get(1));
		Thread.sleep(2000);
		this.chooseLocalImg("201807", "1532139830.png");
		
//		添加网站关键词为“,关键词syj”
		webtest.runJs("window.scrollTo(0, document.body.scrollHeight)");
		webtest.type("name=met_keywords", ",关键词syj");
//		在原有的网站描述后添加“基本信息20”
		webtest.type("name=met_description", "网站描述syj。");
		Thread.sleep(3000);
//		点击保存
		webtest.mouseToElement("xpath=//dl[@class='position-absolute form-submit-position bg-white']");
		webtest.click("xpath=//button[@class='btn btn-primary']");	
		webtest.click("xpath=//span[text()='×']");
//		网站首页的图片LOGO、网站名称、关键词和描述做出相应改变		
		Thread.sleep(2000);
		System.out.println("ID20 前页设置网站基本信息设置修改成功！");
	}
	
//	ID22 “添加外部图片”替换网站LOGO和手机站LOGO
	@Test(priority = 2)
	public void otherImg() throws InterruptedException {
		webtest.click("xpath=//a[@title='当前页面系统参数设置']");
		List<WebElement> chooseImgBtnList=webtest.getElementsList("xpath=//button[text()='添加外部图片']");
		//替换网站LOGO
		webtest.click(chooseImgBtnList.get(0));
		Thread.sleep(2000);
		webtest.type("name=img_url", "https://www.baidu.com/img/flexible/logo/pc/result.png");
		//添加外部图片界面-保存、关闭
		webtest.click("xpath=//div[@class='modal-dialog modal-dialog-centered modal- ']/div//button[@class='btn btn-primary']");
		
		//替换手机站LOGO
		webtest.click(chooseImgBtnList.get(1));
		Thread.sleep(2000);
		webtest.type("name=img_url", "https://www.baidu.com/img/flexible/logo/pc/result.png");
		//添加外部图片界面-保存、关闭
		webtest.click("xpath=//div[@class='modal-dialog modal-dialog-centered modal- ']/div//button[@class='btn btn-primary']");
		
		//基本信息界面-保存、关闭
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.click("xpath=//span[text()='×']");
		System.out.println("ID22 “添加外部图片”替换网站LOGO和手机站LOGO成功！");
	}
	
//	ID23 “选择文件夹上传”图片替换网站LOGO、手机站LOGO和地址栏图标
	@Test(priority = 3)
	public void localImg() throws InterruptedException {
		webtest.click("xpath=//a[@title='当前页面系统参数设置']");
		webtest.down(6);
		List<WebElement> inputElements=webtest.getElementsList("xpath=//input[@type='file']");
		//替换网站LOGO
		webtest.type(inputElements.get(0), "D:\\demo\\OIP.jpg");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-primary']");	
		//替换手机站LOGO
		webtest.type(inputElements.get(1), "D:\\demo\\OIP.jpg");
		Thread.sleep(2000);
		//替换地址栏图标
		webtest.type(inputElements.get(2), "E:\\D3\\project-training\\MetInfo7.1.0\\bitbug_favicon.ico");
		Thread.sleep(2000);
		
		//基本信息界面-保存、关闭
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.click("xpath=//span[text()='×']");
		System.out.println("ID23 “选择文件夹上传”图片替换网站LOGO、手机站LOGO和地址栏图标成功！");
	}
	@AfterSuite
	public void mailUtil() throws IOException, TemplateException {
		FreeMarker freeMarker=new FreeMarker();
		freeMarker.makeReport();
		
		MailUtil m=new MailUtil();
		m.sendMail();
		
	}
}
