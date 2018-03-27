package automationFramework;

import pageObjects.ForgotPasswordPage;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ForgotPasswordTest {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
	    System.setProperty("webdriver.firefox.marionette","pathToGeckodriver");
	    driver=new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.get("forgotPasswordURL");
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
