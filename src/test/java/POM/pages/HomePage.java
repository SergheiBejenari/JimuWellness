package POM.pages;

import POM.Application;
import POM.pages.common.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;


@Getter
public class HomePage extends BasePage {

    private final By logInButton = By.cssSelector("#login");
    private final By registrationButton = By.cssSelector("#signup");
    private final By headerLogo = By.cssSelector(".header__logo");

    public HomePage(Application app) {
        super(app);
    }

    public void clickLogInButton() {
        click(logInButton);
    }

    public void openHomePage() {
        driver.get(baseUrl);
    }
}
