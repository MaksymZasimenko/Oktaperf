package impls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import pages.BasePage;
import pages.HomePage;
import utils.CucumberLogUtils;
import utils.LocalConfig;
import utils.WebDriverUtils;


public class HomePageImpl {
    private BasePage basePage;
    private WebDriver driver=WebDriverUtils.getDriver();


    public void navigateToHomepage() {
        String url = LocalConfig.getProperty("url");
        WebDriverUtils.getDriver().get(url);
    }


    public void verifyCurrentPage() {
        System.out.println(driver.getTitle());
    }

    public void verifySignInLogoIsThere() {
        String sigIn = HomePage.XPATH_TEMPLATE_SIGIN_LOGO;
        driver.findElement(By.xpath(sigIn)).isDisplayed();
    }

    public void enterValidValue(String value, String inputBox) {
        String elementXpath = String.format(HomePage.XPATH_TEMPLATE_INPUT_FIELD, inputBox);
        WebElement element = driver.findElement(By.xpath(elementXpath));
        element.sendKeys(value);
        CucumberLogUtils.logPass(value  + " was entered in " + inputBox + " input box successfully", true);
    }

    public void verifyLogInButton(String button) {
        String elementXpath = String.format(HomePage.XPATH_TEMPLATE_LOGIN_BUTTON, button);
        WebElement element = driver.findElement(By.xpath(elementXpath));
        element.isEnabled();
        CucumberLogUtils.logPass(button  + " is displayed ", false);
    }


    public void clickLogInButton(String button) {
        String elementXpath = String.format(HomePage.XPATH_TEMPLATE_LOGIN_BUTTON, button);
        WebElement element = driver.findElement(By.xpath(elementXpath));
        element.click();
        CucumberLogUtils.logPass(button + " was clicked", false);
        CucumberLogUtils.sleep(2000);
    }

    public void verifyFailedMessage() {
        String elementXpath = String.format(HomePage.XPATH_TEMPLATE_FAILED_MESSAGE);
        WebElement element = driver.findElement(By.xpath(elementXpath));
        element.isDisplayed();
        CucumberLogUtils.sleep(2000);
        CucumberLogUtils.logFail("failed to log in", true);

    }
}
