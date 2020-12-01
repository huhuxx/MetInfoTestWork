package com.bxx.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.canoo.webtest.WebtestCase;

public class JoinusjianliTest extends BaseTest {
	
	@BeforeTest
	public void before() throws InterruptedException {
		webtest.click("xpath=//a[text()='内容']");
		List<WebElement> list = webtest.backlist("xpath=//*[@class='py-2 d-block']");
		webtest.click(list.get(5));
		webtest.click("xpath=//div[@class='content-show-item']/nav/a[text()='简历表单设置']");
		
	}
	@Test
	public void test1() throws InterruptedException {
		//设置性别的选项为男、女
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[2]/td[8]/button");
		List<WebElement> list = webtest.backlist("xpath=//input[@name='value']");
		webtest.typeAndClear(list.get(0), "女");
		webtest.typeAndClear(list.get(1), "男");
		webtest.click("xpath=//div[@class='modal-footer clearfix d-block']/div/button[text()='保存']");
	}
	@Test
	public void test2() throws InterruptedException {
		//给性别、联系电话、邮箱设置提示文字-这是必填项
		webtest.type("xpath=//*[@name='description-164']", "这是必填项");
		webtest.type("xpath=//*[@name='description-167']", "这是必填项");
		webtest.type("xpath=//*[@name='description-168']", "这是必填项");
		
		webtest.click("xpath=//*[@id=\"parameter-list-job-43-0-0\"]/tfoot/tr/th[1]/div/input");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tfoot/tr/th[2]/button[@class='btn btn-primary']");
	}
	@Test
	public void test3() throws InterruptedException {
		//添加新的默认选项
		webtest.click("xpath=//*[@id=\"parameter-list-job-43-0-0\"]/tfoot/tr/th[2]/button[text()='添加']");
		Thread.sleep(5000);
		webtest.type("xpath=//*[@id=\"parameter-list-job-43-0-0\"]/tbody/tr[15]/td[2]/div/input","这是新添加的项");
		
		webtest.click("xpath=//*[@id=\"parameter-list-job-43-0-0\"]/tfoot/tr/th[1]/div/input");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tfoot/tr/th[2]/button[@class='btn btn-primary']");
	}
	@Test
	public void test4() throws InterruptedException {
		//将作品和业余爱好同时删除，并选择取消
		List<WebElement> list = webtest.backlist("xpath=//*[@name='id']");
		webtest.click(list.get(20));
		webtest.click(list.get(21));
		webtest.click("xpath=//*[@id=\"parameter-list-job-43-0-0\"]/tfoot/tr/th[2]/button[text()='删除']");
		
		webtest.click("xpath=//button[text()='取消']");
	}
	@Test
	public void test5() throws InterruptedException {
		//将姓名所属栏目设置更改为【加入我们】
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[1]/td[5]/select");
		webtest.click("xpath=//*[text()='加入我们']");
		
		webtest.click("xpath=//*[@id=\"parameter-list-job-43-0-0\"]/tbody/tr[1]/td[1]/div/input");
		webtest.click("xpath=//*[@id=\"parameter-list-job-43-0-0\"]/tfoot/tr/th[2]/button[text()='保存']");
	}
	@Test
	public void test6() throws InterruptedException {
		//设置姓名的访问权限为代理商,设置性别的访问权限为普通会员
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[1]/td[6]/select");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[1]/td[6]/select/option[text()='代理商']");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[2]/td[6]/select");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[2]/td[6]/select/option[text()='普通会员']");
		
		webtest.click("xpath=//*[@id=\"parameter-list-job-43-0-0\"]/tfoot/tr/th[2]/button[text()='保存']");
		
	}
	@Test
	public void test7() throws InterruptedException {
		//设置其他为附件格式
		webtest.click("xpath=//*[@name='type-195']");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[12]/td[4]/select/option[text()='附件']");
		webtest.click("xpath=//*[@id=\"parameter-list-job-43-0-0\"]/tfoot/tr/th[2]/button[text()='保存']");
	}
	@Test
	public void test8() throws InterruptedException {
		//设置通讯地址为必填项
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[8]/td[7]/select");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[8]/td[7]/select/option[text()='是']");
		webtest.click("xpath=//*[@id=\"parameter-list-job-43-0-0\"]/tfoot/tr/th[2]/button[text()='保存']");
	}
	@Test
	public void test9() throws InterruptedException {
		//将业余爱好设置为下拉，并设置其他的下拉属性
		webtest.click("xpath=//*[@id=\"parameter-list-job-43-0-0\"]/tbody/tr[10]/td[4]/select");
		webtest.click("xpath=//*[@id=\"parameter-list-job-43-0-0\"]/tbody/tr[10]/td[4]/select/option[text()='下拉']");
		webtest.click("xpath=//*[@id=\"parameter-list-job-43-0-0\"]/tbody/tr[10]/td[8]/button[text()='设置选项']");
		
		webtest.click("xpath=//*[@id=\"parameter-options-list\"]/tfoot/tr/th[2]/button[text()='添加']");
		webtest.type("xpath=//*[@id=\"parameter-options-list\"]/tbody/tr/td[2]/div/input","爱好1");
		webtest.click("xpath=//*[@id=\"parameter-options-list\"]/tfoot/tr/th[2]/button[text()='添加']");
		webtest.type("xpath=//*[@id=\"parameter-options-list\"]/tbody/tr[2]/td[2]/div/input","爱好2");
		webtest.click("xpath=//*[@id=\"parameter-options-list\"]/tfoot/tr/th[2]/button[text()='添加']");
		webtest.type("xpath=//*[@id=\"parameter-options-list\"]/tbody/tr[3]/td[2]/div/input","爱好3");
		
		webtest.click("xpath=/html/body/div[3]/div/div/div[3]/div/button[text()='保存']");
		
	}
	@Test
	public void test10() throws InterruptedException {
		//删除业余爱好的属性3
		webtest.click("xpath=//*[@id=\"parameter-list-job-43-0-0\"]/tbody/tr[10]/td[8]/button[text()='设置选项']");
		webtest.click("xpath=//*[@id=\"parameter-options-list\"]/tbody/tr[3]/td[3]/button[text()='删除']");
		webtest.click("xpath=//*[@class='ok btn btn-primary']");
		
		webtest.click("xpath=/html/body/div[3]/div/div/div[3]/div/button[text()='保存']");
	}
	@Test
	public void test11() throws InterruptedException {
		//增加选项然后选择【撤销】
		webtest.click("xpath=//*[@id=\"parameter-list-job-43-0-0\"]/tfoot/tr/th[2]/button[text()='添加']");
		webtest.click("xpath=//*[@id=\"parameter-list-job-43-0-0\"]/tbody/tr[13]/td[8]/button[text()='撤销']");
	}
}
