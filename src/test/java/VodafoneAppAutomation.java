import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class VodafoneAppAutomation {

	@Test
	public void testAppLauncg() throws MalformedURLException{
		URL appiumUrl = new URL("http://localhost:4723/wd/hub");
		DesiredCapabilities caps;
		caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "S5");
		caps.setCapability(MobileCapabilityType.APP, "/Users/vikasthange/apps/MyVodafone8.0.0.3.apk");
		caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(appiumUrl,caps);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		waitForSeconds(5);
		System.out.println(driver.getPageSource());
	}

	private void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}




//WebDriverWait wait = new WebDriverWait(driver, 10*60);
//wait.pollingEvery(10, TimeUnit.SECONDS);
////System.out.println("Waiting for Hold on to get invisible");
////wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@content-desc='Hang on...']")));
//System.out.println("Waiting for Login screen");
//WebElement loginElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Log in']")));
//loginElement.click();
//System.out.println("Typing mobile no");
//driver.findElement(By.id("loginMsisdn")).sendKeys("123456789");
//System.out.println("Clicking on generate login");
//driver.findElement(By.id("mva_login_genrate_otp_button")).click();
//System.out.println("Test executed!!");
