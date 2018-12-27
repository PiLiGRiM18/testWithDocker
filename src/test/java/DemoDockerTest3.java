import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Alexander Pervachuk <apervachuk@wiley.com> on 26.12.2018 10:00
 */
public class DemoDockerTest3 extends BaseDockerTest {

    @Test
    public void test() {

        driver.get("https://www.wikipedia.org/");

        List<WebElement> searchInput = driver.findElementsByName("search");

        driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("жопа");

        timeout(2);

        driver.findElement(By.xpath("//*[@id=\"search-form\"]/fieldset/button")).click();

        timeout(5);

        assertThat(searchInput != null).isTrue();
        assertThat(searchInput.size() > 0).isTrue();
    }
}
