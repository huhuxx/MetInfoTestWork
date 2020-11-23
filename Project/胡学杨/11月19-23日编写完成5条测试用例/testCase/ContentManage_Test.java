package com.hxy.testCase;

import org.testng.annotations.Test;

import com.hxy.pageObjects.ContentManage;
import com.hxy.util.BaseTest;

public class ContentManage_Test extends BaseTest {
	//16¸ö
	ContentManage a= new ContentManage(driver);
	@Test
	public void ContentManage_addContent() throws InterruptedException {	
		a.addContent();
	}
	@Test
	public void ContentManage_editColumn_computer() throws InterruptedException {			
		a.editColumn_computer();
	}
	@Test
	public void ContentManage_editColumn_cAndp() throws InterruptedException {	
		a.editColumn_cAndp();
	}
	@Test
	public void ContentManage_editColumn_computerOne() throws InterruptedException {	
		a.editColumn_computerOne();
	}
	@Test
	public void ContentManage_editColumn_notePC() throws InterruptedException {	
		a.editColumn_notePC();
	}
	@Test
	public void ContentManage_editColumn_phone() throws InterruptedException {	
		a.editColumn_phone();
	}
	@Test
	public void ContentManage_editColumn_phone_first() throws InterruptedException {	
		a.editColumn_phone_first();
	}
	@Test
	public void ContentManage_editColumn_phone_second() throws InterruptedException {	
		a.editColumn_phone_second();
	}
	@Test
	public void ContentManage_editColumn_phone_third() throws InterruptedException {	
		a.editColumn_phone_third();
	}
	@Test
	public void ContentManage_editColumn_productshow() throws InterruptedException {	
		a.editColumn_productshow();
	}
	@Test
	public void ContentManage_editColumn_tabletPC() throws InterruptedException {	
		a.editColumn_tabletPC();
	}
	@Test
	public void ContentManage_editContent_text_size() throws InterruptedException {	
		a.editContent_text_size();
	}
	@Test
	public void ContentManage_editContent_text_color() throws InterruptedException {	
		a.editContent_text_color();
	}
	@Test
	public void ContentManage_editContent_model() throws InterruptedException {	
		a.editContent_model();
	}
	@Test
	public void ContentManage_editContent_JingDong() throws InterruptedException {	
		a.editContent_JingDong();
	}
	@Test
	public void ContentManage_editContent_Taobao() throws InterruptedException {	
		a.editContent_Taobao();
	}
}
