package test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import driver.BaseTest;
import listener.JavaMailTestListener;

/**
 * 
 * @author 杨佳乐
 * 50条测试用例
 *
 */

@Listeners(JavaMailTestListener.class)
public class TestAuto extends BaseTest {
	// 进入在线留言
	public void email() throws InterruptedException {
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
		webtest.open("http://localhost:99/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
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

	//1，成功添加测试在线留言
	@Test(priority = 1)
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
	@Test(priority = 2)
	public void yjltest2() throws InterruptedException {
		webtest.open("http://localhost:99/admin");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
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
		webtest.open("http://localhost:99/message/");
	}

	// 3，添加在线留言失败，添加Email格式错误
	@Test(priority = 3)
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
	@Test(priority = 4)
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
	@Test(priority = 5)
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
	@Test(priority = 6)
	public void yjltest6() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']","杨佳乐");
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
	@Test(priority = 7)
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
	@Test(priority = 8)
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
	@Test(priority = 9)
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
	@Test(priority = 10)
	public void yjltest10() throws InterruptedException {
		email();
		webtest.type("xpath=//input[@name='para137']","杨佳乐");
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
	@Test(priority = 11)
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
	@Test(priority = 12)
	public void yjltest12() throws InterruptedException {
		webtest.open("http://localhost:99/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
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
		webtest.open("http://localhost:99/message/");
	}

	// 13,回复留言并且不在前台界面显示
	@Test(priority = 13)
	public void yjltest13() throws InterruptedException {
		webtest.open("http://localhost:99/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
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
		webtest.open("http://localhost:99/message/");
	}

	// 14,后台成功删除留言
	@Test(priority = 14)
	public void yjltest14() throws InterruptedException {
		webtest.open("http://localhost:99/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//button[@data-index='5']");
		webtest.leaveFrame();
		webtest.click("xpath=//button[@class='btn btn-sm btn-default ']");
		webtest.click("xpath=//button[@class='ok btn btn-primary']");
		webtest.open("http://localhost:99/message/");
	}

	// 15，在线留言查看已审核的留言
	@Test(priority = 15)
	public void yjltest15() throws InterruptedException {
		webtest.open("http://localhost:99/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//button[@data-index='5']");
		webtest.leaveFrame();
		webtest.click("xpath=//select[@name='checkok']");
		webtest.click("xpath=//option[text()='是']");
	}

	// 16，在线留言中查看未阅读留言
	@Test(priority = 16)
	public void yjltest16() throws InterruptedException {
		webtest.open("http://localhost:99/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//button[@data-index='5']");
		webtest.leaveFrame();
		webtest.click("xpath=//select[@name='search_type']");
		webtest.click("xpath=//option[text()='未阅读信息']");
	}

	// 17,修改前台显示留言的方式
	@Test(priority = 17)
	public void yjltest17() throws InterruptedException {
		webtest.open("http://localhost:99/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//button[@data-index='6']");
		webtest.leaveFrame();
		webtest.click("xpath=//input[@class='custom-control-input']");
		webtest.click("xpath=//button[@class='btn btn-primary ']");
		webtest.open("http://localhost:99/admin/?lang=cn&n=ui_set");
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
		webtest.open("http://localhost:99/message/");
	}

	// 18,防刷新时间
	@Test(priority = 18)
	public void yjltest18() throws InterruptedException {
		webtest.open("http://localhost:99/");
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

	// 19,修改防刷新时间为300秒
	@Test(priority = 19)
	public void yjltest19() throws InterruptedException {
		webtest.open("http://localhost:99/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//button[@data-index='6']");
		webtest.leaveFrame();
		webtest.typeAndClear("xpath=//input[@name='met_msg_time']", "300");
		webtest.click("xpath=//button[@class='btn btn-primary ']");
		webtest.open("http://localhost:root/");
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

	// 20，成功添加在线留言（前置条件为登录，在前端登录执行）
	@Test(priority = 20)
	public void yjltest20() throws InterruptedException {
		webtest.open("http://localhost:99/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@class='met_navbtn']");
		webtest.type("xpath=//input[@name='username']", "user");
		webtest.type("xpath=//input[@name='password']", "password");
//		webtest.type("xpath=//input[@name='code']", "aaaa");
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

	// 21，成功在前台显示留言（前置条件，前端登录）
	@Test(priority = 21)
	public void yjltest21() throws InterruptedException {
		webtest.open("http://localhost:99/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
//		webtest.type("xpath=//input[@name='code']", "aaaa");
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
		webtest.open("http://localhost:99");
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

	// 22，修改留言的内容设置（将姓名设为非必填项）
	@Test(priority = 22)
	public void yjltest22() throws InterruptedException {
		webtest.open("http://localhost:99/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//div[@data-index='6']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//select[@name='wr_ok-137']");
		webtest.click("xpath=//option[text()='��']");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:99/");
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

	// 23，修改姓名的字段类型为文本
	@Test(priority = 23)
	public void yjltest23() throws InterruptedException {
		webtest.open("http://localhost:99/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//div[@data-index='6']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//select[@name='type-137']");
		webtest.click("xpath=//option[text()='文本']");
		webtest.click("xpath=//button[text()='保存']");
	}

	// 24，修改姓名的访问权限为普通会员
	@Test(priority = 24)
	public void yjltest24() throws InterruptedException {
		webtest.open("http://localhost:99/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//div[@data-index='6']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//select[@name='access-137']");
		webtest.click("xpath=//option[text()='普通会员']");
		webtest.click("xpath=//button[text()='保存']");
	}

	// 25,后台界面删除姓名输入框
	@Test(priority = 25)
	public void yjltest25() throws InterruptedException {
		webtest.open("http://localhost:99/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
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
		webtest.open("http://localhost:99/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线留言']");
	}

	// 26，后台界面添加姓名输入框
	@Test(priority = 26)
	public void yjltest26() throws InterruptedException {
		webtest.open("http://localhost:99/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//div[@data-index='6']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//button[text()='添加']");
		webtest.type("xpath=//input[@name='name-new-0']", "����");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:99/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线留言']");
	}

	// 27，姓名添加提示文字
	@Test(priority = 27)
	public void yjltest27() throws InterruptedException {
		webtest.open("http://localhost:99/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		webtest.click("xpath=//a[@title='关于我们']");
		webtest.click("xpath=//a[@class='editable-click']");
		webtest.click("xpath=//div[@data-index='6']//button[2]");
		webtest.leaveFrame();
		webtest.type("xpath=//input[@name='description-195']", "真实姓名");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:99/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线留言']");
	}

	// 28,成功添加在线反馈
	@Test(priority = 28)
	public void yjltest28() throws InterruptedException {
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
		webtest.type("xpath=//input[@name='code']", "aaaa");
		webtest.mouseToElement("xpath=//div[@class='form-group m-b-0']");
		webtest.runJs(
				"document.getElementsByClassName('btn btn-primary btn-lg btn-block btn-squared editable-click set')[0].className=''");
		webtest.mouseToElementandClick("xpath=//button[text()='提交信息']");
		Thread.sleep(1000);
		webtest.alertAccept();
	}

	// 29，添加在线反馈失败（不选择反馈主题）
	@Test(priority = 29)
	public void yjltest29() throws InterruptedException {
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
	}

	// 30，添加在线反馈失败（Email输入框为空）
	@Test(priority = 30)
	public void yjltest30() throws InterruptedException {
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
	}

	// 31，添加在线反馈失败（Email格式错误，输入“123”）
	@Test(priority = 31)
	public void yjltest31() throws InterruptedException {
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
	}

	// 32，添加在线反馈失败（Email格式输入错误，输入“1837519045@qq.com11111”）
	@Test(priority = 32)
	public void yjltest32() throws InterruptedException {
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

	// 33,添加在线反馈失败,验证码为空
	@Test(priority = 33)
	public void yjltest33() throws InterruptedException {
		email1();
		webtest.click("xpath=//select[@name='para141']");
		webtest.click("xpath=//option[@value='']");
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
	}

	// 34，添加在线反馈失败，验证码错误
	@Test(priority = 34)
	public void yjltest34() throws InterruptedException {
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

	// 35,防刷新时间
	@Test(priority = 35)
	public void yjltest35() throws InterruptedException {
		webtest.open("http://localhost:99/");
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

	// 36,修改防刷新时间为300秒
	@Test(priority = 36)
	public void yjltest36() throws InterruptedException {
		email1();
		webtest.click("xpath=//button[@data-index='5']");
		webtest.leaveFrame();
		webtest.typeAndClear("xpath=//input[@name='met_fd_time']", "300");
		webtest.click("xpath=//button[@class='btn btn-primary ']");
		webtest.open("http://localhost:99/");
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

	// 37，成功添加在线反馈（前置条件前端登录）
	@Test(priority = 37)
	public void yjltest37() throws InterruptedException {
		webtest.open("http://localhost:99/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@class='met_navbtn']");
		webtest.type("xpath=//input[@name='username']", "user");
		webtest.type("xpath=//input[@name='password']", "password");
//		webtest.type("xpath=//input[@name='code']", "aaaa");
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

	// 38，后台成功删除反馈
	@Test(priority = 38)
	public void yjltest38() throws InterruptedException {
		email1();
		webtest.click("xpath=//div[@data-index='5']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//a[text()='反馈信息管理']");
		webtest.click("xpath=//input[@class='checkall-item custom-control-input']");
		webtest.click("xpath=//button[text()='删除']");
		webtest.click("xpath=//button[@class='ok btn btn-primary']");
	}

	// 39,查看在线反馈的未阅读的信息
	@Test(priority = 39)
	public void yjltest39() throws InterruptedException {
		email1();
		webtest.click("xpath=//div[@data-index='5']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//a[text()='反馈信息管理']");
		webtest.click("xpath=//select[@name='search_type']");
		webtest.click("xpath=//option[text()='未阅读']");
	}

	// 40，查看反馈主题为所有产品的在线反馈
	@Test(priority = 40)
	public void yjltest40() throws InterruptedException {
		email1();
		webtest.click("xpath=//div[@data-index='5']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//a[text()='反馈信息管理']");
		webtest.click("xpath=//select[@name='para_141']");
		webtest.click("xpath=//option[text()='所有产品']");
	}

	// 41，修改反馈内容设置（将反馈主题设置为非必填项）
	@Test(priority = 41)
	public void yjltest41() throws InterruptedException {
		email1();
		webtest.click("xpath=//div[@data-index='5']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//select[@name='wr_ok-141']");
		webtest.click("xpath=//option[text()='否']");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:99/");
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

	// 42，修改姓名的字段类型为文本
	@Test(priority = 42)
	public void yjltest42() throws InterruptedException {
		email1();
		webtest.click("xpath=//div[@data-index='5']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//select[@name='type-142']");
		webtest.click("xpath=//option[text()='文本']");
		webtest.click("xpath=//button[text()='保存']");
	}

	// 43,修改姓名的所属栏目为在线反馈
	@Test(priority = 43)
	public void yjltest43() throws InterruptedException {
		email1();
		webtest.click("xpath=//div[@data-index='5']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//select[@name='class-142']");
		webtest.click("xpath=//option[text()='在线反馈']");
		webtest.click("xpath=//button[text()='保存']");
	}

	// 44,修改姓名的访问权限为普通会员
	@Test(priority = 44)
	public void yjltest44() throws InterruptedException {
		email1();
		webtest.click("xpath=//div[@data-index='5']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//select[@name='access-142']");
		webtest.click("xpath=//option[text()='普通会员']");
		webtest.click("xpath=//button[text()='保存']");
	}

	// 45,修改反馈内容设置（删除姓名）
	@Test(priority = 45)
	public void yjltest45() throws InterruptedException {
		email1();
		webtest.click("xpath=//div[@data-index='5']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//input[@value='142']");
		webtest.click("xpath=//button[text()='删除']");
		webtest.click("xpath=//button[@class='ok btn btn-primary']");
		webtest.open("http://localhost:99/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线反馈']");
		Thread.sleep(1000);
	}

	// 46,修改反馈内容设置（添加姓名）
	@Test(priority = 46)
	public void yjltest46() throws InterruptedException {
		email1();
		webtest.click("xpath=//div[@data-index='5']//button[2]");
		webtest.leaveFrame();
		webtest.click("xpath=//button[text()='添加']");
		webtest.type("xpath=//input[@name='name-new-0']", "姓名");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:99/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线反馈']");
	}

	// 47，职务添加提示文字
	@Test(priority = 47)
	public void yjltest47() throws InterruptedException {
		email1();
		webtest.click("xpath=//div[@data-index='5']//button[2]");
		webtest.leaveFrame();
		webtest.type("xpath=//input[@name='description-143']", "具体职务");
		webtest.click("xpath=//button[@class='btn btn-primary']");
		webtest.open("http://localhost:99/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='在线反馈']");
	}

	// 48，修改公司简介为公司介绍
	@Test(priority = 48)
	public void yjltest48() throws InterruptedException {
		webtest.open("http://localhost:99/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.mouseToElement("xpath=//a[@met-id='39']");
		webtest.click("xpath=//button[@data-index='34']");
		webtest.typeAndClear("xpath=//input[@class='form-control input-sm']", "公司介绍");
		webtest.click("xpath=//button[@class='btn btn-primary btn-xs editable-submit']");
	}

	// 49，修改联系我们的背景图颜色
	@Test(priority = 49)
	public void yjltest49() throws InterruptedException {
		webtest.open("http://localhost:99/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
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
		webtest.open("http://localhost:99/");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='联系我们']");
	}

	// 50，修改在线反馈的背景图中的文字为反馈
	@Test(priority = 50)
	public void yjltest50() throws InterruptedException {
		webtest.open("http://localhost:99/admin/index.php");
		webtest.type("xpath=//input[@name='login_name']", "root");
		webtest.type("xpath=//input[@name='login_pass']", "root");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		webtest.click("xpath=//button[@class='btn btn-default no-prompt']");
		webtest.enterFrame(0);
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='关于我们']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@met-id='44']");
		webtest.mouseToElement("xpath=//h3[@class='vertical-align-middle editable-click']");
		webtest.click("xpath=//button[@data-index='33']");
		webtest.typeAndClear("xpath=//input[@class='form-control input-sm']", "反馈");
		webtest.click("xpath=//button[@class='btn btn-primary btn-xs editable-submit']");
	}
}