package com.sport.pages;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import utils.BaseAction;

public class BodybuildingPages {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;

	public BodybuildingPages(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.action = new BaseAction(driver);
	}

	// 1,进入主页，点击健身百科，点击塑性，查看页面显示情况
	public AndroidElement click_suxing() {
		return driver.findElementsById("com.example.fitnessdemo:id/ll_test").get(3);
	}

	public void inter_one() throws InterruptedException {
		action.click(click_suxing());
		Thread.sleep(3000);
	}

	// 2,进入主页，点击健身百科，点击上方的滑动图片（有bug）
	public AndroidElement click_tupian() {
		return driver.findElementsByClassName("android.widget.ImageView").get(1);
	}

	public void inter_two() throws InterruptedException {
		action.click(click_tupian());
		Thread.sleep(3000);
	}

	// 3，进入主页，点击健身百科，点击减脂，点击瘦腿
	public AndroidElement click_jianzhi() {
		return driver.findElementsById("com.example.fitnessdemo:id/ll_test").get(1);
	}

	public AndroidElement click_shoutui() {
		return driver.findElementsById("com.example.fitnessdemo:id/clb_tv_1").get(1);
	}

	public void inter_three() throws InterruptedException {
		action.click(click_jianzhi());
		Thread.sleep(3000);
		action.click(click_shoutui());
		Thread.sleep(3000);
	}

	// 4,进入主页，点击健身百科，点击饮食，点击健康餐，将相关内容向左滑动到底
	public void drag(AndroidElement from, AndroidElement to) {
		// 长按，拖动
		AndroidTouchAction action = new AndroidTouchAction(driver);

		LongPressOptions longOptions = LongPressOptions.longPressOptions();
		longOptions.withElement(ElementOption.element(from));

		action.longPress(longOptions).moveTo(ElementOption.element(to)).release().perform();
	}

	public AndroidElement click_yinshi() {
		return driver.findElementsById("com.example.fitnessdemo:id/ll_test").get(0);
	}

	public AndroidElement click_jiankangcan() {
		return driver.findElementsById("com.example.fitnessdemo:id/clb_tv_1").get(1);
	}

	public void inter_four() throws InterruptedException {
		action.click(click_yinshi());
		Thread.sleep(3000);
		action.click(click_jiankangcan());
		Thread.sleep(3000);
		AndroidElement e1 = driver.findElementByXPath("//*[@text='饮食计划']");
		AndroidElement e2 = driver.findElementByXPath("//*[@text='相关']");
		drag(e1, e2);
		AndroidElement e3 = driver.findElementByXPath("//*[@text='孕期饮食']");
		AndroidElement e4 = driver.findElementByXPath("//*[@text='懒人食谱']");
		drag(e3, e4);
		Thread.sleep(3000);
	}

	// 5,进入主页，点击健身百科，点击饮食，点击健康餐，点击相关中的的增肌饮食
	public AndroidElement click_zengjiyinshi() {
		return driver.findElementByXPath("//*[@text='增肌饮食']");
	}

	public void inter_five() throws InterruptedException {
		action.click(click_yinshi());
		Thread.sleep(3000);
		action.click(click_jiankangcan());
		Thread.sleep(3000);
		action.click(click_zengjiyinshi());
		Thread.sleep(3000);
	}

	// 6,进入主页，点击健身百科，点击饮食，点击健康餐，点击相关中的的增肌饮食，点击官方必读的第一篇文章
	public AndroidElement click_wenzhang() {
		return driver.findElementByXPath("//*[@text='蛋白质吃够了，为什么肌肉还是长不起来？']");
	}

	public void inter_six() throws InterruptedException {
		action.click(click_yinshi());
		Thread.sleep(3000);
		action.click(click_jiankangcan());
		Thread.sleep(3000);
		action.click(click_zengjiyinshi());
		Thread.sleep(3000);
		action.click(click_wenzhang());
		Thread.sleep(3000);
	}

	// 7,进入主页，点击健身百科，点击减脂，点击瘦脸，点击关注，返回，再次进入
	public AndroidElement click_shoulian() {
		return driver.findElementsById("com.example.fitnessdemo:id/clb_tv_1").get(3);
	}

