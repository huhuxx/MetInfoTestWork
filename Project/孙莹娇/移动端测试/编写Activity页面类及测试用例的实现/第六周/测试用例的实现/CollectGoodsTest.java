package com.sport.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.AllCoursePage;
import com.sport.pages.AllGoodsPage;
import com.sport.pages.CourseDetailPage;
import com.sport.pages.CoursePages;
import com.sport.pages.GoodsCateDetailPage;
import com.sport.pages.GoodsDetailPage;
import com.sport.pages.LoginPage;
import com.sport.pages.MainPages;
import com.sport.pages.MoreCoursePage;
import com.sport.pages.MyCollectPage;
import com.sport.pages.MyInformationPages;
import com.sport.pages.RecommendPages;

import io.appium.java_client.touch.offset.PointOption;
import utils.BaseAction;

public class CollectGoodsTest extends BaseTest{
	MainPages mainPages;
	LoginPage loginPage;
	MyInformationPages myInformationPages;
	RecommendPages recommendPages;
	GoodsDetailPage goodsDetailPage;
	BaseAction action;
	AllGoodsPage allGoodsPage;
	GoodsCateDetailPage goodsCateDetailPage;
	
	@BeforeClass
	public void initpage() {
		mainPages=new MainPages(driver);
		loginPage=new LoginPage(driver);
		myInformationPages=new MyInformationPages(driver);
		recommendPages =new RecommendPages(driver);
		goodsDetailPage =new GoodsDetailPage(driver);
		action=new BaseAction(driver);
		allGoodsPage=new AllGoodsPage(driver);
		goodsCateDetailPage=new GoodsCateDetailPage(driver);
	}
	/**
	 * 登录
	 * @throws InterruptedException
	 */
	@Test
	public void login() throws InterruptedException {
		loginPage.login_sucess("19831125536", "123456");
//		assertEquals(driver.currentActivity(), ".MR.ShouYeActivity");
		Thread.sleep(2000);
	}
	/**
	 * 1
	 * 在“推荐”-“一周严选”中收藏商品
	 * @throws InterruptedException
	 */
	@Test(priority = 1,dependsOnMethods = {"login"})
	public void addCollect_inGoodRecomment() throws InterruptedException {
		int width = driver.manage().window().getSize().width;// 获取屏幕的宽
		int height = driver.manage().window().getSize().height;// 获取屏幕的长
		PointOption fromOption= PointOption.point(width/2, height*19/20);// 这里相当于一个坐标原点
		PointOption toOption= PointOption.point(width/2, height*1/20);// 这里相当于一个坐标原点
		mainPages.turn_success("推荐");
		Thread.sleep(1500);
		//点击第1个商品
		recommendPages.click_yanxuan(1);
		Thread.sleep(1500);
		//滑到底部
		for (int i = 0; i < 6; i++) {
			action.slide(fromOption, toOption);
		}
		Thread.sleep(1500);
		//点击“想要”
		goodsDetailPage.click_btnCollect();
		//判断toast提示内容是否符合预期
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNotNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏成功"+"')]"))),"收藏失败");
		//无“收藏成功”的提升，故为bug
	}
	/**
	 * 2
	 * 在“推荐”-“家庭健身房”中收藏商品
	 * @throws InterruptedException
	 */
	@Test(priority = 2,dependsOnMethods = {"login"})
	public void addCollect_inRemenYanxuan() throws InterruptedException {
		int width = driver.manage().window().getSize().width;// 获取屏幕的宽
		int height = driver.manage().window().getSize().height;// 获取屏幕的长
		PointOption fromOption= PointOption.point(width/2, height*19/20);// 这里相当于一个坐标原点
		PointOption toOption= PointOption.point(width/2, height*1/20);// 这里相当于一个坐标原点
		mainPages.turn_success("推荐");
		Thread.sleep(1500);
		action.slide(fromOption, toOption);
		Thread.sleep(1500);
		//点击第2个商品
		recommendPages.clickOneGood(1);
		Thread.sleep(1500);
		//滑到底部
		for (int i = 0; i < 6; i++) {
			action.slide(fromOption, toOption);
		}
		Thread.sleep(1500);
		//点击“想要”
		goodsDetailPage.click_btnCollect();
		//判断toast提示内容是否符合预期
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNotNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏成功"+"')]"))));
		//收藏成功
	}
	/**
	 * 3
	 * 取消收藏
	 * @throws InterruptedException
	 */
	@Test(priority = 3,dependsOnMethods = {"login"})
	public void cancelCollect_inGoodRecomment() throws InterruptedException {
		mainPages.turn_success("我的");
		Thread.sleep(1500);
		myInformationPages.turn_to_target("我的商品");
		Thread.sleep(1500);
		allGoodsPage.clickOneGood(2);
		Thread.sleep(1500);
		//滑到底部
		int width = driver.manage().window().getSize().width;// 获取屏幕的宽
		int height = driver.manage().window().getSize().height;// 获取屏幕的长
		PointOption fromOption= PointOption.point(width/2, height*19/20);// 这里相当于一个坐标原点
		PointOption toOption= PointOption.point(width/2, height*1/20);// 这里相当于一个坐标原点
		for (int i = 0; i < 6; i++) {
			action.slide(fromOption, toOption);
		}
		//点击“想要”
		goodsDetailPage.click_btnCollect();
		//判断toast提示内容是否符合预期
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏成功"+"')]"))),"取消收藏失败");
		//无法取消收藏，故为bug
	}
	/**
	 *4
	 * 重复收藏
	 * @throws InterruptedException
	 */
	@Test(priority = 4,dependsOnMethods = {"login"})
	public void repeatCollect_inGoodRecomment() throws InterruptedException {
		mainPages.turn_success("我的");
		Thread.sleep(1500);
		myInformationPages.turn_to_target("我的商品");
		Thread.sleep(1500);
		allGoodsPage.clickOneGood(3);
		Thread.sleep(1500);
		//滑到底部
		int width = driver.manage().window().getSize().width;// 获取屏幕的宽
		int height = driver.manage().window().getSize().height;// 获取屏幕的长
		PointOption fromOption= PointOption.point(width/2, height*19/20);// 这里相当于一个坐标原点
		PointOption toOption= PointOption.point(width/2, height*1/20);// 这里相当于一个坐标原点
		for (int i = 0; i < 6; i++) {
			action.slide(fromOption, toOption);
		}
		//点击“想要”
		goodsDetailPage.click_btnCollect();
		//判断toast提示内容是否和第一次收藏不同
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏成功"+"')]"))),"取消收藏失败");
		//重复收藏的提示内容和第一次收藏相同，故为bug
	}
	/**
	 * 5
	 * 在”一周严选“的全部中收藏商品
	 * @throws InterruptedException
	 */
	@Test(priority = 5,dependsOnMethods = {"login"})
	public void addCollect_inAll() throws InterruptedException {
		//滑到底部
		int width = driver.manage().window().getSize().width;// 获取屏幕的宽
		int height = driver.manage().window().getSize().height;// 获取屏幕的长
		PointOption fromOption= PointOption.point(width/2, height*19/20);// 这里相当于一个坐标原点
		PointOption toOption= PointOption.point(width/2, height*1/20);// 这里相当于一个坐标原点
		mainPages.turn_success("推荐");
		Thread.sleep(1500);
		recommendPages.click_AllBtn();
		Thread.sleep(2000);
		//点击展示的第2个商品
		allGoodsPage.clickOneGood(1);
		Thread.sleep(1500);
		
		for (int i = 0; i < 6; i++) {
			action.slide(fromOption, toOption);
		}
		Thread.sleep(1500);
		//点击“想要”
		goodsDetailPage.click_btnCollect();
		//判断toast提示内容是否符合预期
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNotNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏成功"+"')]"))));
		//收藏成功
	}
	/**
	 * 6
	 * 在“品牌精选”中收藏商品
	 * @throws InterruptedException
	 */
	@Test(priority = 6,dependsOnMethods = {"login"})
	public void addCollect_inCateg1() throws InterruptedException {
		int width = driver.manage().window().getSize().width;// 获取屏幕的宽
		int height = driver.manage().window().getSize().height;// 获取屏幕的长
		PointOption fromOption= PointOption.point(width/2, height*19/20);// 这里相当于一个坐标原点
		PointOption toOption= PointOption.point(width/2, height*1/20);// 这里相当于一个坐标原点
		mainPages.turn_success("推荐");
		Thread.sleep(1500);
		//选择“品牌精选”
		recommendPages.click_oneCategory("品牌精选");;
		Thread.sleep(2000);
		//点击展示的第1个商品
		goodsCateDetailPage.clickOneGoods(0);
		Thread.sleep(1500);
		//滑到底部
		for (int i = 0; i < 6; i++) {
			action.slide(fromOption, toOption);
		}
		Thread.sleep(1500);
		//点击“想要”
		goodsDetailPage.click_btnCollect();
		//判断toast提示内容是否符合预期
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNotNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏成功"+"')]"))));
		//收藏成功
	}
	/**
	 * 7
	 * 在“智能硬件”中收藏商品
	 * @throws InterruptedException
	 */
	@Test(priority = 7,dependsOnMethods = {"login"})
	public void addCollect_inCateg2() throws InterruptedException {
		int width = driver.manage().window().getSize().width;// 获取屏幕的宽
		int height = driver.manage().window().getSize().height;// 获取屏幕的长
		PointOption fromOption= PointOption.point(width/2, height*19/20);// 这里相当于一个坐标原点
		PointOption toOption= PointOption.point(width/2, height*1/20);// 这里相当于一个坐标原点
		mainPages.turn_success("推荐");
		Thread.sleep(1500);
		//选择“智能硬件”
		recommendPages.click_oneCategory("智能硬件");;
		Thread.sleep(2000);
		//点击展示的第2个商品
		goodsCateDetailPage.clickOneGoods(1);
		Thread.sleep(1500);
		//滑到底部
		for (int i = 0; i < 6; i++) {
			action.slide(fromOption, toOption);
		}
		Thread.sleep(1500);
		//点击“想要”
		goodsDetailPage.click_btnCollect();
		//判断toast提示内容是否符合预期
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNotNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏成功"+"')]"))));
		//收藏成功
	}
	/**
	 * 8
	 * 在“女子服饰”中收藏商品
	 * @throws InterruptedException
	 */
	@Test(priority = 8,dependsOnMethods = {"login"})
	public void addCollect_inCateg3() throws InterruptedException {
		int width = driver.manage().window().getSize().width;// 获取屏幕的宽
		int height = driver.manage().window().getSize().height;// 获取屏幕的长
		PointOption fromOption= PointOption.point(width/2, height*19/20);// 这里相当于一个坐标原点
		PointOption toOption= PointOption.point(width/2, height*1/20);// 这里相当于一个坐标原点
		mainPages.turn_success("推荐");
		Thread.sleep(1500);
		//选择“女子服饰”
		recommendPages.click_oneCategory("女子服饰");;
		Thread.sleep(2000);
		//点击展示的第2个商品
		goodsCateDetailPage.clickOneGoods(1);
		Thread.sleep(1500);
		//滑到底部
		for (int i = 0; i < 6; i++) {
			action.slide(fromOption, toOption);
		}
		Thread.sleep(1500);
		//点击“想要”
		goodsDetailPage.click_btnCollect();
		//判断toast提示内容是否符合预期
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNotNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏成功"+"')]"))));
		//收藏成功
	}
	/**
	 * 9
	 * 在“男子服饰”中收藏商品
	 * @throws InterruptedException
	 */
	@Test(priority = 9,dependsOnMethods = {"login"})
	public void addCollect_inCateg4() throws InterruptedException {
		int width = driver.manage().window().getSize().width;// 获取屏幕的宽
		int height = driver.manage().window().getSize().height;// 获取屏幕的长
		PointOption fromOption= PointOption.point(width/2, height*19/20);// 这里相当于一个坐标原点
		PointOption toOption= PointOption.point(width/2, height*1/20);// 这里相当于一个坐标原点
		mainPages.turn_success("推荐");
		Thread.sleep(1500);
		//选择“男子服饰”
		recommendPages.click_oneCategory("男子服饰");;
		Thread.sleep(2000);
		//点击展示的第1个商品
		goodsCateDetailPage.clickOneGoods(0);
		Thread.sleep(1500);
		//滑到底部
		for (int i = 0; i < 6; i++) {
			action.slide(fromOption, toOption);
		}
		Thread.sleep(1500);
		//点击“想要”
		goodsDetailPage.click_btnCollect();
		//判断toast提示内容是否符合预期
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNotNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏成功"+"')]"))));
		//收藏成功
	}
	/**
	 * 10
	 * 在“运动装备”中收藏商品
	 * @throws InterruptedException
	 */
	@Test(priority = 10,dependsOnMethods = {"login"})
	public void addCollect_inCateg5() throws InterruptedException {
		int width = driver.manage().window().getSize().width;// 获取屏幕的宽
		int height = driver.manage().window().getSize().height;// 获取屏幕的长
		PointOption fromOption= PointOption.point(width/2, height*19/20);// 这里相当于一个坐标原点
		PointOption toOption= PointOption.point(width/2, height*1/20);// 这里相当于一个坐标原点
		mainPages.turn_success("推荐");
		Thread.sleep(1500);
		//选择“运动装备”
		recommendPages.click_oneCategory("运动装备");;
		Thread.sleep(2000);
		//点击展示的第3个商品
		goodsCateDetailPage.clickOneGoods(2);
		Thread.sleep(1500);
		//滑到底部
		for (int i = 0; i < 6; i++) {
			action.slide(fromOption, toOption);
		}
		Thread.sleep(1500);
		//点击“想要”
		goodsDetailPage.click_btnCollect();
		//判断toast提示内容是否符合预期
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNotNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏成功"+"')]"))));
		//收藏成功
	}
	
	
	/**
	 * 11
	 * 在“轻食代餐”中收藏商品
	 * @throws InterruptedException
	 */
	@Test(priority = 11,dependsOnMethods = {"login"})
	public void addCollect_inCateg6() throws InterruptedException {
		int width = driver.manage().window().getSize().width;// 获取屏幕的宽
		int height = driver.manage().window().getSize().height;// 获取屏幕的长
		PointOption fromOption= PointOption.point(width/2, height*19/20);// 这里相当于一个坐标原点
		PointOption toOption= PointOption.point(width/2, height*1/20);// 这里相当于一个坐标原点
		mainPages.turn_success("推荐");
		Thread.sleep(1500);
		//选择“轻食代餐”
		recommendPages.click_oneCategory("轻食代餐");;
		Thread.sleep(2000);
		//点击展示的第1个商品
		goodsCateDetailPage.clickOneGoods(0);
		Thread.sleep(1500);
		//滑到底部
		for (int i = 0; i < 6; i++) {
			action.slide(fromOption, toOption);
		}
		Thread.sleep(1500);
		//点击“想要”
		goodsDetailPage.click_btnCollect();
		//判断toast提示内容是否符合预期
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNotNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏成功"+"')]"))));
		//收藏成功
	}
	/**
	 * 12
	 * 在“运动生活”中收藏商品
	 * @throws InterruptedException
	 */
	@Test(priority = 11,dependsOnMethods = {"login"})
	public void addCollect_inCateg7() throws InterruptedException {
		int width = driver.manage().window().getSize().width;// 获取屏幕的宽
		int height = driver.manage().window().getSize().height;// 获取屏幕的长
		PointOption fromOption= PointOption.point(width/2, height*19/20);// 这里相当于一个坐标原点
		PointOption toOption= PointOption.point(width/2, height*1/20);// 这里相当于一个坐标原点
		mainPages.turn_success("推荐");
		Thread.sleep(1500);
		//选择“运动生活”
		recommendPages.click_oneCategory("运动生活");;
		Thread.sleep(2000);
		//点击展示的第3个商品
		goodsCateDetailPage.clickOneGoods(2);
		Thread.sleep(1500);
		//滑到底部
		for (int i = 0; i < 6; i++) {
			action.slide(fromOption, toOption);
		}
		Thread.sleep(1500);
		//点击“想要”
		goodsDetailPage.click_btnCollect();
		//判断toast提示内容是否符合预期
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNotNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏成功"+"')]"))));
		//收藏成功
	}
	/**
	 * 13
	 * 在“健身器材”中收藏商品
	 * @throws InterruptedException
	 */
	@Test(priority = 13,dependsOnMethods = {"login"})
	public void addCollect_inCateg8() throws InterruptedException {
		int width = driver.manage().window().getSize().width;// 获取屏幕的宽
		int height = driver.manage().window().getSize().height;// 获取屏幕的长
		PointOption fromOption= PointOption.point(width/2, height*19/20);// 这里相当于一个坐标原点
		PointOption toOption= PointOption.point(width/2, height*1/20);// 这里相当于一个坐标原点
		mainPages.turn_success("推荐");
		Thread.sleep(1500);
		//选择“健身器材”
		recommendPages.click_oneCategory("健身器材");;
		Thread.sleep(2000);
		//点击展示的第3个商品
		goodsCateDetailPage.clickOneGoods(2);
		Thread.sleep(1500);
		//滑到底部
		for (int i = 0; i < 6; i++) {
			action.slide(fromOption, toOption);
		}
		Thread.sleep(1500);
		//点击“想要”
		goodsDetailPage.click_btnCollect();
		//判断toast提示内容是否符合预期
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNotNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏成功"+"')]"))));
		//收藏成功
	}
}
