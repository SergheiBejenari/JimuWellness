package POM.pages;

import POM.Application;
import POM.pages.common.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.AssertJUnit.assertEquals;

public class DashBord extends BasePage {
    public final String url = baseUrl + "/dashboard";

    public DashBord(Application app) {
        super(app);
    }

    public void waitForDisplayed() {
        wait.until(ExpectedConditions.urlToBe(url));
        assertEquals(driver.getCurrentUrl(), url);
    }
}
