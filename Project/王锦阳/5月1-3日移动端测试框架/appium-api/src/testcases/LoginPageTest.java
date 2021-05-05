package testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {
	LoginPage loginPage;
	@BeforeClass
	public void initPage() {
		loginPage=new LoginPage(driver);
	}
	
	@Test
	public void test_login_success() {
		
		loginPage.login_sucess("1", "1");
		assertEquals(driver.currentActivity(), ".MainActivity");
	}
	@Test
	public void test_login_fail() {

		String message=loginPage.login_fail("1", "2");
		assertEquals(message, "用户名或者密码错误！");
		
	}

}
