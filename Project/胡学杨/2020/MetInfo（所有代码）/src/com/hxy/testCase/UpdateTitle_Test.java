package com.hxy.testCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hxy.pageObjects.UpdateTitie;
import com.hxy.util.BaseTest;

public class UpdateTitle_Test extends BaseTest{
	public UpdateTitie u(WebDriver webDriver) {
		UpdateTitie aTitie=new UpdateTitie(webDriver);
		return aTitie;
	}
	//4¸ö
	@Test
	public void UpdateTitle_updateTitle_text() throws InterruptedException {
		u(driver).updateTitle_text();
	}
	@Test
	public void UpdateTitle_updateTitle_all() throws InterruptedException {
		u(driver).updateTitle_all();
	}
	@Test
	public void UpdateTitle_updateTitle_symbol() throws InterruptedException {
		u(driver).updateTitle_symbol();
	}
	@Test
	public void UpdateTitle_updateTitle_number() throws InterruptedException {
		u(driver).updateTitle_number();
	}
}
