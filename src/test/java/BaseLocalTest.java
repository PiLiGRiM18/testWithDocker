import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Created by Alexander Pervachuk <apervachuk@wiley.com> on 27.12.2018 9:05
 */
public class BaseLocalTest {

//    static WebDriver driver;

    @BeforeClass
    public static void before() {
        Configuration.browser = Browsers.CHROME;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
//        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
//        driver = new ChromeDriver();
    }

    @AfterClass
    public static void after() {
//        driver.close();
    }
}

