package StepDef;

import Hooks.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class GlobalSteps {

    private WebDriver driver = Hook.driver;
    private HomePage homePage = new HomePage(driver);
    private BaseUtil base = new BaseUtil();

    @Given("^I am on homepage$")
    public void i_am_on_homepage() {
        driver.get(homePage.getURL());

        if (homePage.PopUpDialog.isDisplayed()) {
            homePage.PopUpDialog_Close.click();
        }
    }

    @Then("I see element {string} on page")
    public void i_see_elem_on_page(String pageObject) throws Throwable{
        String xpath = convertStringToElemXpath(pageObject);
        boolean result = driver.findElement(By.xpath(xpath)).isDisplayed();
        Assert.assertEquals(result,true, "Element is NOT present on the page");
    }

    @When("I click on {string}")
    public void i_click_on(String pageObject) throws Throwable{
        String xpath = convertStringToElemXpath(pageObject);
        driver.findElement(By.xpath(xpath)).click();
    }

    @When("I wait for {int} seconds")
    public void i_for_int_seconds(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    @Then("^I am logged in$")
    public void i_am_logged_in() {
        boolean result = false;
        result = homePage.LoggedUserButton.getText().contains(base.getDefaultUser());
        Assert.assertEquals(result, true, "User is not logged in");
    }

    @When("^I switch focus to default$")
    public void i_switch_focus_default() {
        driver.switchTo().defaultContent();
    }

    @Then("I am on page {string}")
    public void i_am_on_page(String pageName) {

    }

    @Then("I see text {string} in element {string}")
    public void i_see_text_in_element(String text, String element) {

    }

    private String convertStringToElemXpath(String pageObject) throws Throwable{
        String[] split = pageObject.split("-");

        String pageName = split[0];
        String elementName = split[1];
        Class cls = Class.forName("pages."+pageName);
        Constructor cst = cls.getConstructor(WebDriver.class);
        Object page = cst.newInstance(driver);
        Field field = cls.getField(elementName);
        String elValue = field.get(page).toString().split("->")[1];
        elValue = elValue.replace(" ","");
        elValue = elValue.substring(0,elValue.length()-1);
        String how = elValue.split(":")[0];
        String val = elValue.split(":")[1];
        String xpath ="";

        if (how.equals("xpath")) {
            xpath = val;
        }
        else {
            xpath = "//*[@"+how+"=\""+val+"\"]";
        }

        //System.out.println("xpath "+xpath);
        return xpath;
    }
}
