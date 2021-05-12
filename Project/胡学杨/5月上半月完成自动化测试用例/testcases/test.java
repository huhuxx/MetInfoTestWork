package com.sport.testcases;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class test {
	public static void main(String[] args) throws IOException {
		AndroidDriver<AndroidElement> driver;
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
    	DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("deviceName", "127.0.0.1:62001");
        capabilities.setCapability("appPackage", "com.example.fitnessdemo");
		capabilities.setCapability("appActivity", ".ws.LoginActivity");
		capabilities.setCapability("noReset", true);
		driver=new AndroidDriver<AndroidElement>(url,capabilities);
	}
}
