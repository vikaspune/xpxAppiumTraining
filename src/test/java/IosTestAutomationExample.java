import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class IosTestAutomationExample {

	@Test
	public void testCase1() throws MalformedURLException{
		
		// Launch app 
		// close app
		
		URL appiumUrl = new URL("http://localhost:4723/wd/hub");
		DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability( MobileCapabilityType.APP, "/Users/vikasthange/apps/ContactManager.apk");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ANDROID");
		
		
		/*
		 * mandatory capability
		 * app    browser_name
		 * deviceName 
		 */
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(appiumUrl,caps);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		waitForSeconds(10);
		driver.findElement(By.id("com.example.android.contactmanager:id/addContactButton")).click();
		driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys("VikasT");
		driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).sendKeys("9762204018");
		driver.findElement(By.xpath("//*[@text='Save']")).click();
		Assert.assertTrue(isElementDisplayed(driver,By.id("com.example.android.contactmanager:id/addContactButton")));
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
