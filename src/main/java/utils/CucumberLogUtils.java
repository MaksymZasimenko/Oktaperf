package utils;

import io.cucumber.core.api.Scenario;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CucumberLogUtils {
    public static Scenario currentScenario;

    public static void initScenario(Scenario scenario){
        currentScenario = scenario;
    }

    public static void logPass(String message, boolean takeScreenshot){
        currentScenario.write(getLogTime() + "Timestamp "+message);

        if(takeScreenshot==true){
            final byte[] screenshot = ((TakesScreenshot) WebDriverUtils.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            currentScenario.embed(screenshot, "image/png");
        }
    }

    public static void logFail(String message, boolean takeScreenshot){
        if(takeScreenshot==true){
            final byte[] screenshot = ((TakesScreenshot) WebDriverUtils.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            currentScenario.embed(screenshot, "image/png");
        }
        Assert.fail(getLogTime() + message);
    }

    public static void sleep(long millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static String getLogTime(){
        String format = "yyyy-MM-dd HH:mm:ss";

        DateFormat dateFormat = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
}
