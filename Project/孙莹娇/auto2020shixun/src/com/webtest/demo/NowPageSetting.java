package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.JavaMailTestListener;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.utils.FreeMarker;
import com.webtest.utils.MailUtil;
import com.webtest.utils.ReadProperties;

import freemarker.template.TemplateException;

public class NowPageSetting extends BaseTest {

	public void chooseLocalImg(String fileName,String imgTitle) throws InterruptedException {
		webtest.doubleClick("xpath=//a[@data-path='/upload/"+fileName+"']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@title='"+imgTitle+"']");
		webtest.click("xpath=//div[@class='modal-dialog modal-dialog- modal-xl my-0 mx-auto h-100']/div//button[@class='btn btn-primary']");
	}
//1、	ID20 当前页设置网站基本信息设置
	@Test(priority = 1,dataProvider = "logoInfoExcel",dataProviderClass =NSDataProvider.class)
	public void siteInfoSetting1(String logoInfo) throws InterruptedException {
		//点击顶部“当前页设置”
		webtest.click("xpath=//a[@title='当前页面系统参数设置']");
//		修改网站名称为 ‘SYJ的网站’
		webtest.typeAndClear("name=met_webname","SYJ的网站" );
		
//		修改网站LOGO为从图片库中任选一张图片
		List<WebElement> chooseImgBtnList=webtest.getElementsList("xpath=//button[text()='从图片库选择']");
		webtest.click(chooseImgBtnList.get(0));
		Thread.sleep(2000);
		this.chooseLocalImg("201807", logoInfo);
		
//		修改手机LOGO为从图片库中任选一张图片
		webtest.click("xpath=//label[text()='手机站LOGO']");
		webtest.down(6);
		Thread.sleep(2000);
		webtest.click(chooseImgBtnList.get(1));
		Thread.sleep(2000);
		this.chooseLocalImg("201807", logoInfo);
		
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
	
//2、	ID22 “添加外部图片”替换网站LOGO和手机站LOGO
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
	
//3、	ID23 “选择文件夹上传”图片替换网站LOGO、手机站LOGO和地址栏图标
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
//22、	ID174 当前页设置-基本信息-底部信息设置-基本信息修改
	//在版权信息、地址邮编和联系方式后均填入“syj123”，点击保存
	@Test(priority = 4)
	public void setBottomInf() throws InterruptedException {
		//点击顶部“当前页设置”
		webtest.click("xpath=//a[@title='当前页面系统参数设置']");
		//页面向下滑动
		webtest.click("xpath=//h3[text()='网站基本信息设置']");
		webtest.down(15);
		//修改 版权信息、地址邮编和联系方式
		String met_footright="我的网站 版权所有 2008-2014 湘ICP备8888888syj123";
		String met_footaddress="本页面内容为网站演示数据，前台页面内容都可以在后台修改。syj123";
		String met_foottel="syj123456789";
		webtest.typeAndClear("xpath=//input[@name='met_footright']", met_footright);
		webtest.typeAndClear("xpath=//input[@name='met_footaddress']", met_footaddress);
		webtest.typeAndClear("xpath=//input[@name='met_foottel']", met_foottel);
		//点击保存
		webtest.mouseToElement("xpath=//dl[@class='position-absolute form-submit-position bg-white']");
		webtest.click("xpath=//button[@class='btn btn-primary']");	
		webtest.click("xpath=//span[text()='×']");
		//进入前台页面，验证修改是否成功
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		webtest.runJs("window.scrollTo(0, document.body.scrollHeight);");
		List<WebElement> bottomInfoList=webtest.getElementsList("xpath=//div[@class='container text-xs-center']/*");
		for (int i = 0; i < 3; i++) {
			System.out.println(bottomInfoList.get(i).getText());
		}
		Assert.assertEquals(bottomInfoList.get(0).getText(), met_footright);
		Assert.assertEquals(bottomInfoList.get(1).getText(), met_footaddress);
		Assert.assertEquals(bottomInfoList.get(2).getText(), met_foottel);
		webtest.leaveFrame();
		System.out.println("ID174 底部信息设置,版权信息、地址邮编和联系方式修改成功！");
	}
//23、ID175 当前页设置-基本信息-底部信息设置-其他信息修改 	
	@Test(priority = 5)
	public void setBottomOtherInf() throws InterruptedException {
		//点击顶部“当前页设置”
		String otherInf="测试其他信息123";
		webtest.click("xpath=//a[@title='当前页面系统参数设置']");
		webtest.click("xpath=//h3[text()='网站基本信息设置']");
		webtest.down(18);
		webtest.enterFrame("ueditor_0");
		webtest.typeAndClear("tag=body",otherInf );
		webtest.leaveFrame();
		//点击保存
		webtest.mouseToElement("xpath=//dl[@class='position-absolute form-submit-position bg-white']");
		webtest.click("xpath=//button[@class='btn btn-primary']");	
		webtest.click("xpath=//span[text()='×']");
		//进入前台页面，验证修改是否成功
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		webtest.runJs("window.scrollTo(0, document.body.scrollHeight);");
		List<WebElement> bottomInfoList=webtest.getElementsList("xpath=//div[@class='container text-xs-center']/*");
		System.out.println("修改后的其他信息为"+bottomInfoList.get(3).getText());
		Assert.assertEquals(bottomInfoList.get(3).getText(), otherInf);
		webtest.leaveFrame();
		System.out.println("ID175 底部其他信息修改成功！");
	}
//24、	ID176 当前页设置-基本信息-底部信息设置-系统版权文字风格修改
//	设置系统版权文字风格为第二个选项
	@Test(priority = 6)
	public void setTextStyle() throws InterruptedException {
		//点击顶部“当前页设置”
		webtest.click("xpath=//a[@title='当前页面系统参数设置']");
		//页面下滑
		webtest.click("xpath=//h3[text()='网站基本信息设置']");
		webtest.down(19);
		//选择第二个系统版权文字风格
		webtest.click("xpath=//label[text()='系统版权文字风格']/../following-sibling::dd[1]/div/div[2]/input");
		//点击保存
		webtest.mouseToElement("xpath=//dl[@class='position-absolute form-submit-position bg-white']");
		webtest.click("xpath=//button[@class='btn btn-primary']");	
		webtest.click("xpath=//span[text()='×']");
		//进入前台页面，验证修改是否成功
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		webtest.runJs("window.scrollTo(0, document.body.scrollHeight);");
		List<WebElement> bottomInfoList=webtest.getElementsList("xpath=//div[@class='container text-xs-center']/*");
		System.out.println("修改后的的系统版权文字风格为："+bottomInfoList.get(bottomInfoList.size()-2).getText());
		Assert.assertEquals(bottomInfoList.get(bottomInfoList.size()-1).getText(), "本站基于 米拓企业建站系统 7.1.0 搭建");
		System.out.println("ID176 设置系统版权文字风格为第二个选项成功！");
	}
}
