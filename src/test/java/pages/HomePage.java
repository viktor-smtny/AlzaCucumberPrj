package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private static String URL = "https://www.alza.cz/";

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public String getURL() {
        return URL;
    }

    @FindBy(how = How.ID, using = "lblLogin")
    public WebElement LoginButton;

    @FindBy(how = How.ID, using = "popUpDialog")
    public WebElement PopUpDialog;

    @FindBy(how = How.XPATH, using = "//*[@id=\"alzaDialog\"]/div[2]")
    public WebElement PopUpDialog_Close;

    @FindBy(how = How.XPATH, using = "//*[@id=\"rootHtml\"]/body/alza-component-head/div[6]")
    public WebElement CookiesPopUp;

    @FindBy(how = How.XPATH, using = "//*[@id=\"rootHtml\"]/body/alza-component-head//div[@class=\"cookies-info__buttons\"]/a[3]")
    public WebElement CookiesPopUp_DenyAllButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"rootHtml\"]/body/alza-component-head//div[@class=\"cookies-info__buttons\"]/a[2]")
    public WebElement CookiesPopUp_SettingsButton;

    @FindBy(how = How.ID, using = "lblUser")
    public WebElement LoggedUserButton;
}
