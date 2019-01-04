package runners.demoFeatures;

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

public class RunDemoCucumberTest_2 {

    @ClassRule
    public static BrowserWebDriverContainer chromeWebDriverContainer = new BrowserWebDriverContainer()
            .withCapabilities(new ChromeOptions())
            .withRecordingMode(RECORD_ALL, new File("./build/"))
//            .withRecordingFileFactory(getRecordingFactory())
            ;

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

//    private static DefaultRecordingFileFactory getRecordingFactory(){
//        DefaultRecordingFileFactory factory = new DefaultRecordingFileFactory();
//        File vncRecordingDirectory = null;
//        try {
//            vncRecordingDirectory = Files.createTempDirectory("recording").toFile();
//        } catch (IOException e) {
//            System.out.println(">>>>>>>>>>>>>>");
//            e.printStackTrace();
//        }
//        Description description = createTestDescription(RunDemoCucumberTest_1.class.getCanonicalName(), "methodname", Test.class);
//        factory.recordingFileForTest(vncRecordingDirectory, description, TRUE);
//        return factory;
//    }
}
