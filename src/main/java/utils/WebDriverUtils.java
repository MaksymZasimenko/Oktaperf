package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverUtils {

    private static WebDriver driver;

    private WebDriverUtils(){

    }

    public static WebDriver getDriver(){
        if(driver==null){
            String browserType = LocalConfig.getProperty("browser");

            switch (browserType.toLowerCase()){
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }
    public static void closeWebDriver(){
        if(driver != null){
            driver.quit();
            driver=null;
        }
    }
}
