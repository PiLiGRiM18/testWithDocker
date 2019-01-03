package runner;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.io.File;

import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL;

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

public class RunCucumberTest {

    @ClassRule
    public static BrowserWebDriverContainer chromeWebDriverContainer = new BrowserWebDriverContainer()
            .withCapabilities(new ChromeOptions())
            .withRecordingMode(RECORD_ALL, new File("target/video-test-results"));

    private static RemoteWebDriver driver;

    @BeforeClass
    public static void before() {
        Configuration.browser = Browsers.CHROME;
        driver = chromeWebDriverContainer.getWebDriver();
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterClass
    public static void after() {
//        driver.close();
    }
}
