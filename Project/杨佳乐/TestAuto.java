package test;

import org.testng.annotations.Test;

import driver.BaseTest;

public class TestAuto extends BaseTest{
	//进入在线留言界面
	public void email() throws InterruptedException {
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@class='editable-click']");
		Thread.sleep(1000);
//		webtest.leaveFrame();
	}
	
	//1，成功添加测试在线留言
	//提交信息用的绝对路径
	@Test
	public void yjltest1() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']","杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']","1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']","18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']","河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']","好");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']","aaaa");
		Thread.sleep(1000);
		webtest.click("xpath=//button[@class='btn btn-xs btn-warning pageset-content']");
		webtest.click("xpath=/html/body/section[2]/div/div/div[2]/div/div/form/div[7]/button");
		Thread.sleep(3000);
	}
	
	//2，成功在前台显示留言
	@Test
	public void yjltest2() throws InterruptedException {
		email();
		
//		WebDriver driver=null;
//		driver.findElements(By.xpath("//button[@class='btn btn-xs btn-warning pageset-content']")).get(4).click();
//		webtest.click("xpath=//button[@class='btn btn-xs btn-warning pageset-content']");
		Thread.sleep(1000);
	}
	
	//3，添加在线留言失败，添加Email格式错误
	@Test
	public void yjltest3() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']","杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']","1");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']","18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']","河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']","好");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']","aaaa");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/section[2]/div/div/div[2]/div/div/form/div[7]/button");
		Thread.sleep(3000);
	}
	
	//4,添加在线留言失败，姓名为空
	@Test
	public void yjltest4() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']","");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']","1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']","18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']","河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']","好");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']","aaaa");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/section[2]/div/div/div[2]/div/div/form/div[7]/button");
		Thread.sleep(3000);
	}
	
	//5,添加在线留言失败,联系电话格式错误
	@Test
	public void yjltest5() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']","杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']","1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']","1");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']","河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']","好");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']","aaaa");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/section[2]/div/div/div[2]/div/div/form/div[7]/button");
		Thread.sleep(3000);
	}
	
	//6，添加在线留言失败，联系地址为空
	@Test
	public void yjltest6() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']","杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']","1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']","");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']","河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']","好");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']","aaaa");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/section[2]/div/div/div[2]/div/div/form/div[7]/button");
		Thread.sleep(3000);
	}
	
	//7,添加在线留言失败，联系地址为空
	@Test
	public void yjltest7() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']","杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']","1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']","18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']","");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']","好");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']","aaaa");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/section[2]/div/div/div[2]/div/div/form/div[7]/button");
		Thread.sleep(3000);
	}
}
