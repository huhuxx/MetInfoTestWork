package com.hxy.testCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hxy.pageObjects.ContentManage;
import com.hxy.util.BaseTest;

public class ContentManage_Test extends BaseTest {
	//16¸ö
	public ContentManage u(WebDriver webDriver) {
		ContentManage a= new ContentManage(webDriver);
		return a;
	}
	@Test
	public void ContentManage_addContent() throws InterruptedException {	
		u(driver).addContent();
	}
	@Test
	public void ContentManage_editColumn_computer() throws InterruptedException {			
		u(driver).editColumn_computer();
	}
	@Test
	public void ContentManage_editColumn_cAndp() throws InterruptedException {	
		u(driver).editColumn_cAndp();
	}
	@Test
	public void ContentManage_editColumn_computerOne() throws InterruptedException {	
		u(driver).editColumn_computerOne();
	}
	@Test
	public void ContentManage_editColumn_notePC() throws InterruptedException {	
		u(driver).editColumn_notePC();
	}
	@Test
	public void ContentManage_editColumn_phone() throws InterruptedException {	
		u(driver).editColumn_phone();
	}
	@Test
	public void ContentManage_editColumn_phone_first() throws InterruptedException {	
		u(driver).editColumn_phone_first();
	}
	@Test
	public void ContentManage_editColumn_phone_second() throws InterruptedException {	
		u(driver).editColumn_phone_second();
	}
	@Test
	public void ContentManage_editColumn_phone_third() throws InterruptedException {	
		u(driver).editColumn_phone_third();
	}
	@Test
	public void ContentManage_editColumn_productshow() throws InterruptedException {	
		u(driver).editColumn_productshow();
	}
	@Test
	public void ContentManage_editColumn_tabletPC() throws InterruptedException {	
		u(driver).editColumn_tabletPC();
	}
	@Test
	public void ContentManage_editContent_text_size() throws InterruptedException {	
		u(driver).editContent_text_size("5");
	}
	@Test
	public void ContentManage_editContent_text_color() throws InterruptedException {	
		u(driver).editContent_text_color("#1baadb");
	}
	@Test
	public void ContentManage_editContent_model() throws InterruptedException {	
		u(driver).editContent_model("AKG&HUAWEI");
	}
	@Test
	public void ContentManage_editContent_JingDong() throws InterruptedException {	
		u(driver).editContent_JingDong("https://www.jd.com/");
	}
	@Test
	public void ContentManage_editContent_Taobao() throws InterruptedException {	
		u(driver).editContent_Taobao("https://www.taobao.com/");
	}
}
