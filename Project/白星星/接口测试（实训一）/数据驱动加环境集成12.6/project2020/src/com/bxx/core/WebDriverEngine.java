package com.bxx.core;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.bxx.utils.Log;




public class WebDriverEngine {

	WebDriver driver = null;
	ElementFinder finder = null;
	Actions action  =null;

	public WebDriverEngine(WebDriver driver) {
		
		this.driver = driver;
		driver.manage().window().maximize();
		finder = new ElementFinder(driver);
		action = new Actions(driver);
	}
	public String[] getAllWindowTitles() {
		// TODO Auto-generated method stub
	    String current = driver.getWindowHandle();

	    List<String> attributes = new ArrayList<String>();
	    for (String handle : driver.getWindowHandles()) {
	      driver.switchTo().window(handle);
	      attributes.add(driver.getTitle());
	    }

	    driver.switchTo().window(current);

	    return attributes.toArray(new String[attributes.size()]);
	}


	public void enterFrame(String frameID) throws InterruptedException {
		this.pause(3000);
		driver.switchTo().frame(frameID);
		Log.info("Entered iframe " + frameID);
	}
	public void enterFrame(int frameID) throws InterruptedException {
		this.pause(3000);
		driver.switchTo().frame(frameID);
		Log.info("Entered iframe " + frameID);
	}
	
	public void enterFrame1(String locator) throws InterruptedException {
		WebElement element = finder.findElement(locator);
		this.pause(3000);
		driver.switchTo().frame(element);
		Log.info("Entered iframe " + element);
	}


	public void leaveFrame() {
		driver.switchTo().defaultContent();
		Log.info("Left the iframe");
	}

	public void open(String url) {

		try {
			driver.get(url);
			pause(5000);
		} catch (Exception e) {
			e.printStackTrace();

		}
		Log.info("Opened url " + url);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	private void pause(int time) throws InterruptedException {
		if (time <= 0) {
			return;
		}
		Thread.sleep(time);
	}

	public void leave() {
		driver.close();
	}
	
	
	public boolean isTextPresent(String pattern) {

		String text = driver.getPageSource();
		text = text.trim();
		if (text.contains(pattern)) {
			return true;
		}
		return false;
	}
	public void enter() {
		action.sendKeys(Keys.ENTER);
	}

	public void typeAndClear(String locator, String value) {
		WebElement element = finder.findElement(locator);
		element.clear();
		element.sendKeys(value);
//		if (element != null) {
//			element.clear();
//			element.sendKeys(value);
//		} else {
//			System.out.println("typeAndClear()元素未找到");
//		}
	}
	public void typeAndClear(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public void type(String locator, String value) {
		WebElement element = finder.findElement(locator);
		element.sendKeys(value);
//		if (element != null) {
//			element.sendKeys(value);
//		} else {
//			System.out.println("type()元素未找到");
//		}
	}


	public void type(WebElement element, String value) {
		element.sendKeys(value);
	}
	public boolean isChecked(String locator) {
		WebElement element = finder.findElement(locator);
		return element.isSelected();
	}

	public void click(String locator) throws InterruptedException {

		WebElement element = finder.findElement(locator);
		element.click();
		this.pause(3000);
//		if (element != null) {
//			element.click();
//			this.pause(3000);
//		} else {
//			System.out.println("click()元素未找到");
//		}
	}
	
	public void click(WebElement element) throws InterruptedException {
		element.click();
		this.pause(3000);
	}
		
	
	
	public List<WebElement> backlist(String target) {
		return finder.findElements(target);
		
	}
	

	public void clickLonger(String locator) throws InterruptedException {

		WebElement element = finder.findElement(locator);
		runJs("window.scrollTo(0," + element.getLocation().x + ")");
		element.click();
		this.pause(3000);
//		if (element != null) {
//			runJs("window.scrollTo(0," + element.getLocation().x + ")");
//			element.click();
//			this.pause(3000);
//		} else {
//			System.out.println("clickLonger()元素未找到");
//		}
	}

	public void doubleClick(String locator) throws InterruptedException {
		WebElement element = finder.findElement(locator);
	
		action.doubleClick(element).build().perform();
	}

	public void doubleClick(WebElement element) throws InterruptedException {
		
		action.doubleClick(element).build().perform();
	}
	public boolean isDisplayed(String locator) {

		WebElement element = finder.findElement(locator);
		return element.isDisplayed();
//		if (element != null) {
//			return element.isDisplayed();
//		} else {
//			System.out.println("isDisplayed()元素未找到");
//		}
//		return false;
	}

	public String getText(String locator) {

		return finder.findElement(locator).getText().trim();
	}

	public boolean isElementPresent(String locator) {

		WebElement element = null;
		element = finder.findElement(locator);
//		try {
//			element = finder.findElement(locator);
//		} catch (Exception e) {
//
//			Log.info(e.getMessage());
//		}
		if (element != null) {
			return true;
		}
		{
			return false;
		}
	}

	public String getValue(String locator) {

		return finder.findElement(locator).getAttribute("value");
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public void goBack() {
		driver.navigate().back();
	}

	public void goForward() {

		driver.navigate().forward();
	}

	public Alert getAlert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	public String getAlertTest() {

		return getAlert().getText();
	}

	public void alertAccept() {

		getAlert().accept();
		}

	public Select getSelect(String locator) {
		Select inputSelect = new Select(finder.findElement(locator));
		return inputSelect;
	}

	public void selectByValue(String locator, String value) throws InterruptedException {
		getSelect(locator).selectByValue(value);
		this.pause(5000);
	}

	public void selectByVisibleText(String locator, String value) {
		getSelect(locator).selectByVisibleText(value);
	}

	public void selectByIndex(String locator, int index) {
		getSelect(locator).selectByIndex(index);
	}

	

	public String getHtmlSource() {

		return driver.getPageSource();
	}

	public void runJs(String js) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript(js);
	}


	public void mouseToElement(String locator) throws InterruptedException {
		action.moveToElement(finder.findElement(locator)).perform();
	}

	public void mouseToElementandClick(String locator) throws InterruptedException {
		action.moveToElement(finder.findElement(locator)).click().perform();
	}
	
	public void switchWidow(int i){
	    List<String> windows = new ArrayList<String>();
	    for (String handle : driver.getWindowHandles()) {
	    
	    	windows.add(handle);
	    }
	    driver.switchTo().window(windows.get(i));
	}
	public String switchtoalert() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	//�Ҽ�
	public void rightClickMouse(String locator) throws InterruptedException {
		action.contextClick(finder.findElement(locator)).perform();
		}
	//Tab��
	public void tapClick(){
	
		action.sendKeys(Keys.TAB).perform();;
	}
	
	public void tapType(String content){
		
			action.sendKeys(content).perform();
		}
	
	public void getWindow(int i){
		List<String> windows = new ArrayList<String>();
		for (String handle : driver.getWindowHandles())
		{
			//System.out.println(handle);  //杩涘叆鍒扮浜屼釜椤甸潰
			windows.add(handle);
		}
		driver.switchTo().window(windows.get(i));
	}
	
	
}
