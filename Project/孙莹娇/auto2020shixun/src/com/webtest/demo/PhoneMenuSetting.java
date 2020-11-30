package com.webtest.demo;

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
import com.webtest.utils.FreeMarker;
import com.webtest.utils.MailUtil;
import com.webtest.utils.ReadProperties;

import freemarker.template.TemplateException;
@Listeners(JavaMailTestListener.class)
public class PhoneMenuSetting extends BaseTest{
	@BeforeClass
	public void loginTest() throws InterruptedException {
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.type("name=login_name",ReadProperties.getPropertyValue("username"));
		webtest.type("name=login_pass", ReadProperties.getPropertyValue("password"));
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
	}
	public void openPhoneMenuSetting() {
		webtest.click("xpath=//button[text()='风格']");
		webtest.click("xpath=//a[text()='手机菜单']");
	}
//25、	ID184 手机菜单-按钮文字修改 
	@Test(priority = 1)
	public void editBtnText() throws InterruptedException {
//		打开“手机菜单”设置界面方法一：
//		鼠标移动到 手机菜单 div上，点击“内容”按钮
//		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
//		webtest.mouseToElement("xpath=//div[@class='met-menu-list text-xs-center     iskeshi set']");
//		webtest.click("xpath=//button[@data-type='menu']");
//		webtest.leaveFrame();
//		打开“手机菜单”设置界面方法二：
		this.openPhoneMenuSetting();
		//修改第一个按钮文字“首页”为“手机首页”
		webtest.typeAndClear("xpath=//input[@value='首页']", "手机首页");
		//保存、关闭
		webtest.click("xpath=//tfoot/tr/th[2]//button[@class='btn btn-primary']");	
		webtest.click("xpath=//span[text()='×']");
		//返回前台页面验证修改
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
//		List<WebElement> btnTextList=webtest.getElementsList("xpath=//div[@class='met-menu-list text-xs-center     iskeshi set']/div//span");
//		WebElement homeText=webtest.getElement("xpath=//span[text()='联系']");
//		System.out.println("修改后的按钮文字为："+homeText.getText());
//		Assert.assertEquals(homeText.getText(), "手机首页");
		System.out.println(webtest.isElementPresent("xpath=//span[text()='手机首页']"));
		webtest.leaveFrame();
		Thread.sleep(2000);
		System.out.println("ID184 手机菜单-按钮文字修改 成功！");
	}
//26、	ID185 手机菜单-链接修改 
//	修改“联系”按钮的链接为https://www.baidu.com/
	@Test(priority = 2)
	public void editBtnUrl() throws InterruptedException {
		//打开“手机菜单”设置界面
		this.openPhoneMenuSetting();
		//修改链接
		webtest.typeAndClear("xpath=//input[@value='联系']/../../following-sibling::td[1]/input", "https://www.baidu.com/");
		//保存、关闭
		webtest.click("xpath=//tfoot/tr/th[2]//button[@class='btn btn-primary']");	
		webtest.click("xpath=//span[text()='×']");
		//进入前台页面验证修改
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		webtest.click("xpath=//span[text()='联系']");
		Thread.sleep(5000);
		boolean status= webtest.isElementPresent("xpath=//div[text()='百度热榜']");
		System.out.println("是否进入百度页面："+status);
		Assert.assertEquals(status, true);
		webtest.goBack();
		webtest.leaveFrame();
		System.out.println("ID184  手机菜单-链接修改  成功！");
	}
//27、ID186 手机菜单-图标删除 	
	@Test(priority = 3)
	public void deleteBtnImg() {
		//打开“手机菜单”设置界面
		this.openPhoneMenuSetting();
		//点击“新闻”的图标的删除按钮
		webtest.click("xpath=//input[@value='新闻']/../../following-sibling::td[2]/div[2]/button");
		//保存、关闭
		webtest.click("xpath=//tfoot/tr/th[2]//button[@class='btn btn-primary']");	
		webtest.click("xpath=//span[text()='×']");
		//进入前台页面验证修改
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		WebElement newsImgElement=webtest.getElement
				("xpath=//span[text()='新闻']/preceding-sibling::i[1]");
		Assert.assertEquals(newsImgElement.getText(), "");
		webtest.leaveFrame();
		System.out.println("ID186 手机菜单-新闻图标删除成功！");
	}	
//28、ID187 手机菜单-图标修改	
	@Test(priority = 4)
	public void editBtnImg() {
		//打开“手机菜单”设置界面
		this.openPhoneMenuSetting();
		//点击“新闻”的图标的删除按钮
		webtest.click("xpath=//input[@value='新闻']/../../following-sibling::td[2]/div[2]//button[text()='选择图标']");
		//选择web-icons图标库的grid-9图标
		webtest.click("xpath=//h2[text()='web-icons']/following-sibling::button[1]");
		webtest.click("xpath=//div[text()='grid-9']");
		//保存
		List<WebElement> submitBtns=webtest.getElementsList("xpath=//button[text()='保存']");
		webtest.click(submitBtns.get(1));
		//保存、关闭
		webtest.click("xpath=//tfoot/tr/th[2]//button[@class='btn btn-primary']");	
		webtest.click("xpath=//span[text()='×']");
		//进入前台页面验证修改
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		WebElement newsImgElement=webtest.getElement
				("xpath=//span[text()='新闻']/preceding-sibling::i[1]");
		Assert.assertEquals(webtest.getValue(newsImgElement, "class"),"icon wb-grid-9");
		webtest.leaveFrame();
		System.out.println("ID186 手机菜单-新闻的图标修改成功！");
		
	}
//29、ID188 手机菜单-按钮颜色修改
	@Test(priority = 5)
	public void editBtnColor() {
		//打开“手机菜单”设置界面
		this.openPhoneMenuSetting();
		//修改“产品”的按钮颜色为#1bdb51
		webtest.typeAndClear("xpath=//input[@value='产品']/../../following-sibling::td[3]/div/input", "#1bdb51");
		//保存、关闭
		webtest.click("xpath=//tfoot/tr/th[2]//button[@class='btn btn-primary']");	
		webtest.click("xpath=//span[text()='×']");
		//进入前台页面验证修改
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		WebElement productBtnDiv=webtest.getElement
				("xpath=//span[text()='产品']/preceding-sibling::i[1]/../..");
		Assert.assertEquals(webtest.getValue(productBtnDiv, "style"),"background-color: rgb(27, 219, 81);");
		webtest.leaveFrame();
		System.out.println("ID186 手机菜单-产品的按钮颜色修改成功！");
	}
//30、ID189 手机菜单-文字颜色修改
	@Test(priority = 6)
	public void editTextColor() {
		//打开“手机菜单”设置界面
		this.openPhoneMenuSetting();
		//修改“联系”按钮的文字颜色为#1bdb51
		webtest.typeAndClear("xpath=//input[@value='联系']/../../following-sibling::td[4]/div/input", "#1bdb51");
		//保存、关闭
		webtest.click("xpath=//tfoot/tr/th[2]//button[@class='btn btn-primary']");	
		webtest.click("xpath=//span[text()='×']");
		//进入前台页面验证修改
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		WebElement productBtnDiv=webtest.getElement
				("xpath=//span[text()='联系']/preceding-sibling::i[1]/..");
		Assert.assertEquals(webtest.getValue(productBtnDiv, "style"),"color: rgb(27, 219, 81);");
		webtest.leaveFrame();
		System.out.println("ID189 手机菜单-产品按钮的文字颜色修改成功！");
	}
//31、ID190 手机菜单-启用修改
	@Test(priority = 7)
	public void editEnable() {
		//打开“手机菜单”设置界面，修改“新闻”按钮的启用
		this.openPhoneMenuSetting();
		String newsEnable=webtest.getValue("xpath=//input[@value='新闻']/../../following-sibling::td[5]/select", "data-checked");
		if (newsEnable.equals("1")) {
			webtest.selectByValue("xpath=//input[@value='新闻']/../../following-sibling::td[5]/select", "0");
			//保存、关闭
			webtest.click("xpath=//tfoot/tr/th[2]//button[@class='btn btn-primary']");	
			webtest.click("xpath=//span[text()='×']");
			//进入前台页面验证修改
			webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
			System.out.println("新闻按钮是否已启用："+webtest.isElementPresent("xpath=//span[text()='新闻']"));
			Assert.assertEquals(webtest.isElementPresent("xpath=//span[text()='新闻']"),false);
			webtest.leaveFrame();
			System.out.println("ID190 手机菜单-启用修改-新闻按钮已成功关闭启用！");
		}
		if(newsEnable.equals("0")){
			webtest.selectByValue("xpath=//input[@value='新闻']/../../following-sibling::td[5]/select", "1");
			//保存、关闭
			webtest.click("xpath=//tfoot/tr/th[2]//button[@class='btn btn-primary']");	
			webtest.click("xpath=//span[text()='×']");
			//进入前台页面验证修改
			webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
			System.out.println("新闻按钮是否已启用："+webtest.isElementPresent("xpath=//span[text()='新闻']"));
			Assert.assertEquals(webtest.isElementPresent("xpath=//span[text()='新闻']"),true);
			webtest.leaveFrame();
			System.out.println("ID190 手机菜单-启用修改-新闻按钮已成功开启启用！");
		}
	}
//32、	ID191 手机菜单-按钮顺序修改
	@Test(priority = 8)
	public void edtiBtnTurns() throws InterruptedException {
		//打开“手机菜单”设置界面
		this.openPhoneMenuSetting();
		//获取表格集合，以便拖拽
		List<WebElement> formGroup=webtest.getElementsList("xpath=//tr[@role='row']");
		System.out.println("formGroup:"+formGroup.size());
		
		//获得拖拽前的最后一个按钮的文字
		String beforeDrag_lastBtn=webtest.getValue("xpath=//tbody/tr[last()]/child::td[2]//input", "value");
		System.out.println("beforeDrag_lastBtn:"+beforeDrag_lastBtn);
				
		//将最后一个表格拖拽到第一的位置
		webtest.dragAndDrop(formGroup.get(formGroup.size()-1),formGroup.get(0));
		Thread.sleep(2000);
		//保存、关闭
		webtest.click("xpath=//tfoot/tr/th[2]//button[@class='btn btn-primary']");	
		webtest.click("xpath=//span[text()='×']");
		//进入前台页面验证修改
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		//验证拖拽是否对前台页面起作用
		List<WebElement> afterDrag_btnText=webtest.getElementsList("xpath=//div[@class='met-menu-list text-xs-center     iskeshi set']//span");
		System.out.println(afterDrag_btnText.size());
		String afterDrag_firstBtn=afterDrag_btnText.get(0).getText();
		System.out.println("拖拽前，最后一个按钮文字为："+beforeDrag_lastBtn);
		System.out.println("拖拽后前台页面的第一个按钮文字为："+afterDrag_firstBtn);
		//预期：拖拽前最后一个按钮文字 和 拖拽后前台页面的第一个按钮文字相同
		if (beforeDrag_lastBtn.equals(afterDrag_btnText)) {
			System.out.println("ID191  手机菜单按钮顺序调整成功！");
		}else {
			System.out.println("ID191 手机菜单按钮顺序调整失败！");
		}
		Assert.assertEquals(beforeDrag_lastBtn, afterDrag_firstBtn);
	}
			
//	@AfterSuite
	public void mailUtil() throws IOException, TemplateException {
		FreeMarker freeMarker=new FreeMarker();
		freeMarker.makeReport();
		
		MailUtil m=new MailUtil();
		m.sendMail();
	}
		
}
