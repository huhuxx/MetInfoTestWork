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
		webtest.mouseToElement("xpath=//div[@m-id='message_form']");
		webtest.down();
		Thread.sleep(2000);
	}
	
	//提交留言
	public void sub() throws InterruptedException {
		webtest.mouseToElement("xpath=//div[@class='form-group m-b-0']");
		webtest.runJs("document.getElementsByClassName('btn btn-primary btn-block btn-squared editable-click set')[0].className=''");
		webtest.mouseToElementandClick("xpath=//button[text()='提交留言']");
		Thread.sleep(3000);
	}
	
	//1，成功添加测试在线留言
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
		Thread.sleep(2000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']","aaaa");
		Thread.sleep(1000);
		sub();
	}
	
	//2，成功在前台显示留言
	@Test
	public void yjltest2() throws InterruptedException {
		email();
		webtest.mouseToElementandClick("xpath=//button[text()='内容']");
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
		sub();
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
		sub();
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
		sub();
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
		sub();
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
		sub();
	}
	
	//8,添加在线留言失败,留言内容为空
	@Test
	public void yjltest8() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']","杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']","1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']","18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']","河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']","");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']","aaaa");
		Thread.sleep(1000);
		sub();
	}
	
	//9,添加在线留言失败,Email格式错误（输入的是1837519045@qq.com11111）
	@Test
	public void yjltest9() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']","杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']","1837519045@qq.com11111");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']","18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']","河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']","好");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']","aaaa");
		Thread.sleep(1000);
		sub();
	}
	
	//10，添加在线留言失败，验证码为空
	@Test
	public void yjltest10() throws InterruptedException {
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
		webtest.type("xpath=//input[@class='form-control input-codeimg']","");
		Thread.sleep(1000);
		sub();
	}
	
	//11，添加在线留言失败，验证码错误
	@Test
	public void yjltest11() throws InterruptedException {
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
		webtest.type("xpath=//input[@class='form-control input-codeimg']","bbbb");
		Thread.sleep(1000);
		sub();
	}
	
	//12,留言在前台不显示
	@Test
	public void yjltest12() {
		
	}
	
	//13,回复留言并且不在前台界面显示
	@Test
	public void yjltest13() {
		
	}
	
	//14,后台成功删除留言
	@Test
	public void yjltest14() {
		
	}
	
	//15,修改前台显示留言的方式
	@Test
	public void yjltest15() {
		
	}
	
	//16,
	@Test
	public void yjltest16() {
		
	}
	@Test
	public void yjltest17() {
		
	}
	@Test
	public void yjltest18() {
		
	}
	@Test
	public void yjltest19() {
		
	}
	@Test
	public void yjltest20() {
		
	}
	@Test
	public void yjltest21() {
		
	}
	@Test
	public void yjltest22() {
		
	}
	@Test
	public void yjltest23() {
		
	}
	@Test
	public void yjltest24() {
		
	}
	@Test
	public void yjltest25() {
		
	}
	@Test
	public void yjltest26() {
		
	}
	@Test
	public void yjltest27() {
		
	}
	@Test
	public void yjltest28() {
		
	}
	@Test
	public void yjltest29() {
		
	}
	@Test
	public void yjltest30() {
		
	}
	@Test
	public void yjltest31() {
		
	}
	@Test
	public void yjltest32() {
		
	}
	@Test
	public void yjltest33() {
		
	}
	@Test
	public void yjltest34() {
		
	}
	@Test
	public void yjltest35() {
		
	}
	@Test
	public void yjltest36() {
		
	}
	@Test
	public void yjltest37() {
		
	}
	@Test
	public void yjltest38() {
		
	}
	@Test
	public void yjltest39() {
		
	}
	@Test
	public void yjltest40() {
		
	}
	@Test
	public void yjltest41() {
		
	}
	@Test
	public void yjltest42() {
		
	}
	@Test
	public void yjltest43() {
		
	}
	@Test
	public void yjltest44() {
		
	}
	@Test
	public void yjltest45() {
		
	}
	@Test
	public void yjltest46() {
		
	}
	@Test
	public void yjltest47() {
		
	}
	@Test
	public void yjltest48() {
		
	}
	@Test
	public void yjltest49() {
		
	}
	@Test
	public void yjltest50() {
		
	}
}
