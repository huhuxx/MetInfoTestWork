package com.hxy.testCase;

import org.testng.annotations.Test;

import com.hxy.pageObjects.SearchBox;
import com.hxy.util.BaseTest;

public class SearchBox_Test extends BaseTest {
	//10¸ö
	SearchBox d = new SearchBox(driver);
	@Test
	public void SearchBox_set_content_all() throws InterruptedException {	
		d.set_content_all();	
	}
	@Test
	public void SearchBox_set_content_number() throws InterruptedException {	
		d.set_content_number();		
	}
	@Test
	public void SearchBox_set_content_symbol() throws InterruptedException {	
		d.set_content_symbol();		
	}
	@Test
	public void SearchBox_set_content_text() throws InterruptedException {	
		d.set_content_text();		
	}
	@Test
	public void SearchBox_set_range_1() throws InterruptedException {	
		d.set_range_1();
	}
	@Test
	public void SearchBox_set_range_2() throws InterruptedException {	
		d.set_range_2();		
	}
	@Test
	public void SearchBox_set_style_all() throws InterruptedException {	
		d.set_style_all();	
	}
	@Test
	public void SearchBox_set_style_content() throws InterruptedException {	
		d.set_style_content();	
	}
	@Test
	public void SearchBox_set_style_tc() throws InterruptedException {	
		d.set_style_tc();	
	}
	@Test
	public void SearchBox_set_style_title() throws InterruptedException {	
		d.set_style_title();		
	}
}
