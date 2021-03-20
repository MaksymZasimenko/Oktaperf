import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/HomePageRunner",
        "rerun:target/Rerun_Failed/HomePageRunner.text"},
        features = "src/main/resources/features/homepage.feature",
        glue = {"steps"}
)




public class HomePageRunner {
}
