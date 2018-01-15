import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class FirstIOSAutomationExample {

	@Test
	public void testCase1() throws MalformedURLException{
		
		// Launch app 
		// close app
		
		URL appiumUrl = new URL("http://localhost:4723/wd/hub");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);
		caps.setCapability( MobileCapabilityType.APP, "/Users/vikasthange/apps/v9.2-int-423581.ipa");
		caps.setCapability(MobileCapabilityType.UDID, "a78ed28e52d89afb365e6373ba9e6867fd02660d");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 500);
		caps.setCapability(IOSMobileCapabilityType.COMMAND_TIMEOUTS, "180000");

		IOSDriver<MobileElement> driver = new IOSDriver<MobileElement>(appiumUrl,caps);
		driver.switchTo().alert().accept();
		System.out.println(driver.getPageSource());
		driver.quit();
		
	}

	private void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private boolean isElementDisplayed(AndroidDriver<MobileElement> driver, By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
