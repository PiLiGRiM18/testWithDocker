package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Alexander Pervachuk <apervachuk@wiley.com> on 28.12.2018 15:27
 */
public class BasePage implements MyProgectPage {

    public void openPage(String url) {
        open(url);
    }

    public SelenideElement getElementByText(String text) {
        return $(byText(text));
    }

    public void clickElement(String text) {
        getElementByText(text).click();
    }

    public void sendKeys(By by, String text) {
        $(by).sendKeys(text);
    }
}
