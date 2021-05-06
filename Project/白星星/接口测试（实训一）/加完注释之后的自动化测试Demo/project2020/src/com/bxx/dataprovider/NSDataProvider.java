package com.bxx.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NSDataProvider {

	
	@DataProvider(name="zl_shop")
	public  Object[][] getTxtData() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/user.txt");
	}
	@DataProvider(name="movie")
	public  Object[][] getMovieData() throws IOException{
		return new  ExcelDataProvider().getTestDataByExcel("data/movie.xlxs","岗位信息");
	}
	@Test(dataProvider="txt")
	public void getData(String a,String b) {
		System.out.println(a+" "+b);
		
	}

	@DataProvider(name="gangwei")
	public Object[][] getExcelDada() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("D:\\ABCD\\Data.xlsx","Sheet1");
	}
	@DataProvider(name="photo")
	public Object[][] getExcelphoto() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("D:\\ABCD\\Data.xlsx","Sheet2");
	}
	
	@DataProvider(name="mysql")
	public Object[][] getMysqlDada() throws IOException{
		return new MysqlDataProvider().getTestDataByMysql("SELECT filmname, petname\r\n" + 
				"FROM `mm_movie` ");
	}
	
	@Test(dataProvider="mysql")
	public void testDB(String a,String b) {
		System.out.println(a+" "+b);
	}
	
}