	public AndroidElement click_guanzhu() {
		return driver.findElementById("com.example.fitnessdemo:id/clb_btn_stair2_1");
	}

	public AndroidElement click_back() {
		return driver.findElementById("com.example.fitnessdemo:id/clb_iv_stair2_back");
	}

	public void inter_seven() throws InterruptedException {
		action.click(click_jianzhi());
		Thread.sleep(3000);
		action.click(click_shoulian());
		Thread.sleep(3000);
		action.click(click_guanzhu());
		Thread.sleep(3000);
		action.click(click_back());
		Thread.sleep(3000);
		action.click(click_jianzhi());
		Thread.sleep(3000);
		action.click(click_shoulian());
		Thread.sleep(3000);
	}

	// 8,进入主页，点击健身百科，点击饮食，点击减脂餐，点击免费课程
	public AndroidElement click_jianzhican() {
		return driver.findElementsById("com.example.fitnessdemo:id/clb_tv_1").get(0);
	}

	public AndroidElement click_free() {
		return driver.findElementByXPath("//*[@text='免费课程']");
	}

	public void inter_eight() throws InterruptedException {
		action.click(click_yinshi());
		Thread.sleep(3000);
		action.click(click_jianzhican());
		Thread.sleep(3000);
		action.click(click_free());
		Thread.sleep(3000);
	}

	// 9,进入主页，点击健身百科，点击瑜伽，点击一字马，进行分享（有bug,没有跳转页面）
	public AndroidElement click_yujia() {
		return driver.findElementsById("com.example.fitnessdemo:id/ll_test").get(5);
	}

	public AndroidElement click_yizima() {
		return driver.findElementsById("com.example.fitnessdemo:id/clb_tv_1").get(3);
	}

	public AndroidElement click_share() {
		return driver.findElementsByClassName("android.widget.ImageView").get(1);
	}

	public void inter_nine() throws InterruptedException {
		action.click(click_yujia());
		Thread.sleep(3000);
		action.click(click_yizima());
		Thread.sleep(3000);
		action.click(click_share());
		Thread.sleep(3000);
	}

	// 10,进入主页，点击健身百科，左侧栏滑动到最底端
	public void inter_ten() throws InterruptedException {
		AndroidElement caoke = driver.findElementsById("com.example.fitnessdemo:id/ll_test").get(10);
		AndroidElement yunqi = driver.findElementsById("com.example.fitnessdemo:id/ll_test").get(8);
		drag(caoke, yunqi);
		Thread.sleep(3000);
	}

	// 11,进入主页，点击健身百科，点击饮食，滑动到最低端
	public void inter_eleven() throws InterruptedException {
		AndroidElement breakfast = driver.findElementsById("com.example.fitnessdemo:id/clb_tv_1").get(6);
		AndroidElement shipu = driver.findElementsById("com.example.fitnessdemo:id/clb_tv_1").get(4);
		drag(breakfast, shipu);
		Thread.sleep(3000);
	}

	// 12,进入主页，点击健身百科，点击饮食，点击减脂餐，点击第一条官方必读，并滑动到底端
	public AndroidElement click_wenzhang_one() {
		return driver.findElementsById("com.example.fitnessdemo:id/clb_tv_stair3_1").get(0);
	}

