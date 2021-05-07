package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    public  AndroidDriver<AndroidElement> driver;
    @BeforeClass
    public void startUp () throws MalformedURLException {
    	URL url=new URL("http://127.0.0.1:4723/wd/hub");
    	DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("deviceName", "127.0.0.1:62001");
        capabilities.setCapability("appPackage", "com.example.android.notepad");
		capabilities.setCapability("appActivity", ".NotesList");
		capabilities.setCapability("noReset", true);
		driver=new AndroidDriver<AndroidElement>(url,capabilities);
		
    }
   //@AfterClass
 	public void tearDown() {
 		if (driver != null) {
 			driver.quit();
 		}
 	}
   
}
