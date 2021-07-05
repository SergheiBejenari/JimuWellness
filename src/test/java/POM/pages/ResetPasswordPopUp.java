package POM.pages;

import POM.Application;
import POM.pages.common.BasePage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class ResetPasswordPopUp extends BasePage {
    private final By emailField = By.cssSelector("#email");
    private final By confirmationEmailButton = By.cssSelector(".button.button--inner.button--primary .material-icons");

    public ResetPasswordPopUp(Application app) {
        super(app);
    }

    @Step("type into email field")
    public void typeIntoEmailField(String email) {
        type(emailField, email);
        click(confirmationEmailButton);
    }
}
