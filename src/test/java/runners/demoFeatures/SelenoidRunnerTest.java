package runners.demoFeatures;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Created by Alexander Pervachuk <apervachuk@wiley.com> on 28.12.2018 15:12
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

public class SelenoidRunnerTest {
    private static RemoteWebDriver driver;

    @BeforeClass
    public static void before() throws Exception {
        final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        capabilities.setCapability("screenResolution", "1920x1080x24");

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), capabilities);
        driver.manage().window().setSize(new Dimension(1092, 1080));

        WebDriverRunner.setWebDriver(driver);
    }

    @AfterClass
    public static void after() {
    }
}
