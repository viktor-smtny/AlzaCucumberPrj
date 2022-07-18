package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"userName\"]")
    public WebElement UsernameField;

    @FindBy(how = How.ID, using = "password")
    public WebElement PasswordField;

    @FindBy(how = How.ID, using = "btnLogin")
    public WebElement SubmitButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"alzaDialog\"]/div[2]")
    public WebElement CloseButton;

    @FindBy(how = How.ID, using = "loginIframe")
    public WebElement loginIframe;

}
