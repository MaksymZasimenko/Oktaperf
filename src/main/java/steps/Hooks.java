package steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CucumberLogUtils;
import utils.WebDriverUtils;

public class Hooks {

    @Before
    public void setUp(Scenario currentScenario){
        CucumberLogUtils.initScenario(currentScenario);
    }

    @After
    public void tearDown(){
        WebDriverUtils.closeWebDriver();
    }
}
