package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Point;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BaseAction {
	public AndroidDriver<AndroidElement> driver;
	public AndroidTouchAction action;

	public BaseAction(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		action = new AndroidTouchAction(driver);

	}

	/**
	 * @param by
	 */
	public void click(By by) {
		driver.findElement(by).click();
	}

	public void click(WebElement elemnet) {
		elemnet.click();
	}

	/**
	 * ����
	 * 
	 * @param by
	 * @param value
	 */
	public void type(By by, String value) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);

	}

	public void type(WebElement element, String context) {
		element.clear();
		element.sendKeys(context);
	}

	/**
	 * ����
	 * 
	 * @param element
	 */
	public void longPress(WebElement element) {
		LongPressOptions longPressOptions = LongPressOptions.longPressOptions();
		longPressOptions.withElement(ElementOption.element(element));
		action.longPress(longPressOptions).release().perform();
	}

	/**
	 * �����Ļ���
	 * 
	 * @param fromOption
	 * @param toOption
	 */
	public void slide(PointOption fromOption, PointOption toOption) {
		action.press(fromOption).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(toOption)
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).release().perform();
	}

	/**
	 * Ԫ�ؼ�Ļ���
	 * 
	 * @param fromEle
	 * @param toEle
	 */
	public void slide(WebElement fromEle, WebElement toEle) {

		slide(ElementOption.element(fromEle), ElementOption.element(toEle));
	}

	/**
	 * �����϶�
	 * 
	 * @param element
	 */
	public void dragAndSlide(AndroidElement element) {

		LongPressOptions longPressOptions = LongPressOptions.longPressOptions();
		longPressOptions.withElement(ElementOption.element(element));

		action.longPress(longPressOptions).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(100, element.getLocation().getY()))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).release().perform();
	}
	
	public void drag(AndroidElement from, AndroidElement to) {
		// 长按，拖动

		LongPressOptions longOptions = LongPressOptions.longPressOptions();
		longOptions.withElement(ElementOption.element(from));

		action.longPress(longOptions).moveTo(ElementOption.element(to)).release().perform();
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
//		LongPressOptions longPress = LongPressOptions.longPressOptions();
//		longPress.withElement(ElementOption.element(e0));

		action.press(PointOption.point(fromx, fromy)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(tox, toy)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.release().perform();
	}
/**
 * ��㴥�ع���ʵ��
 * @param x1
 * @param y1
 * @param x2
 * @param y2
 * @param x3
 * @param y3
 */
	public void multiTouch(int x1, int y1, int x2, int y2, int x3, int y3) {
		MultiTouchAction multiAction = new MultiTouchAction(driver);
		AndroidTouchAction action1 = new AndroidTouchAction(driver);
		AndroidTouchAction action2 = new AndroidTouchAction(driver);
		AndroidTouchAction action3 = new AndroidTouchAction(driver);
		AndroidTouchAction action4 = new AndroidTouchAction(driver);
		AndroidTouchAction action5 = new AndroidTouchAction(driver);

		action1.longPress(PointOption.point(x1, y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.release();
		action2.longPress(PointOption.point(x2, y2)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.release();
		action3.longPress(PointOption.point(x3, y3)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.release();

		multiAction.add(action1).add(action2).add(action3).add(action4).add(action5).perform();
	}
/**
 * ����Toast���ı���Ϣ
 */
	public String getToast() {
		return driver.findElementByXPath("//*[@class='android.widget.Toast']").getText();
	}
}
