package runners.demoFeatures;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

/**
 * Created by Alexander Pervachuk <apervachuk@wiley.com> on 17.01.2019 17:56
 */

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"html:target/cucumber-report/smoketest",
                "json:target/cucumber.json",
                "pretty"
//                "junit:target/cucumber-report/smoketest/junit.xml"
        },
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@demoTest"
)

public class LocalRunner {
    @AfterClass
    public static void after() {
        System.out.println();
    }
}
