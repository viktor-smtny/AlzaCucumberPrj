package StepDef;

import Base.BaseUtil;
import Hooks.Hook;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {

    private WebDriver driver = Hook.driver;
    private LoginPage loginPage = new LoginPage(driver);
    private BaseUtil base = new BaseUtil();

    @When("^I fill in valid credentials$")
    public void i_fill_in_valid_credentials() {
        driver.switchTo().frame(loginPage.loginIframe);
        loginPage.UsernameField.click();
        loginPage.UsernameField.sendKeys(base.getDefaultUser());
        loginPage.PasswordField.click();
        loginPage.PasswordField.sendKeys(base.getDefaultPass());
        //driver.switchTo().defaultContent();
    }

    @When("I fill in invalid user")
    public void i_fill_in_invalid_user() {
        driver.switchTo().frame(loginPage.loginIframe);
        loginPage.UsernameField.sendKeys("NoTestUser");
        loginPage.PasswordField.sendKeys(base.getDefaultPass());
    }

    @When("I fill in invalid password")
    public void i_fill_in_invalid_password() {
        driver.switchTo().frame(loginPage.loginIframe);
        loginPage.UsernameField.sendKeys(base.getDefaultUser());
        loginPage.PasswordField.sendKeys("NoTestPassword");
    }

    @Then("^I am not logged in$")
    public void i_am_not_logged() {
        //driver.switchTo().frame(loginPage.loginIframe);
        Assert.assertEquals(loginPage.UsernameField.isDisplayed() && loginPage.PasswordField.isDisplayed(),true, "LoginPopUp is Not Displayed");
    }

}
