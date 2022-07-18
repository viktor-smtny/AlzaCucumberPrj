package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private static String URL = "https://www.alza.cz/";

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public String getURL() {
        return URL;
    }
}
