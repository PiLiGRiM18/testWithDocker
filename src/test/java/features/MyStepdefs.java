package features;

import cucumber.api.java8.En;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Alexander Pervachuk <apervachuk@wiley.com> on 27.12.2018 16:33
 */
public class MyStepdefs implements En {
    public MyStepdefs() {

        Given("^I am on the Wikipedia page$", () ->
                open("https://www.wikipedia.org/")
        );

        And("^I type \"([^\"]*)\" in search inputfield$", (String arg0) ->
                $(byXpath("//*[@id=\"searchInput\"]")).sendKeys(arg0)
        );

        And("^I press 'Search\" button$", () ->
                $(byXpath("//*[@id=\"search-form\"]/fieldset/button")).click()
        );

        Then("^The page is reloaded$", () ->
                System.out.println("The page is reloaded")
        );

        And("^Search result is shown$", () ->
                System.out.println("Search result is shown")
        );
    }
}
