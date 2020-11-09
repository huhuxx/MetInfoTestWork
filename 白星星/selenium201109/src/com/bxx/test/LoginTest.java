package com.bxx.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.bxx.pageobject.LoginPage;

public class LoginTest extends BaseTest {

	LoginPage loginPage = new LoginPage();
	String LoginURL = "http://oneadmin.peersafe.cn/logout";

/**
 * 方法名称：loginTest1   
 * 方法描述： This method is testing the empty username and the right password
 *         The end is Loginfailed ,I will print some error information  on the console and
 *         the page still stay on the login page
 * 创建人：zzx
 * 创建时间：2017年9月12日 下午5:33:27   
 * 修改人：zzx 
 * 修改时间：2017年9月12日 下午5:33:27   
 * 修改备注：   
 * @version  1.0
 * @throws Exception maybe some exception will happen
 */



	@Test(priority=1)
	public void loginTest1() throws Exception{
		loginPage.login(getDriver(), "admin", "admin");
	}
}


