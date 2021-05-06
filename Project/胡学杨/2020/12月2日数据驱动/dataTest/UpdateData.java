package com.hxy.dataTest;

import org.testng.annotations.Test;

import com.hxy.dataProvider.NSDataProvider;
import com.hxy.pageObjects.UpdateTitie;
import com.hxy.util.BaseTest;

public class UpdateData extends BaseTest {
	@Test(dataProvider = "excel",dataProviderClass = NSDataProvider.class)
	public void updateTitle(String text) throws InterruptedException {
		UpdateTitie  u =new UpdateTitie(driver);
		u.updateTitle_data(text);
	}
}
