package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	private WebDriver driver;

    @FindBy(id="email")
    WebElement email;
    @FindBy(className="aaw-button")
    WebElement sendButton;
    public ForgotPasswordPage(WebDriver driver){
     //initialize elements
       PageFactory.initElements(driver, this);
    }
    
    public void set_email(String usere){
     email.clear();
     email.sendKeys(usere);
    }
    
    public void click_button(){
     sendButton.submit();
    }
}
