package automationFramework;

import pageObjects.ForgotPasswordPage;
import org.testng.Assert;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ForgotPasswordTest {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		File appDir = new File(System.getProperty("user.dir"), "../../../apps/TestApp/build/Release-iphonesimulator");
		File app = new File(appDir, "TestApp.app");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
	    capabilities.setCapability(CapabilityType.VERSION, "6.0");
	    capabilities.setCapability(CapabilityType.PLATFORM, "Mac");

	    //tell Appium where the location of the app is
	    capabilities.setCapability("app", app.getAbsolutePath());

	    //create a RemoteWebDriver, the default port for Appium is 4723
	    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	//valid email
	@Test(priority=1)
	public void verify1()
	{
	    ForgotPasswordPage forgotPassword=new ForgotPasswordPage(driver);
	    forgotPassword.set_email("admin@gmail.com");
	    forgotPassword.click_button();
	    Assert.assertTrue(driver.getPageSource().contains("An email to reset your password has been sent to"));
	}
	//not valid email
	@Test(priority=2)
	public void verify2()
	{
	    ForgotPasswordPage forgotPassword=new ForgotPasswordPage(driver);
	    forgotPassword.set_email("adm@gmail.com");
	    forgotPassword.click_button();
	    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='errorMessage']")).getText(),"Wrong email!");
	}
	//blank email
	@Test(priority=2)
	public void verify3()
	{
	    ForgotPasswordPage forgotPassword=new ForgotPasswordPage(driver);
	    forgotPassword.set_email("");
	    forgotPassword.click_button();
	    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='email']")).getCssValue("border-bottom-color").replaceAll("(rgba)|(rgb)|(\\()|(\\s)|(\\))","").split(","),"2398380");
	}
	@AfterTest
	public void close()
	{
	    driver.close();
	}
}
