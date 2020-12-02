package com.webtest.demo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.JavaMailTestListener;
import com.webtest.utils.FreeMarker;
import com.webtest.utils.MailUtil;
import com.webtest.utils.ReadProperties;

import freemarker.template.TemplateException;
@Listeners(JavaMailTestListener.class)
public class BannerSetting extends BaseTest {
	@BeforeClass
	public void loginTest() throws InterruptedException {
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.type("name=login_name", ReadProperties.getPropertyValue("username"));
		webtest.type("name=login_pass", ReadProperties.getPropertyValue("password"));
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
	}

	@BeforeMethod
	public void refreshPage() {
		webtest.refresh();
	}

	public int getImgsNum() {
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		List<WebElement> items = webtest.getElementsList("xpath=//div[@role='listbox']/child::div");
		System.out.println(items.size());
		webtest.leaveFrame();
		return items.size();
	}

	public void openBannerSetting() {
		webtest.click("xpath=//button[text()='风格']");
		webtest.click("xpath=//a[text()='Banner 管理']");
	}

//14、	ID104 Banner管理-添加Banner
	@Test(priority = 1)
	public void addBanner() throws InterruptedException {
		int beforeAddNum = this.getImgsNum();
		System.out.println("添加前banner的数量为：" + beforeAddNum);
		this.openBannerSetting();
		webtest.click("xpath=//button[@data-modal-title='添加Banner']");
		List<WebElement> inputImg = webtest.getElementsList("xpath=//button[text()='从图片库选择']");
//		网站图片添加
		webtest.click(inputImg.get(0));
		webtest.chooseLocalImg("201801", "1516066438664023.jpg");
		List<WebElement> submitBtns = webtest.getElementsList("xpath=//button[text()='保存']");
		for (int i = 0; i < submitBtns.size(); i++) {
			String dateId = webtest.getValue(submitBtns.get(i), "data-id");
			if (dateId != null) {
				webtest.click(submitBtns.get(i));
			}
		}
//		手机端图片添加
		webtest.click(inputImg.get(1));
		webtest.chooseLocalImg("201801", "1515738299330527.jpg");
		List<WebElement> submitBtns2 = webtest.getElementsList("xpath=//button[text()='保存']");
		for (int i = 0; i < submitBtns2.size(); i++) {
			String dateId = webtest.getValue(submitBtns2.get(i), "data-id");
			if (dateId != null) {
				webtest.click(submitBtns.get(i));
			}
		}
//		填写图片标题
		webtest.down(6);
		webtest.type("xpath=//input[@name='img_title']", "新添加的Banner");
//		选择所属栏目为“网站首页”
		webtest.click("xpath=//label[text()='网站首页']");
//		保存、关闭
		webtest.click(submitBtns2.get(1));
		Thread.sleep(5000);
		webtest.click("xpath=//button[@aria-label='Close']");
//		添加一个banner之后
		int afterAdd = this.getImgsNum();
		System.out.println("添加后的banner数量为：" + afterAdd);
		Assert.assertEquals(beforeAddNum + 1, afterAdd);
		System.out.println("ID104:成功添加一个Banner到网站首页!");
	}

//15、	ID105 Banner管理-删除banner 
//	删除标题为"新添加的Banner"的banner,即第一个banner
	@Test(priority = 2)
	public void deleteBanner() throws InterruptedException {
		this.openBannerSetting();
		webtest.click("xpath=//button[text()='删除']");
		webtest.click("xpath=//button[text()='确定']");
		Thread.sleep(5000);
		webtest.click("xpath=//button[@aria-label='Close']");
		System.out.println("ID105新添加的第一个Banner删除成功！");
	}

//16、	ID106 Banner管理-编辑  
//	对图片标题为“米拓企业建站系统“的banner进行编辑
	@Test(priority = 0)
	public void editBanner() throws InterruptedException {
		this.openBannerSetting();
		webtest.click("xpath=//a[text()='米拓企业建站系统']/../../following-sibling::td[4]//button[text()='编辑']");
		Thread.sleep(5000);
		webtest.mouseToElementandClick("xpath=//label[text()='Banner尺寸']");
		webtest.down(10);
//		修改图片标题为“米拓企业建站系统syj”
		webtest.typeAndClear("xpath=//input[@name='img_title']", "米拓企业建站系统syj");
//		修改图片描述为“1个网站内容轻松同步到10种终端展示123”
		webtest.typeAndClear("xpath=//input[@name='img_des']", "1个网站内容轻松同步到10种终端展示syj");
//		修改图片文字位置为“左”
		webtest.click("xpath=//label[text()='左']");
//		保存
		webtest.click("xpath=//div[@class='float-right']//button[@class='btn btn-primary']");
//		关闭界面
		Thread.sleep(5000);
		webtest.click("xpath=//button[@aria-label='Close']");
		System.out.println("ID106编辑成功！");
	}

//17、	ID107 Banner管理-按钮-添加
//	添加百度按钮
	@Test(priority = 4)
	public void addButtons() throws InterruptedException {
		this.openBannerSetting();
		webtest.click("xpath=//a[text()='米拓企业建站系统syj']/../../following-sibling::td[4]//button[text()='按钮']");
		webtest.click("xpath=//button[text()='添加']");
		// 按钮文字
		webtest.type("xpath=//input[@name='but_text-new-0']", "百度");
		// 链接
		webtest.type("xpath=//input[@name='but_url-new-0']", "https://www.baidu.com/");
		// 打开方式
		webtest.selectByValue("xpath=//input[@name='but_url-new-0']/../following-sibling::td[1]/select", "1");
		// 保存
		webtest.click("xpath=//th[@colspan='11']//button[text()='保存']");
		Thread.sleep(5000);
		// 关闭设置界面
		List<WebElement> closeBtns = webtest.getElementsList("xpath=//button[@aria-label='Close']");
		webtest.click(closeBtns.get(1));
		webtest.click(closeBtns.get(0));
//		进入前台页面，点击新添加的按钮“百度”
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		webtest.click("xpath=//a[text()='百度']");
//		切换窗口，获取title为“百度一下，你就知道”
		webtest.switchWidow(1);
		System.out.println(webtest.getTitle());
		Assert.assertEquals(webtest.getTitle(), "百度一下，你就知道");
//		切换到米拓页面
		webtest.switchWidow(0);
		webtest.leaveFrame();
		System.out.println("ID107 百度按钮添加成功！");
	}

//18、	ID109 Banner管理-按钮-颜色设置
	@Test(priority = 5)
	public void setBtnColor() {
		this.openBannerSetting();
		webtest.click("xpath=//a[text()='米拓企业建站系统syj']/../../following-sibling::td[4]//button[text()='按钮']");
		webtest.type("xpath=//input[@value='百度']/../../following-sibling::td[4]/div//input[@data-plugin='minicolors']",
				"#ffffff");
		webtest.click("xpath=//th[@colspan='11']//button[text()='保存']");
		// 关闭设置界面
		List<WebElement> closeBtns = webtest.getElementsList("xpath=//button[@aria-label='Close']");
		webtest.click(closeBtns.get(1));
		webtest.click(closeBtns.get(0));
		System.out.println("ID109 百度按钮设置颜色为白色成功！");
	}

//19、	ID108 Banner管理-按钮-文字大小
	@Test(priority = 6)
	public void setWordsSize() {
		this.openBannerSetting();
		webtest.click("xpath=//a[text()='米拓企业建站系统syj']/../../following-sibling::td[4]//button[text()='按钮']");
		webtest.type("xpath=//input[@value='百度']/../../following-sibling::td[6]//input[@data-plugin='select-fontsize']",
				"20");
		webtest.click("xpath=//th[@colspan='11']//button[text()='保存']");
		// 关闭设置界面
		List<WebElement> closeBtns = webtest.getElementsList("xpath=//button[@aria-label='Close']");
		webtest.click(closeBtns.get(1));
		webtest.click(closeBtns.get(0));
		System.out.println("ID108 百度按钮文字大小设为20像素成功！");
	}

//20、	ID110 Banner管理-按钮-删除	
	@Test(priority = 7)
	public void deleteBtn() {
		// 删除“百度”按钮前
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		boolean btnStatus0 = webtest.isElementPresent("xpath=//a[text()='百度']");
		System.out.println("删除前，百度按钮是否存在：" + btnStatus0);
		webtest.leaveFrame();
		// 删除操作
		this.openBannerSetting();
		webtest.click("xpath=//a[text()='米拓企业建站系统syj']/../../following-sibling::td[4]//button[text()='按钮']");
		webtest.click("xpath=//input[@value='百度']/../../following-sibling::td[10]");
		webtest.click("xpath=//button[@class='ok btn btn-primary']");
		// 关闭设置界面
		List<WebElement> closeBtns = webtest.getElementsList("xpath=//button[@aria-label='Close']");
		webtest.click(closeBtns.get(1));
		webtest.click(closeBtns.get(0));
		// 删除“百度”按钮后
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		boolean btnStatus1 = webtest.isElementPresent("xpath=//a[text()='百度']");
		System.out.println("删除后，百度按钮是否存在：" + btnStatus1);
		webtest.leaveFrame();
		if (!btnStatus1) {
			System.out.println("ID110 百度按钮删除成功！");
		}
		Assert.assertEquals(btnStatus1, false);

	}

//21、		ID111 Banner管理-按钮-顺序调整
	@Test(priority = 3)
	public void setTurns() throws InterruptedException {
		this.openBannerSetting();
		webtest.click("xpath=//a[text()='米拓企业建站系统syj']/../../following-sibling::td[4]//button[text()='按钮']");
		// 获取表格集合，以便拖拽
		List<WebElement> formGroup = webtest.getElementsList("xpath=//tr[@role='row']");
		// 获得拖拽前的最后一个按钮的文字
		List<WebElement> beforeDrag_btnInput = webtest
				.getElementsList("xpath=//tr[@role='row']/child::td[2]/div/input");
		String beforeDrag_lastBtn = webtest.getValue(beforeDrag_btnInput.get(beforeDrag_btnInput.size() - 1), "value");

		// 将最后一个表格拖拽到第一的位置
		webtest.dragAndDrop(formGroup.get(formGroup.size() - 1), formGroup.get(0));
		Thread.sleep(2000);
		// 保存
		webtest.click("xpath=//th[@colspan='11']//button[text()='保存']");
		// 关闭设置界面
		List<WebElement> closeBtns = webtest.getElementsList("xpath=//button[@aria-label='Close']");
		webtest.click(closeBtns.get(1));
		webtest.click(closeBtns.get(0));
		// 进入前台页面
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:98/index.php?lang=cn&pageset=1']");
		List<WebElement> afterDrag_btnText = webtest.getElementsList("xpath=//h3[text()='米拓企业建站系统syj']/..//a[@*]");

		// 验证拖拽是否对前台页面起作用
		String afterDrag_firstBtn = afterDrag_btnText.get(0).getText();
		System.out.println("拖拽前，最后一个按钮文字为：" + beforeDrag_lastBtn);
		System.out.println("拖拽后前台页面的第一个按钮文字为：" + afterDrag_firstBtn);
		// 预期：拖拽前最后一个按钮文字 和 拖拽后前台页面的第一个按钮文字相同
		if (beforeDrag_lastBtn.equals(afterDrag_btnText)) {
			System.out.println("ID111 按钮顺序调整成功！");
		} else {
			System.out.println("ID111 按钮顺序调整失败！");
		}
		Assert.assertEquals(beforeDrag_lastBtn, afterDrag_firstBtn);
	}
	@AfterSuite
	public void mailUtil() throws IOException, TemplateException {
		FreeMarker freeMarker=new FreeMarker();
		freeMarker.makeReport();
		
		MailUtil m=new MailUtil();
		m.sendMail();
		
	}
}
