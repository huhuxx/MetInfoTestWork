package com.sport.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.LoginPage;
import com.sport.pages.MainPages;

public class MainPagesTest extends BaseTest {
	MainPages mainPages;
	@BeforeClass
	public void login() {
		LoginPage loginPage=new LoginPage(driver);
		 mainPages=loginPage.login_sucess("1", "1");
	}
	@Test(priority = 1)
	public void test_insert() {
		mainPages.inset_item("��һ��");
		
	}
	
	@Test(priority = 2)
	public void test_delete() {
		mainPages.delete_first();
		
	}
}