	public void VerticalSwip(double i, AndroidElement e0) {
		// 获取屏幕的宽度和高度
		Dimension dimension = driver.manage().window().getSize();
		int height = dimension.getHeight();
		int width = dimension.getWidth();
		int fromx = width / 2;
		int fromy = height / 2;

		int tox = fromx;
		int toy = (int) (height * (i));

		AndroidTouchAction action = new AndroidTouchAction(driver);
		LongPressOptions longPress = LongPressOptions.longPressOptions();
		longPress.withElement(ElementOption.element(e0));

		action.press(PointOption.point(fromx, fromy)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(tox, toy)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.release().perform();
	}

	public void inter_twelve() throws InterruptedException {
		action.click(click_yinshi());
		Thread.sleep(3000);
		action.click(click_jianzhican());
		Thread.sleep(3000);
		action.click(click_wenzhang_one());
		Thread.sleep(3000);
		AndroidElement e0 = driver.findElementById("com.example.fitnessdemo:id/clb_tv_essay_title");
		VerticalSwip(-3, e0);
		Thread.sleep(3000);
	}

	// 13,进入主页，点击健身百科，点击饮食，点击减脂餐，点击免费课程，点击第一个课程
	public AndroidElement click_kecheng() {
		return driver.findElementsById("com.example.fitnessdemo:id/picture").get(0);
	}

	public void inter_thirteen() throws InterruptedException {
		action.click(click_yinshi());
		Thread.sleep(3000);
		action.click(click_jianzhican());
		Thread.sleep(3000);
		action.click(click_free());
		Thread.sleep(3000);
		action.click(click_kecheng());
		Thread.sleep(3000);
	}

	// 14,进入主页，点击健身百科，点击饮食，点击减脂餐，点击免费课程，点击第一个课程，并收藏课程，进入我的收藏中查看
	public void inter_fourteen() throws InterruptedException {
		action.click(click_yinshi());
		Thread.sleep(3000);
		action.click(click_jianzhican());
		Thread.sleep(3000);
		action.click(click_free());
		Thread.sleep(3000);
		action.click(click_kecheng());
		Thread.sleep(3000);
	}

	// 15,进入主页，点击健身百科，点击饮食，点击减脂餐，点击免费课程，点击第一个课程，并收藏课程，再次进入第一个课程，查看显示我已收藏
	public void inter_fifteen() throws InterruptedException {
		action.click(click_yinshi());
		Thread.sleep(3000);
		action.click(click_jianzhican());
		Thread.sleep(3000);
		action.click(click_free());
		Thread.sleep(3000);
		action.click(click_kecheng());
		Thread.sleep(3000);
	}

	// 16,进入主页，点击健身百科，点击饮食，点击减脂餐，点击免费课程，点击第一个课程，点击视频列表，查看第一个视频
	public void inter_sixteen() throws InterruptedException {
		action.click(click_yinshi());
		Thread.sleep(3000);
		action.click(click_jianzhican());
		Thread.sleep(3000);
		action.click(click_free());
		Thread.sleep(3000);
		action.click(click_kecheng());
		Thread.sleep(3000);
	}

	// 17,进入主页，点击健身百科，点击饮食，点击减脂餐，点击第一条官方必读，并进行分享
	public void inter_seventeen() throws InterruptedException {
		action.click(click_yinshi());
		Thread.sleep(3000);
		action.click(click_jianzhican());
		Thread.sleep(3000);
		action.click(click_wenzhang_one());
		Thread.sleep(3000);
		action.click(click_share());
		Thread.sleep(3000);
	}

	// 18,进入主页，点击健身百科，点击饮食，点击减脂餐，点击免费课程，并滑动到底端
	public void inter_eighteen() throws InterruptedException {
		action.click(click_yinshi());
		Thread.sleep(3000);
		action.click(click_jianzhican());
		Thread.sleep(3000);
		action.click(click_free());
		Thread.sleep(3000);
		AndroidElement elem1 = driver.findElementsById("com.example.fitnessdemo:id/picture").get(0);
		VerticalSwip(0.1, elem1);
		Thread.sleep(3000);
	}

	// 19,进入主页，点击健身百科，点击体态，上滑动切换至舞蹈模块
	public AndroidElement click_titai() {
		return driver.findElementsById("com.example.fitnessdemo:id/ll_test").get(6);
	}

	public void inter_nineteen() throws InterruptedException {
		action.click(click_titai());
		Thread.sleep(3000);
		AndroidElement elem2 = driver.findElementsByClassName("android.widget.LinearLayout").get(1);
		VerticalSwip((-1), elem2);
		Thread.sleep(3000);
	}

	// 20,进入主页，点击健身百科，点击产后，下滑动切换至孕期模块
	public AndroidElement click_chanhou() {
		return driver.findElementsById("com.example.fitnessdemo:id/ll_test").get(9);
	}

	public void inter_twenty() throws InterruptedException {
		action.click(click_chanhou());
		Thread.sleep(3000);
		AndroidElement elem2 = driver.findElementsByClassName("android.widget.LinearLayout").get(1);
		VerticalSwip((2), elem2);
		Thread.sleep(3000);
	}
}
