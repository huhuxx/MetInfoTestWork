package com.bxx.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.canoo.webtest.WebtestCase;
/**
 * 加入我们后台的简历表单设置页面
 * 对简历表单的操作
 * 
 * @author 白星星
 *
 */
public class JoinusjianliTest extends BaseTest {
	
	@BeforeMethod(description = "进入后台的加入我们简历表单设置页面")
	public void before() throws InterruptedException {
		webtest.click("xpath=//a[text()='内容']");
		List<WebElement> list = webtest.backlist("xpath=//*[@class='py-2 d-block']");
		webtest.click(list.get(5));
		webtest.click("xpath=//div[@class='content-show-item']/nav/a[text()='简历表单设置']");
		
	}
	@Test(description = "设置性别的选项为男、女")
	public void test1() throws InterruptedException {
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[2]/td[8]/button");
		List<WebElement> list = webtest.backlist("xpath=//input[@name='value']");
		webtest.typeAndClear(list.get(0), "女");
		webtest.typeAndClear(list.get(1), "男");
		webtest.click("xpath=//div[@class='modal-footer clearfix d-block']/div/button[text()='保存']");
	}
	@Test(description = "给性别、联系电话、邮箱设置提示文字-这是必填项")
	public void test2() throws InterruptedException {
		webtest.typeAndClear("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[2]/td[3]/input", "这是必填项");
		webtest.typeAndClear("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[3]/td[3]/input", "这是必填项");
		webtest.typeAndClear("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[4]/td[3]/input", "这是必填项");
		
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tfoot/tr/th[1]/div/input");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tfoot/tr/th[2]/button[@class='btn btn-primary']");
	}
	@Test(description = "添加新的默认选项,并不保存")
	public void test3() throws InterruptedException {
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tfoot/tr/th[2]/button[text()='添加']");
		Thread.sleep(5000);
		webtest.typeAndClear("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[13]/td[2]/div/input","这是新添加的项");
		
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tfoot/tr/th[1]/div/input");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[13]/td[8]/button[2]");
	}
	@Test(description ="将第三、第五两个选项同时删除，并选择取消")
	public void test4() throws InterruptedException {
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[3]/td[1]/div/input");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[5]/td[1]/div/input");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tfoot/tr/th[2]/button[text()='删除']");
		
		webtest.click("xpath=//button[text()='取消']");
	}
	@Test(description = "将姓名所属栏目设置更改为【加入我们】")
	public void test5() throws InterruptedException {
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[1]/td[5]/select");
		webtest.click("xpath=//*[text()='加入我们']");
		
		webtest.click("xpath=//*[@id=\"parameter-list-job-43-0-0\"]/tbody/tr[1]/td[1]/div/input");
		webtest.click("xpath=//*[@id=\"parameter-list-job-43-0-0\"]/tfoot/tr/th[2]/button[text()='保存']");
	}
	@Test(description = "设置姓名的访问权限为代理商,设置性别的访问权限为普通会员")
	public void test6() throws InterruptedException {
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[1]/td[6]/select");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[1]/td[6]/select/option[text()='代理商']");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[2]/td[6]/select");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[2]/td[6]/select/option[text()='普通会员']");
		
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tfoot/tr/th[2]/button[text()='保存']");
		
	}
	@Test(description = "设置其他为附件格式")
	public void test7() throws InterruptedException {
		webtest.click("xpath=//*[@name='type-195']");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[12]/td[4]/select/option[text()='附件']");
		webtest.click("xpath=//*[@id=\"parameter-list-job-43-0-0\"]/tfoot/tr/th[2]/button[text()='保存']");
	}
	@Test(description = "设置通讯地址为非必填项")
	public void test8() throws InterruptedException {
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[8]/td[7]/select");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[8]/td[7]/select/option[text()='否']");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tfoot/tr/th[2]/button[text()='保存']");
	}
	@Test(description = "将业余爱好设置为下拉，并设置其他的下拉属性")
	public void test9() throws InterruptedException {
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[10]/td[4]/select");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[10]/td[4]/select/option[text()='下拉']");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[10]/td[8]/button[text()='设置选项']");
		
		webtest.click("xpath=//*[@id='parameter-options-list']/tfoot/tr/th[2]/button[text()='添加']");
		webtest.typeAndClear("xpath=//*[@id='parameter-options-list']/tbody/tr/td[2]/div/input","爱好1");
		webtest.click("xpath=//*[@id='parameter-options-list']/tfoot/tr/th[2]/button[text()='添加']");
		webtest.typeAndClear("xpath=//*[@id='parameter-options-list']/tbody/tr[2]/td[2]/div/input","爱好2");
		webtest.click("xpath=//*[@id='parameter-options-list']/tfoot/tr/th[2]/button[text()='添加']");
		webtest.typeAndClear("xpath=//*[@id='parameter-options-list']/tbody/tr[3]/td[2]/div/input","爱好3");
		
		webtest.click("xpath=/html/body/div[3]/div/div/div[3]/div/button[text()='保存']");
		
	}
	@Test(description = "删除业余爱好的属性3,并选择取消")
	public void test10() throws InterruptedException {
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[10]/td[8]/button[text()='设置选项']");
		webtest.click("xpath=//*[@id='parameter-options-list']/tbody/tr[3]/td[3]/button[text()='删除']");
		webtest.click("xpath=//*[@class='cancel btn btn-default']");
		
		webtest.click("xpath=/html/body/div[3]/div/div/div[3]/div/button[text()='保存']");
	}
	@Test(description = "增加选项然后选择【撤销】")
	public void test11() throws InterruptedException {
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tfoot/tr/th[2]/button[text()='添加']");
		webtest.click("xpath=//*[@id='parameter-list-job-43-0-0']/tbody/tr[13]/td[8]/button[text()='撤销']");
	}
}
