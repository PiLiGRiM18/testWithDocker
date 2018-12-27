import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Alexander Pervachuk <apervachuk@wiley.com> on 27.12.2018 8:33
 */
public class DemoLocalTest extends BaseLocalTest {

//    @RunWith()
    @Test
    public void test() {

        open("https://www.wikipedia.org/");

        step1();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ElementsCollection searchInput = $$(byName("search"));

        $(byXpath("//*[@id=\"searchInput\"]")).sendKeys("qweqweqwe");

        assertThat(searchInput != null).isTrue();
        assertThat(searchInput.size() > 0).isTrue();

    }

    @Step
    private void step1(){
        System.out.println("step1");
    }
}
