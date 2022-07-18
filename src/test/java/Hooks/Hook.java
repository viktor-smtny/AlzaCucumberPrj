package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Hook {

    public static WebDriver driver;

    public Hook() {}

    @Before
    public void initialize(Scenario scenario){
        System.out.println("Init browser driver and test");
        System.setProperty("webdriver.chrome.driver", "src/test/Drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            Screenshot screenshot = new AShot().takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "png", new File("src/test/Reports/Screenshots/"+scenario.getName()+".png"));
            System.out.println(scenario.getName()+" TEST FAILED");
        }
        else {
            System.out.println(scenario.getName()+" TEST PASSED");
        }
        System.out.println("Test tear down-closing driver");
        driver.close();
    }
}
