package com.sport.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.LoginPage;
import com.sport.pages.MainPages;
import com.sport.pages.BodybuildingPages;

public class BodybuildingPagesTest extends BaseTest {
	BodybuildingPages bodyPages;
	LoginPage loginPage;
	MainPages mainPages;
	
	@BeforeClass
	public void login() throws InterruptedException {
		loginPage=new LoginPage(driver);
		loginPage.login("19831125535", "123456");
		mainPages=new MainPages(driver);
		bodyPages=new BodybuildingPages(driver);
	}
	@Test(priority = 1)
	public void test_one() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_one();
	}
	
	@Test(priority = 2)
	public void test_two() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_two();
	}
	
	@Test(priority = 3)
	public void test_three() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_three();
	}
	
	@Test(priority = 4)
	public void test_four() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_four();
	}
	
	@Test(priority = 5)
	public void test_five() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_five();
	}
	
	@Test(priority = 6)
	public void test_six() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_six();
	}
	
	@Test(priority = 7)
	public void test_seven() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_seven();
	}
	
	@Test(priority = 8)
	public void test_eight() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_eight();
	}
	
	@Test(priority = 9)
	public void test_nine() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_nine();
	}
	
	@Test(priority = 10)
	public void test_ten() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_ten();
	}
	
	@Test(priority = 11)
	public void test_eleven() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_eleven();
	}
	
	@Test(priority = 12)
	public void test_twelve() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_twelve();
	}
	
	@Test(priority = 13)
	public void test_thirteen() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_thirteen();
	}
	
	@Test(priority = 14)
	public void test_fourteen() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_fourteen();
	}
	
	@Test(priority = 15)
	public void test_fifteen() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_fifteen();
	}
	
	@Test(priority = 16)
	public void test_sixteen() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_sixteen();
	}
	
	@Test(priority = 17)
	public void test_seventeen() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_seventeen();
	}
	
	@Test(priority = 18)
	public void test_eighteen() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_eighteen();
	}
	
	@Test(priority = 19)
	public void test_nineteen() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_nineteen();
	}
	
	@Test(priority = 20)
	public void test_twenty() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_twenty();
	}
}