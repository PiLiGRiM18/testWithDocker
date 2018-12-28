package plainJavaTests;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alexander Pervachuk <apervachuk@wiley.com> on 27.12.2018 9:19
 */
public class BaseDockerTest {

    @ClassRule
    public static BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
            .withCapabilities(new ChromeOptions())
//            .withRecordingMode(RECORD_ALL, new File("build/video-test-results"))
            ;
    static RemoteWebDriver driver;

    @BeforeClass
    public static void before() {
        Configuration.browser = Browsers.CHROME;
        driver = chrome.getWebDriver();
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterClass
    public static void after() {
    }

    protected void timeout(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
