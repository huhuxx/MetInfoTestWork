package test;

import org.openqa.selenium.WebElement;
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
		webtest.down(4);
		Thread.sleep(1000);
	}
	
	//提交留言
	public void sub() throws InterruptedException {
		webtest.mouseToElement("xpath=//div[@class='form-group m-b-0']");
		webtest.runJs("document.getElementsByClassName('btn btn-primary btn-block btn-squared editable-click set')[0].className=''");
		webtest.mouseToElementandClick("xpath=//button[text()='提交留言']");
		Thread.sleep(3000);
	}
	
	//进入在线反馈界面
	public void email1() throws InterruptedException {
		WebElement element=null;
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		element=webtest.back("editable-click").get(36);
		webtest.click(element);
		Thread.sleep(1000);
	}
	
	//提交信息
	public void sub1() throws InterruptedException {
		webtest.mouseToElementandClick("class=met-feedback-body");
		Thread.sleep(2000);
		webtest.down(4);
		Thread.sleep(2000);
		webtest.mouseToElement("xpath=//div[@class='form-group m-b-0']");
		webtest.runJs("document.getElementsByClassName('btn btn-primary btn-lg btn-block btn-squared editable-click set')[0].className=''");
		webtest.mouseToElementandClick("xpath=//button[text()='提交信息']");
		Thread.sleep(2000);
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
		webtest.alertAccept();
	}
	
	//2，成功在前台显示留言
	@Test
	public void yjltest2() throws InterruptedException {
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//button[@data-index='5']");
		webtest.leaveFrame();
		webtest.click("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		webtest.mouseToElementandClick("xpath=//div[@class='modal-body  oya met-scrollbar']");
		webtest.down(3);
		webtest.type("xpath=//textarea[@name='useinfo']","好");
		webtest.click("xpath=//label[text()='审核通过并在前台显示']");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:8090/message/");
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
	public void yjltest12() throws InterruptedException {
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//button[@data-index='5']");
		webtest.leaveFrame();
		webtest.click("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		webtest.mouseToElementandClick("xpath=//div[@class='modal-body  oya met-scrollbar']");
		webtest.down(3);
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:8090/message/");
	}
	
	//13,回复留言并且不在前台界面显示
	@Test
	public void yjltest13() throws InterruptedException {
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//button[@data-index='5']");
		webtest.leaveFrame();
		webtest.click("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		webtest.mouseToElementandClick("xpath=//div[@class='modal-body  oya met-scrollbar']");
		webtest.down(3);
		webtest.type("xpath=//textarea[@name='useinfo']","好");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:8090/message/");
	}
	
	//14,后台成功删除留言
	@Test
	public void yjltest14() throws InterruptedException {
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//button[@data-index='5']");
		webtest.leaveFrame();
		webtest.click("xpath=//button[@class='btn btn-sm btn-default ']");
		webtest.click("xpath=//button[@class='ok btn btn-primary']");
		webtest.open("http://localhost:8090/message/");
	}
	
	//15,修改前台显示留言的方式
	@Test
	public void yjltest15() throws InterruptedException {
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//button[@data-index='6']");
		webtest.leaveFrame();
		webtest.click("xpath=//input[@class='custom-control-input']");
		webtest.click("xpath=//button[@class='btn btn-primary ']");
		webtest.open("http://localhost:8090/admin/?lang=cn&n=ui_set");
		webtest.enterFrame(0);
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@class='editable-click']");
		Thread.sleep(1000);
		webtest.mouseToElement("xpath=//div[@m-id='message_form']");
		webtest.down(4);
		Thread.sleep(1000);
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
		webtest.open("http://localhost:8090/message/");
	}
	
	//16,防刷新时间
	@Test
	public void yjltest16() throws InterruptedException {
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线留言']");
		Thread.sleep(1000);
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
		webtest.click("xpath=//button[@class='btn btn-primary btn-block btn-squared']");
		webtest.alertAccept();
		Thread.sleep(2000);
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
		webtest.click("xpath=//button[@class='btn btn-primary btn-block btn-squared']");
		webtest.alertAccept();
	}
	
	//17,修改防刷新时间为300秒
	@Test
	public void yjltest17() throws InterruptedException {
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//button[@data-index='6']");
		webtest.leaveFrame();
//		webtest.runJs("document.getElementByTagNeme('met_msg_time').value='300'");
		webtest.type("xpath=//input[@name='met_msg_time']", "300");
		webtest.click("xpath=//button[@class='btn btn-primary ']");
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线留言']");
		Thread.sleep(1000);
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
		webtest.click("xpath=//button[@class='btn btn-primary btn-block btn-squared']");
		webtest.alertAccept();
		Thread.sleep(2000);
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
		webtest.click("xpath=//button[@class='btn btn-primary btn-block btn-squared']");
		webtest.alertAccept();
	}
	
	//18，修改留言的内容设置（将姓名设为非必填项）
	@Test
	public void yjltest18() throws InterruptedException {
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//div[@data-index='6']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//select[@name='wr_ok-137']");
		webtest.click("xpath=//option[text()='否']");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线留言']");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para137']","");
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
		webtest.click("xpath=//button[@class='btn btn-primary btn-block btn-squared']");
		webtest.alertAccept();
	}
	
	//19,
	@Test
	public void yjltest19() {
		
	}
	
	//20,后台界面删除姓名输入框
	@Test
	public void yjltest20() throws InterruptedException {
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//div[@data-index='6']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//input[@name='id']");
		webtest.click("xpath=//button[text()='删除']");
		webtest.click("xpath=//button[@class='ok btn btn-primary']");
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线留言']");
	}
	
	//21，后台界面添加姓名输入框
	@Test
	public void yjltest21() throws InterruptedException {
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//div[@data-index='6']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//button[text()='添加']");
		webtest.type("xpath=//input[@name='name-new-0']","姓名");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线留言']");
	}
	
	//22，姓名添加提示文字
	@Test
	public void yjltest22() throws InterruptedException {
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//div[@data-index='6']//button[2]");
		webtest.leaveFrame();
		webtest.type("xpath=//input[@name='description-195']", "真实姓名");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线留言']");
	}
	
	//23,成功添加在线反馈
	@Test
	public void yjltest23() throws InterruptedException {
		email1();
		webtest.click("xpath=//select[@name='para141']");
		webtest.click("xpath=//option[@value='索取资料']");
		webtest.type("xpath=//input[@name='para142']", "杨佳乐");
		webtest.type("xpath=//input[@name='para143']", "无");
		webtest.type("xpath=//input[@name='para144']", "1837519045@qq.com");
		webtest.type("xpath=//input[@name='para176']", "18732338187");
		webtest.type("xpath=//input[@name='para177']", "河北师范大学");
		webtest.type("xpath=//input[@name='para178']", "河北省");
		webtest.type("xpath=//textarea[@name='para179']", "好");
		webtest.socll();
//		webtest.mouseToElementandClick("xpath=//section[@m-id='feedback']");
//		webtest.down(4);
//		WebElement element=webtest.back("form-group ").get(6);
//		webtest.click(element);
//		webtest.click("xpath=//div[@class='form-group ']//div");
		webtest.type("xpath=//input[@name='code']", "aaaa");
		sub1();
	}
	
	//24
	@Test
	public void yjltest24() {
		
	}
	
	//25
	@Test
	public void yjltest25() {
		
	}
	
	//26
	@Test
	public void yjltest26() {
		
	}
	
	//27
	@Test
	public void yjltest27() {
		
	}
	
	//28
	@Test
	public void yjltest28() {
		
	}
	
	//29
	@Test
	public void yjltest29() {
		
	}
	
	//30
	@Test
	public void yjltest30() {
		
	}
	
	//31
	@Test
	public void yjltest31() {
		
	}
	
	//32
	@Test
	public void yjltest32() {
		
	}
	
	//33
	@Test
	public void yjltest33() {
		
	}
	
	//34
	@Test
	public void yjltest34() {
		
	}
	
	//35
	@Test
	public void yjltest35() {
		
	}
	
	//36
	@Test
	public void yjltest36() {
		
	}
	
	//37
	@Test
	public void yjltest37() {
		
	}
	
	//38
	@Test
	public void yjltest38() {
		
	}
	
	//39
	@Test
	public void yjltest39() {
		
	}
	
	//40
	@Test
	public void yjltest40() {
		
	}
	
	//41
	@Test
	public void yjltest41() {
		
	}
	
	//42
	@Test
	public void yjltest42() {
		
	}
	
	//43
	@Test
	public void yjltest43() {
		
	}
	
	//44
	@Test
	public void yjltest44() {
		
	}
	
	//45
	@Test
	public void yjltest45() {
		
	}
	
	//46
	@Test
	public void yjltest46() {
		
	}
	
	//47
	@Test
	public void yjltest47() {
		
	}
	
	//48
	@Test
	public void yjltest48() {
		
	}
	
	//49
	@Test
	public void yjltest49() {
		
	}
	
	//50
	@Test
	public void yjltest50() {
		
	}
}
