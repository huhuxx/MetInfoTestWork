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
@Listeners(JavaMailTestListener.class)
public class DataDownload extends BaseTest{
	public void openDataDowmloadSetting() {
		webtest.click("xpath=//a[text()='内容']");
		webtest.click("xpath=//span[text()='资料下载']");
	}
//47、ID207 内容管理-资料下载-编辑
	@Test(priority = 1)
	public void editData() throws InterruptedException {
		//进入内容管理-资料下载界面
		this.openDataDowmloadSetting();
		//点击标题为“产品说明书”的列表的编辑按钮
		webtest.click("xpath=//a[text()='产品使用说明书']/../following-sibling::td[5]//button[text()='编辑']");
		//修改标题为“产品使用说明书syj”
		webtest.typeAndClear("xpath=//h3[text()='基本信息']/following-sibling::dl[2]//input[@name='title']", "产品使用说明书syj");
		//保存、关闭
		List<WebElement> submitBtns=webtest.getElementsList("xpath=//button[text()='保存']");
		webtest.click(submitBtns.get(1));
		Thread.sleep(3000);
		webtest.click("xpath=//button[text()='关闭']");
		//进入前台页面验证修改
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		webtest.click("xpath=//span[text()='资料下载']");
		Assert.assertEquals(webtest.isElementPresent("xpath=//span[text()='产品使用说明书syj']"),true );
		webtest.leaveFrame();
		System.out.println("ID207 内容管理-资料下载-编辑 成功！");
		
		//进入内容管理-资料下载界面，将“产品说明书”标题修改回来，以便下次测试
		this.openDataDowmloadSetting();
		//点击标题为“产品说明书”的列表的编辑按钮
		webtest.click("xpath=//a[text()='产品使用说明书syj']/../following-sibling::td[5]//button[text()='编辑']");
		//修改标题为“产品说使用明书”
		webtest.typeAndClear("xpath=//h3[text()='基本信息']/following-sibling::dl[2]//input[@name='title']", "产品使用说明书");
		//保存、关闭
		List<WebElement> submitBtns2=webtest.getElementsList("xpath=//button[text()='保存']");
		webtest.click(submitBtns2.get(1));
		Thread.sleep(3000);
		webtest.click("xpath=//button[text()='关闭']");
		
	}
//48、ID208 内容管理-资料下载-访问量验证  
	@Test(priority = 2)
	public void visitNum() throws InterruptedException {
		//进入内容管理-资料下载界面
		Thread.sleep(2000);
		this.openDataDowmloadSetting();
		//变量count记录“产品使用说明书”的访问量
		String beforeVisitNum=webtest.getElement("xpath=//a[text()='产品使用说明书']/../following-sibling::td[1]").getText();
		System.out.println(beforeVisitNum);
		int count=Integer.parseInt(beforeVisitNum);
		System.out.println("“产品使用说明书”访问操作前的访问量为："+count);	
		//关闭界面
		webtest.click("xpath=//button[text()='关闭']");
		//进入前台页面，点击“资料下载”，再点击“产品使用说明书syj”
		Thread.sleep(2000);
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		webtest.click("xpath=//span[text()='资料下载']");
		Thread.sleep(2000);
		webtest.click("xpath=//span[text()='产品使用说明书']");
		webtest.leaveFrame();
		//进入内容管理-资料下载界面，验证访问量是否增加
		this.openDataDowmloadSetting();
		String afterVisitNum=webtest.getElement("xpath=//a[text()='产品使用说明书']/../following-sibling::td[1]").getText();
		System.out.println("“产品使用说明书”访问操作后的访问量为："+Integer.parseInt(afterVisitNum));
		Assert.assertEquals(count+1, Integer.parseInt(afterVisitNum));
		//关闭界面
		webtest.click("xpath=//button[text()='关闭']");
		System.out.println("ID208 内容管理-资料下载-访问量验证成功！");
	}
//49、	ID209 内容管理-资料下载-复制
	@Test(priority = 3)
	public void dataCopy() throws InterruptedException {
		//复制前
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		webtest.click("xpath=//span[text()='资料下载']");
		List<WebElement> beforeCopy_dataList=webtest.getElementsList("xpath=//span[text()='产品使用说明书']");
		System.out.println("复制前，产品使用说明书的数量为："+beforeCopy_dataList.size());
		Assert.assertEquals(webtest.isElementPresent("xpath=//span[text()='产品使用说明书']"),true );
		webtest.leaveFrame();
		//进入内容管理-资料下载界面
		this.openDataDowmloadSetting();
		//选中“产品使用说明书”，点击复制，选择“简体中文，点击弹出的“资料下载”
		webtest.click("xpath=//a[text()='产品使用说明书']/../preceding-sibling::td[1]/div");
		webtest.click("xpath=//button[text()='复制']");
		webtest.click("xpath=//a[text()='简体中文']");
		Thread.sleep(2000);
		//复制到“资料下载”
		webtest.click("xpath=//div[@class='dropup d-inline-block contentlist-copy-list show']/div[1]");
		//关闭当前页面
		webtest.click("xpath=//button[text()='关闭']");
		//复制后，进入前台页面验证修改
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		webtest.click("xpath=//span[text()='资料下载']");
		Thread.sleep(2000);
		List<WebElement> afterCopy_dataList=webtest.getElementsList("xpath=//span[text()='产品使用说明书']");
		System.out.println("产品使用说明书的数量为："+afterCopy_dataList.size());
		Assert.assertEquals(beforeCopy_dataList.size()+1,afterCopy_dataList.size());
		webtest.leaveFrame();
		System.out.println("ID209 内容管理-资料下载-复制成功！");
	}
//50、ID213 内容管理-资料下载-添加内容  
	@Test(priority = 4)
	public void addData() throws InterruptedException {
		//进入内容管理-资料下载0o界面
		this.openDataDowmloadSetting();
		//点击“添加内容”按钮
		webtest.click("xpath=//button[text()='添加内容']");		
		//填写标题为“图片资料”
		webtest.type("xpath=//input[@name='title']", "图片资料");
		//填写下载地址为“https://www.baidu.com/img/flexible/logo/pc/result@2.png”
		webtest.type("xpath=//input[@name='downloadurl']","https://www.baidu.com/img/flexible/logo/pc/result@2.png" );
		//保存
//		List<WebElement> submitBtns=webtest.getElementsList("xpath=//button[text()='保存']");
//		webtest.click(submitBtns.get(1));
//		webtest.click(locator);

		Thread.sleep(3000);
		webtest.click("xpath=//button[text()='关闭']");
	
		//进入前台页面验证
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		webtest.click("xpath=//span[text()='资料下载']");
		Thread.sleep(2000);
		boolean imgData=webtest.isElementPresent("xpath=//span[text()='图片资料']");
		System.out.println("图片资料是否存在："+imgData);
		Assert.assertEquals(imgData,true);
		webtest.leaveFrame();
		System.out.println("ID213 内容管理-资料下载-添加内容  成功！");
	}
//51、ID210 内容管理-资料下载-删除	
	@Test(priority = 5)
	public void deleteData() throws InterruptedException {
		//进入内容管理-资料下载界面
		this.openDataDowmloadSetting();
		//选中“图片资料”，点击其删除按钮
		webtest.click("xpath=//a[text()='图片资料']/../following-sibling::td[5]//button[text()='删除']");
		webtest.click("xpath=//button[text()='彻底删除']");
		//关闭当前页面
		webtest.click("xpath=//button[text()='关闭']");
		//进入前台页面验证
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		webtest.click("xpath=//span[text()='资料下载']");
		Thread.sleep(2000);
		boolean imgData=webtest.isElementPresent("xpath=//span[text()='图片资料']");
		System.out.println("图片资料是否存在："+imgData);
		Assert.assertEquals(imgData,false);
		webtest.leaveFrame();
		System.out.println("ID213 内容管理-资料下载-删除  成功！");
	}
//	@AfterSuite
	public void mailUtil() throws IOException, TemplateException {
		FreeMarker freeMarker=new FreeMarker();
		freeMarker.makeReport();
		
		MailUtil m=new MailUtil();
		m.sendMail();
		
	}
}
