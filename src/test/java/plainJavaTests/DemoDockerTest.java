package plainJavaTests;

import com.codeborne.selenide.ElementsCollection;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Alexander Pervachuk <apervachuk@wiley.com> on 26.12.2018 10:00
 */
public class DemoDockerTest extends BaseDockerTest {

    @Test
    public void test() {

        open("https://www.wikipedia.org/");

        ElementsCollection searchInput = $$(byName("search"));

        $(byXpath("//*[@id=\"searchInput\"]")).sendKeys("жопа");

//        timeout(2);

        $(byXpath("//*[@id=\"search-form\"]/fieldset/button")).click();

//        timeout(5);

        assertThat(searchInput != null).isTrue();
        assertThat(searchInput.size() > 0).isTrue();
    }
}
