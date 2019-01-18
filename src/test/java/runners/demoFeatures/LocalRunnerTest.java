package runners.demoFeatures;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
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

public class LocalRunnerTest {
        @Rule
        static
        TestName name = new TestName();

        @BeforeClass
        public static void beforeClass() {
                System.out.println();
        }

        @AfterClass
        public static void afterClass() {
                System.out.println(name.getMethodName());
        }

//        @After
//        public static void after(){
//                System.out.println();
//        }
}
