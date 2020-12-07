package test;

import org.testng.annotations.Test;
import dataprovide.NSDataProvider;
import driver.BaseTest;

/**
 * 
 * @author 杨佳乐
 * 数据驱动的例子
 *
 */

public class TestDemo extends BaseTest{
	@Test(dataProvider = "excel",dataProviderClass = NSDataProvider.class)
	public void test1(String text,String text1,String text2,String text3) throws InterruptedException {
		webtest.open("http://localhost:99/admin");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@class='editable-click']");
		Thread.sleep(1000);
		webtest.mouseToElement("xpath=//div[@m-id='message_form']");
		webtest.down(4);
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para137']", text);
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']", "1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']","18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']",text1);
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']", text2);
		Thread.sleep(2000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']", text3);
		Thread.sleep(1000);
		webtest.mouseToElement("xpath=//div[@class='form-group m-b-0']");
		webtest.runJs(
				"document.getElementsByClassName('btn btn-primary btn-block btn-squared editable-click set')[0].className=''");
		webtest.mouseToElementandClick("xpath=//button[text()='提交留言']");
		Thread.sleep(3000);
		webtest.alertAccept();
		Thread.sleep(2000);
	}
	
}
