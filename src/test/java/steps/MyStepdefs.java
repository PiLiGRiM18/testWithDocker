package steps;

import cucumber.api.java8.En;
import pages.WikipediaPage;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Alexander Pervachuk <apervachuk@wiley.com> on 27.12.2018 16:33
 */
public class MyStepdefs implements En {

    WikipediaPage page = new WikipediaPage();

    public MyStepdefs() {

        Given("^I am on the Wikipedia page$", () -> {
            page.openPage("https://www.wikipedia.org/");
        });

        And("^I type \"([^\"]*)\" in inputfield with id \"([^\"]*)\"$", (String arg0, String arg1) -> {
            page.sendKeys(byXpath("//*[@id=\"" + arg1 + "\"]"), arg0);
        });

        And("^I press 'Search\" button$", () -> {
            $(byXpath("//*[@id=\"search-form\"]/fieldset/button")).click();
        });

        Then("^The page is reloaded$", () -> {
            // todo: write code here
        });

        And("^Search result is shown$", () -> {
            page.checkResultsIsShown();
        });
    }
}
