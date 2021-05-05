package com.hxy.testCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hxy.pageObjects.SearchBox;
import com.hxy.util.BaseTest;

public class SearchBox_Test extends BaseTest {
	//10¸ö
	public SearchBox u(WebDriver webDriver) {
		SearchBox u=new SearchBox(webDriver);
		return u;
	}
	@Test
	public void SearchBox_set_content_all() throws InterruptedException {	
		u(driver).set_content_all();	
	}
	@Test
	public void SearchBox_set_content_number() throws InterruptedException {	
		u(driver).set_content_number();		
	}
	@Test
	public void SearchBox_set_content_symbol() throws InterruptedException {	
		u(driver).set_content_symbol();		
	}
	@Test
	public void SearchBox_set_content_text() throws InterruptedException {	
		u(driver).set_content_text();		
	}
	@Test
	public void SearchBox_set_range_1() throws InterruptedException {	
		u(driver).set_range_1();
	}
	@Test
	public void SearchBox_set_range_2() throws InterruptedException {	
		u(driver).set_range_2();		
	}
	@Test
	public void SearchBox_set_style_all() throws InterruptedException {	
		u(driver).set_style_all();	
	}
	@Test
	public void SearchBox_set_style_content() throws InterruptedException {	
		u(driver).set_style_content();	
	}
	@Test
	public void SearchBox_set_style_tc() throws InterruptedException {	
		u(driver).set_style_tc();	
	}
	@Test
	public void SearchBox_set_style_title() throws InterruptedException {	
		u(driver).set_style_title();		
	}
}
