package automationFramework;

import pageObjects.LoginPage;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginTest {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
	    System.setProperty("webdriver.firefox.marionette","//Users//nurulatiqah//eclipse-workspace//UseCase1//geckodriver");
	    driver=new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.get("http://www.facebook.com");
	}
	//right username, right password
	@Test(priority=1)
	public void verify1()
	{
	    LoginPage login=new LoginPage(driver);
	    login.set_username("admin");
	    login.set_password("admin");
	    login.click_button();
	    Assert.assertTrue(driver.getPageSource().contains("Upcoming Product"));
	}
	//wrong username, right password
	@Test(priority=2)
	public void verify2()
	{
	    LoginPage login=new LoginPage(driver);
	    login.set_username("adm");
	    login.set_password("admin");
	    login.click_button();
	    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='errorMessage']")).getText(),"Wrong username or password!");
	}
	//right username, wrong password
	@Test(priority=3)
	public void verify3()
	{
	    LoginPage login=new LoginPage(driver);
	    login.set_username("admin");
	    login.set_password("adm");
	    login.click_button();
	    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='errorMessage']")).getText(),"Wrong username or password!");
	}
	//wrong username, wrong password
	@Test(priority=4)
	public void verify4()
	{
	    LoginPage login=new LoginPage(driver);
	    login.set_username("adm");
	    login.set_password("adm");
	    login.click_button();
	    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='errorMessage']")).getText(),"Wrong username or password!");
	}
	//blank username, blank password
	@Test(priority=5)
	public void verify5()
	{
	    LoginPage login=new LoginPage(driver);
	    login.set_username("");
	    login.set_password("");
	    login.click_button();
	    //getting the rgb red in color value -- rgb(239, 83, 80)
	    //split everything to only get the numbers value
	    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='userName']")).getCssValue("border-bottom-color").replaceAll("(rgba)|(rgb)|(\\()|(\\s)|(\\))","").split(","),"2398380");
	    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='password']")).getCssValue("border-bottom-color").replaceAll("(rgba)|(rgb)|(\\()|(\\s)|(\\))","").split(","),"2398380");
	}
	//right username, blank password
	@Test(priority=6)
	public void verify6()
	{
	    LoginPage login=new LoginPage(driver);
	    login.set_username("admin");
	    login.set_password("");
	    login.click_button();
	    //getting the rgb red in color value -- rgb(239, 83, 80)
	    //split everything to only get the numbers value
	    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='password']")).getCssValue("border-bottom-color").replaceAll("(rgba)|(rgb)|(\\()|(\\s)|(\\))","").split(","),"2398380");
	}
	//blank username, right password
	@Test(priority=7)
	public void verify7()
	{
	    LoginPage login=new LoginPage(driver);
	    login.set_username("");
	    login.set_password("admin");
	    login.click_button();
	    //getting the rgb red in color value -- rgb(239, 83, 80)
	    //split everything to only get the numbers value
	    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='userName']")).getCssValue("border-bottom-color").replaceAll("(rgba)|(rgb)|(\\()|(\\s)|(\\))","").split(","),"2398380");
	}
	//5 spaces username, 5 spaces password
	@Test(priority=8)
	public void verify8()
	{
	    LoginPage login=new LoginPage(driver);
	    login.set_username("     ");
	    login.set_password("     ");
	    login.click_button();
	    //getting the rgb red in color value -- rgb(239, 83, 80)
	    //split everything to only get the numbers value
	    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='userName']")).getCssValue("border-bottom-color").replaceAll("(rgba)|(rgb)|(\\()|(\\s)|(\\))","").split(","),"2398380");
	    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='password']")).getCssValue("border-bottom-color").replaceAll("(rgba)|(rgb)|(\\()|(\\s)|(\\))","").split(","),"2398380");
	}
	//additional test case can be:
	//URL is https instead of http
	//once logged in, clicking back button doesn't logout user
	//password can be copied paste
	//number of unsuccessful attempts
	@AfterTest
	public void close()
	{
	    driver.close();
	}
}
