package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Alexander Pervachuk <apervachuk@wiley.com> on 28.12.2018 15:12
 */

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"html:target/cucumber-report/smoketest", "json:target/cucumber.json"},
        features = "src/test/resources/features",
        glue = "",
        tags = "@smoketest"
)

public class RunnerTest extends BaseDockerRunner {
}
