import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class IosUICatlogAutomation {

	@Test
	public void testiosApp() throws MalformedURLException{
		
		URL appiumUrl = new URL("http://localhost:4723/wd/hub");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
//		caps.setCapability(MobileCapabilityType.UDID, "unique device id ideviceid -l");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5 * 60);
		caps.setCapability(MobileCapabilityType.APP, "/Users/vikasthange/apps/UICatalog.app");
		
		IOSDriver<MobileElement> driver = new IOSDriver<MobileElement>(appiumUrl,caps);
		System.out.println(driver.getPageSource());
		System.out.println(driver.getContextHandles());
		driver.findElement(By.name("Alert Views")).click();
		driver.findElement(By.name("Text Entry")).click();
		driver.findElement(By.xpath("//XCUIElementTypeAlert//XCUIElementTypeTextField")).sendKeys("Vikas");
//		Alert a = driver.switchTo().alert();
//		a.sendKeys("Vikas");
//		a.accept();
		driver.findElement(By.name("OK")).click();
		driver.findElement(By.cssSelector(".ac-gn-menuicon-bread")).click();
		driver.context("WEBVIEW_24726.1");
		
	}
	@Test
	public void testiosWebApp() throws MalformedURLException{
		
		URL appiumUrl = new URL("http://localhost:4723/wd/hub");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
//		caps.setCapability(MobileCapabilityType.UDID, "unique device id ideviceid -l");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5 * 60);
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
		
		IOSDriver<MobileElement> driver = new IOSDriver<MobileElement>(appiumUrl,caps);
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Vikas Thange"+ Keys.ENTER);
	}
}
