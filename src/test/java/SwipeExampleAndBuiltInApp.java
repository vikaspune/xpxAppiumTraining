
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class SwipeExampleAndBuiltInApp {
	AndroidDriver<AndroidElement> driver;
	DesiredCapabilities caps;
	TouchAction act;

	@Test(priority = 1)
	public void setUp() {
		caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "S5");
		caps.setCapability("appPackage", "com.android.settings");
		caps.setCapability("appActivity", ".Settings");

		try {
			driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), caps);
			act = new TouchAction(driver);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void swipeUp() {
		act = new TouchAction(driver);
		act.longPress(72, 1757).moveTo(72, 417).release().perform();
	}

	@Test(priority = 3)
	public void swipeDown() {
		act = new TouchAction(driver);
		act.longPress(72, 417).moveTo(72, 1757).release().perform();
	}

	@Test(priority = 4)
	public void TurnOnAndOffWiFi() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Connections']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Wi-Fi']")).click();
		driver.findElement(By.id("com.android.settings:id/switch_widget")).click();
		driver.findElement(By.id("com.android.settings:id/switch_widget")).click();
	}

}
