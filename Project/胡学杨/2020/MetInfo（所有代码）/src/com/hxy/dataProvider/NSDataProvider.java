package com.hxy.dataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class NSDataProvider {

	@DataProvider(name="excel")
	public Object[][] getExcelDada() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("data/MetInfo.xlsx","Sheet1");
	}
	
	@DataProvider(name="excel2")
	public Object[][] getExcelDada2() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("data/MetInfo.xlsx","Sheet2");
	}
	
	@DataProvider(name="excel3")
	public Object[][] getExcelDada3() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("data/MetInfo.xlsx","Sheet3");
	}
	
	@DataProvider(name="excel4")
	public Object[][] getExcelDada4() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("data/MetInfo.xlsx","Sheet4");
	}
	
}
