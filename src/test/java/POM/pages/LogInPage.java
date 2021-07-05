package POM.pages;

import POM.Application;
import POM.pages.common.BasePage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class LogInPage extends BasePage {

    private final By emailField = By.cssSelector("#email");
    private final By passwordField = By.cssSelector("#password");
    private final By submitButton = By.cssSelector(".button.button--submit");
    private final By errorMessage = By.cssSelector(".modal__form__server-error");
    private final By registrationButton = By.cssSelector("div[class='modal__form__registration']");
    private final By resetPasswordButton = By.cssSelector(".button.button--link");
    private final By resetPopUp = By.cssSelector(".material-icons");

    private final Application app = new Application();

    public LogInPage(Application app) {
        super(app);
    }

    @Step("User is logged in with credentials login: {email} and password: {password}")
    public void logIn(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
        click(submitButton);
    }

    @Step("get Error message")
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getAttribute("innerText");
    }

    @Step("reset password")
    public void clickToResetPasswordButton() {
        driver.findElement(getResetPasswordButton()).click();
    }
}
