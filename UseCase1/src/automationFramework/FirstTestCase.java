package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTestCase {
	public static void main(String[] args) throws InterruptedException {
		//if you didn't update the Path system variable to add the full directory path to the executable as above mentioned then doing this directly through code
		System.setProperty("webdriver.chrome.driver", "//Users//nurulatiqah//Downloads//chromedriver");		
		// Create a new instance of the Firefox driver
		WebDriver driver = new ChromeDriver();

		//Launch the facebook Website
		driver.get("http://www.facebook.com");

		// Print a Log In message to the screen
		System.out.println("Successfully opened Facebook website!");

		//Wait for 5 Secs
		Thread.sleep(5000);

		// Close the driver
		driver.quit();
	}
}
