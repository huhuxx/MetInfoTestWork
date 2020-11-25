package com.hxy.testCase;

import org.testng.annotations.Test;

import com.hxy.pageObjects.UpdateTitie;
import com.hxy.util.BaseTest;

public class UpdateTitle_Test extends BaseTest{
	//4¸ö
	UpdateTitie aTitie=new UpdateTitie(driver);
	@Test
	public void UpdateTitle_updateTitle_text() throws InterruptedException {
		aTitie.updateTitle_text();
	}
	@Test
	public void UpdateTitle_updateTitle_all() throws InterruptedException {
		aTitie.updateTitle_all();
	}
	@Test
	public void UpdateTitle_updateTitle_symbol() throws InterruptedException {
		aTitie.updateTitle_symbol();
	}
	@Test
	public void UpdateTitle_updateTitle_number() throws InterruptedException {
		aTitie.updateTitle_number();
	}
}
