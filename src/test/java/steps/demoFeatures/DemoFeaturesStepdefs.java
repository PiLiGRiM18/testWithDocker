package steps.demoFeatures;

import cucumber.api.java8.En;
import pages.WikipediaPage;

import java.lang.management.ManagementFactory;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by Alexander Pervachuk <apervachuk@wiley.com> on 27.12.2018 16:33
 */
public class DemoFeaturesStepdefs implements En {

    WikipediaPage page = new WikipediaPage();

    public DemoFeaturesStepdefs() {

        Given("^I am on the Wikipedia page$", () -> {
            page.openPage("https://www.wikipedia.org/");
        });

        And("^I type \"([^\"]*)\" in inputfield with id \"([^\"]*)\"$", (String arg0, String arg1) -> {
            page.sendKeys(byXpath("//*[@id=\"" + arg1 + "\"]"), arg0);
        });

        And("^I press \"Search\" button$", () -> {
            $(byXpath("//*[@id=\"search-form\"]/fieldset/button")).click();
        });

        Then("^the page is reloaded$", () -> {
            System.out.println("The page is reloaded");

        });

        And("^search result is shown$", () -> {
            page.checkResultsIsShown();
        });

        And("^the feature is completed$", () -> {
            Thread thread = Thread.currentThread();
            System.out.println(">>> The feature is completed <<<" + Thread.currentThread().getId());
            System.out.println(ManagementFactory.getRuntimeMXBean().getName());
        });

        Given("^I am on the \"([^\"]*)\" page$", (String arg0) -> {
            page.openPage(arg0);

//            if (arg0.equalsIgnoreCase("Wikipedia")) {
//                page.openPage("https://www.wikipedia.org/");
//            } else if (arg0.equalsIgnoreCase("Google")) {
//                page.openPage("https://www.google.com/");
//            } else {
//                throw new cucumber.api.PendingException();
//            }
        });

        And("^Sleep \"([^\"]*)\" seconds$", (String arg0) -> {
            sleep(Long.parseLong(arg0) * 1000);
        });
    }
}
