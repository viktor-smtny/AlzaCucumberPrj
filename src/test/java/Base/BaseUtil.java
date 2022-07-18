package Base;

import Hooks.Hook;
import org.openqa.selenium.WebDriver;


public class BaseUtil {

    //private WebDriver driver = Hook.driver;
    private String PROJECT_PATH = System.getProperty("user.dir").replace("\\","\\\\");
    private static String defaultUser = "TestUser@gmail.com";
    private static String defaultPass = "TestPassword";

    public BaseUtil(){
    }

    public static String getDefaultPass() {
        return defaultPass;
    }

    public static String getDefaultUser() {
        return defaultUser;
    }
}
