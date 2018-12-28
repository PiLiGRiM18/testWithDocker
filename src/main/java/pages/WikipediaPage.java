package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Alexander Pervachuk <apervachuk@wiley.com> on 28.12.2018 15:11
 */
public class WikipediaPage extends BasePage {

    @Step
    public void checkResultsIsShown() {
        ElementsCollection searchInput = $$(byName("search"));
        assertThat(searchInput != null).isTrue();
        assertThat(searchInput.size() > 0).isTrue();
        sleep(10000);
    }
}
