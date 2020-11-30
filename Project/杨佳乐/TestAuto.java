package test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import driver.BaseTest;

public class TestAuto extends BaseTest {
	// 进入在线留言界面
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

	// 提交留言
	public void sub() throws InterruptedException {
		webtest.mouseToElement("xpath=//div[@class='form-group m-b-0']");
		webtest.runJs(
				"document.getElementsByClassName('btn btn-primary btn-block btn-squared editable-click set')[0].className=''");
		webtest.mouseToElementandClick("xpath=//button[text()='提交留言']");
		Thread.sleep(3000);
	}

	// 进入在线反馈界面
	public void email1() throws InterruptedException {
		WebElement element = null;
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		element = webtest.back("editable-click").get(36);
		webtest.click(element);
		Thread.sleep(1000);
	}

	// 1，成功添加测试在线留言
	@Test
	public void yjltest1() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']", "杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']", "1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']", "18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']", "河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']", "好");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']", "aaaa");
		Thread.sleep(1000);
		sub();
		webtest.alertAccept();
	}

	// 2，成功在前台显示留言
	@Test
	public void yjltest2() throws InterruptedException {
		webtest.open("http://localhost:8090/admin");
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
		webtest.type("xpath=//textarea[@name='useinfo']", "好");
		webtest.click("xpath=//label[text()='审核通过并在前台显示']");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:8090/message/");
	}

	// 3，添加在线留言失败，添加Email格式错误
	@Test
	public void yjltest3() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']", "杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']", "1");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']", "18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']", "河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']", "好");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']", "aaaa");
		Thread.sleep(1000);
		sub();
	}

	// 4,添加在线留言失败，姓名为空
	@Test
	public void yjltest4() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']", "");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']", "1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']", "18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']", "河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']", "好");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']", "aaaa");
		Thread.sleep(1000);
		sub();
	}

	// 5,添加在线留言失败,联系电话格式错误
	@Test
	public void yjltest5() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']", "杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']", "1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']", "1");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']", "河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']", "好");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']", "aaaa");
		Thread.sleep(1000);
		sub();
	}

	// 6，添加在线留言失败，联系地址为空
	@Test
	public void yjltest6() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']", "杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']", "1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']", "");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']", "河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']", "好");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']", "aaaa");
		Thread.sleep(1000);
		sub();
	}

	// 7,添加在线留言失败，联系地址为空
	@Test
	public void yjltest7() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']", "杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']", "1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']", "18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']", "");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']", "好");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']", "aaaa");
		Thread.sleep(1000);
		sub();
	}

	// 8,添加在线留言失败,留言内容为空
	@Test
	public void yjltest8() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']", "杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']", "1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']", "18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']", "河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']", "");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']", "aaaa");
		Thread.sleep(1000);
		sub();
	}

	// 9,添加在线留言失败,Email格式错误（输入的是1837519045@qq.com11111）
	@Test
	public void yjltest9() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']", "杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']", "1837519045@qq.com11111");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']", "18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']", "河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']", "好");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']", "aaaa");
		Thread.sleep(1000);
		sub();
	}

	// 10，添加在线留言失败，验证码为空
	@Test
	public void yjltest10() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']", "杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']", "1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']", "18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']", "河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']", "好");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']", "");
		Thread.sleep(1000);
		sub();
	}

	// 11，添加在线留言失败，验证码错误
	@Test
	public void yjltest11() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']", "杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']", "1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']", "18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']", "河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']", "好");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']", "bbbb");
		Thread.sleep(1000);
		sub();
	}

	// 12,留言在前台不显示
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

	// 13,回复留言并且不在前台界面显示
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
		webtest.type("xpath=//textarea[@name='useinfo']", "好");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:8090/message/");
	}

	// 14,后台成功删除留言
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

	// 15,修改前台显示留言的方式
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
		webtest.type("xpath=//input[@name='para137']", "杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']", "1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']", "18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']", "河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']", "好");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']", "aaaa");
		Thread.sleep(1000);
		sub();
		webtest.alertAccept();
		webtest.open("http://localhost:8090/message/");
	}

	// 16,防刷新时间
	@Test
	public void yjltest16() throws InterruptedException {
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线留言']");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para137']", "杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']", "1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']", "18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']", "河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']", "好");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']", "aaaa");
		Thread.sleep(1000);
		webtest.click("xpath=//button[@class='btn btn-primary btn-block btn-squared']");
		webtest.alertAccept();
		Thread.sleep(2000);
		webtest.type("xpath=//input[@name='para137']", "杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']", "1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']", "18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']", "河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']", "好");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']", "aaaa");
		Thread.sleep(1000);
		webtest.click("xpath=//button[@class='btn btn-primary btn-block btn-squared']");
		webtest.alertAccept();
	}

	// 17,修改防刷新时间为300秒
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
		webtest.typeAndClear("xpath=//input[@name='met_msg_time']", "300");
		webtest.click("xpath=//button[@class='btn btn-primary ']");
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线留言']");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para137']", "杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']", "1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']", "18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']", "河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']", "好");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']", "aaaa");
		Thread.sleep(1000);
		webtest.click("xpath=//button[@class='btn btn-primary btn-block btn-squared']");
		webtest.alertAccept();
		Thread.sleep(2000);
		webtest.type("xpath=//input[@name='para137']", "杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']", "1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']", "18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']", "河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']", "好");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']", "aaaa");
		Thread.sleep(1000);
		webtest.click("xpath=//button[@class='btn btn-primary btn-block btn-squared']");
		webtest.alertAccept();
	}

	// 18，成功添加在线留言（前置条件为登录，在前端登录执行）
	@Test
	public void yjltest18() throws InterruptedException {
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@class='met_navbtn']");
		webtest.type("xpath=//input[@name='username']", "user");
		webtest.type("xpath=//input[@name='password']", "password");
		webtest.click("xpath=//button[@class='btn btn-lg btn-primary btn-squared btn-block']");
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线留言']");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para137']", "杨佳乐");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']", "1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']", "18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']", "河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']", "好");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']", "aaaa");
		Thread.sleep(1000);
		webtest.click("xpath=//button[@class='btn btn-primary btn-block btn-squared']");
		webtest.alertAccept();
	}

	// 19，成功在前台显示留言（前置条件，前端登录）
	@Test
	public void yjltest19() throws InterruptedException {
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
		webtest.type("xpath=//textarea[@name='useinfo']", "好");
		webtest.click("xpath=//label[text()='审核通过并在前台显示']");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:8090");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@class='met_navbtn']");
		webtest.type("xpath=//input[@name='username']", "user");
		webtest.type("xpath=//input[@name='password']", "password");
		webtest.click("xpath=//button[@class='btn btn-lg btn-primary btn-squared btn-block']");
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线留言']");
		Thread.sleep(1000);
	}

	// 20，修改留言的内容设置（将姓名设为非必填项）
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
		webtest.click("xpath=//select[@name='wr_ok-137']");
		webtest.click("xpath=//option[text()='否']");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线留言']");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para137']", "");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para186']", "1837519045@qq.com");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para138']", "18732338187");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para139']", "河北省");
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@name='para140']", "好");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@class='form-control input-codeimg']", "aaaa");
		Thread.sleep(1000);
		webtest.click("xpath=//button[@class='btn btn-primary btn-block btn-squared']");
		webtest.alertAccept();
	}

	// 21,后台界面删除姓名输入框
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
		webtest.click("xpath=//input[@name='id']");
		webtest.click("xpath=//button[text()='删除']");
		webtest.click("xpath=//button[@class='ok btn btn-primary']");
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线留言']");
	}

	// 22，后台界面添加姓名输入框
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
		webtest.click("xpath=//button[text()='添加']");
		webtest.type("xpath=//input[@name='name-new-0']", "姓名");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线留言']");
	}

	// 23，姓名添加提示文字
	@Test
	public void yjltest23() throws InterruptedException {
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

	// 24,成功添加在线反馈
	// 勾选问题没有解决
	@Test
	public void yjltest24() throws InterruptedException {
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
//		webtest.click("xpath=//*[text()='搜索引擎']");
		webtest.type("xpath=//input[@name='code']", "aaaa");
		webtest.mouseToElement("xpath=//div[@class='form-group m-b-0']");
		webtest.runJs(
				"document.getElementsByClassName('btn btn-primary btn-lg btn-block btn-squared editable-click set')[0].className=''");
		webtest.mouseToElementandClick("xpath=//button[text()='提交信息']");
		Thread.sleep(1000);
		webtest.alertAccept();
	}

	// 25，添加在线反馈失败（不选择反馈主题）
	@Test
	public void yjltest25() throws InterruptedException {
		email1();
		webtest.type("xpath=//input[@name='para142']", "杨佳乐");
		webtest.type("xpath=//input[@name='para143']", "无");
		webtest.type("xpath=//input[@name='para144']", "1837519045@qq.com");
		webtest.type("xpath=//input[@name='para176']", "18732338187");
		webtest.type("xpath=//input[@name='para177']", "河北师范大学");
		webtest.type("xpath=//input[@name='para178']", "河北省");
		webtest.type("xpath=//textarea[@name='para179']", "好");
		webtest.socll();
		webtest.type("xpath=//input[@name='code']", "aaaa");
		webtest.mouseToElement("xpath=//div[@class='form-group m-b-0']");
		webtest.runJs(
				"document.getElementsByClassName('btn btn-primary btn-lg btn-block btn-squared editable-click set')[0].className=''");
		webtest.mouseToElementandClick("xpath=//button[text()='提交信息']");
		Thread.sleep(1000);
		webtest.alertAccept();
	}

	// 26，添加在线反馈失败（Email输入框为空）
	@Test
	public void yjltest26() throws InterruptedException {
		email1();
		webtest.click("xpath=//select[@name='para141']");
		webtest.click("xpath=//option[@value='索取资料']");
		webtest.type("xpath=//input[@name='para142']", "杨佳乐");
		webtest.type("xpath=//input[@name='para143']", "无");
		webtest.type("xpath=//input[@name='para176']", "18732338187");
		webtest.type("xpath=//input[@name='para177']", "河北师范大学");
		webtest.type("xpath=//input[@name='para178']", "河北省");
		webtest.type("xpath=//textarea[@name='para179']", "好");
		webtest.socll();
		webtest.type("xpath=//input[@name='code']", "aaaa");
		webtest.mouseToElement("xpath=//div[@class='form-group m-b-0']");
		webtest.runJs(
				"document.getElementsByClassName('btn btn-primary btn-lg btn-block btn-squared editable-click set')[0].className=''");
		webtest.mouseToElementandClick("xpath=//button[text()='提交信息']");
		Thread.sleep(1000);
		webtest.alertAccept();
	}

	// 27，添加在线反馈失败（Email格式错误，输入“123”）
	@Test
	public void yjltest27() throws InterruptedException {
		email1();
		webtest.click("xpath=//select[@name='para141']");
		webtest.click("xpath=//option[@value='索取资料']");
		webtest.type("xpath=//input[@name='para142']", "杨佳乐");
		webtest.type("xpath=//input[@name='para143']", "无");
		webtest.type("xpath=//input[@name='para144']", "123");
		webtest.type("xpath=//input[@name='para176']", "18732338187");
		webtest.type("xpath=//input[@name='para177']", "河北师范大学");
		webtest.type("xpath=//input[@name='para178']", "河北省");
		webtest.type("xpath=//textarea[@name='para179']", "好");
		webtest.socll();
		webtest.type("xpath=//input[@name='code']", "aaaa");
		webtest.mouseToElement("xpath=//div[@class='form-group m-b-0']");
		webtest.runJs(
				"document.getElementsByClassName('btn btn-primary btn-lg btn-block btn-squared editable-click set')[0].className=''");
		webtest.mouseToElementandClick("xpath=//button[text()='提交信息']");
		Thread.sleep(1000);
		webtest.alertAccept();
	}

	// 28，添加在线反馈失败（Email格式输入错误，输入“1837519045@qq.com11111”）
	@Test
	public void yjltest28() throws InterruptedException {
		email1();
		webtest.click("xpath=//select[@name='para141']");
		webtest.click("xpath=//option[@value='索取资料']");
		webtest.type("xpath=//input[@name='para142']", "杨佳乐");
		webtest.type("xpath=//input[@name='para143']", "无");
		webtest.type("xpath=//input[@name='para144']", "1837519045@qq.com11111");
		webtest.type("xpath=//input[@name='para176']", "18732338187");
		webtest.type("xpath=//input[@name='para177']", "河北师范大学");
		webtest.type("xpath=//input[@name='para178']", "河北省");
		webtest.type("xpath=//textarea[@name='para179']", "好");
		webtest.socll();
		webtest.type("xpath=//input[@name='code']", "aaaa");
		webtest.mouseToElement("xpath=//div[@class='form-group m-b-0']");
		webtest.runJs(
				"document.getElementsByClassName('btn btn-primary btn-lg btn-block btn-squared editable-click set')[0].className=''");
		webtest.mouseToElementandClick("xpath=//button[text()='提交信息']");
		Thread.sleep(1000);
		webtest.alertAccept();
	}

	// 29,添加在线反馈失败,验证码为空
	@Test
	public void yjltest29() throws InterruptedException {
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
		webtest.type("xpath=//input[@name='code']", "");
		webtest.mouseToElement("xpath=//div[@class='form-group m-b-0']");
		webtest.runJs(
				"document.getElementsByClassName('btn btn-primary btn-lg btn-block btn-squared editable-click set')[0].className=''");
		webtest.mouseToElementandClick("xpath=//button[text()='提交信息']");
		Thread.sleep(1000);
		webtest.alertAccept();
	}

	// 30，添加在线反馈失败，验证码错误
	@Test
	public void yjltest30() throws InterruptedException {
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
		webtest.type("xpath=//input[@name='code']", "bbbb");
		webtest.mouseToElement("xpath=//div[@class='form-group m-b-0']");
		webtest.runJs(
				"document.getElementsByClassName('btn btn-primary btn-lg btn-block btn-squared editable-click set')[0].className=''");
		webtest.mouseToElementandClick("xpath=//button[text()='提交信息']");
		Thread.sleep(1000);
		webtest.alertAccept();
	}

	// 31,防刷新时间
	@Test
	public void yjltest31() throws InterruptedException {
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线反馈']");
		Thread.sleep(1000);
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
		webtest.type("xpath=//input[@name='code']", "aaaa");
		webtest.click("xpath=//button[text()='提交信息']");
		Thread.sleep(1000);
		webtest.alertAccept();
		Thread.sleep(1000);
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
		webtest.type("xpath=//input[@name='code']", "aaaa");
		webtest.click("xpath=//button[text()='提交信息']");
		Thread.sleep(1000);
		webtest.alertAccept();
	}

	// 32,修改防刷新时间为300秒
	@Test
	public void yjltest32() throws InterruptedException {
		email1();
		webtest.click("xpath=//button[@data-index='5']");
		webtest.leaveFrame();
		webtest.typeAndClear("xpath=//input[@name='met_fd_time']", "300");
		webtest.click("xpath=//button[@class='btn btn-primary ']");
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线反馈']");
		Thread.sleep(1000);
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
		webtest.type("xpath=//input[@name='code']", "aaaa");
		webtest.click("xpath=//button[text()='提交信息']");
		Thread.sleep(1000);
		webtest.alertAccept();
		Thread.sleep(1000);
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
		webtest.type("xpath=//input[@name='code']", "aaaa");
		webtest.click("xpath=//button[text()='提交信息']");
		Thread.sleep(1000);
		webtest.alertAccept();
	}

	// 33，成功添加在线反馈（前置条件前端登录）
	@Test
	public void yjltest33() throws InterruptedException {
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@class='met_navbtn']");
		webtest.type("xpath=//input[@name='username']", "user");
		webtest.type("xpath=//input[@name='password']", "password");
		webtest.click("xpath=//button[@class='btn btn-lg btn-primary btn-squared btn-block']");
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线反馈']");
		Thread.sleep(1000);
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
		webtest.type("xpath=//input[@name='code']", "aaaa");
		webtest.click("xpath=//button[text()='提交信息']");
		Thread.sleep(1000);
		webtest.alertAccept();
	}

	// 34，后台成功删除反馈
	@Test
	public void yjltest34() throws InterruptedException {
		email1();
		webtest.click("xpath=//div[@data-index='5']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//a[text()='反馈信息管理']");
		webtest.click("xpath=//input[@class='checkall-item custom-control-input']");
		webtest.click("xpath=//button[text()='删除']");
		webtest.click("xpath=//button[@class='ok btn btn-primary']");
	}

	// 35,后台查看反馈信息
	//重新测
	@Test
	public void yjltest35() throws InterruptedException {
		email1();
		webtest.click("xpath=//div[@data-index='5']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//a[text()='反馈信息管理']");
		webtest.click("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		webtest.click("xpath=//button[text()='保存']");
	}
	
	//36，后台查看反馈信息编辑记录添加在线视频
	//重新测
	@Test
	public void yjltest36() throws InterruptedException {
		email1();
		webtest.click("xpath=//div[@data-index='5']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//a[text()='反馈信息管理']");
		webtest.click("xpath=//button[@class='btn btn-sm btn-primary mr-1']");
		webtest.down(6);
//		webtest.socll();
//		webtest.click("xpath=//button[text()='保存']");
	}

	// 37，修改反馈内容设置（将反馈主题设置为非必填项）
	@Test
	public void yjltest37() throws InterruptedException {
		email1();
		webtest.click("xpath=//div[@data-index='5']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//select[@name='wr_ok-141']");
		webtest.click("xpath=//option[text()='否']");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线反馈']");
		Thread.sleep(1000);
		webtest.type("xpath=//input[@name='para142']", "杨佳乐");
		webtest.type("xpath=//input[@name='para143']", "无");
		webtest.type("xpath=//input[@name='para144']", "1837519045@qq.com");
		webtest.type("xpath=//input[@name='para176']", "18732338187");
		webtest.type("xpath=//input[@name='para177']", "河北师范大学");
		webtest.type("xpath=//input[@name='para178']", "河北省");
		webtest.type("xpath=//textarea[@name='para179']", "好");
		webtest.socll();
		webtest.type("xpath=//input[@name='code']", "aaaa");
		webtest.click("xpath=//button[text()='提交信息']");
		Thread.sleep(1000);
		webtest.alertAccept();
	}

	// 38,修改反馈内容设置（删除姓名）
	@Test
	public void yjltest38() throws InterruptedException {
		email1();
		webtest.click("xpath=//div[@data-index='5']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//input[@value='142']");
		webtest.click("xpath=//button[text()='删除']");
		webtest.click("xpath=//button[@class='ok btn btn-primary']");
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线反馈']");
		Thread.sleep(1000);
	}

	// 39,修改反馈内容设置（添加姓名）
	@Test
	public void yjltest39() throws InterruptedException {
		email1();
		webtest.click("xpath=//div[@data-index='5']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//button[text()='添加']");
		webtest.type("xpath=//input[@name='name-new-0']", "姓名");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线反馈']");
	}

	// 40，职务添加提示文字
	@Test
	public void yjltest40() throws InterruptedException {
		email1();
		webtest.click("xpath=//div[@data-index='5']//button[2]");
		webtest.leaveFrame();
		webtest.type("xpath=//input[@name='description-143']", "具体职务");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线反馈']");
	}

	// 41，修改公司简介的内容
	// 重改
	@Test
	public void yjltest41() throws InterruptedException {
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//button[@data-index='5']");
		webtest.leaveFrame();
		webtest.typeAndClear("p", "杨佳乐2018011720");
		webtest.click("xpath=//button[@class='btn btn-primary']");
	}

	// 42，修改联系我们的内容
	// 打不开界面
	// 输入有问题
	@Test
	public void yjltest42() throws InterruptedException {
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@met-id='77']");
		webtest.click("xpath=//button[@data-mid='noset']");
	}

	// 43，修改公司简介为公司介绍
	@Test
	public void yjltest43() throws InterruptedException {
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.mouseToElement("xpath=//a[@met-id='39']");
		webtest.click("xpath=//button[@data-index='34']");
		webtest.typeAndClear("xpath=//input[@class='form-control input-sm']", "公司介绍");
	}

	// 44，修改联系我们的背景图颜色
	@Test
	public void yjltest44() throws InterruptedException {
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@met-id='77']");
		webtest.click("xpath=//button[@data-index='3']");
		webtest.leaveFrame();
		webtest.typeAndClear("xpath=//input[@name='36_metinfo']", "#edb4ea");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='联系我们']");
	}

	// 45，在公司简介中加入在线视频
	// 找不到输入网址的地方
	@Test
	public void yjltest45() throws InterruptedException {
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//div[@data-index='5']//button");
		webtest.leaveFrame();
		webtest.click("xpath=//div[@id='edui167_body']");
		webtest.enterFrame(0);
		webtest.type("xpath=//input[@id='videoUrl']",
				"https://haokan.baidu.com/v?vid=10864138390511576996&pd=bjh&fr=bjhauthor&type=video");
		webtest.click("xpath=//div[text()='确认']");
		webtest.leaveFrame();
		webtest.click("xpath=//button[text()='保存']");
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
	}

	// 46，在公司简介中加入在线图片
	// 找不到在线
	@Test
	public void yjltest46() throws InterruptedException {
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//div[@data-index='5']");
		webtest.leaveFrame();
		webtest.click("xpath=//div[@id='edui157_body']");
		webtest.enterFrame(0);
		webtest.click("xpath=//div[@id='tabhead']//span");
		webtest.type("xpath=//input[@id='url']",
				"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=998153380,1003080363&fm=26&gp=0.jpg");
		webtest.click("xpath=//div[text()='确认']");
		webtest.leaveFrame();
		webtest.click("xpath=//button[text()='保存']");
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
	}

	// 47，修改联系我们的内容的字体
	// 全选内容
	@Test
	public void yjltest47() throws InterruptedException {
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@met-id='77']");
		webtest.click("xpath=//div[@data-index='3']//button");
		webtest.leaveFrame();
		webtest.click("xpath=//div[@id='edui12_state']");
		webtest.click("xpath=//div[text()='楷体']");
		webtest.click("xpath=//button[text()='保存']");
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='联系我们']");
	}

	// 48，联系我们添加在线图片
	// 没有测试
	@Test
	public void yjltest48() throws InterruptedException {
		webtest.open("http://localhost:8090/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "username");
		webtest.type("xpath=//input[@name='login_pass']", "password");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@met-id='77']");
		webtest.click("xpath=//button[@data-index='5']");
		webtest.leaveFrame();
		webtest.click("xpath=//div[@id='edui793_body']");
		webtest.enterFrame(0);
		webtest.click("xpath=//span[text()='插入图片']");
		webtest.type("xpath=//input[@id='url']",
				"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=998153380,1003080363&fm=26&gp=0.jpg");
		webtest.click("xpath=//div[text()='确认']");
		webtest.leaveFrame();
		webtest.click("xpath=//button[text()='保存']");
		webtest.open("http://localhost:8090/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
	}
	
	//49,
	@Test
	public void yjltest49() {
		
	}
	
	//50,
	@Test
	public void yjltest50() {
		
	}
}
